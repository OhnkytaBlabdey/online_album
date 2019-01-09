package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utility.ConfKit;
import utility.Global;

public class DBUtil {
	private static String username = null;
    private static String password = null;
    private static String drivername = "com.mysql.cj.jdbc.Driver";

    private static String url = null;

    public static Connection getConnection() throws SQLException {
        try {
        	username=ConfKit.getProperty("db_user");
        	password=ConfKit.getProperty("db_pw");
        	url=ConfKit.getProperty("db_url");
            Class.forName(drivername);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  DriverManager.getConnection(url, username, password);
    }
}
