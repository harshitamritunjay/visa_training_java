package com.visa.prj.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTask {

	public static void main(String[] args) {
		String report="Ramesh sold 500 products of iPhone each costing 98000";
		Map<String,Integer> map= new HashMap<>();
		int c=0,p=0;
		for(String word:report.split(" ")) {
			if(word.matches(".*\\d+.*")){
				p++;
			}
			else{
				c++;
				//res.put("Word",)
			}
			
		}
		map.put("Words",c);
		map.put("Numbers", p);
		map.forEach((k,v)->{
			System.out.println(k+" : "+v);
		});
		Map<String, List<String> > res= new HashMap<>();
		List<String> r= new ArrayList<>();
		List<String> q= new ArrayList<>();;
		for(String word:report.split(" ")) {
			if(word.matches(".*\\d+.*")) {
				r.add(word);
			}else
			{
				q.add(word);
			}
		}
		res.put("Words", q);
		res.put("Numbers", r);
		res.forEach((k,v)->{
			System.out.println(k+" : "+v);
		});
		
	}

}
