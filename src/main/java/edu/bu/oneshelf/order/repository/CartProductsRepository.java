package edu.bu.oneshelf.order.repository;

import edu.bu.oneshelf.order.models.CartProducts;
import edu.bu.oneshelf.order.models.CartProductsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartProductsRepository extends JpaRepository<CartProducts, CartProductsKey> {


    @Query(
            value = "select  createdAt, updatedAt, cart_id, product_id, (select quantity where cart_products.product_id in (select pantry_inventory.product_id from pantry_inventory where pantry_id = :pi)) as quantity from cart_products where cart_id = :ci ;",
            nativeQuery = true
    )
    List<CartProducts> findAllByCartIdAndPantryId(@Param("ci") Long cartId,@Param("pi") Long pantryId);

}
