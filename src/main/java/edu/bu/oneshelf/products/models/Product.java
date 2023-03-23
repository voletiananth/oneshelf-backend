package edu.bu.oneshelf.products.models;


import edu.bu.oneshelf.common.BaseModel;
import edu.bu.oneshelf.common.ImageUtils;
import edu.bu.oneshelf.common.Mapper;
import edu.bu.oneshelf.products.dto.ProductResponse;
import edu.bu.oneshelf.products.utils.ImagesMapping;
import jakarta.persistence.*;
import lombok.*;

import java.util.StringJoiner;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel implements Mapper<ProductResponse> {


    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String thumbnail;



    @Column(nullable = false)
    private String brand;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "category_id")
    private Category category;


    @OneToOne( targetEntity = ProductGallery.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "product_gallery_id",unique = true)
    private ProductGallery product_gallery;







    @Override
    public ProductResponse toMap() {

        return ProductResponse.builder()
                .id(this.getId())

                .name(this.name)
                .description(this.description)
                .thumbnail(ImagesMapping.getProductUrl(this.thumbnail) )
                .brand(this.brand)
                .images_details(this.product_gallery.toMap())
                .categoryId(this.category.getId())
                .build();
    }
}
