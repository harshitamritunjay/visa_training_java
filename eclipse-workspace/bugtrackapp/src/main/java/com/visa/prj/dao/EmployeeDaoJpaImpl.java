package com.visa.prj.dao;

import javax.persistence.EntityManager;

import com.visa.prj.entity.Employee;
import com.visa.prj.util.JPAUtil;

public class EmployeeDaoJpaImpl implements EmployeeDao {

	@Override
	public void addEmployee(Employee e) throws DaoException {
		EntityManager em= JPAUtil.getEntityManager();
		em.getTransaction().begin();
			em.persist(e);
		em.getTransaction().commit();
		

	}

	

}
