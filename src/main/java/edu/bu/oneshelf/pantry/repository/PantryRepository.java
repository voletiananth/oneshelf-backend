package edu.bu.oneshelf.pantry.repository;


import edu.bu.oneshelf.pantry.models.Pantry;
import edu.bu.oneshelf.products.models.Product;
import edu.bu.oneshelf.slot.models.WeekDay;
import org.jetbrains.annotations.NotNull;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PantryRepository extends JpaRepository<Pantry, Long>{








    @NotNull
    List<Pantry> findByZipcodeBetween(Integer from, Integer to);

    @Query(value = "SELECT * FROM pantry as p WHERE ST_Distance_Sphere(p.coordinates,:coordinates) * 0.000621371  <= :range", nativeQuery = true)
    List<Pantry> findAllByCoordinatesAndRange(Point coordinates, double range);


    @Query(value = "select p from pantry p join manager_details m on p.id = m.pantry.id where m.user.username = :username")
    Optional<Pantry> findByUsername(String username);



}
