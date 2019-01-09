package servlets;

import db.ImageUtil;
import po.Album;
import po.Photo;
import service.AlbumService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

@WebServlet(name = "ImagesServlet")
public class ImagesServlet extends HttpServlet {
    public AlbumService albumService = new AlbumService();
    ArrayList<Album> albumArrayList = new ArrayList<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int location = Integer.parseInt(request.getParameter("location"));
        if(method.equals("findall")){
            albumArrayList = albumService.findAllAlbums(location);
            session.setAttribute("albumArrayList", albumArrayList);
            out.print("<script>"
                    + "window.location.href='"
                    + request.getContextPath()
                    + "/index.jsp';"
                    + "</script>");
        }else if (method.equals("findalbumbylocation")){

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
