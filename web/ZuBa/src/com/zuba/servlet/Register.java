package com.zuba.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.CycleRecoverable.Context;
import com.zuba.json.User_Json;
import com.zuba.moclass.User;
import com.zuba.service.UserService;

public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ServletContext context;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		context = this.getServletContext();

		// context = this.getServletContext();

		StringBuffer jString = new StringBuffer();
		PrintWriter out = response.getWriter();

		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jString.append(line);
			}
		} catch (Exception e) {
			// report an error
		}
		String str = URLDecoder.decode(jString.toString(), "utf-8");
		System.out.println(str);

		/**
		 * 注册
		 */
		if (str.length() != 0) {
			User user = User_Json.registerUser(str);

			// String name = "张三";
			// String pwd = "123";
			// String phone = "18870019777";
			// user.setUser_name(user.getUser_name());
			// user.setPsw(user.getPsw());
			// user.setPhone(user.getPhone());
			UserService us = new UserService();
			User existuser = us.register(user);
			// response.setCharacterEncoding("utf-8");
			User selectUser = us.selectId(user);

			context.setAttribute("username", existuser.getUsername());
			 context.setAttribute("id", selectUser.getId());

			if (existuser != null) {
				// 上传时生成的临时文件保存目录
				String tempPath = this.getServletContext().getRealPath(
						"/images/" + selectUser.getId());
				String filepath = this.getServletContext().getRealPath(
						"/images");
				File path = new File(filepath);
				File tmpFile = new File(tempPath);
				if (!path.exists()) {
					path.mkdir();
				}
				if (!tmpFile.exists()) {
					// 创建临时目录
					tmpFile.mkdir();
				}
				
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
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
