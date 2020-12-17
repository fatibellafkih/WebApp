package com.projet.pwa.model.automate;

public class Adresse {
	private String voie;
	private long codePostal;
	private String ville;
	private String pays;
	
	public Adresse(String voie, long codePostal, String ville, String pays) {
		super();
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public long getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(long codePostal) {
		this.codePostal = codePostal;
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
	
	@Override
	public String toString() {
		return "Adresse{" +
		        "voie: " + voie + "\n" +
		        "code_postal: " + codePostal + "\n" +
		        "ville:  " + ville + "\n" +
		        "pays: " + pays +
		        '}';
	}
	
	
	
	

}
