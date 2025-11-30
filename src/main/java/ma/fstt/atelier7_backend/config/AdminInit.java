package ma.fstt.atelier7_backend.config;

import ma.fstt.atelier7_backend.entites.Admin;
import ma.fstt.atelier7_backend.repositories.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInit {

    @Bean
    CommandLineRunner init(AdminRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (!repo.findByEmail("admin").isPresent()) {
                Admin admin = new Admin();
                admin.setUsername("admin");
                admin.setEmail("admin@gmail.com");
                admin.setPassword(encoder.encode("1234"));
                repo.save(admin);
            }
        };
    }
}
