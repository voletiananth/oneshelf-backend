package edu.bu.oneshelf.pantry.models;


import edu.bu.oneshelf.common.BaseModel;
import edu.bu.oneshelf.common.Mapper;
import edu.bu.oneshelf.pantry.dto.PantryResponse;
import jakarta.persistence.*;
import lombok.*;


import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.locationtech.jts.geom.Coordinate;

@Entity(name = "pantry")
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table( uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phone"),
        @UniqueConstraint(columnNames = "name"),
})
@Builder
@Data
public class Pantry extends BaseModel implements Mapper<PantryResponse> {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(name = "street", nullable = false)
    private String streetAddress;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false, length = 5)
    private Integer zipcode;
    @Column(nullable = false, unique = true, length = 10)
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Point<G2D> coordinates;









    @Override
    public PantryResponse toMap() {
        G2D point = coordinates.getPosition();
       return PantryResponse.builder()
                .id(this.getId())
                .name(this.name)
                .latitude(point.getLat())
                .longitude(point.getLon())
                .address(this.streetAddress + ", " + this.city + ", " + this.state + " " + this.zipcode)
                .email(email)
                .phone(phone)
                .build();
    }


}
