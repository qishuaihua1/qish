package com.asiainfo.dacp.qish.springboot.demo.controller;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/***
 * 定时任务  添加注释  fixedRate 为相隔毫秒数
 * 
 * **/
@Component
public class SechedulDemo {

	@Scheduled( fixedRate =2000)
	public void secheduling() {
		System.out.println("当前时间为："+new Date());
	}
}
