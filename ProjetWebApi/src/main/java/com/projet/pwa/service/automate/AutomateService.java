package com.projet.pwa.service.automate;

import java.util.List;

import com.projet.pwa.model.automate.Automate;

public interface AutomateService {

	Automate findAutomateByNumeroSerie(Long numeroSerie);
	List<Automate> findAllAutomate();
	Automate addAutomate(Automate automate);
	List<Automate> addListAutomate(List<Automate> automates);
	
	boolean existsAutomateByNumeroSerie(Long numeroSerie);
	void deleteAutomateByNumeroSerie(Long numeroSerie);
	void deleteAllAutomate();
}
