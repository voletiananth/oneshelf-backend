package edu.bu.oneshelf.pantry.repository;


import edu.bu.oneshelf.pantry.models.Pantry;
import edu.bu.oneshelf.pantry.models.PantryInventory;
import edu.bu.oneshelf.pantry.models.PantryInventoryKey;
import edu.bu.oneshelf.products.models.Category;
import edu.bu.oneshelf.products.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface PantryInventoryRepository  extends JpaRepository<PantryInventory, PantryInventoryKey> {

    Optional<PantryInventory> findByPantryAndProduct(Pantry pantry, Product product);



    @Query("SELECT p.product FROM pantry_inventory p WHERE p.pantry.id = ?1 AND p.product.id = ?2")
    Optional<Product> findProductByPantryIdAndProductId(Long pantryId, Long productId);




    @Query("SELECT distinct p.product.category FROM pantry_inventory p WHERE p.pantry = ?1")
    List<Category> findDistinctCategoryByPantry(Pantry pantry);

    @Query("SELECT p.product FROM pantry_inventory p WHERE p.pantry = ?1 AND p.product.category = ?2")
    List<Product> findProductsByPantryAndCategory(Pantry pantry, Category category);

    @Query("SELECT p.product FROM pantry_inventory p WHERE p.pantry = ?1 AND p.product.category.id = ?2")
    List<Product> findProductsByPantryAndCategoryId(Pantry pantry, Long categoryId);
}
