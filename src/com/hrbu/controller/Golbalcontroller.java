package com.hrbu.controller;

import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrbu.dao.ConnectionUtil;
import com.hrbu.service.LoginService;
import com.hrbu.service.Impl.LoginServiceImpl;
import com.hrbu.vo.User;

public class Golbalcontroller extends HttpServlet {
	private Map<String,String> userMap = new HashMap<String,String>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("run in doget");
		resp.sendRedirect("ok.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String uri = req.getRequestURI();
		//我们截取的位置是从左后一个/开始（包括）到。do（不包含）
		String action = uri.substring(uri.lastIndexOf("/")+1,uri.indexOf(".do"));
		if(action.equals("register")) {//注册
		//存储到map
		//	userMap.put(username,password);
			//跳转注册成功页面
		//	resp.sendRedirect("register_ok.jsp");
			Connection conn=ConnectionUtil.getConnection();
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("insert into user(username,password) values(?,?)");
				ps.setString(1,username);
				ps.setString(2,password);
				int i = ps.executeUpdate();
				if(i==1) {
					resp.sendRedirect("register_ok.jsp");
				}else {
					resp.sendRedirect("register_fail.jsp");
				}
			} catch (SQLException e) {
				resp.sendRedirect("register_fail.jsp");
				e.printStackTrace();
			}
			
		}else 
			if(action.equals("login")) {//登录
				LoginService loginService = new LoginServiceImpl();
				User user= new User();
				user.setUsername(username);
				user.setpassword(password);
				if(loginService.login(user)=="login_success.jsp") {
					HttpSession session = req.getSession();
					session.setAttribute("username",username);
					List<User> userList=loginService.getUserList();
					session.setAttribute("userList",userList);
					resp.sendRedirect("login_success.jsp");
				}
				else {
					resp.sendRedirect("login_fail.jsp");
				}
			}
	}
}
	
			//获取数据库连接
				/*
			Connection conn = ConnectionUtil.getConnection();
			//创建PS引用（jdbc的预处理对象）
			PreparedStatement ps = null;
			//获取session对象
			HttpSession session = req.getSession();
			try {
				ps = conn.prepareStatement("select * from user where username=?");
				ps.setString(1, username);
				//设置完成后使用executeQuery方法即可执行上面的sql语句，该方法会返回一个ResultSet结果集，该结果集中包含了我们要查询的数据
				ResultSet rs = ps.executeQuery();
				if(rs!=null&&rs.next()) {
					//rs.next方法会返回一个boolean，代表没有下一行，顺便会让行指针指向下一行
					//因为我们只需要一行数据（正常情况下应该只有一行），所以我们直接next之后用rs获取数据就行了
					String dbpwb = rs.getString(2);//此处获取当行数据的第二列对应的数据，第二行对应的是密码
					if(password.equals(dbpwb)) {
						//密码相同 跳转成功
						//在登录成功后 使用session存储用户名 以供在页面上显示用户名
						session.setAttribute("username",username);
						*//**
						 * 登录成功后查询你想要的的表里面的数据（这里就以用户信息user表为例查询了当前表下的所有数据）
						 * 并使用泛型存储数据，使用session进行存储
						 *//*
						PreparedStatement ps_second = null;
						//查询所有数据
						ps_second = conn.prepareStatement("select * from user");
						ResultSet rsList = ps_second.executeQuery();
						//定义泛型，存储返回的数据，这里使用了user对数据进行封装
						List<User> userlist = new ArrayList<User>();
						//遍历返回数据并将其存储到userlist中
						while(rsList.next()){
							//实例化user
							User user = new User();
							//向user中赋值
							user.setUsername(rsList.getString(1));
							user.setage(rsList.getInt(3));
							//将user存储到userList
							userlist.add(user);
						}
						//将user存储到session中
						sessionsetAttribute("userList",userlist);
						resp.sendRedirect("login_success.jsp");
					}else {
						//这里是密码错了
						resp.sendRedirect("login_fail.jsp");
					}
				}else {//没有结果集或者没有数据表示用户不存在
					resp.sendRedirect("login_fail.jsp");
				}
			}catch(SQLException e) {
				resp.sendRedirect("login_fail.jsp");
				e.printStackTrace();
				*/
