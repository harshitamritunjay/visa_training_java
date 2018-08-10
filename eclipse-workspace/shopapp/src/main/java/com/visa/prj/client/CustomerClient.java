package com.visa.prj.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.visa.prj.entity.Customer;
import com.visa.prj.util.JPAUtil;

public class CustomerClient {

	public static void main(String[] args) {
		addCustomer();
		listCustomers();

	}
	private static void addCustomer() {
		Customer c= new Customer("smith@visa.com","George","Smith"); //transient state
		EntityManager em= JPAUtil.getEntityManager();
		em.getTransaction().begin();
			em.persist(c);
		em.getTransaction().commit();
	}
	private static void listCustomers() {
		EntityManager em= JPAUtil.getEntityManager();
		TypedQuery<Customer> query= em.createQuery("Select c from Customer c",Customer.class);
		List<Customer> customers= query.getResultList();
		for(Customer c:customers) {
			System.out.println(c.getEmail()+" , "+c.getFirstName());
		}
	}
}
