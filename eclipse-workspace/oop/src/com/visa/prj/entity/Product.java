package com.visa.prj.entity;

public abstract class Product implements Comparable<Product>{
	private int id;
	private String name;
	private double price;
	public Product() {
	}
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	/*public boolean isExpensive() {
		return false;
	}*/
	public abstract boolean  isExpensive();
	/* if geneerics are not used i.e <Product> is not used.
	@Override
	//here we will decide in which order to sort like asc or desc
	public int compareTo(Object o) {//sorting based on price
		Product p=(Product) o;
		if(this.price>p.price) {
			return 1;
		}else if(p.price>this.price) {
			return -1;
		}
		return 0;
	}
	*/
	//---------------------
	public int compareTo(Product p) {//sorting based on price
		//Product p=(Product) o;  //type casting not required now.
		if(this.price>p.price) {
			return 1;
		}else if(p.price>this.price) {
			return -1;
		}
		return 0;
	}
	//----------------------
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
