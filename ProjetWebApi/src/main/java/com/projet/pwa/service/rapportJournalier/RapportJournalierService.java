package com.projet.pwa.service.rapportJournalier;

import java.util.List;

import com.projet.pwa.model.RapportJournalier;



public interface RapportJournalierService {
	RapportJournalier findRapportJournalierById(Long id);
	List<RapportJournalier> findRapportJournalierByNumeroSerie(Long NumeroSerie);
	List<RapportJournalier> findAllRapportJournalier();
	RapportJournalier addRapportJournalier(RapportJournalier dailyReport);
	List<RapportJournalier> addListRapportJournalier(List<RapportJournalier> dailyReports);
	
	void deleteRapportJournalierById(Long id);
	void deleteAllRapportJournalier();
}
