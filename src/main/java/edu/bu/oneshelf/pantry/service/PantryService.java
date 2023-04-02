package edu.bu.oneshelf.pantry.service;

import edu.bu.oneshelf.common.BadRequestException;
import edu.bu.oneshelf.common.Pair;
import edu.bu.oneshelf.pantry.dto.AddPantryRequest;
import edu.bu.oneshelf.pantry.dto.PantryCoordinatesRequest;
import edu.bu.oneshelf.pantry.dto.PantryResponse;
import edu.bu.oneshelf.pantry.dto.PantryUpdateRequest;
import edu.bu.oneshelf.pantry.exceptions.CoordinatesException;
import edu.bu.oneshelf.pantry.exceptions.PantryDoesNotExistsException;
import edu.bu.oneshelf.pantry.exceptions.PantryExistsException;
import edu.bu.oneshelf.pantry.models.Pantry;
import edu.bu.oneshelf.pantry.repository.PantryRepository;
import edu.bu.oneshelf.pantry.utils.Zipcode;
import edu.bu.oneshelf.slot.models.SlotDay;
import edu.bu.oneshelf.slot.repositories.SlotDayRepository;
import jakarta.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PantryService {
    private final PantryRepository pantryRepository;
    private final SlotDayRepository slotDayRepository;


    @Transactional
    public PantryResponse addPantry(@NotNull AddPantryRequest pantryRequest) {
        try{
        Pantry pantry = pantryRepository.save(pantryRequest.toMap());
        slotDayRepository.saveAll(SlotDay.generate(pantry));
        return pantry.toMap();

        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            throw new PantryExistsException("Pantry with name " + pantryRequest.getName() + " already exists");
        }
        catch (Exception e){
            e.printStackTrace();
            throw new BadRequestException("Invalid request");
        }

    }



    public List<PantryResponse> getAllPantriesByGeo(Integer zipcode, PantryCoordinatesRequest pantryCoordinatesRequest){
        if(pantryCoordinatesRequest != null){
            return pantryRepository.findAllByCoordinatesAndRange(pantryCoordinatesRequest.toPoint(), pantryCoordinatesRequest.getRange()).stream().map(Pantry::toMap).toList();
        }
        else if(Zipcode.isValidZipcode(zipcode)){
            Pair<Integer, Integer> range = Zipcode.getZipcodeRange(zipcode);
           return pantryRepository.findByZipcodeBetween(range.getFirst(),range.getSecond()).stream().map(Pantry::toMap).toList();
        }
        else{
          throw new CoordinatesException("Invalid Coordinates or Zipcode");
        }
    }

    @Transactional
    public PantryResponse updatePantry(Long pantryId, @NotNull PantryUpdateRequest pantryRequest) {
        Pantry pantry = pantryRepository.findById(pantryId).orElseThrow(() -> new PantryDoesNotExistsException("Pantry with id " + pantryId + " does not exists"));

        return pantryRepository.save(pantryRequest.updatePantry(pantry)).toMap();
    }


    public List<PantryResponse> getAllPantry() {
        return pantryRepository.findAll().stream().map(Pantry::toMap).toList();
    }



}
