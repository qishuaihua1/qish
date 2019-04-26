package com.asiainfo.dacp.qish.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AsyncDemo {
	
	@Value("${name}")  //读取application配置文件中的自定义参数
	private String name;
	
	@RequestMapping("/index")
	public String indexDemo(Model model) {
		System.out.println("主程序的线程ID"+Thread.currentThread().getId());
		this.AsyncProc();
		return "index";
	}
	
	@Async
	private void AsyncProc() {
		System.out.println("异步方法的线程ID"+Thread.currentThread().getId());
	}

}
