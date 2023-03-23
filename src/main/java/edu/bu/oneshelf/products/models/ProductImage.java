package edu.bu.oneshelf.products.models;
import edu.bu.oneshelf.common.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Table(name = "product_images")
@Data

@EqualsAndHashCode(callSuper = true)
public class ProductImage  extends BaseModel {



        @Column(unique = true)
        private String file;

        @ManyToOne()
        @ToString.Exclude
        @JoinColumn(name = "product_gallery_id")
        ProductGallery product_gallery;
}
