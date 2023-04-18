package edu.bu.oneshelf.products.controller;


import edu.bu.oneshelf.common.BadRequestException;
import edu.bu.oneshelf.products.dto.*;
import edu.bu.oneshelf.products.services.CategoryService;
import edu.bu.oneshelf.products.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Validated
@RequestMapping(path = "/api/v1/admin/")
@AllArgsConstructor
public class ProductController {
    public final ProductService productService;
    private final CategoryService categoryService;


    @PostMapping("category/")
    public CategoryResponse addCategory(@Valid @ModelAttribute CategoryRequest category){
        return categoryService.addCategory(category);
    }



    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "product/")
    public ProductResponse addProduct(@Valid @ModelAttribute AddProductRequest productRequest){

        return productService.addProduct(productRequest);
    }

    @PostMapping("product/images/")
    public ProductImagesResponse addProductImages(@RequestParam(value = "id",required = false) Long id,@RequestParam(value = "name",required = false) String name ,@RequestParam(value = "image") MultipartFile file){
        if (id == null && name != null)
            return productService.addProductImages(file,name);
        else if (name == null)
            throw new BadRequestException("name is required");

        return productService.addProductImages(id,file);
    }










}
