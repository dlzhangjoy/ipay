package com.ipay.core.req;

import java.io.Serializable;
/**
 * 分页查询请求
 * @author kaifa
 *
 * @param <T>
 */
public class PageQueryReq<T> extends BaseReq<T>  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 /**
	     * 页码，从1开始，默认1
	     */
	private int pageNum=1;
	    /**
	     * 页面大小,默认10
	     */
	private int pageSize=10;
	 
	public PageQueryReq() {
		super();
	}
	public PageQueryReq(String requestId,String originAppName, T data) {
		super(requestId,originAppName, data);
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
