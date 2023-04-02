package edu.bu.oneshelf.pantry;

import edu.bu.oneshelf.pantry.models.LatLog;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKBWriter;

import java.util.concurrent.locks.ReentrantLock;

@Converter
public class CoordinateConverter implements AttributeConverter<LatLog, byte[]> {

    private static final WKBWriter WKB_WRITER = new WKBWriter();

    private static final WKBReader WKB_READER = new WKBReader();

    private static final ReentrantLock WRITE_LOCK = new ReentrantLock();

    private static final ReentrantLock READ_LOCK = new ReentrantLock();


    public byte[] convertToDatabaseColumn(LatLog attribute) {
        Point point = new GeometryFactory().createPoint(new Coordinate(attribute.getLng(), attribute.getLat()));
        try {
            WRITE_LOCK.lock();
            return WKB_WRITER.write(point);
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    @Override
    public LatLog convertToEntityAttribute(byte[] dbData) {
        try {
            READ_LOCK.lock();
            Geometry geometry = WKB_READER.read(dbData);
            return new LatLog(geometry.getCoordinate().y, geometry.getCoordinate().x);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            READ_LOCK.unlock();
        }
    }


}
