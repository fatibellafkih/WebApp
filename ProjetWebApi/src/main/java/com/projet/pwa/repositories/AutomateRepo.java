package com.projet.pwa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.pwa.model.automate.Automate;

@Repository
public interface AutomateRepo extends JpaRepository<Automate, Long> {

}
