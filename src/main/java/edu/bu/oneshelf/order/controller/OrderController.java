package edu.bu.oneshelf.order.controller;


import edu.bu.oneshelf.order.dto.OrderRequest;
import edu.bu.oneshelf.order.dto.OrderResponse;
import edu.bu.oneshelf.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/client/order/")
public class OrderController {
    OrderService orderService;

    @PostMapping
    @ResponseBody
    public OrderResponse placeOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

}
