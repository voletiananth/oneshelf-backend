package edu.bu.oneshelf.pantry.models;

import edu.bu.oneshelf.common.CreateUpdateTimeStampModel;
import edu.bu.oneshelf.common.Mapper;
import edu.bu.oneshelf.pantry.dto.AddPantryProductResponse;
import edu.bu.oneshelf.products.models.Product;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "pantry_inventory")
@Table( )
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
@IdClass(PantryInventoryKey.class)
public class PantryInventory extends CreateUpdateTimeStampModel implements Mapper<AddPantryProductResponse> {


        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
        @Id
        @JoinColumn(name = "pantry_id",updatable = false)
                @OnDelete(action = OnDeleteAction.CASCADE)
        Pantry pantry;


        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
        @Id
        @JoinColumn(name = "product_id",updatable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        Product product;



        int quantity = 0;

        @Override
        public AddPantryProductResponse toMap() {
                return AddPantryProductResponse.builder()
                        .productId(product.getId())

                        .quantity(quantity)
                        .build();
        }
}
