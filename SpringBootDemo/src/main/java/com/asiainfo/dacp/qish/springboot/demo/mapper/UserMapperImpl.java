package com.asiainfo.dacp.qish.springboot.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.dacp.qish.springboot.demo.entity.UserEntity;

public class UserMapperImpl implements UserMapper{
	
	@Autowired
	private UserMapper um;

	@Override
	public UserEntity quertUserList(String name) {
		return null;
	}
	
/*
 * 添加事务通过 @Transactional注释
 * 
 * */
	@Override
	@Transactional
	public void trans() {
		um.deleteUserList("1");
		um.insertUserList("123");
		um.quertUserList("123");
	}

	@Override
	public UserEntity insertUserList(String name) {
		return null;
	}

	@Override
	public UserEntity deleteUserList(String name) {
		return null;
	}

}
