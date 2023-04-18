package edu.bu.oneshelf.products.models;

import edu.bu.oneshelf.common.BaseModel;
import edu.bu.oneshelf.common.Mapper;
import edu.bu.oneshelf.products.dto.ProductImagesResponse;
import edu.bu.oneshelf.products.utils.ImagesMapping;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


@Data
@Entity(name = "product_gallery")
@EqualsAndHashCode(callSuper = true,exclude = {"product_images","product"})
@NoArgsConstructor
@Builder
@Table(name = "product_gallery")
@AllArgsConstructor
public class ProductGallery extends BaseModel implements Mapper<ProductImagesResponse> {

        @OneToOne(mappedBy = "product_gallery", targetEntity =  Product.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @ToString.Exclude
        Product product;

        @OneToMany(mappedBy = "product_gallery" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity = ProductImage.class)
        @ToString.Exclude
        List<ProductImage> product_images = new ArrayList<>();


        String name;

        public void addProductImage(ProductImage productImage){
                this.product_images.add(productImage);
        }



        private String mapImages(@NotNull ProductImage image) {
                return ImagesMapping.getProductUrl(image.getFile());
        }

        @Override
        public ProductImagesResponse toMap() {
                return ProductImagesResponse.builder()
                        .id(this.getId())
                        .images(this.product_images.stream().map(this::mapImages).toList())
                        .build();
        }
}
