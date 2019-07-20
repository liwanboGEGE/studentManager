package com.hrbu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public String getUsersByUsername(String username) {
		//获取数据库连接	
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String password = null;
		try {
			ps = conn.prepareStatement("select * from user where username=? ");
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			rs.next();
			//获取密码
			password = rs.getString(2);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps!= null) {
				try {
					ps.close();
				}catch(SQLException e ) {
					e.printStackTrace();
				}
			}
		}
		//返回密码
		return password;
	}
	
	

}
