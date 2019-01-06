package service;

import dao.AlbumDao;
import po.Album;

public class AlbumService {
	private AlbumDao albumDao=new AlbumDao();
	
	public Album findAlbum(String name) {
		return albumDao.findByAlbumName(name);
	}
public static void main(String[] args) {
	
}
}
