package edu.bu.oneshelf.products.repositories;

import edu.bu.oneshelf.products.models.Product;
import edu.bu.oneshelf.products.models.ProductGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {



    @Query("SELECT p FROM Product p WHERE p.name = ?1 OR p.product_gallery = ?2")
    Optional<Product> findByNameOrGalleryId(String name, ProductGallery productGallery);
}
