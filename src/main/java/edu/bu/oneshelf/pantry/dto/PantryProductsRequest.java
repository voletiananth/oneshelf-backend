package edu.bu.oneshelf.pantry.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PantryProductsRequest {

    @NotNull(message = "Pantry Id cannot be null")
    Long pantryId;
    @NotNull(message = "Category Id cannot be null")
    Long categoryId;
}
