package servlets;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.ConfKit;
import utility.Global;
import utility.ImageUtil;

/**
 * 获取硬盘路径中的图片
 *
 */
@WebServlet("/image")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImageServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Global.conf_path=request.getServletContext().getRealPath("./WEB-INF/classes/system.conf");
		// 可以从请求字符串中获取要显示的图片名
		String imgId = (String) request.getParameter("id");
		String imgFormat=(String)request.getParameter("format");
		if(imgFormat==null || imgId==null) {
			return;
		}
		OutputStream out=response.getOutputStream();
		// 查询数据库获得完整的图片路径（此处临时拼凑一个）
		String imgPath = ConfKit.getProperty("imgs") + imgId +"."+ imgFormat; 
		imgPath=getServletContext().getRealPath(imgPath);
		if (null != imgPath && !"".equals(imgPath.trim())) {
			ImageUtil.showImage(response,out, imgPath, true);
		}
	}
}
