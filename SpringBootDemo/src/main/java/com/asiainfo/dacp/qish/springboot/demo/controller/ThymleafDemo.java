package com.asiainfo.dacp.qish.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * springboot集成thymeleaf  轻量级的前端框架   原生的HTML语言
 * 1.在pox.xml文件中引入thymeleaf 的包
 * 2.在application中配置相关信息  spring.thymeleaf.***
 * 3.在template中写html  页面名称和返回值对应
 * */
@Controller
public class ThymleafDemo {

	@RequestMapping("/index")
	public String indexDemo(Model model) {
		model.addAttribute("name", "123123");
		return "index";
	}
}
