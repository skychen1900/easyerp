package com.ibm.easyerp.model;

import com.ibm.easyerp.base.BasePageVo;

public class Product extends BasePageVo {				//��Ʒ��Ϣ��

	private String productNO;		//��Ʒ���

	private ProductType productType;//��Ʒ����

	private String productName;		//��Ʒ����

	private String producingArea;	//��Ʒ��������

	private String productOwner;	//��Ʒ������

	private String unit;			//��Ʒ��λ

	private double price;			//��Ʒ�۸�

	private int quantity;			//��Ʒ����

	private String otherInfo;		//������Ϣ
	
	public String getProductNO() {
		return productNO;
	}
	public void setProductNO(String productNO) {
		this.productNO = productNO;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProducingArea() {
		return producingArea;
	}
	public void setProducingArea(String producingArea) {
		this.producingArea = producingArea;
	}
	
	public String getProductOwner() {
		return productOwner;
	}
	public void setProductOwner(String productOwner) {
		this.productOwner = productOwner;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
}
