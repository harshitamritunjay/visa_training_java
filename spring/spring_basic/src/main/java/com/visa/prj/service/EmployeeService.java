package com.visa.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	//dependency injection
	@Autowired
	private EmployeeDao employeeDao; //ByteCode Instrumentation
	//extra code is generated
	
	public void doTask() {
		employeeDao.addEmployee();
	}
}
