package edu.bu.oneshelf.pantry.dto;


import edu.bu.oneshelf.products.dto.CategoryResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PantryCategoryResponse {
    PantryResponse pantry;
    List<CategoryResponse> categories;


    PantryCategoryResponse(PantryResponse pantry, List<CategoryResponse> categories) {
        this.pantry = pantry;
        this.categories = categories;
    }


}
