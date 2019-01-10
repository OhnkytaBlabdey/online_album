package service;

import dao.AlbumDao;
import dao.PhotoDao;
import po.Album;
import po.Photo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class AlbumService {
    /**
     * 根据相册id查询
     */
    private AlbumDao albumDao = new AlbumDao();
    public Album[] findTenAlbum(){
        return null;
    }
    public ArrayList<Album> findAllAlbums(int location){
        return albumDao.findAllAlbums(location);
    }
    public ArrayList<Album> findAllAlbumsByUserName(String userName){
        return albumDao.findAllAlbumsByUserName(userName);
    }
    public void deleteAlbumByAlbumId(int id){
        albumDao.deleteAlbumsByAlbumId(id);
    }
}
