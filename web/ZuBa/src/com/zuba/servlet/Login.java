package com.zuba.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuba.json.User_Json;
import com.zuba.moclass.User;
import com.zuba.service.UserService;

public class Login extends HttpServlet {
	
	public ServletContext context;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		context = this.getServletContext();
		/**
		 * 获取流
		 */
		StringBuffer jString = new StringBuffer();
		PrintWriter out = response.getWriter();

		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jString.append(line);
			}
			reader.close();
		} catch (Exception e) {
			// report an error
		}

		// String str1 =new String(jString.toString().getBytes(), "UTF-8");

		String str = URLDecoder.decode(jString.toString(), "utf-8");
		System.out.println(str);
		/**
		 * 登录
		 */
		if (str.length() != 0) {
			User user = User_Json.loginUser(str);

			// String name = "张三";
			// String pwd = "123";
			// user.setUser_name(user.getUser_name());
			// user.setPsw(user.getPsw());
			System.out.println("login" + user.getUsername());
			UserService us = new UserService();
			User existuser = us.login(user);

//			context.setAttribute("username", existuser.getUsername());
			
			System.out.println("login_context:" + context.getAttribute("username"));

			if (existuser != null) {
				String ok = URLEncoder.encode("ok", "UTF-8");

				out.print("ok");

			} else {
				out.print("error");
			}
			// out.println("ok");
			System.out.println(existuser);

			// out.println(existuser);
			out.flush();
			out.close();
		} else {
			out.print("error");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
