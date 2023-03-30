package edu.bu.oneshelf.order.models;


import edu.bu.oneshelf.common.BaseModel;
import edu.bu.oneshelf.order.dto.OrderResponse;
import edu.bu.oneshelf.pantry.models.Pantry;
import edu.bu.oneshelf.slot.models.SlotTime;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "orders")
@Table(name = "orders", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"pantry_id","cart_id","time_slot_id"})
}
)
@Data
@EqualsAndHashCode(callSuper = true)

public class Order extends BaseModel {




    @Column(name = "order_number")
    Integer orderNumber;

    @ManyToOne
    @JoinColumn(name = "pantry_id")
    Pantry pantry;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    Cart cart;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "time_slot_id",referencedColumnName = "id")
    SlotTime slotTime;

    @Temporal(TemporalType.DATE)
    Calendar orderDate;


    public OrderResponse toResponse() {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
        return OrderResponse.builder()
                .orderNo(dateTimeFormat.format(orderDate.getTime())+ " - " + pantry.getId() +" - "+orderNumber.toString())
                .pantry(pantry.toMap())
                .products(cart.toResponse().getProducts())
                .slotTime(slotTime.toResponse())
                .orderDate(orderDate)
                .build();
    }
}
