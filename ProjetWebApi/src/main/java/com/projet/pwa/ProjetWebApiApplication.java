package com.projet.pwa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.projet.pwa.controller"})  // scan JPA entities
@ComponentScan(basePackages= {"com.projet.pwa.controller","com.projet.pwa.service"})

@EnableJpaRepositories(basePackages= {"com.projet.pwa.repositories"})
public class ProjetWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetWebApiApplication.class, args);
	}

}