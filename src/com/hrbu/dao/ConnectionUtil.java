package com.hrbu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
		private static Connection conn;
		public static Connection getConnection() {
			if(conn==null) {
				//创建数据库连接
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentManager?useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC","root","root");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				
			}
			return conn;
		}
		public static void main(String[] args) {
			System.out.println(ConnectionUtil.getConnection());
		}
	}

