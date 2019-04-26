package com.asiainfo.dacp.qish.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
//还注解自动扫描和此类同级的所有的包和类
//springboot 获得静态文件配置 默认获取application.properties文件中的信息  js、css默认是static文件下的
@SpringBootApplication
@EnableScheduling//开启定时任务
@EnableAsync//开启异步
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
