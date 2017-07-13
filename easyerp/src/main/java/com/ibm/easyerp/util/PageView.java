package com.ibm.easyerp.util;

import com.ibm.easyerp.base.BaseVo;

public class PageView extends BaseVo{
	
	/** 改ページ用 　何ページ　デフォルト　１ページ　*/
	protected Integer page = 1;
	
	/** 改ページ用　ページ毎に表示件数　デフォルト　10件 */
	protected Integer rows = 10;
	
	/** 改ページ用　総件数 */
	protected Integer totalRecord;
	
	/** 改ページ用 総ページ数 */
	protected Integer totalPage;
	
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
		return getPage() * getRows() - 1;
	}

	/**
	 * 当ページ最初の行目を取得する。
	 * 
	 * @return 行目
	 */
	public Integer getBegin() {
		if (getPage() == 1) {
			return 0;
		}
		return getPage() * getRows() - getRows() + 1;
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
	public void setPage(Integer page) {
		this.page = page;
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

}
