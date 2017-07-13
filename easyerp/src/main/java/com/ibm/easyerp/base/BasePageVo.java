package com.ibm.easyerp.base;

import com.ibm.easyerp.util.PageIndex;

/*******************************************************************************
 * <pre>
 * 改ページ用VOクラス
 * </pre>
 *
 * @author　
 * @version 1.00.00.00
 ******************************************************************************/
public class BasePageVo extends BaseVo {

	/** 改ページ用 　何ページ　デフォルト　１ページ　*/
	protected Integer page = 1;
	
	/** 改ページ用　ページ毎に表示件数　デフォルト　10件 */
	protected Integer rows = 10;
	
	/** 改ページ用　総件数 */
	protected Integer total;
	
	/** 改ページ用 総ページ数 */
	protected Integer totalPage;
	
	protected Integer totalRecord;
	
	private PageIndex pageindex;
	
	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	/**
	 * 当ページ最終の行目を取得する
	 * 
	 * @return　行目
	 */
	public Integer getEnd() {
		//return getPage() * getRows();
		return getRows();
	}

	/**
	 * 当ページ最初の行目を取得する。
	 * 
	 * @return 行目
	 */
	public Integer getBegin() {
		System.out.println("BaseVo page:" + page);
		if (getPage() == 1) {
			return 0;
		}
		return getPage() * getRows() - getRows();
	}

	/**
	 * 当ページを取得する。
	 * 
	 * @return
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * 当ページに設定する。
	 *
	 * @param page
	 */
	public void setPage(String page) {
		this.page = Integer.parseInt(page);
	}

	/**
	 * ページ毎に表示件数を取得する。
	 * 
	 * @return 件数
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * ページ毎に表示件数に設定する。
	 * 
	 * @param rows
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	/**
	 * 総件数を取得する。
	 * 
	 * @return
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * 総件数に設定する。
	 * 
	 * @param total
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * 総ページ数を取得する。
	 * 
	 * @return
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * 総ページ数に設定する。
	 * 
	 * @param totalPage
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public PageIndex getPageindex() {
		return pageindex;
	}

	public void setPageindex(PageIndex pageindex) {
		this.pageindex = pageindex;
	}

}
