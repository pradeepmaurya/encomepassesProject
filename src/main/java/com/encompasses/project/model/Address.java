package com.encompasses.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Address {
	
	private String landMark;
	private String zipCode;
	private String district;
	private String state;
	private String country;
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String landMark, String zipCode, String district, String state, String country) {
		super();
		this.landMark = landMark;
		this.zipCode = zipCode;
		this.district = district;
		this.state = state;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [landMark=" + landMark + ", zipCode=" + zipCode + ", district=" + district + ", state=" + state
				+ ", country=" + country + "]";
	}
	
}
