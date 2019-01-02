package servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.Global;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		log("login servlet inited");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//TODO initialize configuration
		 Global.conf_path=request.getServletContext().getRealPath("/system.conf");
//		 ConfKit.init();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String user=request.getParameter(m_user);
		String pw=request.getParameter(m_pw);
		if(!validate(user, pw)) {
//			response.sendRedirect("./LogIn.jsp");
			request.getRequestDispatcher("/LogIn.jsp").forward(request, response);
		}
		log("user",user);
		log("password",pw);
//		String realPath = getServletContext().getContextPath();
//		System.out.println(realPath);
	}
	
	private boolean validate(String user,String pw) {
		if(user==null||pw==null)return false;
		return true;
	}

	
	final String m_user="username";
	final String m_pw="password";
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void log(String str) {
		System.out.println(str);
	}
	public void log(String mod,String str) {
		System.out.println("[ "+mod+" ]:\t"+str);
	}
	
}
