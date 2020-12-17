package com.projet.pwa.service.rapportJournalier;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projet.pwa.model.RapportJournalier;

import com.projet.pwa.repositories.RapportJournalierRepo;

@Service
public class RapportJournalierServiceImpl implements RapportJournalierService {
	private final RapportJournalierRepo rapportJournalierRepo;

	public RapportJournalierServiceImpl(RapportJournalierRepo rapportJournalierRepo) {
		super();
		this.rapportJournalierRepo = rapportJournalierRepo;
	}

	@Override
	public RapportJournalier findRapportJournalierById(Long id) {
		return rapportJournalierRepo.findById(id).get();
	}

	@Override
	public List<RapportJournalier> findRapportJournalierByNumeroSerie(Long NumeroSerie) {
		return rapportJournalierRepo.findRapportJournalierByNumeroSerie_Repo(NumeroSerie);
	}

	@Override
	public List<RapportJournalier> findAllRapportJournalier() {
		return rapportJournalierRepo.findAll();
	}

	@Override
	public RapportJournalier addRapportJournalier(RapportJournalier dailyReport) {
		return rapportJournalierRepo.save(dailyReport);
	}

	@Override
	public void deleteRapportJournalierById(Long id) {
		rapportJournalierRepo.deleteById(id);
	}

	@Override
	public List<RapportJournalier> addListRapportJournalier(List<RapportJournalier> dailyReports) {
		return rapportJournalierRepo.saveAll(dailyReports);
	}

	@Override
	public void deleteAllRapportJournalier() {
		rapportJournalierRepo.deleteAll();

	}

}
