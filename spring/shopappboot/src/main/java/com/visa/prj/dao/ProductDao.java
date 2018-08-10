package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visa.prj.entity.Product;
//looking at the interface implementation will be generated automatically no need to write class, basic CRUD operations will be done,
//customized we have to write on our own
public interface ProductDao extends JpaRepository<Product, Integer> {
	@Query("from Product p where p.quantity > 0")
	List<Product> getAvailableProducts();
	
	
	List<Product> findByPriceAndQuantity(double price,String qty);
}
