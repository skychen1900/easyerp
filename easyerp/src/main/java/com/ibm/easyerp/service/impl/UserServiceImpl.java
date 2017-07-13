package com.ibm.easyerp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.easyerp.dao.UserMapper;
import com.ibm.easyerp.model.User;
import com.ibm.easyerp.service.UserServiceI;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	
	private UserMapper userMapper;

	public boolean login(User user) {
		int count = userMapper.select(user);
		return count > 0;
	}

	public User find(String username) {
		return userMapper.select2(username);
	}
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public void update(User user) {
		userMapper.update(user);
	}

	public Integer getUserSize(User user) {
		return userMapper.selectCount();
	}

	public List<User> getUserList(User user) {
		List<User> userList = userMapper.getAll(user);
		return userList;
	}

	public void insert(User user) {
		userMapper.insert(user);
	}

	public void delete(User user) {
		userMapper.delete(user.getUsername());
	}

}
