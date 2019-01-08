package dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhotoDaoTest {
    PhotoDao photoDao = new PhotoDao();
    @Test
    public void findPhtotsByAlbumId() {
        System.out.println(photoDao.findPhtotsByAlbumId("1"));
        System.out.println(photoDao.findPhtotsByAlbumId("2"));
        System.out.println(photoDao.findPhtotsByAlbumId("3"));
    }
}