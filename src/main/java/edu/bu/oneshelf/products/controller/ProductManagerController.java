package edu.bu.oneshelf.products.controller;

import edu.bu.oneshelf.products.dto.CategoryProductResponse;
import edu.bu.oneshelf.products.dto.CategoryResponse;
import edu.bu.oneshelf.products.dto.ProductResponse;
import edu.bu.oneshelf.products.services.CategoryService;
import edu.bu.oneshelf.products.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/manager/")
@AllArgsConstructor
public class ProductManagerController {

    private final CategoryService categoryService;
    private final ProductService productService;



    @GetMapping("category/")
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("category/products/")
    public List<CategoryProductResponse> getAllCategoriesWithProducts() {
        return categoryService.getAllCategoriesWithProducts();
    }

    @GetMapping("products/")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }


}
