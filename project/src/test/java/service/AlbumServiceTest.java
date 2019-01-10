package service;

import org.junit.Test;
import po.Album;

//import java.sql.SQLException;
//
//import static org.junit.Assert.*;

public class AlbumServiceTest {
    AlbumService albumService = new AlbumService();
    @Test
    public void findByAlbumIdService() {
        Album album = new Album();
        album.setName("new");
        albumService.addAlbumService("root", album);
    }
}