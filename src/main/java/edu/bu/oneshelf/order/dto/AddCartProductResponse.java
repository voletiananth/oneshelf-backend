package edu.bu.oneshelf.order.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddCartProductResponse  {
    public Long id;
    private CartProductResponse product;

}
