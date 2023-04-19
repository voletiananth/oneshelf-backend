package edu.bu.oneshelf.products.services;


import edu.bu.oneshelf.products.dto.AddProductRequest;
import edu.bu.oneshelf.products.dto.ProductResponse;
import edu.bu.oneshelf.products.exceptions.ImageException;
import edu.bu.oneshelf.products.exceptions.ProductDetailsNotExistsException;
import edu.bu.oneshelf.products.models.Category;
import edu.bu.oneshelf.products.models.Product;
import edu.bu.oneshelf.products.repositories.CategoryRepository;
import edu.bu.oneshelf.products.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;



    private final Path productImagesLocation = Paths.get("images", "products");


    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(Product::toMap).toList();
    }


    public  ProductResponse addProduct(AddProductRequest productRequest){



        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(
                () -> new ProductDetailsNotExistsException("Category not found")
        );


        Product product;
        try {
            product = productRequest.toProduct(category, productImagesLocation);
        } catch (IOException e) {
            throw new ImageException("Error while saving image");
        }
        return productRepository.save(product).toMap();
    }






    public byte[] getImage(String name) {

        Path path = productImagesLocation.resolve(name);

        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ImageException("Error reading image");
        }

    }



}
