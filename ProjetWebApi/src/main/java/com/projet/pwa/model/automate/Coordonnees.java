package com.projet.pwa.model.automate;

import javax.persistence.Embeddable;

@Embeddable
public class Coordonnees {
	
	private Long longitude;
	private Long latitude;
	public Coordonnees() {
		super();
		this.longitude = (long)0;
		this.latitude = (long)0;
	}
	public Coordonnees(Long longitude, Long latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	
	

}
