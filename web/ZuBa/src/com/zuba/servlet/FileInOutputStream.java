package com.zuba.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zuba.dao.InsertUrl;
import com.zuba.utils.FileInOutput;

public class FileInOutputStream extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletFileUpload upload;
	private final long MAXSize = 4194304 * 2L;// 4*2MB
	private String filedir;
	public ServletContext context;
	private InsertUrl inurl;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		context = this.getServletContext();
		inurl = new InsertUrl();
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();
		// Create a new file upload handler
		this.upload = new ServletFileUpload(factory);
		// Set overall request size constraint 4194304
		this.upload.setSizeMax(this.MAXSize);
		// File file = new File(pathname);

		
		String username = (String) context.getAttribute("username");
		int id = (Integer) context.getAttribute("id");
		
		filedir = this.getServletContext().getRealPath("/images/" + id);
		
		// context = this.getServletContext();
		System.out.println("file_context:" + context.getAttribute("username"));

		PrintWriter out = response.getWriter();
		FileInOutput fio = new FileInOutput();

		// ServletContext context = this.getServletContext();

		try {
			@SuppressWarnings("unchecked")
			List<FileItem> items = this.upload.parseRequest(request);

			String url = fio.upLoadFile(items, filedir);
//			inurl.inserturlfile(username, url);
			// 使用单例保存url
			// FileUrlDao.getInstance().getFileUrl(str);
			// InsertUrl
			out.println("upload-ok");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			out.println("upload-error");
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
