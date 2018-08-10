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

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Product;
import com.visa.prj.service.ShopService;

@RestController
public class CustomerController {

	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value="api/customers",method=RequestMethod.GET)
	public @ResponseBody List<Customer> getCustomers() {
		return shopService.getCustomers();
	}
	
	@RequestMapping(value="api/customers/{email}",method=RequestMethod.GET)
	public @ResponseBody Customer getCustomer(@PathVariable("email") String email) {
		return shopService.getById(email);
	}
	
	
	@RequestMapping(value="api/customers",method=RequestMethod.POST)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		shopService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="api/customers/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteCustomer(@PathVariable("email") String email) {
		shopService.deleteCustomer(email);
		return new ResponseEntity<String>("Customer with id " + email + " deleted !!!",HttpStatus.OK);
	}
	
	@RequestMapping(value="api/customers/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@PathVariable("email") String email, @RequestBody Customer customer) {
		shopService.updateCustomer(email,customer);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
}
