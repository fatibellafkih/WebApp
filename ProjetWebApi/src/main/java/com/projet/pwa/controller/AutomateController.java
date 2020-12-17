package com.projet.pwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.projet.pwa.model.automate.Automate;
import com.projet.pwa.service.automate.AutomateService;

@RestController
@RequestMapping(path = AutomateController.BASE_URL )
public class AutomateController {
	
	public static final String BASE_URL = "/pwa/services/automate";
	public static final String PathGetAllAutomates = "/all";
	public static final String PathGetAutomateByNumeroSerie = "/numeroSerie/{NumeroSerie}";
	public static final String PathCheckAutomateByNumeroSerie = "/Check/numeroSerie/{NumeroSerie}";

	public static final String PathAddAutomate = "/add";
	public static final String PathAddListAutomate = "/add/list";
	public static final String PathDeleteAutomate = "/delete/{NumeroSerie}";
	public static final String PathDeleteAllAutomate = "/delete/all";
	
	@Autowired
	private AutomateService automateService;

	public AutomateController() {
		super();
	}
	public AutomateController(AutomateService automateService) {
		super();
		this.automateService = automateService;
	}
	
	@GetMapping(path=AutomateController.PathGetAllAutomates)
	public List<Automate> getAllAutomate(){
		return automateService.findAllAutomate();
	}
	
	@GetMapping(path=AutomateController.PathGetAutomateByNumeroSerie)
	public Automate getAutomateByNumeroSerie(@PathVariable Long NumeroSerie){
		return automateService.findAutomateByNumeroSerie(NumeroSerie);
	}
	@GetMapping(path=AutomateController.PathCheckAutomateByNumeroSerie)
	public Boolean CheckAutomateByNumeroSerie(@PathVariable Long NumeroSerie){
		return automateService.existsAutomateByNumeroSerie(NumeroSerie);
	}
	@PostMapping(path=AutomateController.PathAddAutomate)
	@ResponseStatus(HttpStatus.CREATED)
	public String addAutomate(@RequestBody Automate automate){
		Automate res =  automateService.addAutomate(automate);
		
		String msg; 
		if(res != null )msg = "Automate Ajoute avec succes" ;
		else msg = "Erreur d'ajout d'Automates";
		return msg; 
	}
	
	@PostMapping(path=AutomateController.PathAddListAutomate)
	@ResponseStatus(HttpStatus.CREATED)
	public String addListAutomate(@RequestBody List<Automate> automates){
		List<Automate> res =  automateService.addListAutomate(automates);
		
		String msg; 
		if(res != null )msg = "Automate Ajoute avec succes" ;
		else msg = "Erreur d'ajout d'Automates";
		return msg; 
	}
	
	@DeleteMapping(path=AutomateController.PathDeleteAutomate)
	public String deleteAutomateByNumeroSerie(@PathVariable Long NumeroSerie){
		automateService.deleteAutomateByNumeroSerie(NumeroSerie);
		return "Delete Completed";
	}
	
	@DeleteMapping(path=AutomateController.PathDeleteAllAutomate)
	public String deleteAllAutomate(){
		automateService.deleteAllAutomate();
		return "All Automate Have been Deleted";
	}

}
