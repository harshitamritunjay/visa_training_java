package com.visa.prj.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TBL_MOBILE")
//@DiscriminatorValue("mobile")
public class Mobile extends Item {

	private String connectivity;

	public Mobile() {
	}

	
	public Mobile(int id, String names, double price,String connectivity) {
		super(id, names, price);
		this.connectivity=connectivity;
		// TODO Auto-generated constructor stub
	}



	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	};
	
}
