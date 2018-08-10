package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.visa.prj.entity.Product;
import com.visa.prj.util.JPAUtil;

public class ProductDaoJpaImpl implements ProductDao {

	@Override
	public List<Product> getProducts() throws DaoException {
		EntityManager em= JPAUtil.getEntityManager();
		/*
		 * JPQL=> Java Persistence Query Language
		 * JPQL uses Class name and attributes of class and not table and columns
		 * JPQL is case-sensitive , SQL is not case-sensitive
		 * looks like sql, but not sql(not products we are writing Product i.e class name)
		 */
		TypedQuery<Product> query= em.createQuery("SELECT p from Product p",Product.class);
		return query.getResultList();
	}

	@Override
	public void addProduct(Product p) throws DaoException {
		//first of all get entity manager then start the transaction, do all the things(right now only persist) then commit
		//if something goes wrong then rollback , hence surround with try/catch block
		EntityManager em= JPAUtil.getEntityManager();
		em.getTransaction().begin();
			em.persist(p);
		em.getTransaction().commit();

	}

	@Override
	public Product getProduct(int id) throws DaoException {
		EntityManager em= JPAUtil.getEntityManager();
		//find will always work on primary key, gives you only one
		return em.find(Product.class,id);
		
	}

	@Override
	public void deleteProduct(int id) throws DaoException {
		EntityManager em= JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Product p= em.find(Product.class, id);
			em.remove(p);
		em.getTransaction().commit();

	}

	@Override
	public void updateProduct(Product p) throws DaoException {
		EntityManager em= JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(p);  //update without dirty check ,while giving to the UI no dirty checking
		em.getTransaction().commit();

	}

	@Override
	public List<Product> getProductsByPrice(double price) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updatePrice() {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
			TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
			List<Product> prds = query.getResultList();
			for(Product  p : prds) {
				if(p.getPrice() > 100000) {
					p.setPrice(p.getPrice() - 5000);
				}
			}
		em.getTransaction().commit();
	}

}
