package com.visa.prj.dao;

import org.springframework.stereotype.Repository;

//all Dao classes must be marked with repository-more specific for error codes
@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {

	@Override
	public void addEmployee() {
		System.out.println("Employee stored using JDBC!!!");

	}

}
