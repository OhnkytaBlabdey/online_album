package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import po.Album;
import po.Photo;
import service.PhotoService;
import utility.ConfKit;
import utility.Global;

/**
 * 文件上传
 * 
 * 基于Servlet 3.0的文件上传实现
 * 
 * @see http://www.cnblogs.com/xdp-gacl/p/4224960.html
 * 
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = "/upload")
@MultipartConfig // 该注解标识此Servlet支持文件上传
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PhotoService photoService = new PhotoService();

	public FileUploadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(getServletContext().getRealPath("."));
	}


	/**
	 *  user upload file
	 * @throws IOException 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
			{
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			

		//TODO initialize configuration
		Global.conf_path=request.getServletContext().getRealPath(Global.conf);
//		Global.conf_path="./system.conf";
		 
		// 指定文件上传存储路径
		 String savePath = null;
		 savePath=ConfKit.getProperty("imgs");
		 savePath=getServletContext().getRealPath(savePath);
		 if(savePath==null) {
			 doGet(request, response);
			 return;
		 }

		
		// 获取上传的文件集合
		Collection<Part> parts = request.getParts();

		if (parts.size() == 1) { // 上传单个文件
			/**
			 * Servlet 3.0将 multipart/form-data 的POST请求封装成Part，通过Part对上传的文件进行操作
			 * Part part = parts[0]; 从上传的文件集合中获取Part对象
			 * 通过表单file控件(<input type="file" name="file">)的名字直接获取Part对象
			 */
			Part part = request.getPart("file");

			/**
			 * Servlet3没有提供直接获取文件名的方法,需要从请求头中解析出来
			 * 获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
			 */
			String header = part.getHeader("content-disposition");
			// 获取文件名
			String fileName = getFileName(header);
			String absolutePath = savePath + fileName;
			// 把文件写到指定路径
			part.write(absolutePath);
			Photo photo = new Photo();
			photo.setPhotoPath(absolutePath);
			HttpSession session = request.getSession();
			int albumId = ((Album)session.getAttribute("album")).getId();
			photo.setAlbumId(albumId);
			photoService.addPhoto(photo);
            request.getRequestDispatcher("/ImagesServlet?method=findall&pageNumber=0").forward(request, response);
		} else { // 一次性上传多个文件
			for (Part part : parts) { // 循环处理上传的文件
				// 获取请求头，请求头的格式：form-data; name="file"; filename="abc.jpg"
				String header = part.getHeader("content-disposition");
				// 获取文件名
				String fileName = getFileName(header);
				// 把文件写到指定路径
				part.write(savePath + File.separator + fileName);

			}
		}

//		PrintWriter out = response.getWriter();
		out.println("文件上传结束");
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace(out);
		} catch (ServletException e) {
			e.printStackTrace(out);
		}
		out.flush();
		out.close();
	}

	/**
	 * 根据请求头解析出上传文件名
	 * 
	 * 请求头的格式：
	 * 火狐和Google浏览器：form-data; name="file"; filename="abc.jpg" 
	 * IE浏览器：form-data; name="file"; filename="E:\abc.jpg"
	 * 
	 * @param header 请求头
	 * @return 文件名
	 */
	public String getFileName(String header) {
		String[] tempArr1 = header.split(";");
		String[] tempArr2 = tempArr1[2].split("=");
		// 获取文件名，兼容各种浏览器的写法
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}
}