package com.visa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
//more of a java application but internally it will trigger the servers n all everything
//requirement is that every other package must be child of that package
@SpringBootApplication
public class ShopappbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopappbootApplication.class, args);
	}
}