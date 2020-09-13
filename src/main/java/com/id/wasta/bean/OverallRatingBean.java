package com.id.wasta.bean;

import java.io.Serializable;

public class OverallRatingBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long noOfConnection;
	private double overAllRating;
	
	public Long getNoOfConnection() {
		return noOfConnection;
	}
	
	public void setNoOfConnection(Long noOfConnection) {
		this.noOfConnection = noOfConnection;
	}
	
	public double getOverAllRating() {
		return overAllRating;
	}
	
	public void setOverAllRating(double overAllRating) {
		this.overAllRating = overAllRating;
	}
}
