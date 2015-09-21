package com.zuba.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuba.json.Reply_Json;
import com.zuba.moclass.Reply;
import com.zuba.service.ReplyService;

public class InsertReply extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		
		if (str.length() != 0) {
			Reply reply = Reply_Json.insertReply(str);

			ReplyService rs = new ReplyService();
			Reply existreply = rs.insert_info(reply);
			// response.setCharacterEncoding("utf-8");

			if (existreply != null) {
				out.println("ok");
			} else {
				out.println("error");
			}
			out.println("ok");

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
