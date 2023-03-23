package edu.bu.oneshelf.products.services;


import edu.bu.oneshelf.products.dto.CategoryProductResponse;
import edu.bu.oneshelf.products.dto.ProductResponse;
import edu.bu.oneshelf.products.exceptions.CategoryExistsException;
import edu.bu.oneshelf.products.models.Category;
import edu.bu.oneshelf.products.repositories.CategoryRepository;
import edu.bu.oneshelf.products.dto.CategoryRequest;
import edu.bu.oneshelf.products.dto.CategoryResponse;
import edu.bu.oneshelf.products.exceptions.ImageException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final Path imageFolder = Paths.get("images", "categories");


    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream().map(Category::toMap).toList();
    }


    public CategoryResponse addCategory(CategoryRequest categoryRequest) {

        categoryRepository.findCategoriesByName(categoryRequest.getName()).ifPresent(category -> {
                throw new CategoryExistsException("Category is Exists");

        });

        try {
            return categoryRepository.save(categoryRequest.saveThumbnailAndMapTo(imageFolder)).toMap();
        }catch (ImageException e){
            throw new ImageException("Image is required");
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new ImageException("Error saving image");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public byte[] getImage(String name) {
        Path path = imageFolder.resolve(name);
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ImageException("Error reading image");
        }

    }

    public List<CategoryProductResponse> getAllCategoriesWithProducts() {
        return categoryRepository.findAll().stream().map(Category::toMapWithProducts).toList();
    }


}
