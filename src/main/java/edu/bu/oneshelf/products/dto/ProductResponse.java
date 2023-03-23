package edu.bu.oneshelf.products.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder()
public class ProductResponse {

    private Long id;

    private String name;
    private String description;
    private String thumbnail;
    private String brand;
    private Long categoryId;
    private ProductImagesResponse images_details;
}
