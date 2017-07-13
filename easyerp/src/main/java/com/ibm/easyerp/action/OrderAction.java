package com.ibm.easyerp.action;

import com.ibm.easyerp.base.BaseAction;
import com.ibm.easyerp.model.Order;
import com.ibm.easyerp.service.OrderServiceI;

import java.util.List;

/**
 * 订单显示action
 */

public class OrderAction extends BaseAction {

	private static final long serialVersionUID = -3675623781845348379L;

	private OrderServiceI orderService;
	private Order order;

	private List<Order> OrderList;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String getOrderAll(){
		return "building";
	
/*		try {
			order = new Order();
			
			getParams(order);
			
			order.setSort("orderNO");
			order.setOrder("asc");
			order.setTotalRecord((int)orderService.getOrderSize(order));
			OrderList = orderService.getOrderList(order);

			int totalPageNum = order.getTotalRecord()/order.getRows();
			if(order.getTotalRecord() % order.getRows() > 0){
				totalPageNum++;
			}
			order.setTotalPage(totalPageNum);
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return "orderList";*/
	}
	
	public String queryOrder(){
		
		//return "orderList";
		return "building";
	}

	public List<Order> getOrderList() {
		return OrderList;
	}

	public void setOrderList(List<Order> OrderList) {
		this.OrderList = OrderList;
	}
	
	public OrderServiceI getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderServiceI orderService) {
		this.orderService = orderService;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
