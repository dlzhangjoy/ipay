package com.ipay.core.resp;

import com.ipay.core.BaseObj;
import com.ipay.core.enums.ReturnCode;
import com.ipay.core.exception.ReturnCodeException;
/**
 * 接口调用返回
 * @author kaifa
 *
 * @param <T>
 */
public class BaseResp<T> extends BaseObj{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 返回码
	 */
	String code;
	/**
	 * 返回消息
	 */
    String msg;
    /**
     * 结果
     */
    private T result;
    
    public BaseResp(){
    	
    }
    public BaseResp(T result){
    	this.code=ReturnCode.SUCCESS.getCode();
    	this.msg=ReturnCode.SUCCESS.getMsg();
    	this.result=result;
    }
    public BaseResp(ReturnCodeException returnCodeException){
          this.code=returnCodeException.getCode();
          this.msg=returnCodeException.getMsg();
    }
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
}
