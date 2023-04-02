package edu.bu.oneshelf.pantry;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;

import java.util.concurrent.locks.ReentrantLock;

@Converter(autoApply = true)
public class CoordinateConverter implements AttributeConverter<Point, String> {

    private static final WKTWriter WKB_WRITER = new WKTWriter();

    private static final WKTReader WKB_READER = new WKTReader();

    private static final ReentrantLock WRITE_LOCK = new ReentrantLock();

    private static final ReentrantLock READ_LOCK = new ReentrantLock();



    @Override
    public String convertToDatabaseColumn(Point attribute) {
        try {
            WRITE_LOCK.lock();

            System.out.println("Latitude: " + attribute.getCoordinate().y + " Longitude: " + attribute.getCoordinate().x);
            return WKB_WRITER.write(attribute);
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    @Override
    public Point convertToEntityAttribute(String dbData) {
        try {
            READ_LOCK.lock();

            return (Point) WKB_READER.read(dbData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            READ_LOCK.unlock();
        }
    }


}
