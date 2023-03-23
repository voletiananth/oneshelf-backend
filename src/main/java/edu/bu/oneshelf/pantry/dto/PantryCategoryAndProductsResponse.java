package edu.bu.oneshelf.pantry.dto;

import edu.bu.oneshelf.products.dto.CategoryProductResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class PantryCategoryAndProductsResponse {
    PantryResponse pantry;
    List<CategoryProductResponse> categories;


}
