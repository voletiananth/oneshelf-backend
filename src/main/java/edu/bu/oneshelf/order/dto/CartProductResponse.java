package edu.bu.oneshelf.order.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartProductResponse {
    Long productId;
    String name;
    String image;
    Integer quantity;
}
