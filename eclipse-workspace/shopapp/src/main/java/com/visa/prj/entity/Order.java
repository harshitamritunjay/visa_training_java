package com.visa.prj.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
//not work if Order is used as table name because order is a keyword in sql
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id") //@column can be only given on primitives not on associations
	private int orderId;
	
	@ManyToOne //foreign key is created in this entity
	@JoinColumn(name="customer_fk") //if not join column then linked table will be created, not required, foreign key is needed
	private Customer customer;
	
	private double total;
	
	@Column(name="order_date")
	@Temporal(TemporalType.TIMESTAMP) //if no timestamp is required..directly we can have only date
	private Date orderDate= new Date();
	
	@OneToMany(cascade=CascadeType.ALL) //foreign key is created in target entity
	@JoinColumn(name="order_fk")
	private List<LineItem> items= new ArrayList<>();
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	
	
	
	
}
