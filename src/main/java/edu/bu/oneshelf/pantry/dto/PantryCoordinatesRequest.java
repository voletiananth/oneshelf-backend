package edu.bu.oneshelf.pantry.dto;


import edu.bu.oneshelf.pantry.exceptions.CoordinatesException;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

@Data
public class PantryCoordinatesRequest {

    @NotNull(message = "Latitude cannot be null")
    private Double latitude;
    @NotNull(message = "Longitude cannot be null")
    private Double longitude;

    @NotNull(message = "Range cannot be null")
    @Max(value = 50L, message = "Range cannot be greater than 50 miles")
    private Double range = 50.0;

    public Point toPoint() {
        if (this.latitude == null || this.longitude == null ) {
            throw new CoordinatesException("Invalid coordinates");
        }
        System.out.println("Latitude: " + this.latitude + " Longitude: " + this.longitude + " Range: " + this.range);

        GeometryFactory geometryFactory = new GeometryFactory();

        return geometryFactory.createPoint(new Coordinate(this.longitude, this.latitude));
    }

}
