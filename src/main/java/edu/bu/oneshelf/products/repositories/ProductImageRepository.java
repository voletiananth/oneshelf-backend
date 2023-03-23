package edu.bu.oneshelf.products.repositories;

import edu.bu.oneshelf.products.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
}
