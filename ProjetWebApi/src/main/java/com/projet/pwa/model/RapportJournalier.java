package com.projet.pwa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@Entity
@Table(name = "rapport_journalier")
@XmlRootElement(name = "rapport_journalier")
@XmlAccessorType(XmlAccessType.FIELD)
public class RapportJournalier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long numeroSerie;

	private Date dateRapport;
	private String status;

	private InfosAutomate infosAutomate;

	@XmlElementWrapper(name = "erreurs")
	@XmlElement(name = "erreur")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_rapport_journalier", nullable = false, updatable = false)
	private List<RapportErreur> erreurs;

	@XmlElementWrapper(name = "articles")
	@XmlElement(name = "article")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_rapport_journalier", nullable = false, updatable = false)
	private List<Article> articles;

	private Long benefice;

	public RapportJournalier() {
		super();
	}

	public RapportJournalier(Long numeroSerie, Date dateRapport, String status, Long benefice) {
		super();
		this.numeroSerie = numeroSerie;
		this.dateRapport = dateRapport;
		this.status = status;
		this.benefice = benefice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(Long numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Date getDateRapport() {
		return dateRapport;
	}

	public void setDateRapport(Date dateRapport) {
		this.dateRapport = dateRapport;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
