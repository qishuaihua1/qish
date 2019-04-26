package com.asiainfo.dacp.qish.springboot.demo.mapper;

import com.asiainfo.dacp.qish.springboot.demo.entity.UserEntity;
import org.apache.ibatis.annotations.*;
/**
 * 
 *spring boot 整合mybatis 在pom.xml中导入mybatis的包
 *在application中配置数据的连接信息
 *@mapper @select @delete  使用这些注释  省去写mapper.xml的sql配置文件
 * 
 * **/
@Mapper
public interface UserMapper {

	UserEntity ue = new UserEntity();
	@Select("select * from user where name = #{name}")
	UserEntity quertUserList(@Param("name")String name);
	
	@Select("insert into user values(null,#{name}")
	UserEntity insertUserList(@Param("name")String name);
	
	@Select("delete from user where name = #{name}")
	UserEntity deleteUserList(@Param("name")String name);
	
	
	public void trans();
}
