package com.ipay.core.resp;

import java.io.Serializable;

import com.ipay.core.exception.ReturnCodeException;
/**
 * 分页查询返回
 * @author kaifa
 *
 * @param <T>
 */
public class PageQueryResp<T> extends BaseResp<T>  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 /**
	  * 页码，从1开始，默认1
	  */   
	private int pageNum;
	/**
     * 页面大小,默认20
     */    
	private int pageSize;
    /**
     * 总数
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;
    
	public PageQueryResp(){
	    	
	}
	public PageQueryResp(T result,int pageNum,int pageSize,long total,int pages){
    	super(result);
		this.pageNum=pageNum;
		this.pageSize=pageSize;
		this.total=total;
		this.pages=pages;
    }
    public PageQueryResp(ReturnCodeException returnCodeException){
          super(returnCodeException);
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
	
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
