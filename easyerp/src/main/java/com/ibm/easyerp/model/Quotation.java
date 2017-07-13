package com.ibm.easyerp.model;

import java.util.Date;
import com.ibm.easyerp.base.BasePageVo;

public class Quotation extends BasePageVo{			//������Ϣ��

	private String quotationNO;		//���۱��

	private String quotationMan;	//������

	private Date quotationTime;		//����ʱ��

	private String otherInfo;			//������Ϣ

	private Product product ;		//��Ʒ

	private Customer customer;		//�ͻ�
	
	public String getQuotationNO() {
		return quotationNO;
	}
	public void setQuotationNO(String quotationNO) {
		this.quotationNO = quotationNO;
	}
	
	public String getQuotationMan() {
		return quotationMan;
	}
	public void setQuotationMan(String quotationMan) {
		this.quotationMan = quotationMan;
	}
	
	public Date getQuotationTime() {
		return quotationTime;
	}
	public void setQuotationTime(Date quotationTime) {
		this.quotationTime = quotationTime;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
