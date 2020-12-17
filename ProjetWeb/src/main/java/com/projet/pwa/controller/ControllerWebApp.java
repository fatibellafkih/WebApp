package com.projet.pwa.controller;

import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.projet.pwa.model.*;
import com.projet.pwa.model.automate.Adresse;
import com.projet.pwa.model.automate.Automate;
import com.projet.pwa.model.automate.Coordonnees;
import com.projet.pwa.model.automate.Emplacement;
import com.projet.pwa.model.meteo.Main;


@Controller
public class ControllerWebApp {

	public List<RapportJournalier> getApi(final String path, final HttpMethod method) {
		final RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<List<RapportJournalier>> response = restTemplate.exchange(path, method, null,
				new ParameterizedTypeReference<List<RapportJournalier>>() {
				});
		List<RapportJournalier> list = response.getBody();
		return list;
	}

	public List<Automate> getAutomateAPI(final String path, final HttpMethod method) {
		final RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<List<Automate>> response = restTemplate.exchange(path, method, null,
				new ParameterizedTypeReference<List<Automate>>() {
				});
		List<Automate> liste = response.getBody();
		return liste;
	}

	@GetMapping("/printRapport")
	public String getRapport(Model model) throws Exception {
		
		List<RapportJournalier> rapports = this.getApi("http://localhost:8080/pwa/services/rapportjournalier/all",
				HttpMethod.GET);
		Collections.sort(rapports, (d1, d2) -> {
			return (int) (d2.getBenefice() - d1.getBenefice());
		});
		model.addAttribute("rapports", rapports);

		List<Automate> automates = this.getAutomateAPI("http://localhost:8080/pwa/services/automate/all",
				HttpMethod.GET);
		int nbAutomate = automates.size();
		float meteo[];
		if (nbAutomate != 0) {
			Automate dernier = automates.get(nbAutomate - 1);
			nbAutomate = dernier.getNumeroSerie();
			meteo = new float[nbAutomate];
		} else {
			meteo = new float[1];
		}

		String ville;
		String pays;
		for (Automate automate : automates) {
			ville = automate.getAdresseInstallation().getVille();
			pays = automate.getAdresseInstallation().getPays();
			RestTemplate restTemplate = new RestTemplate();
			Main meteoActuelle = restTemplate
					.getForObject("http://api.openweathermap.org/data/2.5/weather?units=metric&lang=fr&q=" + ville + ","
							+ pays + "&appid=c76f396b22c427c5f3ccb1a63912ca9e", Main.class);
			meteo[automate.getNumeroSerie() - 1] = meteoActuelle.getMain().getTemp();
		}
		model.addAttribute("meteo", meteo);

		return "printRapport";
	}

	@GetMapping("/printAutomates")
	public String getAutomates(Model model) throws Exception {

		// Make the HTTP GET request, marshaling the response from JSON to an array of
		// Events
		List<Automate> automates = this.getAutomateAPI("http://localhost:8080/pwa/services/automate/all",
				HttpMethod.GET);

		model.addAttribute("automates", automates);
		return "printAutomates";
	}
	
	@GetMapping(path= "/addAutomate")
	public void addAutomate(@RequestParam(name="type", required=false, defaultValue="Null") String type, 
										  @RequestParam(name="voie", required=false, defaultValue="Null") String voie,
										  @RequestParam(name="code_postal", required=false, defaultValue="0") long codePostal, 
										  @RequestParam(name="ville", required=false, defaultValue="Null") String ville, 
										  @RequestParam(name="pays",required=false, defaultValue="Null") String pays, 
										  @RequestParam(name="batiment", required=false, defaultValue="0") int batiment, 
										  @RequestParam(name="etage", required=false, defaultValue="0") int etage, 
										  @RequestParam(name="escalier", required=false, defaultValue="0") int escalier, 
										  @RequestParam(name="longitude", required=false, defaultValue="0") long longitude, 
										  @RequestParam(name="latitude", required=false, defaultValue="0") long latitude, 
										  @RequestParam(name="commentaire", required=false, defaultValue="Null") String commentaire, 
										  Model model) throws Exception 
	{  
		if(type.equals("Null")) {
			int added = 0;
		    model.addAttribute("added", added);
		}
		else {
		    RestTemplate restTemplate = new RestTemplate();
		    final String baseUrl = "http://localhost:8080/pwa/services/automate/add";
		    URI uri = new URI(baseUrl);
		    
		    Adresse adresse = new Adresse(voie, codePostal, ville, pays);
		    Coordonnees coordonnees = new Coordonnees(longitude,latitude);
		    Emplacement emplacement = new Emplacement(batiment, etage, escalier);
		    Date dateIntervention = new Date();
		    Automate automate = new Automate(type, adresse, emplacement, coordonnees, dateIntervention , commentaire);
	
		    restTemplate.postForEntity(uri, automate, String.class);
			int added = 1;
		    model.addAttribute("added", added);		    
		}
	}

	
	@GetMapping(path= "/deleteAutomate")	
	public void deleteAutomate(@RequestParam(name="numero_serie", required=true, defaultValue="0") int numeroSerie, Model model)
	{
		if(numeroSerie == 0) {
			int deleted = 0;
		    model.addAttribute("deleted", deleted);
		}
		else {
		    final String uri = "http://localhost:8080/pwa/services/automate/deleteAutomate/"+numeroSerie;	     
		    RestTemplate restTemplate = new RestTemplate();
		    restTemplate.delete ( uri);
		    int deleted = 1;
		    model.addAttribute("deleted", deleted);
		}
	}
}
