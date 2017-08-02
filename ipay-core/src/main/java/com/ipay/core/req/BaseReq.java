package com.ipay.core.req;

import com.ipay.core.BaseObj;
/**
 * 接口调用请求
 * @author kaifa
 *
 * @param <T>
 */
public class BaseReq<T> extends BaseObj{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 每次请求唯一Id
	 */
	 private String requestId;
	 /**
	   * 源系统
	  */
	 private String originAppName; 
	 /**
	  * 请求数据
	  */
	 private T data;
	 public BaseReq(){
	 }
	 public BaseReq(String requestId,String originAppName,T data){
		 this.requestId=requestId;
		 this.originAppName=originAppName;
		 this.data=data;
	 }
	 

	public String getRequestId() {
		return requestId;
	}


	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}


	public String getOriginAppName() {
		return originAppName;
	}

	public void setOriginAppName(String originAppName) {
		this.originAppName = originAppName;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
