package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBUtil;
import po.Album;

public class AlbumDao {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
    Album album = new Album();
    Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    String sql = null;
    /**
     * c注册服务
     */
    public void addAlbum(Album album_t){
        connection = DBUtil.getConnection();
        sql = "insert into album (name,userid) values(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, album_t.getName());
            preparedStatement.setInt(2, album_t.getUserid());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResources();
    }
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
	/**
     *c 通过用户名查询
     * */
    public Album findByAlbumName(String album_name){
        connection = DBUtil.getConnection();
        sql = "select name,userid from album where name = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, album_name);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
            	album.setName(resultSet.getString("name"));
            	album.setUserid(resultSet.getInt("useid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeParaResources();
        return album;
    }

}
