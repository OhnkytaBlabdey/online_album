package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utility.ConfKit;
import utility.Global;

public class DBUtil {
	private static Connection connection=null;
	private static String username = null;
    private static String password = null;
    private static String drivername = "com.mysql.cj.jdbc.Driver";

    private static String url = null;

    public static Connection getConnection(){
    	if(connection!=null) return connection;
        try {
        	username=ConfKit.getProperty("db_user");
        	password=ConfKit.getProperty("db_pw");
        	url=ConfKit.getProperty("db_url");
            Class.forName(drivername);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void main(String[] args) {
    	Global.conf_path="G:\\MyProject\\Java_Eclipse_work\\online_album\\project\\src\\main\\webapp\\system.conf";
    	
    	getConnection();
	}
}
