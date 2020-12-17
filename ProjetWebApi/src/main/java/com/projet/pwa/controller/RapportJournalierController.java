package com.projet.pwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projet.pwa.model.RapportJournalier;
import com.projet.pwa.service.automate.AutomateService;
import com.projet.pwa.service.rapportJournalier.RapportJournalierService;

@RestController
@RequestMapping(path = RapportJournalierController.BASE_URL)
public class RapportJournalierController {

	public static final String BASE_URL = "/pwa/services/rapportJournalier";
	public static final String PathGetAllRapportJournalier = "/all";
	public static final String PathGetRapportJournalierByNumeroSerie = "/numeroSerie/{NumeroSerie}";
	public static final String PathGetRapportJournalierById = "/{id}";

	public static final String PathAddRapportJournalier = "/add";
	public static final String PathAddAllRapportJournalier = "/add/list";
	public static final String PathDeleteRapportJournalier = "/delete/{id}";
	public static final String PathDeleteAllRapportJournalier = "/delete/all";

	@Autowired
	private RapportJournalierService rapportJournalierService;
	@Autowired
	private AutomateService automateService;

	public RapportJournalierController() {
		super();
	}

	public RapportJournalierController(RapportJournalierService rapportJournalierService) {
		super();
		this.rapportJournalierService = rapportJournalierService;
	}

	@GetMapping(path = RapportJournalierController.PathGetAllRapportJournalier)
	public List<RapportJournalier> getAllRapportJournalier() {
		return rapportJournalierService.findAllRapportJournalier();
	}

	@GetMapping(path = RapportJournalierController.PathGetRapportJournalierById)
	public RapportJournalier getRapportJournalierById(@PathVariable Long id) {
		return rapportJournalierService.findRapportJournalierById(id);
	}

	@GetMapping(path = RapportJournalierController.PathGetRapportJournalierByNumeroSerie)
	public List<RapportJournalier> getRapportJournalierNumeroSerie(@PathVariable Long NumeroSerie) {
		return rapportJournalierService.findRapportJournalierByNumeroSerie(NumeroSerie);
	}

	@PostMapping(path = RapportJournalierController.PathAddRapportJournalier, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	// @PostMapping(path=RapportJournalierController.PathAddRapportJournalier)
	@ResponseStatus(HttpStatus.CREATED)
	public String addRapportJournalier(@RequestBody RapportJournalier rapportJournalier) {
		String msg;
		// AutomateController automateController = new AutomateController() ;

		Boolean automate_exist = automateService.existsAutomateByNumeroSerie(rapportJournalier.getNumeroSerie());

		if (automate_exist == true) {
			RapportJournalier res = rapportJournalierService.addRapportJournalier(rapportJournalier);
			if (res != null)
				msg = "Rapport Journalier ajoute avec succes";
			else
				msg = "Erreur lors de l'ajout du rapport journalier";
		} else {
			msg = "Erreur lors de l'ajout de l'automate avec le numero de serie (inexistant) ["
					+ rapportJournalier.getNumeroSerie() + "]";
		}

		return msg;
	}

	@DeleteMapping(path = RapportJournalierController.PathDeleteRapportJournalier)
	public String deleteRapportJournalierNumeroSerie(@PathVariable Long id) {
		rapportJournalierService.deleteRapportJournalierById(id);
		return "Suppression avec succes";
	}

	@PostMapping(path = RapportJournalierController.PathAddAllRapportJournalier, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public String addAllRapportJournalier(@RequestBody List<RapportJournalier> rapportJournaliers) {
		String msg = "[--] \n";
		// AutomateController automateController = new AutomateController() ;
		for (RapportJournalier rapportJournalier : rapportJournaliers) {
			Boolean automate_exist = automateService.existsAutomateByNumeroSerie(rapportJournalier.getNumeroSerie());
			// automateController.CheckAutomateByNumeroSerie(rapportJournalier.getNumeroSerie());

			if (automate_exist == true) {
				RapportJournalier res = rapportJournalierService.addRapportJournalier(rapportJournalier);
				if (res != null)
					msg += " [ RapportJournalier ajoute avec succes " + rapportJournalier.getNumeroSerie() + " ]\n";
				else
					msg += "Erreur lors de l'ajout du  RapportJournalier " + rapportJournalier.getNumeroSerie()
							+ " ]\n";
			} else {
				msg += " Erreur automate  [" + rapportJournalier.getNumeroSerie() + "] n'existe pas\n";
			}
		}

		return msg;
	}

	@DeleteMapping(path = RapportJournalierController.PathDeleteAllRapportJournalier)
	public String deleteAllRapportJournalierNumeroSerie() {
		rapportJournalierService.deleteAllRapportJournalier();
		return "Suppression des rapports avec succes";
	}

}
