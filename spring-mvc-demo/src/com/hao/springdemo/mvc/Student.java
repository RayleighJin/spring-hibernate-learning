package com.hao.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
	private String[] OS;

	public Student() {
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("TW", "Taiwan");
		countryOptions.put("HK", "Hong Kong");
		countryOptions.put("FR", "France");
		countryOptions.put("KR", "Korea");
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String[] getOS() {
		return OS;
	}

	public void setOS(String[] oS) {
		OS = oS;
	}
	
	
	
}
