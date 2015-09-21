package com.zuba.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuba.json.User_Json;
import com.zuba.moclass.User;
import com.zuba.service.UserService;

public class Update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 获取流
		 */
		PrintWriter out = response.getWriter();
		StringBuffer jString = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null){
				jString.append(line);
			}
			reader.close();
		} catch (Exception e) {
			// report an error
		}
		
//		String str1 =new String(jString.toString().getBytes(), "UTF-8");
		String str = URLDecoder.decode(jString.toString(),"utf-8");
		System.out.println(str);
		/**
		 * 登录
		 */
		if (str.length() != 0) {
			User user = User_Json.updateUser(str);

			// String name = "张三";
			// String pwd = "123";
//			user.setUser_name(user.getUser_name());
//			user.setPsw(user.getPsw());
			UserService us = new UserService();
			User existuser = us.update(user);

			if (existuser != null) {
				out.println("ok");
			} else {
				out.println("error");
			}
			out.println("ok");
			System.out.println(existuser);

			// out.println(existuser);
			out.flush();
			out.close();
		} else {
			out.println("error");
			System.out.println("error");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
