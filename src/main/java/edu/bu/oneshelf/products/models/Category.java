package edu.bu.oneshelf.products.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.bu.oneshelf.common.BaseModel;
import edu.bu.oneshelf.common.Mapper;
import edu.bu.oneshelf.products.dto.CategoryProductResponse;
import edu.bu.oneshelf.products.dto.CategoryResponse;
import edu.bu.oneshelf.products.dto.ProductResponse;
import edu.bu.oneshelf.products.utils.ImagesMapping;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;


@Data
@Entity
@Table(name = "categories")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true,exclude = {"products"})
public class Category extends BaseModel implements Mapper<CategoryResponse> {
        @Column(nullable = false, unique = true)
        private String name;

        @Column(nullable = false)
        private String description;

        @Column(nullable = false)
        private String thumbnail;

        @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
                @ToString.Exclude

        Set<Product> products = new HashSet<>();


      @Override
       public CategoryResponse toMap() {

            return CategoryResponse.builder()
                    .name(this.name)
                    .id(this.getId())
                    .description(this.description)
                    .thumbnail(ImagesMapping.getCategoryUrl(this.thumbnail))
                    .build();
        }


    public CategoryProductResponse toMapWithProducts() {

          return new CategoryProductResponse(this.toMap(), this.getProducts().stream().map(Product::toMap).toList());

    }


    public CategoryProductResponse toMapWithProducts(List<Product> products) {

        return new CategoryProductResponse(this.toMap(), products.stream().map(Product::toMap).toList());

    }

}
