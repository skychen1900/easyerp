package com.ibm.easyerp.action;

import java.util.List;

import com.ibm.easyerp.base.BaseAction;
import com.ibm.easyerp.model.Customer;
import com.ibm.easyerp.service.CustomerServiceI;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 客户显示action
 */

public class CustomerAction extends BaseAction {

	private static final long serialVersionUID = -3675623781845348379L;

	private CustomerServiceI customerService;// 注入客户业务组件
	private Customer customer;

	private List<Customer> customerList;

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String getCustomerAll(){
	
		try {
			customer = new Customer();
			
			getParams(customer);

			if(page != null){
				HttpServletRequest request = ServletActionContext.getRequest();
				String page = request.getParameter("page");
				System.out.println("page:" + page);
				customer.setPage(page);
			}
			
			customer.setSort("customerNO");
			customer.setOrder("asc");
			customer.setTotalRecord(customerService.getCustomerSize(customer));  //dbからユーザ数を取得する
			customerList = customerService.getCustomerList(customer);  //dbからユーザを取得する

			int totalPageNum = customer.getTotalRecord()/customer.getRows();
			if(customer.getTotalRecord() % customer.getRows() > 0){
				totalPageNum++;
			}
			customer.setTotalPage(totalPageNum);
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return "customerList";
	}
	
	public String queryCustomer(){
		
		return "customerList";
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
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
	
}
