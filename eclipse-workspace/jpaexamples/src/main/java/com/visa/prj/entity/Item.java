package com.visa.prj.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
/*@Table(name="items")
@DiscriminatorColumn(name="type") //required if single table approach
*/
@Table(name="TBL_items")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) //for table per class strategy
public abstract class Item {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String names;
	private double price;
	public Item() {
	}
	public Item(int id, String names, double price) {
		this.id = id;
		this.names = names;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
