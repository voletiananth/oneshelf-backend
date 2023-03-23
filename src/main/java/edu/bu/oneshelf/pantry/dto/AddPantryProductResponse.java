package edu.bu.oneshelf.pantry.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class AddPantryProductResponse {

//    Long id;
    Long productId;
    Integer quantity;
}
