package com.ibm.easyerp.service;

import com.ibm.easyerp.model.Customer;
import com.ibm.easyerp.util.PageView;

import java.util.List;


public interface CustomerServiceI {
	
	public List<Customer> getAll(PageView pageView);
	
	public int getCustomerSize(Customer customer);
	
	public List<Customer> getCustomerList(Customer customer);

	public void save(Customer customer);

	public Customer selectByPrimaryKey(String customerNO);

	public void update(Customer customer);

	public void deleteByPrimaryKey(String customerNO);
	
}
