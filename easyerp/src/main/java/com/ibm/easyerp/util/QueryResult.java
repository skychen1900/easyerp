package com.ibm.easyerp.util;

import java.util.List;
/**
 * ��ҳʵ�����װ
 *
 */
public class QueryResult<T> {
	/** ��ý���� **/
	private List<T> resultlist;
	/** ����ܵļ�¼�� **/
	private long totalrecord;
	
	public List<T> getResultlist() {
		return resultlist;
	}
	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}
	public long getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
	}
}
