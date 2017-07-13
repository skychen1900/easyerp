package com.ibm.easyerp.action;

import com.ibm.easyerp.base.BaseAction;
import com.ibm.easyerp.model.Customer;
import com.ibm.easyerp.model.Order;

import com.ibm.easyerp.service.CustomerServiceI;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 客户管理action
 */

public class CustomerManageAction extends BaseAction implements ModelDriven<Customer> {

	private static final long serialVersionUID = 4799340236661860273L;
	
	private CustomerServiceI customerService;
	private Customer customer;
	
	private Order order;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("execute");
		return SUCCESS;
	}
	
	public String addUI() {				
		return "add";
		
	}
	
	public String add() {
		Customer customer = new Customer();
		getParams(customer);
		
		//客户存在check
		int count = customerService.getCustomerSize(customer);
		if(count > 0){
			addActionError(getText("9005"));
			return "add";
		}
		
		//保存客户
		customerService.save(customer);
		addActionMessage(getText("1004"));
		System.out.println(getText("1004"));
		return "customerList";
	}
	
	//对话框中修改客户信息
	public String updateUI() {
		Customer customer = new Customer();
		getParams(customer);
		customer = customerService.selectByPrimaryKey(customer.getCustomerNO());
		ActionContext context = ActionContext.getContext();
		context.put("customer",customer);
		return "update";
	}
	
	public String update() {
		Customer customer = new Customer();
		getParams(customer);
		customerService.update(customer);
		return "pub_update_success";
	}
	/**
	 * @return
	 */
	public String del() {
		Customer customer = new Customer();
		getParams(customer);
		customerService.deleteByPrimaryKey(customer.getCustomerNO());
		addActionMessage(getText("1003"));
		System.out.println(getText("1003"));
		return "customerList";
	}
	/**
	 * @return
	 */
	public String query() {
		return "query";
	}
	
	public CustomerServiceI getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerServiceI customerService) {
		this.customerService = customerService;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getModel() {
		return customer;
	}
	
}
