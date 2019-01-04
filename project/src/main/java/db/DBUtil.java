package db;
import java.sql.*;
public class DBUtil {
    private static String username = "root";
    private static String password = "root";
    private static String drivername = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/online_album?userSSL=true&serverTimezone=UTC";

    public static Connection getConnection(){
        try {
            Class.forName(drivername);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
