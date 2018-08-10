package com.visa.prj.dao;

import javax.persistence.EntityManager;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Issue;
import com.visa.prj.util.JPAUtil;

public class IssueDaoPjaImpl implements IssueDao {

	@Override
	public void raiseIssue() throws DaoException {
		EntityManager em= JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Issue issue= new Issue();
		Employee e= em.find(Employee.class, 1);
		issue.setRaisedBy(e);
		String desc="Not able to login";
		issue.setDesc(desc);
		em.getTransaction().commit();

	}

}
