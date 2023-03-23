package edu.bu.oneshelf.products.repositories;

import edu.bu.oneshelf.products.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public
interface CategoryRepository extends JpaRepository<Category, Long>{

    Optional<Category> findCategoriesByName(String name);

}
