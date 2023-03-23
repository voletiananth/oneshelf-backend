package edu.bu.oneshelf.order.repository;

import edu.bu.oneshelf.order.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository  extends JpaRepository<Cart, Long> {



}
