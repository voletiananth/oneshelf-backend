package edu.bu.oneshelf.auth.services;


import edu.bu.oneshelf.auth.TokenUtils;
import edu.bu.oneshelf.auth.dto.*;
import edu.bu.oneshelf.auth.exceptions.UserExistsException;
import edu.bu.oneshelf.auth.models.ManagerDetails;
import edu.bu.oneshelf.auth.models.Role;
import edu.bu.oneshelf.auth.models.User;
import edu.bu.oneshelf.auth.repositories.ManagerDetailsRepository;
import edu.bu.oneshelf.auth.repositories.UserRepository;
import edu.bu.oneshelf.pantry.exceptions.PantryDoesNotExistsException;
import edu.bu.oneshelf.pantry.models.Pantry;
import edu.bu.oneshelf.pantry.repository.PantryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class  UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ManagerDetailsRepository managerDetailsRepository;

    private final PantryRepository pantryRepository;



    public User getUserByUsername(String username) {
       return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User createUser(AuthenticationRequest authenticationRequest, Role role) {
            userRepository.findByUsername(authenticationRequest.getUsername()).ifPresent(user -> {
                throw new UserExistsException("User already exists");
            });
            User user = new User();
            user.setUsername(authenticationRequest.getUsername());
            user.setPassword(bCryptPasswordEncoder.encode(authenticationRequest.getPassword()));
            user.setRole(role);
          return  userRepository.save(user);
    }

    public AccessTokenResponse getAccessTokenResponse(RefreshTokenRequest refreshTokenRequest) {
        User user = getUserByUsername(refreshTokenRequest.getUsername());
        String access = TokenUtils.encodeAccessToken(user);
        return new AccessTokenResponse(access);
    }





    @Transactional
    public void createManager(ManagerRegisterRequest authenticationRequest) {
        User user = createUser(authenticationRequest, Role.MANAGER);
        Pantry pantry = pantryRepository.findById(authenticationRequest.getPantryId()).orElseThrow(() ->
                new PantryDoesNotExistsException("Pantry does not exists"));
        ManagerDetails managerDetails = new ManagerDetails();
        managerDetails.setUser(user);
        managerDetails.setPantry(pantry);
        managerDetailsRepository.save(managerDetails);

    }


    public void deleteUser(String username) {
        userRepository.findByUsername(username).ifPresent(userRepository::delete);
    }

    public void updateManager(UpdateManagerPantry authenticationRequest) {
        ManagerDetails managerDetails = managerDetailsRepository.findByUserUsername(authenticationRequest.getUsername()).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        Pantry pantry = pantryRepository.findById(authenticationRequest.getPantryId()).orElseThrow(() ->  new PantryDoesNotExistsException("Pantry does not exists"));

        managerDetails.setPantry(pantry);
        managerDetailsRepository.save(managerDetails);

    }
}
