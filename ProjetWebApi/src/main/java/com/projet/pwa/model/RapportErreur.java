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
@Table(name = "rapport_erreur")

public class RapportErreur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rapport_journalier", insertable = false, updatable = false)
	private RapportJournalier idRapportJournalier;

	@JsonIgnore
	public RapportJournalier getDaily_report_id() {
		return idRapportJournalier;
	}

	public void setDaily_report_id(RapportJournalier idRapportJournalier) {
		this.idRapportJournalier = idRapportJournalier;
	}

	public RapportErreur() {
		super();
		this.type = "NAType";
		this.description = "NADescription";
	}

	public RapportErreur(String type, String description) {
		super();
		this.type = type;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
