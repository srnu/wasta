package com.id.wasta.bean;

import java.io.Serializable;

public class ToolTipBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String title;
	private String firstName;
	private String lastName;
	private String location;
	private String desifnation;
	private String function;
	private String industry;
	private String role;
	private String company;
	private String city;
	private String state;
	private String country;
	private String pattFileName;
	private Long pinKey;
	private Long profileKey;
	private String relationship;
	
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesifnation() {
		return desifnation;
	}

	public void setDesifnation(String desifnation) {
		this.desifnation = desifnation;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPattFileName() {
		return pattFileName;
	}

	public void setPattFileName(String pattFileName) {
		this.pattFileName = pattFileName;
	}

	public Long getPinKey() {
		return pinKey;
	}

	public void setPinKey(Long pinKey) {
		this.pinKey = pinKey;
	}

	public Long getProfileKey() {
		return profileKey;
	}

	public void setProfileKey(Long profileKey) {
		this.profileKey = profileKey;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
}
