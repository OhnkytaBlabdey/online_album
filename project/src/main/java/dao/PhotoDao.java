package dao;

import db.DBUtil;
import po.Comment;
import po.Photo;
import po.User;
import utility.Global;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhotoDao {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    String sql = null;
    Connection connection = null;
    /**
     * c  关闭各种资源(使用resultset)
     */
    public void closeParaResources(){
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
     *c 关闭资源(未使用resultset)
     */
    public void closeResources(){
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
    
    public void addPhoto(Photo photo_t) {
    	try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "insert into photo (albumid,photopath) values(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, photo_t.getAlbumId());
            preparedStatement.setString(2, photo_t.getPhotoPath());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResources();
	}
    
//    /**
//     * 根据相册id查询图片返回数组
//     */
//    public ArrayList<Photo> findPhtotsByAlbumId(int id){
//        ArrayList<Photo> photoArrayList = new ArrayList<Photo>();
//        try {
//            connection = DBUtil.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        sql = "select albumid,photopath from photo where albumid = ?";
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()){
//                Photo photo = new Photo(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2));
//                photoArrayList.add(photo);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        closeParaResources();
//        return photoArrayList;
//    }
    
    public void deleteAllPhotosInAlbum(int album_id) {
    	try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	sql = "delete from photo where albumid = ?";
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
		PhotoDao dao = new PhotoDao();
//		dao.addPhoto(new Photo(6,"path none"));
		dao.deleteAllPhotosInAlbum(6);
		
	}
}
