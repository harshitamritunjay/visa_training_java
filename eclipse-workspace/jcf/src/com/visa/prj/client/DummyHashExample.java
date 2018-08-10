package com.visa.prj.client;

public class DummyHashExample {

	public static void main(String[] args) {
		String s1= new String("Hello World");
		String s2=   new String("Hello World");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s1.equals(s2));
		String s3= new String("hello");
		System.out.println(s3.hashCode());
		String s4= new String("Aa");
		String s5= new String("BB");
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());
		System.out.println(s4.equals(s5));//when hashcode becomes same it checks for all the attributes then
		
	}

}
