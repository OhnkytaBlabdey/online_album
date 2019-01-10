package servlets;

import po.Album;
import po.Photo;
import po.User;
import service.AlbumService;
import utility.Global;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AlbumServlet")
public class AlbumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Global.conf_path=request.getServletContext().getRealPath(Global.conf);
        AlbumService albumService = new AlbumService();
        String method = request.getParameter("method");
        if(method.equals("create")){
            String albumName = request.getParameter("albumName");
            Album album = new Album();
            album.setName(albumName);
            HttpSession session = request.getSession();
            String userName = ((User)session.getAttribute("userInfo")).getUserName();
            albumService.addAlbumService(userName, album);
            response.sendRedirect(request.getContextPath() + "/ImagesServlet?method=findallbyusername");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
