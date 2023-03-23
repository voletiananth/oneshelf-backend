package edu.bu.oneshelf.auth.repositories;

import edu.bu.oneshelf.auth.models.ManagerDetails;
import edu.bu.oneshelf.pantry.models.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ManagerDetailsRepository extends JpaRepository<ManagerDetails,Long> {

    @Query("SELECT md.pantry FROM  manager_details md WHERE md.user.username = ?1")
    Optional<Pantry> findPantryByUser(String userName);


    Optional<ManagerDetails> findByUserUsername(String userName);
}
