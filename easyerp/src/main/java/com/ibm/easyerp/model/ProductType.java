package com.ibm.easyerp.model;

import com.ibm.easyerp.base.BasePageVo;

public class ProductType extends BasePageVo {			//��Ʒ�����Ϣ
	private String producttypeNO;	//��Ʒ�����
	private String producttypeName;	//��Ʒ�������
	public ProductType(){}			//Ĭ�Ϲ��췽��
	public ProductType(String producttypeNO) {//�Զ��幹�췽��
		this.producttypeNO = producttypeNO;
	}

	public String getProducttypeNO() {//��ò�Ʒ�����
		return producttypeNO;
	}
	public void setProducttypeNO(String producttypeNO) {//���ò�Ʒ�����
		this.producttypeNO = producttypeNO;
	}

	public String getProducttypeName() {//��ò�Ʒ�������
		return producttypeName;
	}
	public void setProducttypeName(String producttypeName) {//���ò�Ʒ�������
		this.producttypeName = producttypeName;
	}
}
