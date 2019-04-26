package com.asiainfo.dacp.qish.springboot.demo.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlDBUtil {

	public Connection getConn(){
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//conn=DriverManager.getConnection("jdbc:mysql://10.19.245.150:3306/dacp","dacp","dacp123");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dacpdb","root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//查询方法
	public List<Map<String, String>> exeQuery(String sql,Object obj[]){
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		Map<String, String> map=null;
		Connection conn=this.getConn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps = conn.prepareStatement(sql);
			if(obj!=null){
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			rs = ps.executeQuery();
			//获得表的结构
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				map = new HashMap<String, String>();
				//rsmd.getColumnCount() 表的列的数目   rsmd.getColumnName(j).toLowerCase()  表的字段名，并且转换为小写
				for (int j = 1; j <= rsmd.getColumnCount(); j++) {
					map.put(rsmd.getColumnName(j).toLowerCase(),rs.getString(j));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		return list;
	}
	
	//增删改方法
	public int execUpdate(String sql,Object obj[]){
		
		Connection conn=this.getConn();
		PreparedStatement ps=null;
		int a=-1;
		try {
			ps = conn.prepareStatement(sql);
			if(obj!=null){
				for (int i = 0; i < obj.length; i++) {	
					ps.setObject(i+1, obj[i]);
				}
			}
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
		
	}
}
