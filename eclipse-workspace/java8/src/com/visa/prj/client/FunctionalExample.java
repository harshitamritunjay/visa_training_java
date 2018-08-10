package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

interface Consumer<T> {
	void accept(T obj);
}

@FunctionalInterface
interface Predicte<T>{
	boolean test(T obj);
}

public class FunctionalExample {

	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(34, 67, 2, 78, 1, 98, 23, 15, 20);
		List<Double> l = Arrays.asList(3.45, 2.32, 5.76, 4.76, 89.89);
		iterate(list, (arg) -> System.out.println(arg));// iterate is a high order function
		iterate(list, arg -> System.out.println(arg));
		iterate(list, System.out::println);
		iterate(l, arg -> System.out.println(arg));
		print(list);
		print(l);
		//function inside function
		List<Integer> even= filter(list,no->no%2==0);// actual implementation of predicate function
		System.out.println(even);
	}

	// high order function not tightly coupled to a particular object
	private static <T> List<T> filter(List<T> list,Predicate<T> pred)
	{
		List<T> copy= new ArrayList<>();
		for(T t:list) {   //copying only even numbers
			if(pred.test(t)) {
				copy.add(t);
			}
		}
		return copy;		//returns list that is why List<T> at the function signature
	}
	/*
	 * private static void iterate(List<Integer> list,Consumer<Integer> cons) {
	 * for(Integer i : list) { cons.accept(i); } }
	 */
	private static void print(List<?> list)//? does not allow mutation
	{
		for(Object o:list) {
			System.out.println(o);
		}
	}
	//PECS ->Producer extends Consumer Super
	private static <T> void iterate(List<? extends T> list,Consumer<? super T> cons) {
		for(T i:list) {
			cons.accept(i);
		}
	}
	//? super T means can store Any of it plus it's super type i.e for integer number can also work
	//and object will also work.that's why super is used.
}
