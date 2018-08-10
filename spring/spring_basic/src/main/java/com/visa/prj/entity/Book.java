package com.visa.prj.entity;

import java.util.Date;

public class Book {
	private int id;
	private String title;
	private double price;
	private String category;
	private Date publishedDate;
	private Address publisherAddress;
	
	
	public Book() {
	}
	public Book(int id, String title, double price, String category) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Address getPublisherAddress() {
		return publisherAddress;
	}
	public void setPublisherAddress(Address publisherAddress) {
		this.publisherAddress = publisherAddress;
	}
}