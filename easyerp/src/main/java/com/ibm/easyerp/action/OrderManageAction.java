package com.ibm.easyerp.action;

import com.ibm.easyerp.base.BaseAction;
import com.ibm.easyerp.model.Order;
import com.ibm.easyerp.service.OrderServiceI;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 客户管理action
 */

public class OrderManageAction extends BaseAction implements ModelDriven<Order> {

	private static final long serialVersionUID = 4799340236661860273L;
	
	private OrderServiceI orderService;
	private Order order;

	@Override
	public String execute() throws Exception {
		System.out.println("execute");
		return SUCCESS;
	}
	
	public String addUI() {				
		//return "add";
		return "building";
		
	}
	
	public String add() {
		Order Order = new Order();
		getParams(Order);
		
		//客户存在check
		int count = (int)orderService.getOrderSize(order);
		if(count > 0){
			addActionError(getText("9005"));
			return "add";
		}
		
		//保存客户
		orderService.save(Order);
		addActionMessage(getText("1004"));
		System.out.println(getText("1004"));
		return "OrderList";
	}
	
	//对话框中修改客户信息
	public String updateUI() {
		Order Order = new Order();
		getParams(Order);
		Order = orderService.selectByPrimaryKey(order.getOrderNO());
		ActionContext context = ActionContext.getContext();
		context.put("Order",Order);
		return "update";
	}
	
	public String update() {
		Order Order = new Order();
		getParams(Order);
		orderService.update(Order);
		return "pub_update_success";
	}
	/**
	 */
	public String del() {
		Order Order = new Order();
		getParams(Order);
		orderService.deleteByPrimaryKey(order.getOrderNO());
		addActionMessage(getText("1003"));
		System.out.println(getText("1003"));
		return "OrderList";
	}
	/**
	 */
	public String query() {
		//return "query";
		return "building";
	}
	
	public OrderServiceI getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderServiceI orderService) {
		this.orderService = orderService;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getModel() {
		return order;
	}
	
}
