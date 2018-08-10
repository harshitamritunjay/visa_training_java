package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Product;
import com.visa.prj.util.JPAUtil;

public class CustomerDaoJpaImpl implements CustomerDao {

	@Override
	public void addCustomer(Customer c) {
		EntityManager em= JPAUtil.getEntityManager();
		em.getTransaction().begin();
			em.persist(c);
		em.getTransaction().commit();

	}

	@Override
	public List<Customer> getCustomers() {
		EntityManager em= JPAUtil.getEntityManager();
		/*
		 * JPQL=> Java Persistence Query Language
		 * JPQL uses Class name and attributes of class and not table and columns
		 * JPQL is case-sensitive , SQL is not case-sensitive
		 * looks like sql, but not sql(not products we are writing Product i.e class name)
		 */
		TypedQuery<Customer> query= em.createQuery("SELECT c from Customer c",Customer.class);
		return query.getResultList();
		
	}
	@Override
	public boolean checkRecordExist() {
		EntityManager em=JPAUtil.getEntityManager();
		Query q=em.createQuery("SELECT count(c) FROM Customer c where email=request.getParameter('email')");
		if(q.getSingleResult().equals(0L)) {
			return false;
		}else
			return true;
	}

}