package com.visa.prj.service;

import com.visa.prj.dao.ProductDao;

public class SampleService {
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao=productDao;
	}
	public void insert() {
		productDao.addProduct();
	}
	public SampleService() {
		
	}
	public SampleService(ProductDao productDao) {
		this.productDao = productDao;
	}
	
}
