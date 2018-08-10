package com.visa.prj.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.PersistenceException;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.User;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class DataServiceTest {

	//private UserDao userDao = Mockito.mock(UserDao.class);
	private List<UserDao> userDao= new ArrayList<>();
	private DataService dataService;
	@Before
	public void setUp() throws Exception {
		dataService = new DataService();
		dataService.setList(userDao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		List<String> list=new ArrayList<String>();
		try{
			donothing().when(UserDao).add(list);
			assertEquals(true,dataService.add(list));
		}catch(PersistenceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

}
