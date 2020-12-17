package com.projet.pwa.model;

public class Article {
	private long idProduit;
	private String nom;
	private String type; 
	private long quantite;
	
	public long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getQuantite() {
		return quantite;
	}
	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "Article{" +
		        "id_produit: " + idProduit + "\n" +
		        "nom: " + nom + "\n" +
		        "type: " + type + "\n"+
		        "quantite: " + quantite + "\n" +
		        '}';
	}
	
}
