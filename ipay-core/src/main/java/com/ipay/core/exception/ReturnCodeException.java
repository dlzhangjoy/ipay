package com.ipay.core.exception;

import com.ipay.core.enums.ReturnCode;

/**
 * 返回异常
 * @author kaifa
 *
 */
public class ReturnCodeException extends Exception {

    private static final long serialVersionUID = 4005358808809902012L;

    private String            code;
    private String            msg;
    
    public ReturnCodeException(ReturnCode returnCode){
         this.code=returnCode.getCode();
         this.msg=returnCode.getMsg();
    }
    public ReturnCodeException(ReturnCode returnCode,String extMsg){
        this.code=returnCode.getCode();
        StringBuilder sb=new StringBuilder();
        sb.append(returnCode.getMsg());
        sb.append(",");
        sb.append(extMsg);
        this.msg=sb.toString();
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
}
