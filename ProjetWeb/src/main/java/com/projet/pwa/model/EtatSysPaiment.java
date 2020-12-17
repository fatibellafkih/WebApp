package com.projet.pwa.model;

public class EtatSysPaiment {
	private String monnayeurP;
	private String cartePuce;
	private String sansContact;
	public String getMonnayeurP() {
		return monnayeurP;
	}
	public void setMonnayeurP(String monnayeurP) {
		this.monnayeurP = monnayeurP;
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
	@Override
	public String toString() {
		return "EtatSysPaiment{" +
		        "monnayeur_Paiment: " + monnayeurP + "\n" +
		        "carte_puce: " + cartePuce + "\n" +
		        "carte_sans_contact: " + sansContact + 
		        '}';
	}
	
	
	

}
