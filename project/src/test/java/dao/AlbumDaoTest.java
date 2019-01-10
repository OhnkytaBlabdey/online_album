package dao;

import org.junit.Test;

import java.sql.SQLException;

public class AlbumDaoTest {
    AlbumDao albumDao = new AlbumDao();
    @Test
    public void findById() throws SQLException {
        System.out.println(albumDao.findByAlbumId("1"));
        System.out.println(albumDao.findByAlbumId("2"));
        System.out.println(albumDao.findByAlbumId("3"));
    }
    @Test
    public void  findAll(){
        System.out.println(albumDao.findAllAlbums(0));
    }
    @Test
    public void findByUserId(){
        System.out.println(albumDao.findAllAlbumsByUserName("didi"));
    }
    @Test
    public void delete(){
        albumDao.deleteAlbumsByAlbumId(5);
    }
}