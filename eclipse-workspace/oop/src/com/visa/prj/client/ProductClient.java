package com.visa.prj.client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;
import com.visa.prj.util.Utility;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products=  new Product[4];
		//instead of mobile or tv array we took product array for future inclusions like washing machine
		products[0]= new Mobile(124,"iPhone x",120000.00,"4G"); //upcasting
		products[1]= new Tv(634,"Onida",3500.00,"CRT");//upcasting
		products[2]=new Mobile(611,"MotoG",12999.00,"4G");//upcasting
		products[3]= new Tv(72,"Sony Bravia",103500.00,"LED");//upcasting
		
		Utility.sort(products);
		for(Product p:products) {
			System.out.println(p);// builtin string() function is being called
		}
		String[] names= {"Harry","Peter","Anita","Danny","Angelina"};
		Utility.sort(names);
		for(String name:names) {
			System.out.println(name);
		}
		
 		System.out.println("*********");
		printExpensive(products);
	}
	// ocp(open/close principle)
	private static void printExpensive(Product[] products) {
		for(int i=0;i<products.length;i++) {
			if(products[i].isExpensive()) { //dynamic binding/polymorphism
				System.out.println(products[i].getName()+","+products[i].getPrice());
				printDetails(products[i]);
			}
		}
	}
	//without ocp
	/*
	private static void printDetails(Product product) {
		if(product instanceof Mobile) {
		Mobile m=(Mobile)product; //downcasting
		System.out.println(m.getConnectivity());
		}
		else if(product instanceof Tv) {
			Tv t=(Tv) product;
			System.out.println(t.getScreenType());
		}
		
	}*/
	//with ocp
	private static void printDetails(Product product) {
		Method[] methods=product.getClass().getDeclaredMethods();//methods only in that class
		for(Method m: methods) {
			if(m.getName().startsWith("get")) {
			try {
				Object ret=	m.invoke(product);
				System.out.println(ret);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			}
		}
	}

}
