package com.api.apiajwt.config;

import com.api.apiajwt.model.User;
import com.api.apiajwt.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                userRepository.save(new User("admin", passwordEncoder.encode("123"), "ROLE_ADMIN"));
                System.out.println("Usuário admin criado.");
            }

            if (userRepository.findByUsername("user").isEmpty()) {
                userRepository.save(new User("user", passwordEncoder.encode("123"), "ROLE_USER"));
                System.out.println("Usuário user criado.");
            }
        };
    }
}
