package com.asiainfo.dacp.qish.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @controller 
 * @RestController 返回json格式的数据
 * 
 * */

@RestController
public class Demo01 {
	@RequestMapping("/helloqish")
	public String Sayhello() {
		return "hello qish";
	}
	
	@RequestMapping("/except")
	public String except() {
		int a = 2/0;
		return "hello qish";
	}

}
