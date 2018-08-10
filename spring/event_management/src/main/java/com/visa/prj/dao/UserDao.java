package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.User;

public interface UserDao {

	void addUser(User user);
	List<User> getUsers();
	User getUserById(int id);
	User getUserByEmail(String email);
}
