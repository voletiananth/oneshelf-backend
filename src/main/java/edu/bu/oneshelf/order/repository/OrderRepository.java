package edu.bu.oneshelf.order.repository;


import edu.bu.oneshelf.order.models.Order;
import edu.bu.oneshelf.pantry.models.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query(value = "select max(o.orderNumber) from orders o where o.pantry = ?1 and o.orderDate = ?2")
    Optional<Integer> generateOrderNoByPantryAndDate(Pantry pantry, Calendar date);
}
