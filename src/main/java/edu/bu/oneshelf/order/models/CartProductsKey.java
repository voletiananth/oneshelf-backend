package edu.bu.oneshelf.order.models;

import edu.bu.oneshelf.products.models.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class CartProductsKey implements Serializable {

    private Cart cart;
    private Product product;

    public CartProductsKey(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }
}
