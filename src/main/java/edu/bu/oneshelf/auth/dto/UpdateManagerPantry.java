package edu.bu.oneshelf.auth.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateManagerPantry {
    @NotBlank(message = "User name is required")
    String username;
    @NotNull(message = "Pantry id is required")
    Long pantryId;
}
