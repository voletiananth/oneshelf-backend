package edu.bu.oneshelf.pantry.dto;


import edu.bu.oneshelf.pantry.models.PantryInventory;
import edu.bu.oneshelf.products.dto.ProductResponse;
import edu.bu.oneshelf.products.models.Product;
import lombok.Data;

import java.util.Map;

@Data
public class ProductAndCartQuantityResponse {
    private ProductResponse product;
    private Integer cart_quantity;


    public static ProductAndCartQuantityResponse  from(PantryInventory pantryInventory){
        ProductAndCartQuantityResponse productAndCartQuantityResponse = new ProductAndCartQuantityResponse();
        productAndCartQuantityResponse.setCart_quantity(pantryInventory.getQuantity());
        productAndCartQuantityResponse.setProduct(pantryInventory.getProduct().toMap());
        return productAndCartQuantityResponse;
    }


}
