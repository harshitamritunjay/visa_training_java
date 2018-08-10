package com.visa.prj.client;

import java.util.Arrays;
import java.util.Comparator;



public class ArrayClient {

	public static void main(String[] args) {
		String[] names = { "Brad", "Angelina", "Chris", "Lee", "David" };
	//	Arrays.sort(names);//string implements comparable
		/*
		 * Arrays.sort(names,new Comparator<String>() {
			public int compare(String o1,String o2) {
				return o1.length()-o2.length();
			}
		});
		
		*/
		
		Arrays.sort(names,(String o1,String o2)->{
			return o1.length()-o2.length();
		});
		/*
		Arrays.sort(names,(o1,o2)->{
			return o1.length()-o2.length();
		});
		*/
		//no curly braces can also be used.
		Arrays.sort(names,(o1,o2)->o1.length()-o2.length());
		
		
		
		for (String name : names) {
			System.out.println(name);
		}

	}

}
