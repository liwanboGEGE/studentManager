package com.hrbu.service.Impl;

import java.util.List;

import com.hrbu.dao.UserDao;
import com.hrbu.service.LoginService;
import com.hrbu.vo.User;

public class LoginServiceImpl implements LoginService{
	//实现接口内定义的login方法
	public String login(User user) {
		//数据库中查找数据（用户名对应密码）进行比对确认是否登录
		//这里需要从数据库中查找 需要使用dao层
		//调用dao层UserDao 根据输入的用户名获取对应的密码
		UserDao userDao = new UserDao();
		String password = userDao.getUsersByUsername(user.getUsername());
		//对比密码 判断是否登录成功
		if(password.equals(user.getpassword())){
			return"login_success.jsp";
		}else {
			return"login_fail.jsp";
		}
	}

	@Override
	public List<User> getUserList() {
		return null;
		// TODO Auto-generated method stub
		
	}


}
