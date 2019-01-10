package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBUtil;
import po.Comment;
import utility.Global;

public class CommentDao {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private ResultSet resultSet_temp = null;
    String sql = null;
    Connection connection = null;
    /**
     * c  关闭各种资源(使用resultset)
     */
    public void closeParaResources() {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * c 关闭资源(未使用resultset)
     */
    public void closeResources() {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Comment getCommentByAlbumId(int album_id) {
    	Comment comment=new Comment();
    	sql="select albumid,comment,username from comment where albumid = ?";
    	 try {
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setInt(1, album_id);
             resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                 comment.setAlbumId(album_id);
                 comment.setComment(resultSet.getString("comment"));
                 comment.setUserName(resultSet.getString("username"));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         closeParaResources();
    	return comment;
    }
    
    public void addComment(Comment comment_t) {
    	try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "insert into comment (albumid,comment,username) values(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, comment_t.getAlbumId());
            preparedStatement.setString(2, comment_t.getComment());
            preparedStatement.setString(3, comment_t.getUserName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResources();
	}
    
    public void deleteComment(int comment_id) {
    	try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	sql = "delete from comment where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, comment_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResources();
	}
    
    public void deleteAlbumComment(int album_id) {
    	try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	sql = "delete from comment where albumid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, album_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResources();
	}
    public static void main(String[] args) {
    	Global.conf_path="C:\\Users\\peace\\Desktop\\Java\\system.conf";
		CommentDao dao=new CommentDao();
//		dao.addComment(new Comment(4,"blabla","user none"));
//		dao.deleteComment(1);
		dao.deleteAlbumComment(1);
	}
}
