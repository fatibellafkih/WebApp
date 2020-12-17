package com.projet.pwa.model.automate;

public class Emplacement {
	private int batiment;
	private int etage;
	private int escalier;
	
	
	public Emplacement(int batiment, int etage, int escalier) {
		super();
		this.batiment = batiment;
		this.etage = etage;
		this.escalier = escalier;
	}


	public int getBatiment() {
		return batiment;
	}


	public void setBatiment(int batiment) {
		this.batiment = batiment;
	}


	public int getEtage() {
		return etage;
	}


	public void setEtage(int etage) {
		this.etage = etage;
	}


	public int getEscalier() {
		return escalier;
	}


	public void setEscalier(int escalier) {
		this.escalier = escalier;
	}
	
	
	@Override
	public String toString() {
		return "Emplacement{" +
		        "batiment: " + batiment + "\n" +
		        "etage: " + etage + "\n" +
		        "escalier:  " + escalier +
		        '}';
	}
	
	
	

}
