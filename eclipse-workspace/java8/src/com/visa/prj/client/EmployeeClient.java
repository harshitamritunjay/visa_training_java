package com.visa.prj.client;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.visa.prj.entity.Employee;

public class EmployeeClient {

	public static void main(String[] args) {
		Employee e1= new Employee();
		Employee e2= new Employee();
		e1.setName("George");
		e2.setName("Amy");
		e1.setLanguages(Arrays.asList("Java","JS","Python","Go","C#"));
		e2.setLanguages(Arrays.asList("Python","LISP","C"));
		
		List<Employee> emps= Arrays.asList(e1,e2);
		
		//print only Skills
		emps.stream().map(e->e.getLanguages()).forEach(System.out::println);

		/*	
		emps.stream().filter(e->e.getName().equals("George")).map(e->e.getLanguages()).forEach(System.out::println);
		*/
		
		// get all the languages my employees possess we use flatmap ->flatmap comes into picture here.
		Set<String> skills=emps.stream()
		.map(e->e.getLanguages())
		.flatMap(Collection::stream)
		.map(e->e.toUpperCase())
		.collect(Collectors.toSet());
		System.out.println(skills);
	}

}
