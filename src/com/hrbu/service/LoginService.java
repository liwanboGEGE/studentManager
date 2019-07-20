package com.hrbu.service;
import java.util.List;
import com.hrbu.vo.User;

public interface LoginService {
	//定义login方法
	public String login(User user);
		public List<User> getUserList();
	
}
