package com.projet.pwa.service.automate;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projet.pwa.model.automate.Automate;
import com.projet.pwa.repositories.AutomateRepo;

@Service
public class AutomateServiceImpl implements AutomateService {
	private final AutomateRepo automateRepo;

	public AutomateServiceImpl(AutomateRepo automateRepo) {
		super();
		this.automateRepo = automateRepo;
	}

	@Override
	public Automate findAutomateByNumeroSerie(Long numeroSerie) {
		return automateRepo.findById(numeroSerie).get();
	}

	@Override
	public List<Automate> findAllAutomate() {
		return automateRepo.findAll();
	}

	@Override
	public Automate addAutomate(Automate automate) {
		return automateRepo.save(automate);
	}

	@Override
	public List<Automate> addListAutomate(List<Automate> automates) {
		return automateRepo.saveAll(automates);
	}

	@Override
	public boolean existsAutomateByNumeroSerie(Long numeroSerie) {
		return automateRepo.existsById(numeroSerie);
	}

	@Override
	public void deleteAutomateByNumeroSerie(Long numeroSerie) {
		automateRepo.deleteById(numeroSerie);

	}

	@Override
	public void deleteAllAutomate() {
		automateRepo.deleteAll();

	}

}
