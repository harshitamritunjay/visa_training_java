package com.visa.prj.entity;

public class Tv extends Product {
	private String screenType;

	public Tv() {
	}

	
	public Tv(int id, String name, double price, String screenType) {
		super(id, name, price);
		this.screenType = screenType;
	}


	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}


	@Override
	public boolean isExpensive() {
		if(this.screenType.equals("CRT")&& this.getPrice()>5000) {
			return true;
		}
		else if(this.screenType.equals("LED")&&this.getPrice()>40000)
		{
			return true;
		}
		return false;
	}
	
}
