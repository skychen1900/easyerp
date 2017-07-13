package com.ibm.easyerp.service;

import com.ibm.easyerp.model.Order;
import com.ibm.easyerp.util.PageView;

import java.util.List;


public interface OrderServiceI {
	
	public List<Order> getAll(Order Order);
	
	public long getOrderSize(Order Order);
	
	public List<Order> getOrderList(Order order);

	public void save(Order Order);

	public Order selectByPrimaryKey(String OrderNO);

	public void update(Order Order);

	public void deleteByPrimaryKey(String OrderNO);
	
}
