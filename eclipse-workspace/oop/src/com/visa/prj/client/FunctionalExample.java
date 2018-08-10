package com.visa.prj.client;

import java.util.function.BiFunction;

import com.visa.prj.util.Compute;

public class FunctionalExample {

	public static void main(String[] args) {
		BiFunction<Integer,Integer,Double> f=(x,y) ->{
			return (double)x/y;
		};
		System.out.println(f.apply(4, 5));
		
		/* 
		 * Compute<Integer> old= new Compute<Integer>(){
		 * @Override
		 * public void add(Integer x,Integer y){
		 * System.out.println(x+y);
		 * }
		 * };
		 * old.add(3,2);
		 * 
		 * */
		//we can use <Integer,Double> for different data types
		//writing Integer on right hand side is also not required,only x and y can suffice as we already mentioned in lhs
		//Anonymous class interface
		Compute<Integer> c=(Integer x,Integer y)->{
			System.out.println(x+y);
		};
		c.add(4, 5);
		c.add(45, 43);
		c.sub(2, 2);
		
	}

}
