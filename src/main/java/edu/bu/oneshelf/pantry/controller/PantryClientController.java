package edu.bu.oneshelf.pantry.controller;


import edu.bu.oneshelf.pantry.dto.*;
import edu.bu.oneshelf.pantry.service.PantryInventoryService;
import edu.bu.oneshelf.pantry.service.PantryService;
import edu.bu.oneshelf.products.dto.CategoryProductResponse;
import edu.bu.oneshelf.products.dto.CategoryResponse;
import edu.bu.oneshelf.products.dto.ProductResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/client/pantry/")
@AllArgsConstructor
@Validated
public class PantryClientController {


    private final PantryService pantryService;
    private final PantryInventoryService pantryInventoryService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PantryResponse> getAllPantriesByGeo(@RequestParam(value = "zipcode", required = false) Integer zipcode, @Valid @RequestBody(required = false) PantryCoordinatesRequest pantry)
    {
        return pantryService.getAllPantriesByGeo(zipcode,pantry);
    }


    @GetMapping("{pantryId}/products/")
    @ResponseStatus(HttpStatus.OK)
    public PantryCategoryAndProductsResponse getPantryProducts(@PathVariable("pantryId") Long pantryId)
    {
        return pantryInventoryService.getPantryCategoriesAndProducts(pantryId);
    }


    @GetMapping("{pantryId}/categories/")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getPantryCategories(@PathVariable("pantryId") Long pantryId)
    {
        return pantryInventoryService.getPantryCategories(pantryId);
    }



    @PostMapping("products/")
    public List<ProductAndCartQuantityResponse> getPantryProductsByCategory(@RequestBody @Valid PantryProductsRequest pantryProductsRequest)
    {
        return pantryInventoryService.getPantryProductsByCategory(pantryProductsRequest);
    }
















}
