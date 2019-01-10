package servlets;

import po.User;
import service.UserService;
import utility.Global;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Global.conf_path=request.getServletContext().getRealPath(Global.conf);
        String method = request.getParameter("method");
        System.out.println(method);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        if (method.equals("login")) {
            logIn(request, response);
        } else if (method.equals("register")) {
            register(request, response);
        } else if(method.equals("logout")){
            logOut(request, response);
        }
    }

    protected void logIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        user.setUserInfo(request.getParameter("username"), request.getParameter("password"));
        String result = userService.logInService(user);
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (result.equals("no_account")) {
            out.print("<script>"
                    + "alert('用户名不存在!');"
                    + "window.location.href='"
                    + request.getContextPath()
                    + "/LogIn.jsp';"
                    + "</script>");
        } else if (result.equals("wrong_password")) {
            out.print("<script>"
                    + "alert('密码错误!');"
                    + "window.location.href='"
                    + request.getContextPath()
                    + "/LogIn.jsp';"
                    + "</script>");
        } else {
            session.setAttribute("userInfo", user);
            out.print("<script>"
                    + "window.location.href='"
                    + request.getContextPath()
                    + "/ImagesServlet?method=findall&pageNumber=0';"
                    + "</script>");
        }
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
    	User user = new User();
        user.setUserInfo(request.getParameter("username"), request.getParameter("password"), request.getParameter("nickname"));
        String result = userService.registorService(user);
        PrintWriter out = response.getWriter();
        System.out.println(result);
        if (result.equals("success")) {
            out.print("<script>"
                    + "window.location.href='"
                    + request.getContextPath()
                    + "/LogIn.jsp';"
                    + "</script>");
        }else{
            out.print("<script>"
                    + "alert('用户名已存在!');"
                    + "window.location.href='"
                    + request.getContextPath()
                    + "/Registor.jsp';"
                    + "</script>");
        }

    }

    protected void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        PrintWriter out = response.getWriter();
        out.print("<script>"
                + "window.location.href='"
                + request.getContextPath()
                + "/ImagesServlet?method=findall&pageNumber=0';"
                + "</script>");
    }

    }
