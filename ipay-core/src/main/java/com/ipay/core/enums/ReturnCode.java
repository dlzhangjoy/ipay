package com.ipay.core.enums;

/**
 * 统一返码
 * @author kaifa
 *
 */
public enum ReturnCode {
	    SUCCESS("0000", "Call Success"),//调用成功
	    ERROR("6500", "Internal Error");//系统异常

	    private String code;
	    private String msg;

	    private ReturnCode(String code, String msg) {
	        this.code = code;
	        this.msg = msg;
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

	    public boolean equals(String code) {
	        return getCode().equals(code);
	    }
}
