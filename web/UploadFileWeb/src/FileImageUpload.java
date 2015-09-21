import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传的Serlvet类
 * 
 */
public class FileImageUpload extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletFileUpload upload;
	private final long MAXSize = 4194304 * 2L;// 4*2MB
	private String filedir;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileImageUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 设置文件上传的初始化信息
	 * 
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();
		// Create a new file upload handler
		this.upload = new ServletFileUpload(factory);
		// Set overall request size constraint 4194304
		this.upload.setSizeMax(this.MAXSize);
		// File file = new File(pathname);
		filedir = config.getServletContext().getRealPath("images");
		File file = new File(filedir);
		if (!file.exists()) {
			// 创建临时目录
			file.mkdir();
		}
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		try {
			List<FileItem> items = this.upload.parseRequest(request);
			if (items != null && !items.isEmpty()) {
				for (FileItem fileItem : items) {
					String filename = fileItem.getName();
					System.out.println(fileItem);
					// 获取系统当前时间
					String currentTime = String.valueOf(System
							.currentTimeMillis());

					// 得到上传文件的扩展名 (.xxx)
					String fileExtName = filename.substring(filename
							.lastIndexOf("."));
					//
					String filerename = currentTime + fileExtName;
					String filepath = filedir + File.separator + filename;
					// 通过System.getProperty("file.separator")来得到系统相关的路径分隔符。
					// String separator = System.getProperty("file.separator");

					System.out.println(filepath.replaceAll("\\\\", "/"));
					// http://192.168.47.114:8080/UploadFileWeb/images/3.jpg
					System.out.println("文件保存路径为:" + filepath);
					// 重命名文件
					File file1 = new File(filedir, filename);
					File file2 = new File(filedir, filerename);
					file1.renameTo(file2);
					System.out.println(file2);
					// File file = new File(filepath);

					InputStream inputSteam = fileItem.getInputStream();
					BufferedInputStream fis = new BufferedInputStream(
							inputSteam);
					FileOutputStream fos = new FileOutputStream(file2);
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
	}

}