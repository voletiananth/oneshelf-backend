package edu.bu.oneshelf.order.models;

import edu.bu.oneshelf.common.CreateUpdateTimeStampModel;
import edu.bu.oneshelf.order.dto.AddCartProductResponse;
import edu.bu.oneshelf.order.dto.CartProductResponse;
import edu.bu.oneshelf.products.models.Product;
import edu.bu.oneshelf.products.utils.ImagesMapping;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data(staticConstructor = "of")
@Entity(name = "cart_products")
@Table(name = "cart_products")
@EqualsAndHashCode(callSuper = true)
@IdClass(CartProductsKey.class)
@AllArgsConstructor
@NoArgsConstructor
public class CartProducts extends CreateUpdateTimeStampModel {



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    @OnDelete(action = OnDeleteAction.CASCADE)

            @Id
    Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "product_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
            @Id
    Product product;


    Integer quantity = 1;


    public CartProductResponse toResponse() {
        return CartProductResponse.builder()
                .productId(this.product.getId())
                .name(this.product.getName())
                .image(ImagesMapping.getProductUrl(this.product.getThumbnail()))
                .quantity(this.quantity)
                .build();
    }

    public AddCartProductResponse toAddCartProductResponse() {
        return AddCartProductResponse.builder()
                .id(this.cart.getId())
                .product(this.toResponse())
                .build();



    }
}
