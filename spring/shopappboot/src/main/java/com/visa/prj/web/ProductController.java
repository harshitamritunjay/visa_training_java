package com.visa.prj.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Product;
import com.visa.prj.service.ShopService;

@RestController
public class ProductController {
	@Autowired
	private ShopService shopService;
	 
	//void methods are strict no in restful 
	@RequestMapping(value="api/products",method=RequestMethod.GET)
	public @ResponseBody List<Product> getProducts() {
		return shopService.getProducts();
	}
	
	@RequestMapping(value="api/products/{id}",method=RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable("id") int id) {
		return shopService.getById(id);
	}
	
	@RequestMapping(value="api/products",method=RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		shopService.addProduct(product);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="api/products/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
		shopService.deleteProduct(id);
		return new ResponseEntity<String>("Product with id " + id + " deleted !!!",HttpStatus.OK);
	}
	
	@RequestMapping(value="api/products/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		shopService.updateProduct(id,product);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
}
