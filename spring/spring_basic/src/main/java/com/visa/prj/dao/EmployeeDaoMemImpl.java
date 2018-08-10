package com.visa.prj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDaoMemImpl implements EmployeeDao {

	@Autowired
	@Qualifier("employeeDaoMemImpl")
	private EmployeeDao employeeDao;

	@Override
	public void addEmployee() {
		employeeDao.addEmployee();

	}

}
