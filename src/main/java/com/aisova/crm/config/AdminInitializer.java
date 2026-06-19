package com.aisova.crm.config;


import com.aisova.crm.entity.Role;
import com.aisova.crm.entity.User;
import com.aisova.crm.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (!userRepository.existsByEmail("admin@gmail.com")) {
            User admin = new User();
            admin.setUsername("admin_user");
            admin.setEmail("admin@gmail.com");
            // Encoding the password to securely store it in the H2 DB
            admin.setPassword(passwordEncoder.encode("Admin@123"));
            admin.setRole(Role.ROLE_ADMIN);

            userRepository.save(admin);
            System.out.println("Admin Account created Successfully");
        }
        else{
            System.out.println("Admin Account Already Exists");
        }
    }
}