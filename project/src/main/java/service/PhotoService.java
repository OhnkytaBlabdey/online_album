package service;

import dao.PhotoDao;
import po.Photo;

public class PhotoService {
	private PhotoDao photoDao = new PhotoDao();
	
	public void addPhoto(Photo photo) {
		photoDao.addPhoto(photo);
	}
	public void deleteAllPhotosInAlbum(int album_id) {
		photoDao.deleteAllPhotosInAlbum(album_id);
	}

}
