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
 * Servlet implementation class FileImageUploadServlet
 * 
 *    此处的文件上传比较简单没有处理各种验证，文件处理的错误等。
 * 如果需要处理，请修改源代码即可。
 */
public class FileImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload upload;
	private final long MAXSize = 4194304*2L;//4*2MB
	private String filedir=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileImageUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 设置文件上传的初始化信息
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		FileItemFactory factory = new DiskFileItemFactory();// Create a factory for disk-based file items
		this.upload = new ServletFileUpload(factory);// Create a new file upload handler
		this.upload.setSizeMax(this.MAXSize);// Set overall request size constraint 4194304
		filedir=config.getServletContext().getRealPath("images");
		System.out.println("filedir="+filedir);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			List<FileItem> items = this.upload.parseRequest(request);
			if(items!=null	&& !items.isEmpty()){
				for (FileItem fileItem : items) {
					
					System.out.println(fileItem);
					
					String filename=fileItem.getName();
					String filepath=filedir+File.separator+filename;
					
					System.out.println("文件保存路径为:"+filepath);
					
					File file=new File(filepath);
					InputStream inputSteam=fileItem.getInputStream();
					BufferedInputStream fis=new BufferedInputStream(inputSteam);
				    FileOutputStream fos=new FileOutputStream(file);
				    int f;
				    while((f=fis.read())!=-1)
				    {
				       fos.write(f);
				    }
				    fos.flush();
				    fos.close();
				    fis.close();
					inputSteam.close();
					System.out.println("文件："+filename+"上传成功!");
				}
			}
			System.out.println("上传文件成功!");
			out.write("上传文件成功!");
		} catch (FileUploadException e) {
			e.printStackTrace();
			out.write("上传文件失败:"+e.getMessage());
		}
	}

}