package com.asiainfo.dacp.qish.springboot.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class DataSource1Conf {
	/**
	 * @MapperScan 代表要扫面的mapper包 即对应的sql语句，执行的sql datasource 写多个配置即可连接多个数据源
	 * 
	 * **/
	@Configuration
	@MapperScan(basePackages = "com.majiaxueyuan.mapper.test1", sqlSessionTemplateRef = "test1SqlSessionTemplate")
	public class DataSource1Config {

	@Bean(name = "test1DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.test1")//这里代表读取的application的中 spring.datasource.test1开头的  配置信息
	          //primary代表主库
	@Primary
	public DataSource testDataSource() {
	return DataSourceBuilder.create().build();
	}

	@Bean(name = "test1SqlSessionFactory")
	@Primary
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource)
	throws Exception {
	SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
	bean.setDataSource(dataSource);
	return bean.getObject();
	}

	@Bean(name = "test1TransactionManager")
	@Primary
	public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
	return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "test1SqlSessionTemplate")
	@Primary
	public SqlSessionTemplate testSqlSessionTemplate(
	@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
	return new SqlSessionTemplate(sqlSessionFactory);
	}
	}


}
