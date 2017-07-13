package com.ibm.easyerp.service;

import com.ibm.easyerp.model.User;

import java.util.List;

public interface UserServiceI {

	public boolean login(User user);

	public User find(String username);

	public void update(User user);

	public Integer getUserSize(User user);

	public List<User> getUserList(User user);
	
	public void insert(User user);
	
	public void delete(User user);
	
}
