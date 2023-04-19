package edu.bu.oneshelf.products.repositories;

import edu.bu.oneshelf.products.models.Category;
import edu.bu.oneshelf.products.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    long countByCategory(Category category);


}
