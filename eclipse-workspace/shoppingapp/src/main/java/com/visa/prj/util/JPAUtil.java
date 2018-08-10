package com.visa.prj.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory emFactory;
	static {
		/*
		 * Read META-INF/persistence.xml and find persistence-unit="PU"
		 * Create EntityManagerFactory using these details.
		 * Internally EntityManagerFactory creates a pool of database connections
		 * using the info provided
		 */
		   emFactory = Persistence.createEntityManagerFactory("PU");
	}
	public static EntityManager getEntityManager(){
		/*
		 * EntityManagerFactory picks a connection from pool and creates a 
		 * EntityManager which is a wrapper for database connection
		 */
		return emFactory.createEntityManager();
	}
	public static void close(){
		emFactory.close();
	}
}
