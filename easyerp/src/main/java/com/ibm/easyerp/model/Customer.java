package com.ibm.easyerp.model;

import com.ibm.easyerp.base.BasePageVo;

public class Customer extends BasePageVo{

	private String customerNO;

	private String customerName;

	private String phone;

	private String address;

	private String relationman;

	private String otherInfo;
	
	public Customer(){}
	
	public Customer(String customerNO) {
		this.customerNO = customerNO;
	}
	public String getCustomerNO() {
		return customerNO;
	}
	public void setCustomerNO(String customerNO) {
		this.customerNO = customerNO;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getRelationman() {
		return relationman;
	}
	public void setRelationman(String relationman) {
		this.relationman = relationman;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
}
