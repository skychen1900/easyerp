package com.ibm.easyerp.model;

import com.ibm.easyerp.base.BasePageVo;
import com.ibm.easyerp.util.MessageDigestUtil;

public class User extends BasePageVo{

	private String username;

	private String password; //加密后

	private int grade;
	
	private String gradeName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = MessageDigestUtil.digestByMD5(password);
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
}
