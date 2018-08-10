package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Customer;

public interface CustomerDao {

	void addCustomer(Customer c);
	List<String> getCustomers();
	
}
