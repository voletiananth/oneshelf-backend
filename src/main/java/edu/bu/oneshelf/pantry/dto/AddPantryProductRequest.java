package edu.bu.oneshelf.pantry.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddPantryProductRequest {

    @NotNull(message = "Product Id is required")
    private Long productId;

    @NotNull(message = "Quantity is required")
    private Integer quantity;
}
