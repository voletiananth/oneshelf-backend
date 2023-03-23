package edu.bu.oneshelf.products.controller;


import edu.bu.oneshelf.products.dto.ProductImagesResponse;
import edu.bu.oneshelf.products.services.CategoryService;
import edu.bu.oneshelf.products.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Validated
@RequestMapping(path = "/api/v1/client/")
@AllArgsConstructor
public class ProductClientController {
    public final ProductService productService;
    private final CategoryService categoryService;


    @GetMapping("product/images/{name}")
    public ResponseEntity<byte[]> getProductImages(@PathVariable String name){
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(productService.getImage(name));
    }


    @GetMapping(path = "category/images/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable String name) {
        byte[] file = categoryService.getImage(name);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(file);

    }

}
