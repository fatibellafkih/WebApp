package com.projet.pwa.model.automate;

import java.util.Date;

public class Automate {
	private int numeroSerie;
	private String type;
	private Adresse adresseInstallation;
	private Emplacement emplacement;
	private Coordonnees coordGps;
	private Date dateIntervention;
	private String commentaire;
	public Automate(String type, Adresse adresseInstallation, Emplacement emplacement,
			Coordonnees coordGps, Date dateIntervention, String commentaire) {
		super();
		this.type = type;
		this.adresseInstallation = adresseInstallation;
		this.emplacement = emplacement;
		this.coordGps = coordGps;
		this.dateIntervention = dateIntervention;
		this.commentaire = commentaire;
	}
	public int getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Adresse getAdresseInstallation() {
		return adresseInstallation;
	}
	public void setAdresseInstallation(Adresse adresseInstallation) {
		this.adresseInstallation = adresseInstallation;
	}
	public Emplacement getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(Emplacement emplacement) {
		this.emplacement = emplacement;
	}
	public Coordonnees getCoordGps() {
		return coordGps;
	}
	public void setCoordGps(Coordonnees coordGps) {
		this.coordGps = coordGps;
	}
	public Date getDateIntervention() {
		return dateIntervention;
	}
	public void setDateIntervention(Date dateIntervention) {
		this.dateIntervention = dateIntervention;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	@Override
	public String toString() {
		return "Automate{" +
		        "numero_serie: " + numeroSerie + "\n" +
		        "type: " + type + "\n" +
		        "adresseInstallation: "+ adresseInstallation + "\n" +
		        "emplacement: "+ emplacement + "\n"+
		        "cordonees_gps: "+ coordGps + "\n"+
		        "date_intervention: "+ dateIntervention + "\n"+
		        "commentaire: "+ commentaire + "\n"+
		        '}';
	}
	

	
}
