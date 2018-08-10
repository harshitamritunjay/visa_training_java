package com.visa.prj.client;

import javax.persistence.EntityManager;

import com.visa.prj.dao.DaoException;
import com.visa.prj.dao.EmployeeDao;
import com.visa.prj.dao.EmployeeDaoJpaImpl;
import com.visa.prj.dao.IssueDao;
import com.visa.prj.dao.IssueDaoPjaImpl;
import com.visa.prj.entity.Employee;
import com.visa.prj.util.JPAUtil;

public class EmployeeClient {

	public static void main(String[] args) {
		// EmployeeDao dao= new EmployeeDaoJpaImpl();
		addEmployee();

		/*
		 * IssueDao issuedao= new IssueDaoPjaImpl(); try { issuedao.raiseIssue(); }
		 * catch (DaoException e) {
		 * 
		 * e.printStackTrace(); }
		 */
	}

	public static void addEmployee() {
		Employee e1 = new Employee(0, "pragya", "pragya@visa.com");
		//System.out.println(e1.getEmp_id());
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(e1);
		em.getTransaction().commit();
	}

}
