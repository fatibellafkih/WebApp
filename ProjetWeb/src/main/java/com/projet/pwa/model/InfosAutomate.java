package com.projet.pwa.model;

public class InfosAutomate {
	private String etat; 
	private Double temperature;
	private EtatSysPaiment etatSysPaiment;
	
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
	
	public EtatSysPaiment getEtatSysPaiment() {
		return etatSysPaiment;
	}
	public void setEtatSysPaiment(EtatSysPaiment etatSysPaiment) {
		this.etatSysPaiment = etatSysPaiment;
	}
	@Override
	public String toString() {
		return "InformationsAutomate{" +
		        "etat: " + etat + "\n" +
		        "temperature: " + temperature + "\n"+
		        "etat_systeme_paiement: " + etatSysPaiment + "\n"+
		        '}';
	}
	
	
}
