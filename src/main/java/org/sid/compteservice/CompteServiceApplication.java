package org.sid.compteservice;

import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.enums.TypeCompte;
import org.sid.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Compte.class);
            compteRepository.save(new Compte(null,86000,new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null,14000,new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null,5000,new Date(), TypeCompte.COURANT));
            compteRepository.findAll().forEach(cp -> {
                System.out.println(cp.getType());
                System.out.println(cp.getSolde());
            });
        };
    }


}
