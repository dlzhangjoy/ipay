package com.ipay.member;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipay.core.enums.ReturnCode;
import com.ipay.core.exception.ReturnCodeException;
import com.ipay.core.resp.BaseResp;
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public BaseResp<Object> exception(Exception e){
		if(e instanceof ReturnCodeException){
			return new BaseResp<Object>((ReturnCodeException)e);
		}else{
			return new BaseResp<Object>(new ReturnCodeException(ReturnCode.ERROR,e.getMessage()));
		}
	}
}
