package edu.bu.oneshelf.pantry.models;

import edu.bu.oneshelf.products.models.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;



@Data
public class PantryInventoryKey implements Serializable {

//    private Long id;

    private Pantry pantry;


    private Product product;
}
