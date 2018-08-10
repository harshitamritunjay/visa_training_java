package com.visa.prj.client;

import javax.persistence.EntityManager;

import com.visa.prj.entity.Product;
import com.visa.prj.util.JPAUtil;

public class ProductClient {

	public static void main(String[] args) {
		new Thread(() -> { 
			firstUser();
		}).start();
		new Thread(() -> {
			secondUser();
		}).start();
	}

	private static void secondUser() {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		 	Product p = em.find(Product.class, 4);
		 	System.out.println("QTY SECOND user " + p.getQuantity());
		 	p.setQuantity(p.getQuantity() - 5);
		em.getTransaction().commit();
	}

	private static void firstUser() {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		 	Product p = em.find(Product.class, 4);
		 	System.out.println("QTY FIRST user " + p.getQuantity());
		 	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 	
		 	p.setQuantity(p.getQuantity() - 10);
		em.getTransaction().commit();
	}

}
