package com.visa.prj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {
	
	@Id
	@Column(name="reg_no")
	private String registrationNumber;
	private String type;
	
	@Column(name="fuel_type")
	private String fuelType;
	
	@Column(name="cost_per_km")
	private double costPerKm;

	public Vehicle() {
	}

	public Vehicle(String registrationNumber, String type, String fuelType, double costPerKm) {
		this.registrationNumber = registrationNumber;
		this.type = type;
		this.fuelType = fuelType;
		this.costPerKm = costPerKm;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public double getCostPerKm() {
		return costPerKm;
	}

	public void setCostPerKm(double costPerKm) {
		this.costPerKm = costPerKm;
	}
	
	
}
