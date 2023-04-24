package edu.bu.oneshelf.order.dto;

import edu.bu.oneshelf.pantry.dto.PantryResponse;
import edu.bu.oneshelf.pantry.models.Pantry;
import edu.bu.oneshelf.slot.dto.SlotTimeResponse;
import edu.bu.oneshelf.slot.models.SlotTime;
import lombok.Builder;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Data
@Builder
public class OrderResponse {
    Long id;
    String orderNo;

    PantryResponse pantry;

    Calendar orderDate;

    SlotTimeResponse slotTime;

    List<CartProductResponse> products;
}
