package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class FunctionalExample2 {

	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(34, 67, 2, 78, 1, 98, 23, 15, 20);
		List<Double> dlist = Arrays.asList(3.45, 2.32, 5.76, 4.76, 89.89);
		//dest,source
		List<Integer> listCopy=new ArrayList<>();
		List<Double> dlistCopy= new ArrayList<>();
		
		copy(list,listCopy);
		copy(dlist,dlistCopy);
		System.out.println(listCopy);
		System.out.println(dlistCopy);
	}
	public static <T> void copy(List <T> list,List<? super T> listCopy)
	{
		for(T t:list) {
			listCopy.add(t);
		}
	}

	
}
