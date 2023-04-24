package edu.bu.oneshelf.products.dto;


import edu.bu.oneshelf.common.ImageUtils;
import edu.bu.oneshelf.products.models.Category;
import edu.bu.oneshelf.products.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Data
public class AddProductRequest {



    @NotBlank(message = "Name is required")
    private String name;


    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Thumbnail is required")
    private MultipartFile thumbnail;

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotNull(message = "Category is required")
    private Long categoryId;





    public Product toProduct(Category category, Path path) throws IOException {
         String fileName = ImageUtils.saveImage(path, this.thumbnail);
        return Product.builder()

                .name(this.name)
                .description(this.description)
                .thumbnail(fileName)
                .brand(this.brand)
                .category(category)

                .build();
    }



}
