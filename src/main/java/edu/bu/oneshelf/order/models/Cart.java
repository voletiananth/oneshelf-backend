package edu.bu.oneshelf.order.models;

import edu.bu.oneshelf.common.BaseModel;
import edu.bu.oneshelf.order.dto.CartResponse;
import edu.bu.oneshelf.pantry.models.Pantry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity(name = "cart")
@Table(name = "cart")
@Data
@EqualsAndHashCode(callSuper = true)
public class Cart extends BaseModel {


    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<CartProducts> cartProducts = new ArrayList<>();


    public CartResponse toResponse(){
        return toResponse(this.cartProducts);
    }


    public CartResponse toResponse(List<CartProducts> cartProducts){
        return CartResponse.builder()
                .id(this.getId())
                .products(cartProducts.stream().map(CartProducts::toResponse).toList())
                .build();
    }
}
