package org.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// Spieghiamo a Spring dove cercare i componenti, visto che sono in pacchetti paralleli
@EntityScan(basePackages = {"Membro.entity", "Hackathon.entity", "Team.entity", "Utente.entity"})
@EnableJpaRepositories(basePackages = {"Membro.entity", "Hackathon.entity", "Team.entity", "Utente.entity"})
public class HackHubApplication {
    public static void main(String[] args) {
        SpringApplication.run(HackHubApplication.class, args);
    }
}