package edu.bu.oneshelf.order.service;


import edu.bu.oneshelf.common.ConflictException;
import edu.bu.oneshelf.common.NotFoundException;
import edu.bu.oneshelf.order.dto.*;
import edu.bu.oneshelf.order.models.Cart;
import edu.bu.oneshelf.order.models.CartProducts;
import edu.bu.oneshelf.order.models.CartProductsKey;
import edu.bu.oneshelf.order.models.Order;
import edu.bu.oneshelf.order.repository.CartProductsRepository;
import edu.bu.oneshelf.order.repository.CartRepository;
import edu.bu.oneshelf.order.repository.OrderRepository;
import edu.bu.oneshelf.pantry.models.Pantry;
import edu.bu.oneshelf.pantry.repository.PantryInventoryRepository;
import edu.bu.oneshelf.products.models.Product;
import edu.bu.oneshelf.slot.models.PantrySlot;
import edu.bu.oneshelf.slot.models.SlotDay;
import edu.bu.oneshelf.slot.models.SlotTime;
import edu.bu.oneshelf.slot.repositories.PantrySlotRepository;
import edu.bu.oneshelf.slot.repositories.SlotDayRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

@Service
@AllArgsConstructor

public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartProductsRepository cartProductsRepository;

    private final PantryInventoryRepository pantryInventoryRepository;


    private final SlotDayRepository slotDayRepository;



    private final PantrySlotRepository pantrySlotRepository;


    public CartResponse getCart(CartRequest request){
        Cart cart = cartRepository.findById(request.getCartId()).orElseThrow( () -> new NotFoundException("Cart not found"));
        List<CartProducts> cartProducts = cartProductsRepository.findAllByCartIdAndPantryId(cart.getId(),request.getPantryId());
        return cart.toResponse(cartProducts);
    }

    public AddCartProductResponse addProductToCart(Long cartId , CartProductRequest request){

       return getCartProduct(cartId,request.getProductId(), request.getPantryId(),(cart, product)->{
            cartProductsRepository.findById(new CartProductsKey(cart,product)).ifPresent(cartProducts -> {
                throw new ConflictException("Product already exists in cart");
            });
            return addProductToCart(cart,product,request.getQuantity());
        }).toAddCartProductResponse();
    }


    private  <T> T getCartProduct(Long cartId, Long productId, Long pantryId, BiFunction<Cart,Product,T> function){
        Cart cart = cartRepository.findById(cartId).orElseThrow( () -> new NotFoundException("Cart not found"));
        Product product = pantryInventoryRepository.findProductByPantryIdAndProductId(pantryId,productId).orElseThrow( () -> new NotFoundException("Product not found"));
        return function.apply(cart,product);
    }


    private CartProducts addProductToCart(Cart cart ,Product product , int quantity){;
        CartProducts cartProducts = new CartProducts();
        cartProducts.setCart(cart);
        cartProducts.setProduct(product);
        cartProducts.setQuantity(quantity);
        return cartProductsRepository.save(cartProducts);
    }


    public AddCartProductResponse updateCartProduct(Long cartId , CartProductRequest request){

       return getCartProduct(cartId,request.getProductId(), request.getPantryId(),(cart, product)->{
           CartProducts products = cartProductsRepository.findById(new CartProductsKey(cart,product)).orElseThrow( () -> new NotFoundException("Product not found in cart"));
              products.setQuantity(request.getQuantity());
              return cartProductsRepository.save(products);
        }).toAddCartProductResponse();

    }



    @Transactional
    public AddCartProductResponse createCart(CartProductRequest request){
        Cart cart = cartRepository.save(new Cart());
        Product product = pantryInventoryRepository.findProductByPantryIdAndProductId(request.getPantryId(),request.getProductId()).orElseThrow( () -> new NotFoundException("Product not found"));
        return addProductToCart(cart,product,request.getQuantity()).toAddCartProductResponse();
    }



    @Transactional
    public OrderResponse placeOrder(OrderRequest request){
        Cart cart = cartRepository.findById(request.getCartId()).orElseThrow( () -> new NotFoundException("Cart not found"));
        if (cart.getCartProducts().isEmpty()){
            throw new NotFoundException("Cart is empty");
        }
        PantrySlot pantrySlot = pantrySlotRepository.findBySlotDayIdAndSlotTimeId(request.getDayId(),request.getTimeId()).orElseThrow( () -> new NotFoundException("Pantry Slot not found"));
        SlotDay slotDay = pantrySlot.getSlotDay();
        Pantry pantry = slotDay.getPantry();
        if (!Objects.equals(pantry.getId(), request.getPantryId())){
            throw new NotFoundException("Pantry not found");
        }
        SlotTime slotTime = pantrySlot.getSlotTime();
        Date date = slotDayRepository.findOrderDateByPantryIdAndSlotId(pantry.getId(),slotDay.getId()).orElseThrow( () -> new NotFoundException("Slot not found"));
        Integer orderNumber = orderRepository.generateOrderNoByPantryAndDate(pantry,date).orElse(0);
        Order order = new Order();
        order.setCart(cart);
        order.setOrderNumber(orderNumber+1);
        order.setPantry(slotDay.getPantry());
        order.setOrderDate(date);
        order.setSlotTime(slotTime);
        return orderRepository.save(order).toResponse();
    }











}
