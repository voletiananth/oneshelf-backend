package edu.bu.oneshelf.pantry.service;


import edu.bu.oneshelf.auth.exceptions.ManagerNotExistsException;
import edu.bu.oneshelf.auth.repositories.ManagerDetailsRepository;
import edu.bu.oneshelf.common.NotFoundException;
import edu.bu.oneshelf.order.dto.CartResponse;
import edu.bu.oneshelf.order.models.Cart;
import edu.bu.oneshelf.order.repository.CartRepository;
import edu.bu.oneshelf.pantry.dto.*;
import edu.bu.oneshelf.pantry.exceptions.PantryDoesNotExistsException;
import edu.bu.oneshelf.pantry.exceptions.PantryExistsException;
import edu.bu.oneshelf.pantry.models.Pantry;
import edu.bu.oneshelf.pantry.models.PantryInventory;
import edu.bu.oneshelf.pantry.repository.PantryInventoryRepository;
import edu.bu.oneshelf.pantry.repository.PantryRepository;
import edu.bu.oneshelf.products.dto.CategoryProductResponse;
import edu.bu.oneshelf.products.dto.CategoryResponse;
import edu.bu.oneshelf.products.dto.ProductResponse;
import edu.bu.oneshelf.products.exceptions.ProductDetailsNotExistsException;
import edu.bu.oneshelf.products.models.Category;
import edu.bu.oneshelf.products.models.Product;
import edu.bu.oneshelf.products.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PantryInventoryService {


    private final PantryInventoryRepository pantryInventoryRepository;
    private final ProductRepository productRepository;

    private final PantryRepository pantryRepository;

    private final ManagerDetailsRepository managerDetailsRepository;


    private final CartRepository cartRepository;



    public AddPantryProductResponse addPantryProduct(String user, AddPantryProductRequest addPantryProductRequest){


        Pantry pantry = getPantry(user);
        Product product = getProduct(addPantryProductRequest.getProductId());

        pantryInventoryRepository.findByPantryAndProduct(pantry,product).ifPresent(pantryInventory -> {
            throw new PantryExistsException("Pantry already exists");
        });

        PantryInventory pantryInventory = PantryInventory.builder().pantry(pantry).product(product).quantity(addPantryProductRequest.getQuantity()).build();

       return pantryInventoryRepository.save(pantryInventory).toMap();
    }


    public AddPantryProductResponse updatePantryProduct(String user, AddPantryProductRequest pantryInventoryRequest) {

            Pantry pantry = getPantry(user);
            Product product = getProduct(pantryInventoryRequest.getProductId());
            PantryInventory pantryInventory = getPantryInventory(pantry,product);
            pantryInventory.setQuantity(pantryInventoryRequest.getQuantity());

            return pantryInventoryRepository.save(pantryInventory).toMap();
    }

    public void deletePantryProduct(String user,Long productId) {
        Pantry pantry = getPantry(user);
        Product product = getProduct(productId);
        PantryInventory pantryInventory = getPantryInventory(pantry,product,new NotFoundException("Product does not exists in the pantry"));
        pantryInventoryRepository.delete(pantryInventory);

    }


    private Pantry getPantry(String user){

        return managerDetailsRepository.findPantryByUser(user).orElseThrow(() -> new ManagerNotExistsException("User is not associated with any pantry"));
    }

    private Product getProduct(Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new ProductDetailsNotExistsException("Product does not exists"));
    }

    private PantryInventory getPantryInventory(Pantry pantry,Product product){
        return getPantryInventory(pantry,product,new PantryDoesNotExistsException("Pantry does not exists"));
    }

    private PantryInventory getPantryInventory(Pantry pantry, Product product, NotFoundException notFoundException){
        return pantryInventoryRepository.findByPantryAndProduct(pantry,product).orElseThrow(() -> notFoundException);
    }

//    public List<Map<String, Object>> getPantryProducts(Long pantryId) {
//        return pantryInventoryRepository.findProductByPantryId(pantryId);
//    }


    public List<CategoryResponse> getPantryCategories(Long pantryId) {
        Pantry pantry = pantryRepository.findById(pantryId).orElseThrow(() -> new PantryDoesNotExistsException("Pantry does not exists"));
        return pantryInventoryRepository.findDistinctCategoryByPantry(pantry).stream().map(Category::toMap).toList();
        }



    public PantryCategoryAndProductsResponse getPantryCategoriesAndProducts(Long pantryId) {
        Pantry pantry = pantryRepository.findById(pantryId).orElseThrow(() -> new PantryDoesNotExistsException("Pantry does not exists"));
        List<CategoryProductResponse> categories = pantryInventoryRepository.findDistinctCategoryByPantry(pantry).stream()
                .map(category -> {
                    List<Product> products = getProducts(pantry,category);
                    return category.toMapWithProducts(products);
                }).toList();

        return PantryCategoryAndProductsResponse.builder().categories(categories).pantry(pantry.toMap()).build();
    }


    private List<Product> getProducts(Pantry pantry, Category category){
        return pantryInventoryRepository.findProductsByPantryAndCategory(pantry,category);
    }


    public List<ProductAndCartQuantityResponse> getPantryProductsByCategory(PantryProductsRequest request) {
        Pantry pantry = pantryRepository.findById(request.getPantryId()).orElseThrow(() -> new PantryDoesNotExistsException("Pantry does not exists"));

      return   pantryInventoryRepository.findProductsByPantryAndCategoryId(pantry.getId(), request.getCategoryId(), request.getCartId()).stream().map(ProductAndCartQuantityResponse::from).toList();

    }
}
