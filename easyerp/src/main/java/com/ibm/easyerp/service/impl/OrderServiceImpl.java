package com.ibm.easyerp.service.impl;

import com.ibm.easyerp.model.Order;
import com.ibm.easyerp.dao.OrderMapper;
import com.ibm.easyerp.service.OrderServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderServiceI {

	private OrderMapper orderMapper;
	
	public List<Order> getAll(Order order) {
		return orderMapper.selectByOrder(order);
	}

	public OrderMapper getOrderMapper() {
		return orderMapper;
	}
	
	@Autowired
	public void setOrderMapper(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}
	
	public long getOrderSize(Order order) {
		return orderMapper.getTotal(order);
	}

	public List<Order> getOrderList(Order order) {
		return orderMapper.selectByOrder(order);
	}

	public void save(Order Order) {
		orderMapper.insert(Order);
	}

	public Order selectByPrimaryKey(String orderNO) {
		return orderMapper.selectByPrimaryKey(orderNO);
	}

	public void update(Order Order) {
		orderMapper.updateByPrimaryKey(Order);
	}

	public void deleteByPrimaryKey(String OrderNO) {
		orderMapper.deleteByPrimaryKey(OrderNO);
	}
	
}
