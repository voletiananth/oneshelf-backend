package edu.bu.oneshelf.auth.config;

import edu.bu.oneshelf.auth.models.Role;
import edu.bu.oneshelf.auth.models.User;
import edu.bu.oneshelf.auth.repositories.UserRepository;
import edu.bu.oneshelf.slot.models.SlotTime;
import edu.bu.oneshelf.slot.repositories.SlotTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveDataRunner implements CommandLineRunner {
    private final BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final SlotTimeRepository slotTimeRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner is running");
        User user = new User();
        user.setUsername("oneshelf");
        user.setPassword(passwordEncoder.encode("oneshelf"));
        user.setRole(Role.ADMIN);
        userRepository.findByUsername(user.getUsername()).ifPresentOrElse(u -> {}, () -> userRepository.save(user));

        long count = slotTimeRepository.count();
        if (count < 24){
            slotTimeRepository.deleteAll();
        }else if (count == 24){
            return;
        }

        slotTimeRepository.saveAll(SlotTime.generate());
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext context){
//        return args -> {
//            User user = new User();
//            user.setUsername("oneshelf");
//            user.setPassword(passwordEncoder.encode("oneshelf"));
//            user.setRole(Role.ADMIN);
//            userRepository.findByUsername(user.getUsername()).ifPresentOrElse(u -> {}, () -> userRepository.save(user));
//
//
//        };
//
//    }
//
//
//
//    public CommandLineRunner commandLineRunner2(ApplicationContext context){
//        return args -> {
//            long count = slotTimeRepository.count();
//            if (count < 24){
//                slotTimeRepository.deleteAll();
//            }else if (count == 24){
//                return;
//            }
//
//            slotTimeRepository.saveAll(SlotTime.generate());
//        };
//    }


}
