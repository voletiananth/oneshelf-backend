package edu.bu.oneshelf.order.dto;

import edu.bu.oneshelf.products.models.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CartProductRequest {
    Long pantryId;
    @NotNull(message = "Product Id is required")
    Long productId;
    @NotNull(message = "Quantity is required")
    Integer quantity;
}
