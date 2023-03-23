package edu.bu.oneshelf.products.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductImagesResponse {
    private Long id;
    private List<String> images;
}
