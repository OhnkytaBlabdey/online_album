package servlets;

import po.Album;
import po.Photo;
import po.User;
import service.AlbumService;
import utility.Global;
import utility.ImageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

@WebServlet("/ImagesServlet")
public class ImagesServlet extends HttpServlet {

    public AlbumService albumService = new AlbumService();
    ArrayList<Album> albumArrayList = new ArrayList<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Global.conf_path=request.getServletContext().getRealPath(Global.conf);
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        HttpSession session = request.getSession();
        if(method.equals("findall")){
            int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            albumArrayList = albumService.findAllAlbums(pageNumber);
            session.setAttribute("albumArrayList", albumArrayList);
            response.sendRedirect(request.getContextPath() + "/index.jsp");

        }else if (method.equals("findbylocation")){
            int location = Integer.parseInt(request.getParameter("location"));
            ArrayList<Album> albumArrayList_temp = (ArrayList<Album>) session.getAttribute("albumArrayList");

            Album album = albumArrayList_temp.get(location);
            Photo photo = album.getPhotos().get(0);

            String imgPath = photo.getPhotoPath();

            imgPath = getServletContext().getRealPath(imgPath);
            OutputStream outImg=response.getOutputStream();
            if (null != imgPath && !"".equals(imgPath.trim())) {
                ImageUtil.showImage(response,outImg, imgPath, true);
            }
        }else if(method.equals("findallbyusername")){
            String userName = ((User)(session.getAttribute("userInfo"))).getUserName();
            System.out.println(userName);
            ArrayList<Album> albumArrayListByUserName = albumService.findAllAlbumsByUserName(userName);
            System.out.println(albumArrayListByUserName);
            session.setAttribute("albumArrayListByUserName", albumArrayListByUserName);
            response.sendRedirect(request.getContextPath() + "/PersonalIndex.jsp");
        }else if(method.equals("deleteAlbumById")){
            int albumId = Integer.parseInt(request.getParameter("albumId"));
            albumService.deleteAlbumByAlbumId(albumId);
            response.sendRedirect(request.getContextPath() + "/ImagesServlet?method=findallbyusername");
        }else if(method.equals("findSingleAlbumbylocation")){
            int location = Integer.parseInt(request.getParameter("location"));
            ArrayList<Album> albumArrayList_temp = (ArrayList<Album>) session.getAttribute("albumArrayListByUserName");

            Album album = albumArrayList_temp.get(location);
            Photo photo = album.getPhotos().get(0);

            String imgPath = photo.getPhotoPath();

            imgPath = getServletContext().getRealPath(imgPath);
            OutputStream outImg=response.getOutputStream();
            if (null != imgPath && !"".equals(imgPath.trim())) {
                ImageUtil.showImage(response,outImg, imgPath, true);
            }
        }else if(method.equals("setAlbum")){
            int location = Integer.parseInt(request.getParameter("location"));
            ArrayList<Album> albumArrayList_temp = (ArrayList<Album>) session.getAttribute("albumArrayListByUserName");


            Album album = albumArrayList_temp.get(location);
            session.removeAttribute("album");
            session.setAttribute("album", album);
            response.sendRedirect(request.getContextPath() + "/DisplayImages.jsp");
        }else if(method.equals("showImageByLocation")){
            int location = Integer.parseInt(request.getParameter("location"));
            Album album = (Album) session.getAttribute("album");

            Photo photo = album.getPhotos().get(location);

            String imgPath = photo.getPhotoPath();

            imgPath = getServletContext().getRealPath(imgPath);
            OutputStream outImg=response.getOutputStream();
            if (null != imgPath && !"".equals(imgPath.trim())) {
                ImageUtil.showImage(response,outImg, imgPath, true);
            }
        }else if(method.equals("setAlbumFromIndex")) {
            int location = Integer.parseInt(request.getParameter("location"));
            ArrayList<Album> albumArrayList_temp = (ArrayList<Album>) session.getAttribute("albumArrayList");


            Album album = albumArrayList_temp.get(location);
            session.removeAttribute("album");
            session.setAttribute("album", album);
            response.sendRedirect(request.getContextPath() + "/DisplayImages.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
