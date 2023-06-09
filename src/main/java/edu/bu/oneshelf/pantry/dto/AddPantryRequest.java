package edu.bu.oneshelf.pantry.dto;


import edu.bu.oneshelf.common.Mapper;
import edu.bu.oneshelf.pantry.models.LatLog;
import edu.bu.oneshelf.pantry.models.Pantry;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.SneakyThrows;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;

@Data
public class AddPantryRequest implements Mapper<Pantry> {

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Latitude is required")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    private Double longitude;

    @NotNull(message = "Street is required")
    private String street;
    @NotNull(message = "City is required")
    private String city;

    @NotNull(message = "State is required")
    private String state;

    @NotNull(message = "Zipcode is required")
    @Min(value = 10000, message = "Zipcode should be 5 digits")
    @Max(value = 99999, message = "Zipcode should be 5 digits")
    private Integer zipcode;

    @NotNull(message = "Phone is required")
    private String phone;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Description is required")
    private String description;



    @SneakyThrows
    @Override
    public Pantry toMap() {


        System.out.println("Latitude: " + this.latitude + " Longitude: " + this.longitude);

        GeometryFactory geometryFactory = new GeometryFactory();

        Point point = geometryFactory.createPoint(new Coordinate(this.longitude, this.latitude));
        point.setSRID(4326);


        return Pantry.builder()
                 .name(this.name)
                 .description(this.description)
                 .streetAddress(this.street)
                 .city(this.city)
                 .state(this.state)
                 .zipcode(this.zipcode)
                 .phone(this.phone)
                 .email(this.email)
                 .coordinates(point)
                 .build();
    }
}
