package com.ibm.easyerp.base;

/*******************************************************************************
 * <pre>
 * ベースVOクラス
 * </pre>
 *
 * @author　
 * @version 1.00.00.00
 ******************************************************************************/
public class BaseVo {

	/** データベース検索用 */
	protected boolean distinct;
	
	/** ソート用 ソート項目 */
	protected String sort;
	
	/** ソート用 ソートのルール */
	protected String order;
	
	/**
	 * Distinctかどうか取得する。
	 * 
	 * @return
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * Distinctかどうかに設定する。
	 * 
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	
	/**
	 * orderを取得する。
	 * 
	 * @return
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * orderに設定する。
	 * 
	 * @param order
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * ソート項目を取得する。
	 * 
	 * @return
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * ソート項目に設定する。
	 * 
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
}
