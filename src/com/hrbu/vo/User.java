package com.hrbu.vo;

import java.util.Date;

public class User {
	//定义私有变量	
	private String username;
	private String password;
	private int age;
	private Date ts;
	//通过get/set方法来获取/存储私有变量
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;	
    }
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public int getage() {
		return age;
	}
	public void setage(int age) {
		this.age = age;
	}
	public Date getts() {
		return ts;
	}
	public void setts(Date ts) {
		this.ts = ts;
	}
}	
