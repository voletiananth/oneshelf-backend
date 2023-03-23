package edu.bu.oneshelf.products.services;


import edu.bu.oneshelf.common.ImageUtils;
import edu.bu.oneshelf.products.dto.AddProductRequest;
import edu.bu.oneshelf.products.dto.ProductImagesResponse;
import edu.bu.oneshelf.products.dto.ProductResponse;
import edu.bu.oneshelf.products.exceptions.CategoryExistsException;
import edu.bu.oneshelf.products.exceptions.ImageException;
import edu.bu.oneshelf.products.exceptions.ProductDetailsNotExistsException;
import edu.bu.oneshelf.products.models.Category;
import edu.bu.oneshelf.products.models.Product;
import edu.bu.oneshelf.products.models.ProductGallery;
import edu.bu.oneshelf.products.models.ProductImage;
import edu.bu.oneshelf.products.repositories.CategoryRepository;
import edu.bu.oneshelf.products.repositories.ProductGalleryRepository;
import edu.bu.oneshelf.products.repositories.ProductImageRepository;
import edu.bu.oneshelf.products.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductGalleryRepository productGalleryRepository;
    private final CategoryRepository categoryRepository;

    private final ProductImageRepository productImageRepository;

    private final Path productImagesLocation = Paths.get("images", "products");


    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(Product::toMap).toList();
    }


    public  ProductResponse addProduct(AddProductRequest productRequest){
        ProductGallery productGallery = productGalleryRepository.findById(productRequest.getImageId()).orElseThrow(
                () -> new ProductDetailsNotExistsException("Product Images not found")
        );
       productRepository.findByNameOrGalleryId(productRequest.getName(),productGallery).ifPresent(
                (product) -> {
                    throw new CategoryExistsException("Product already exists");
                }
        );

        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(
                () -> new ProductDetailsNotExistsException("Category not found")
        );


        Product product;
        try {
            product = productRequest.toProduct(category, productGallery,productImagesLocation);
        } catch (IOException e) {
            throw new ImageException("Error while saving image");
        }
        return productRepository.save(product).toMap();
    }


    @Transactional
    public ProductImagesResponse addProductImages(MultipartFile file){

        ProductGallery productGallery = productGalleryRepository.save(new ProductGallery());

        ProductImage  image =  getProductImagesResponse(file, productGallery);

        productGallery.addProductImage(image);

        return productGallery.toMap();

    }

    private ProductImage getProductImagesResponse(MultipartFile file, ProductGallery productGallery) {
        String fileName ;
        try {
            fileName = ImageUtils.saveImage(productImagesLocation, file);
        } catch (IOException e) {
            throw new ImageException("Error while saving image");
        }

        ProductImage productImage = new ProductImage();
        productImage.setFile(fileName );
        productImage.setProduct_gallery(productGallery);
        return productImageRepository.save(productImage);
    }


    public ProductImagesResponse addProductImages(Long id,MultipartFile file){

        ProductGallery productGallery = productGalleryRepository.findById(id).orElseThrow(
                () -> new ProductDetailsNotExistsException("Product Images not found")
        );

        getProductImagesResponse(file, productGallery);


        return productGallery.toMap();

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
