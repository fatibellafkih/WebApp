package com.projet.pwa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Long quantite;
	private String type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rapport_journalier", insertable = false, updatable = false)
	private RapportJournalier idRapportJournalier;

	@JsonIgnore
	public RapportJournalier getIdRapportJournalier() {
		return idRapportJournalier;
	}

	public void setIdRapportJournalier(RapportJournalier idRapportJournalier) {
		this.idRapportJournalier = idRapportJournalier;
	}

	public Article() {
		super();
		this.nom = "NA";
		this.quantite = (long) 0;
	}

	public Article(String nom, Long quantite, String type) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getQuantite() {
		return quantite;
	}

	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
