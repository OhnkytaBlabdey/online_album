package db;

import java.sql.*;
import java.util.Date;
import java.util.Random;

public final class DBKit {
	// JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/rsp?useSSL=false&serverTimezone=UTC";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "ohnkyta";
    static final String PW = "[[]]";
    
    static Connection conn = null;
    static Statement stmt = null;
    static boolean inited=false;
    
    static int m_row_count=0;
    static final boolean is_log=false;
    
    static protected void init() {
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            // 打开链接
            if(is_log)
            System.out.println("Connecting to db "+DB_URL+USER+PW);
            inited=true;
            conn = DriverManager.getConnection(DB_URL,USER,PW);
//            conn=DriverManager.getConnection(DB_URL+"&user="+USER+"&password="+PASS); //deprecated
            conn.setAutoCommit(true);
            
        }catch (SQLException | ClassNotFoundException e) {
        	e.printStackTrace();
        	inited=false;
		}
        if(conn!=null) {
        	if(is_log)
        	System.out.println("db opened ");
        }
	}
    
    static protected int getRowCount() {
    	if(conn==null) init();
    	
    	if(m_row_count>0) return m_row_count;
    	int r=0;
		try {
//			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select max(id) from user_data;");
			rset.next();
			r=rset.getInt(1);
//	    	ResultSetMetaData rsmd = rset.getMetaData() ; 
//	    	r = rsmd.getColumnCount();
	    	m_row_count=r;
	    	rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    	
    	return r;
    }
    
    static public void list() {
    	if(conn==null) init();
    	try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_data;");
			while(rs.next()) {
				
				Date date=rs.getDate("date");
				String name=rs.getString("user_name");
				int uid=rs.getInt("user_id");
				int p=rs.getByte("figure");
				int f=rs.getByte("oppo_figure");
				System.out.println("[info]\t"+"\t"+name+"\t"+date+"\t"+uid+"\t"+p+"\t"+f);
			}

	    	rs.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
    }
    
    static public void Insert(String name,int uid,int f_player,int f_oppo) {
    	if(conn==null) init();
    	if(conn==null) {
    		System.out.println("fail open.");
    		return;
    	}
    	String sql=" insert into user_data (date,user_name,figure,oppo_figure,user_id) values ("
//    	+(getRowCount()+1)+",
//    	+"'"
    	+"now()"+",'"+
//    	+new Date().toString()+"','"+
//    	+"1997-12-31 14:56;17"+"','"+
    	name+"',"+
    	f_player+","+
    	f_oppo+","+
    	uid+");";
    	if(is_log)
    	System.out.println("[insert]\t"+sql);
    	try {
    		Statement stmt=conn.createStatement();
			++m_row_count;
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			m_row_count=0;
			e.printStackTrace();
		}
    	if(is_log)
    	System.out.println("insert over.");
    }
    
    public static void main(String[] args) {
    	Random rnd= new Random();
		System.out.println("row count"+getRowCount());
		Insert("name-test", (rnd.nextInt()%10086+10086)%10086, (rnd.nextInt()%3+3)%3-1, -1);
		list();
		System.out.println("row count"+getRowCount());
	}
    
}
