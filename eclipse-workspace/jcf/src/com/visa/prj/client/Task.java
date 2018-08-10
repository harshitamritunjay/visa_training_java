package com.visa.prj.client;

import java.util.HashSet;
import java.util.Set;

public class Task {

	public static void main(String[] args) {
		String sentence = "I came I saw U came I left";
		Set<String> unique = new HashSet<>();
		Set<String> dups = new HashSet<>();
		Set<String> set = new HashSet<>();
		for (String s : sentence.split(" ")) {
			if (set.add(s)) {
				unique.add(s);
			} else {
				unique.remove(s);
				dups.add(s);
			}
		}
		
		System.out.println(unique);
		System.out.println(dups);
		System.out.println(set);
	}

}
