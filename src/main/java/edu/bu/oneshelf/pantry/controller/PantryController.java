package edu.bu.oneshelf.pantry.controller;


import edu.bu.oneshelf.pantry.dto.AddPantryRequest;
import edu.bu.oneshelf.pantry.dto.PantryResponse;
import edu.bu.oneshelf.pantry.dto.PantryUpdateRequest;
import edu.bu.oneshelf.pantry.service.PantryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/api/v1/admin/pantry/")
@AllArgsConstructor
public class PantryController {


    private final PantryService pantryService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PantryResponse addPantry(@Valid @RequestBody AddPantryRequest pantry){
        return pantryService.addPantry(pantry);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  List<PantryResponse> getAllPantry(){
        return pantryService.getAllPantry();
    }







    @PutMapping(path = "{storeId}/")
    public PantryResponse updatePantry(@PathVariable("storeId") Long storeId,@RequestBody PantryUpdateRequest pantry){
        return pantryService.updatePantry(storeId,pantry);
    }




}
