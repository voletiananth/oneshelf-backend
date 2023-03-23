package edu.bu.oneshelf.pantry.dto;


import edu.bu.oneshelf.pantry.models.Pantry;
import edu.bu.oneshelf.pantry.utils.Zipcode;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import java.util.Objects;

@Data
@NoArgsConstructor
public class PantryUpdateRequest {

    private String name;

    private String description;

    private String streetAddress;

    private String city;

    private String state;

    private Integer zipcode;

    private String phone;

    private String email;

    private Double latitude;

    private Double longitude;


    public Pantry updatePantry(Pantry pantry) {
       if (name != null && !name.isBlank()  && !Objects.equals(pantry.getName(), name))
           pantry.setName(name);
         if (description != null && !description.isBlank() && !Objects.equals(pantry.getDescription(), description))
              pantry.setDescription(description);
            if (streetAddress != null && !streetAddress.isBlank() && !Objects.equals(pantry.getStreetAddress(), streetAddress))
                pantry.setStreetAddress(streetAddress);
            if (city != null && !city.isBlank() && !Objects.equals(pantry.getCity(), city))
                pantry.setCity(city);
            if (state != null && !state.isBlank() && !Objects.equals(pantry.getState(), state))
                pantry.setState(state);
            if (zipcode != null && !Objects.equals(pantry.getZipcode(), zipcode) && Zipcode.isValidZipcode(zipcode))
                pantry.setZipcode(zipcode);
            if (phone != null && !phone.isBlank() && !Objects.equals(pantry.getPhone(), phone))
                pantry.setPhone(phone);
            if (email != null && !email.isBlank() && !Objects.equals(pantry.getEmail(), email))
                pantry.setEmail(email);
            if (latitude != null && longitude != null &&  !Objects.equals(pantry.getCoordinate(), new GeometryFactory().createPoint(new org.locationtech.jts.geom.Coordinate(longitude, latitude)))){
                GeometryFactory geometryFactory = new GeometryFactory();
                pantry.setCoordinate(geometryFactory.createPoint(new org.locationtech.jts.geom.Coordinate(longitude, latitude)));
            }

        return pantry;
    }
}
