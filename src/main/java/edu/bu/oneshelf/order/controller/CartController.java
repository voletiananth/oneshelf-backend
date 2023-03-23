package edu.bu.oneshelf.order.controller;


import edu.bu.oneshelf.order.dto.AddCartProductResponse;
import edu.bu.oneshelf.order.dto.CartProductRequest;
import edu.bu.oneshelf.order.dto.CartRequest;
import edu.bu.oneshelf.order.dto.CartResponse;
import edu.bu.oneshelf.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client/cart/")
@AllArgsConstructor
public class CartController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddCartProductResponse addProductToCart(@RequestParam(required = false) Long cartId,@Valid @RequestBody CartProductRequest cartProductRequest) {
       if (cartId == null) {
           return orderService.createCart(cartProductRequest);
       }
       return orderService.addProductToCart(cartId,cartProductRequest);
    }





    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public CartResponse getCart(@RequestBody CartRequest cartRequest) {
        return orderService.getCart(cartRequest);
    }




    @PutMapping("{cartId}/")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCartProductResponse updateCartProduct(@PathVariable Long cartId,@Valid @RequestBody CartProductRequest cartProductRequest) {
       return orderService.updateCartProduct(cartId,cartProductRequest);
    }




}
