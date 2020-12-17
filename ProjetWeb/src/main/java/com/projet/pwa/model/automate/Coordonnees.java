package com.projet.pwa.model.automate;

public class Coordonnees {
	private long longitude;
	private long latitude;
	
	
	public Coordonnees(long longitude, long latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}


	public long getLongitude() {
		return longitude;
	}


	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}


	public long getLatitude() {
		return latitude;
	}


	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	
	@Override
	public String toString() {
		return "Cordonees{" +
		        "longitude: " + longitude + "\n" +
		        "latitude: " + latitude + "\n" +
		        '}';
	}
	
	
	

}
