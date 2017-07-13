package com.ibm.easyerp.dao;

import java.util.List;

import com.ibm.easyerp.model.Customer;
import com.ibm.easyerp.util.PageView;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {
	
    Customer selectByPrimaryKey(String customerNO);
	
    List<Customer> getAll(PageView pageView);
    
    List<Customer> getAll2(Customer customer);
    
    int getTotal(Customer customer);
    
    void updateByPrimaryKeySelective(Customer customer);
    
    void updateByPrimaryKey(Customer customer);
    
    void insert(Customer customer);
    
    void deleteByPrimaryKey(String customerNO);

}