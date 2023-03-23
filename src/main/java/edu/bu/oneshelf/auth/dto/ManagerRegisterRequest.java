package edu.bu.oneshelf.auth.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ManagerRegisterRequest extends AuthenticationRequest{

    @NotNull(message = "Pantry Id is required")
    private  Long pantryId;
}
