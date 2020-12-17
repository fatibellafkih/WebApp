package com.projet.pwa.model;

import javax.persistence.Embeddable;

@Embeddable
public class InfosAutomate {
	private String etat;
	private Double temperature;
	
	private EtatSysPaiement  etatSysPaiement;
	
	public InfosAutomate() {
		super();
		this.etat = "NA_Etat";
		this.temperature = (double) 0;
		this.etatSysPaiement = new EtatSysPaiement();
	}
	
	public InfosAutomate(String etat, Double temperature, EtatSysPaiement etatSysPaiement) {
		super();
		this.etat = etat;
		this.temperature = temperature;
		this.etatSysPaiement = etatSysPaiement;
	}

	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public EtatSysPaiement getEtatSysPaiement() {
		return etatSysPaiement;
	}

	public void setEtatSysPaiement(EtatSysPaiement etatSysPaiement) {
		this.etatSysPaiement = etatSysPaiement;
	}
	
	
	

}
