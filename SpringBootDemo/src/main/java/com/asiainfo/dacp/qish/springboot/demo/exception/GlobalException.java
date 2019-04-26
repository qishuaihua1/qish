package com.asiainfo.dacp.qish.springboot.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
//springboot  捕获全局异常
@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String runTimeException() {
		return "捕获异常";
	}
}
