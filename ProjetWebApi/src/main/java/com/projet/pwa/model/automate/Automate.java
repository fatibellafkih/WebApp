package com.projet.pwa.model.automate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "automate")
public class Automate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroSerie;
	private String type;
	private Adresse adresseInstallation;

	private String emplacement;
	private Cordonnees cordonnees;

	private Date dateIntervention;
	private String note;

	public Automate() {
		super();

		this.type = "NAType";
		this.adresseInstallation = new Adresse();
		this.emplacement = "NAEmplacement";
		this.cordonnees = new Cordonnees();
		this.dateIntervention = new Date();
		this.note = "NANote";
	}

	public Automate(String type, Adresse adresseInstallation, String emplacement, Cordonnees cordonnees,
			Date dateIntervention, String note) {
		super();

		this.type = type;
		this.adresseInstallation = adresseInstallation;
		this.emplacement = emplacement;
		this.cordonnees = cordonnees;
		this.dateIntervention = dateIntervention;
		this.note = note;
	}

	public Automate(Long numeroSerie, String type, Adresse adresseInstallation, String emplacement,
			Cordonnees cordonnees, Date dateIntervention, String note) {
		super();
		this.numeroSerie = numeroSerie;
		this.type = type;
		this.adresseInstallation = adresseInstallation;
		this.emplacement = emplacement;
		this.cordonnees = cordonnees;
		this.dateIntervention = dateIntervention;
		this.note = note;
	}

	public Long getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(Long numeroSerie) {
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

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public Cordonnees getCordonnees() {
		return cordonnees;
	}

	public void setCordonnees(Cordonnees cordonnees) {
		this.cordonnees = cordonnees;
	}

	public Date getDateIntervention() {
		return dateIntervention;
	}

	public void setDateIntervention(Date dateIntervention) {
		this.dateIntervention = dateIntervention;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
