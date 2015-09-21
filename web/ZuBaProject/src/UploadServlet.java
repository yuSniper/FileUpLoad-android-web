import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;
	private ServletFileUpload upload;
	private final long MAXSize = 4194304 * 2L;// 4*2MB
	private String filedir = null;

	/**
	 * 设置文件上传的初始化信息
	 * 
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		FileItemFactory factory = new DiskFileItemFactory();// Create a factory
															// for disk-based
															// file items
		this.upload = new ServletFileUpload(factory);// Create a new file upload
														// handler
		this.upload.setSizeMax(this.MAXSize);// Set overall request size
												// constraint 4194304
		filedir = config.getServletContext().getRealPath("images");
		System.out.println("filedir=" + filedir);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		String loadpath = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/Image"); // 上传文件存放目录

		PrintWriter out = response.getWriter();
		try {
			List<FileItem> items = this.upload.parseRequest(request);
			if (items != null && !items.isEmpty()) {
				for (FileItem fileItem : items) {
					String filename = fileItem.getName();
					String filepath = filedir + File.separator + filename;
					System.out.println("文件保存路径为:" + filepath);
					File file = new File(filepath);
					InputStream inputSteam = fileItem.getInputStream();
					BufferedInputStream fis = new BufferedInputStream(
							inputSteam);
					FileOutputStream fos = new FileOutputStream(file);
					int f;
					while ((f = fis.read()) != -1) {
						fos.write(f);
					}
					fos.flush();
					fos.close();
					fis.close();
					inputSteam.close();
					System.out.println("文件：" + filename + "上传成功!");
				}
			}
			System.out.println("上传文件成功!");
			out.write("上传文件成功!");
		} catch (FileUploadException e) {
			e.printStackTrace();
			out.write("上传文件失败:" + e.getMessage());
		}

		// }
		// else{
		// //如果没有文件上传
		// }

		// response.setContentType("text/html; charset=UTF-8");
		//
		// // print query string or body parameter
		// // response.getWriter().print(new
		// // String(request.getParameter("qmsg").getBytes("ISO-8859-1"),
		// "GBK"));
		// System.out.println("dopost");
		//
		// SmartUpload smartUpload = new SmartUpload();
		// smartUpload.initialize(this.getServletConfig(), request, response);
		// // smartUpload.upload();
		// try {
		//
		// // smartUpload.upload();
		// com.jspsmart.upload.File smartFile = smartUpload.getFiles()
		// .getFile(0);
		//
		// if (!smartFile.isMissing()) {
		// String saveFileName = "/data/" + smartFile.getFileName();
		// smartFile.saveAs(saveFileName, smartUpload.SAVE_PHYSICAL);
		//
		// System.out.println(smartFile.getFileName());
		// // print multipart parameter
		// response.getWriter().print(" ok: " + saveFileName);
		// // + ", msg: " + smartUpload.getRequest().getParameter("msg"));
		// } else {
		// response.getWriter().print("missing...");
		// System.out.println("missing...");
		//
		// }
		// } catch (Exception e) {
		// response.getWriter().print(e);
		// System.out.println("error");
		// }
	}
}
