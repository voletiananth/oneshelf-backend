package edu.bu.oneshelf.pantry.controller;


import edu.bu.oneshelf.pantry.dto.AddPantryProductRequest;
import edu.bu.oneshelf.pantry.dto.AddPantryProductResponse;
import edu.bu.oneshelf.pantry.service.PantryInventoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/manager/pantry/")
@AllArgsConstructor
public class PantryInventoryController {

    private final PantryInventoryService pantryInventoryService;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AddPantryProductResponse addPantryProducts(@AuthenticationPrincipal String username, @Valid @RequestBody AddPantryProductRequest pantryInventoryRequest){
        return  pantryInventoryService.addPantryProduct(username,pantryInventoryRequest);
    }



    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public AddPantryProductResponse updatePantryProducts(@AuthenticationPrincipal String user, @RequestBody AddPantryProductRequest pantryInventoryRequest){
        return pantryInventoryService.updatePantryProduct(user,pantryInventoryRequest);
    }

    @DeleteMapping(path = "products/{productId}/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deletePantryProduct(@AuthenticationPrincipal String user,@PathVariable("productId")Long productId){
        pantryInventoryService.deletePantryProduct(user,productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
