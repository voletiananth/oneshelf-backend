package edu.bu.oneshelf.common;

import edu.bu.oneshelf.products.exceptions.ImageException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ImageUtils {



    public static String saveImage(Path uploadPath, MultipartFile multipartFile) throws IOException {
        if (multipartFile == null){
            throw new ImageException("Image is null");
        }

        String fileName = multipartFile.getOriginalFilename();

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }



        try(var inputStream = multipartFile.getInputStream()){
            assert fileName != null;
            final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss.SSS");
            String timeStamp = sdf3.format(new Timestamp(System.currentTimeMillis()))+ "_" + fileName;
            Path filePath = uploadPath.resolve(timeStamp);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return  timeStamp;
        }catch (IOException e){
            throw new IOException("Could not save image file: " + fileName, e);
        }

    }
}
