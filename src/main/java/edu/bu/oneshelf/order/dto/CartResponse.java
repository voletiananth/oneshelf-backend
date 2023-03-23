package edu.bu.oneshelf.order.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CartResponse {
    Long id;
    List<CartProductResponse> products;
}
