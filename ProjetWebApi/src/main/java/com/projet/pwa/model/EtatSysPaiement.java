package com.projet.pwa.model;

import javax.persistence.Embeddable;

@Embeddable
public class EtatSysPaiement {
	private String monayeurP;
	private String cartePuce;
	private String sansContact;
	
	public EtatSysPaiement() {
		super();
		this.monayeurP = "NAmonayeurP";
		this.cartePuce = "NAcartePuce";
		this.sansContact = "NAsansContact";
	}
	public EtatSysPaiement(String monayeurP, String cartePuce, String sansContact) {
		super();
		this.monayeurP = monayeurP;
		this.cartePuce = cartePuce;
		this.sansContact = sansContact;
	}
	public String getMonayeurP() {
		return monayeurP;
	}
	public void setMonayeurP(String monayeurP) {
		this.monayeurP = monayeurP;
	}
	public String getCartePuce() {
		return cartePuce;
	}
	public void setCartePuce(String cartePuce) {
		this.cartePuce = cartePuce;
	}
	public String getSansContact() {
		return sansContact;
	}
	public void setSansContact(String sansContact) {
		this.sansContact = sansContact;
	}
	
	
	
}
