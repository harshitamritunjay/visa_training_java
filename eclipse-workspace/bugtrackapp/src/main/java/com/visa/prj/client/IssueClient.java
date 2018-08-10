package com.visa.prj.client;

import com.visa.prj.dao.IssueDao;
import com.visa.prj.dao.IssueDaoPjaImpl;
import com.visa.prj.entity.Issue;

public class IssueClient {

	public static void main(String[] args) {
		IssueDao issuedao= new IssueDaoPjaImpl();
		Issue iss= new Issue(0,"Unable to login",);
		
	}

}
