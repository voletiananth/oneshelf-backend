package edu.bu.oneshelf.pantry.dto;


import edu.bu.oneshelf.pantry.exceptions.CoordinatesException;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTWriter;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;


@Data
public class PantryCoordinatesRequest {

    @NotNull(message = "Latitude cannot be null")
    private Double latitude;
    @NotNull(message = "Longitude cannot be null")
    private Double longitude;

    @NotNull(message = "Range cannot be null")
    @Max(value = 50L, message = "Range cannot be greater than 50 miles")
    private Double range = 50.0;

    public String toPoint() {
        WKTWriter wktWriter = new WKTWriter();
        if (this.latitude == null || this.longitude == null) {
            throw new CoordinatesException("Invalid coordinates");
        }
        System.out.println("Latitude: " + this.latitude + " Longitude: " + this.longitude + " Range: " + this.range);


        Point point =  new GeometryFactory().createPoint(new Coordinate(this.longitude, this.latitude));
        return wktWriter.write(point);

    }
}
