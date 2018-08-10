package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.visa.prj.entity.Customer;

public class CustomerDaoJpaImpl implements CustomerDao {

	@Override
	public void addCustomer(Customer c) {
		EntityManager em= JPAUtil.getEntityManager();
		em.getTransaction().begin();
		  em.persist(c);
		 em.getTransaction().commit();

	}

	@Override
	public List<String> getCustomers() {
		EntityManager em= JPAUtil.getEntityManager();
		Query query= em.createQuery("SELECT c.customerId FROM Customer c");
		return query.getResultList();
		
	}

}
