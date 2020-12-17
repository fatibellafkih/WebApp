package com.projet.pwa.model.automate;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	private Long voie;
	private String rue;
	private String ville;
	private String pays;
	
	public Adresse() {
		super();
		this.voie = (long)0;
		this.rue = "NARue";
		this.ville = "NAVille";
		this.pays = "NAPays";
	}
	public Adresse(Long voie, String rue, String ville, String pays) {
		super();
		this.voie = voie;
		this.rue = rue;
		this.ville = ville;
		this.pays = pays;
	}
	public Long getVoie() {
		return voie;
	}
	public void setVoie(Long voie) {
		this.voie = voie;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	

}
