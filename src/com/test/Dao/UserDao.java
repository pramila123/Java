package com.test.Dao;

import java.util.List;

import com.test.model.User;

public interface UserDao {
	
	//for the purpose of login and signup
	void signup(User user);
	
	boolean login(String un, String psw);

	List<User> getAllUser();

}
