package com.ibm.easyerp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateConverter extends DefaultTypeConverter {
	private static final DateFormat[] ACCEPT_DATE_FORMATS = {
			new SimpleDateFormat("dd/MM/yyyy"),
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy/MM/dd") }; // ֧��ת�������ڸ�ʽ
	@SuppressWarnings("unchecked")
	public Object convertValue(Map context, Object value, Class toType) {
		if (toType == Date.class) { //����String��Date��ת��
			Date date = null;
			String dateString = null;
			String[] params = (String[]) value;	//��ò����б�
			dateString = params[0]; 			//��ȡ���ڵ��ַ���
			for (DateFormat format : ACCEPT_DATE_FORMATS) {
				try {
					date = format.parse(dateString);//���ַ�������ת��
					return date; 					//����Date��������
				} catch (Exception e) {
					continue;
				}
			}
			return null;
		} else if (toType == String.class) { //����Date��String��ת��
			Date date = (Date) value;//ǿ������ת��
			return new SimpleDateFormat("yyyy-MM-dd").format(date);//����String��������
		}
		return null;
	}
}
