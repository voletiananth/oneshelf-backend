package edu.bu.oneshelf.order.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Calendar;


@Data
public class OrderRequest {

   @NotNull(message = "Cart Id cannot be null")
   private Long cartId;
   @NotNull(message = "Slot Day Id cannot be null")
   private Long dayId;
   @NotNull(message = "Pantry Id cannot be null")
   private Long pantryId;

   @NotNull(message = "Time Id cannot be null")
   private Long timeId;
}
