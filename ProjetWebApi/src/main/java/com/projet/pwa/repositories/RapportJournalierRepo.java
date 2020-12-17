package com.projet.pwa.repositories;

import org.springframework.stereotype.Repository;

import com.projet.pwa.model.RapportJournalier;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface RapportJournalierRepo extends JpaRepository<RapportJournalier, Long> {

	@Query(value = "SELECT * FROM rapport_journalier WHERE numero_serie =?1 ", nativeQuery = true)
	List<RapportJournalier> findRapportJournalierByNumeroSerie_Repo(Long numeroSerie);
}
