package com.visa.prj.client;

import javax.persistence.EntityManager;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.LineItem;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.util.JPAUtil;

public class OrderClient {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Order order = new Order();
		Customer c = em.find(Customer.class, "smith@visa.com"); // get customer
		order.setCustomer(c);
		Product p1 = em.find(Product.class, 4);
		Product p2 = em.find(Product.class, 5);
		LineItem l1 = new LineItem();
		l1.setProduct(p1);
		l1.setQuantity(1);
		p1.setQuantity(p1.getQuantity() - 1);
		l1.setAmount(p1.getPrice() * l1.getQuantity());

		LineItem l2 = new LineItem();
		l2.setProduct(p2);
		l2.setQuantity(2);
		p2.setQuantity(p2.getQuantity() - 2);
		l2.setAmount(p2.getPrice() * l2.getQuantity());

		order.getItems().add(l1);
		order.getItems().add(l2);
		order.setTotal(l1.getAmount()+l2.getAmount());
		// TODO persist
		/*
		 * em.persist(l1);
		 * em.persist(l2);
		 */
		//since cascade is used in order we use order one,,,if not cascade then above two will also have to do
		em.persist(order);
		em.getTransaction().commit();
	}

}
