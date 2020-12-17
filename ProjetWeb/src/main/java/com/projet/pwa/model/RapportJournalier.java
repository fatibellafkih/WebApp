package com.projet.pwa.model;

import java.util.Date;
import java.util.List;

public class RapportJournalier {
	private Long id;
	private String numeroSerie;
	private Date dateRapport;
	private String etat;
	
    private InfosAutomate infosAutomate;
    
    private List<RapportErreur> erreurs;
    
	private List<Article> articles;
	
	private Long benefice;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	
	public String getNumeroSerie() {
		return numeroSerie;
	}
	
	

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}



	public Date getDateRapport() {
		return dateRapport;
	}



	public void setDateRapport(Date dateRapport) {
		this.dateRapport = dateRapport;
	}



	public String getEtat() {
		return etat;
	}



	public void setEtat(String etat) {
		this.etat = etat;
	}



	public InfosAutomate getInfosAutomate() {
		return infosAutomate;
	}



	public void setInfosAutomate(InfosAutomate infosAutomate) {
		this.infosAutomate = infosAutomate;
	}



	public List<RapportErreur> getErreurs() {
		return erreurs;
	}



	public void setErreurs(List<RapportErreur> erreurs) {
		this.erreurs = erreurs;
	}



	public List<Article> getArticles() {
		return articles;
	}



	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}



	public Long getBenefice() {
		return benefice;
	}



	public void setBenefice(Long benefice) {
		this.benefice = benefice;
	}



	@Override
	  public String toString() {
	    return "RapportJournalier{" +
	        "numero_serie: " + numeroSerie + "\n" +
	        "date_rapport: " + dateRapport + "\n" +
	        "etat: " + etat + "\n" +
	        "informations_automate: " + infosAutomate.toString() + "\n" +
	        "erreurs: " + erreurs.toString() + "\n" +
	        "articles: " + articles.toString() + "\n" +
	        "benefice: " + benefice +
	        '}';
	  }

}
