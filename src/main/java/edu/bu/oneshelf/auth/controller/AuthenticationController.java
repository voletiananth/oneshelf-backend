package edu.bu.oneshelf.auth.controller;


import edu.bu.oneshelf.auth.dto.AuthenticationRequest;
import edu.bu.oneshelf.auth.dto.ManagerRegisterRequest;
import edu.bu.oneshelf.auth.dto.UpdateManagerPantry;
import edu.bu.oneshelf.auth.models.Role;
import edu.bu.oneshelf.auth.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@PreAuthorize("hasAuthority(Role.ADMIN.toString())")
@Validated
@RequestMapping("api/v1/auth/")
public class AuthenticationController {


    private UserService userService;

    @PostMapping("register/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String>  register(@RequestBody @Valid AuthenticationRequest authenticationRequest){
        userService.createUser(authenticationRequest, Role.ADMIN);
        return ResponseEntity.ok("Admin created successfully");
    }



    @PostMapping("register/manager/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String>  register(@RequestBody @Valid ManagerRegisterRequest authenticationRequest){
        userService.createManager(authenticationRequest);
        return ResponseEntity.ok("Manager created successfully");
    }


    @PutMapping("manager/")
    public ResponseEntity<String>  updateManager(@RequestBody @Valid UpdateManagerPantry authenticationRequest){
        userService.updateManager(authenticationRequest);
        return ResponseEntity.ok("Manager details updated successfully");
    }


}
