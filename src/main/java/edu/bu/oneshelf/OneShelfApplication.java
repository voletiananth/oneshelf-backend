package edu.bu.oneshelf;

import edu.bu.oneshelf.auth.models.Role;
import edu.bu.oneshelf.auth.models.User;
import edu.bu.oneshelf.auth.repositories.UserRepository;
import edu.bu.oneshelf.auth.services.UserService;
import edu.bu.oneshelf.slot.models.SlotTime;
import edu.bu.oneshelf.slot.repositories.SlotTimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@AllArgsConstructor
public class OneShelfApplication {

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final SlotTimeRepository slotTimeRepository;

    public static void main(String[] args) {
        SpringApplication.run(OneShelfApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context){
        return args -> {
            User user = new User();
            user.setUsername("oneshelf");
            user.setPassword(passwordEncoder.encode("oneshelf"));
            user.setRole(Role.ADMIN);
            userRepository.findByUsername(user.getUsername()).ifPresentOrElse(u -> {}, () -> userRepository.save(user));
        };

    }


    @Bean
    public CommandLineRunner commandLineRunner2(ApplicationContext context){
        return args -> {
            long count = slotTimeRepository.count();
            if (count < 24){
                slotTimeRepository.deleteAll();
            }else if (count == 24){
                return;
            }

            slotTimeRepository.saveAll(SlotTime.generate());
        };
    }




}
