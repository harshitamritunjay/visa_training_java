package com.visa.prj.dto;

import java.util.Date;

//don't mark this with table or entity
public class RentalReportDTO {

	private int id;
	private String email;
	private String registrationNumber;
	private String vehicleType;
	private String fuelType;
	private double totalAmount;
	private Date rentalDate;
	public RentalReportDTO() {
	}
	public RentalReportDTO(int id, String email, String registrationNumber, String vehicleType, String fuelType,
			double totalAmount, Date rentalDate) {
		this.id = id;
		this.email = email;
		this.registrationNumber = registrationNumber;
		this.vehicleType = vehicleType;
		this.fuelType = fuelType;
		this.totalAmount = totalAmount;
		this.rentalDate = rentalDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}
	
}
