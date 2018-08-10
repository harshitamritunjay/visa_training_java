package com.visa.prj.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.visa.prj.entity.Product;
import com.visa.prj.util.JPAUtil;

public class ProductJPQLClient {

	public static void main(String args[]) {
		/*
		 * JPQL uses class and fields and not table and columns JPQL is case-sensitive
		 * about class and attributes JPQL is polymorphic
		 */

		EntityManager em = JPAUtil.getEntityManager();
		
		/*String qry = "SELECT p from Product p where p.category =:cat and p.price>:amt";
		//String qry = "SELECT p from Product p where p.category =?1 and p.price>?2";
		TypedQuery<Product> query = em.createQuery(qry, Product.class);
		query.setParameter("cat", "Beverages");
		//query.setParameter(1,"Beverages");
		query.setParameter("amt", 10.00);
		List<Product> products = query.getResultList();*/
		
		
		/*
		//to get 3 results starting from 10th result
		String qry = "SELECT p from Product p";
		
		TypedQuery<Product> query = em.createQuery(qry, Product.class);
		query.setMaxResults(3);
		query.setFirstResult(10);
		List<Product> products = query.getResultList();
		for (Product p : products) {
			System.out.println(p.getProductName() + " , " + p.getPrice() + " , " + p.getCategory());
		}*/
		
		/*
		String qry="SELECT p.category, count(p) from Product p GROUP BY p.category";
		Query query=em.createQuery(qry);
		List<Object[]> data= query.getResultList();
		
		for(int i=0;i<data.size();i++) {
			Object[] elems=data.get(i);
			System.out.println(elems[0]+" : "+ elems[1]);
		}
		*/
		//sometimes we can use native sql query rather than jpql query so that we don't have to convert complex sql statements into jpql
		String qry="SELECT p.category, count(*) from products p GROUP BY p.category HAVING count(*)>2";
		//for scalar entities use query not typedquery
		Query query=em.createNativeQuery(qry);
		List<Object[]> data= query.getResultList();
		
		for(int i=0;i<data.size();i++) {
			Object[] elems=data.get(i);
			System.out.println(elems[0]+" : "+ elems[1]);
		}
	}
}
