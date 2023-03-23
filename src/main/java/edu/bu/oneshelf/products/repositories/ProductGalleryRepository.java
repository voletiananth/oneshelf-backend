package edu.bu.oneshelf.products.repositories;

import edu.bu.oneshelf.products.models.ProductGallery;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductGalleryRepository extends JpaRepository<ProductGallery, Long> {


    @NotNull
    @Query("SELECT pg FROM product_gallery pg WHERE pg.id = ?1")
    Optional<ProductGallery> findById(@NotNull Long id);
}
