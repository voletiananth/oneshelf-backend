package edu.bu.oneshelf.products.dto;


import edu.bu.oneshelf.products.models.Category;
import edu.bu.oneshelf.common.ImageUtils;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Data
public class CategoryRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Thumbnail is required")
    private MultipartFile thumbnail;




    public Category saveThumbnailAndMapTo(Path uploadPath) throws IOException {


        String path = ImageUtils.saveImage(uploadPath, thumbnail);

        return Category.builder()
                .name(this.name)
                .description(this.description)
                .thumbnail(path)
                .build();
    }
}
