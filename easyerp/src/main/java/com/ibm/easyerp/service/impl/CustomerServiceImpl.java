package com.ibm.easyerp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.easyerp.dao.CustomerMapper;
import com.ibm.easyerp.model.Customer;
import com.ibm.easyerp.service.CustomerServiceI;
import com.ibm.easyerp.util.PageView;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerServiceI {

	private CustomerMapper customerMapper;
	
	public List<Customer> getAll(PageView pageView) {
		return customerMapper.getAll(pageView);
	}
	
	public CustomerMapper getCustomerMapper() {
		return customerMapper;
	}
	
	@Autowired
	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}
	
	public int getCustomerSize(Customer customer) {
		return customerMapper.getTotal(customer);
	}

	public List<Customer> getCustomerList(Customer customer) {
		return customerMapper.getAll2(customer);
	}

	public void save(Customer customer) {
		customerMapper.insert(customer);
	}

	public Customer selectByPrimaryKey(String customerNO) {
		return customerMapper.selectByPrimaryKey(customerNO);
	}

	public void update(Customer customer) {
		customerMapper.updateByPrimaryKey(customer);
	}

	public void deleteByPrimaryKey(String customerNO) {
		customerMapper.deleteByPrimaryKey(customerNO);
	}
	
}
