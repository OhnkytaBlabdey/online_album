package service;

import java.util.ArrayList;

import dao.CommentDao;
import po.Comment;

public class CommentService {
	private CommentDao commentDao=new CommentDao();
	
	public void addComment(Comment comment) {
		commentDao.addComment(comment);
	}
	
	public ArrayList<Comment> findAllCommentInAlbum(int album_id) {
		return commentDao.getAllCommentByAlbumId(album_id);
	}
	
	public void deleteAllCommentInAlbum(int album_id) {
		commentDao.deleteAlbumComment(album_id);
	}
	

}
