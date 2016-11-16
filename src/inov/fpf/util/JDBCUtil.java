package inov.fpf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	private static Connection con=null;
	private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private static String name="test";
	private static String pwd="admin";

	public static Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(url,name,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库问题");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void closeupdate(Connection con,PreparedStatement pst,ResultSet rs){

			try {
				if(con!=null){
				con.close();
				}
				if(pst!=null){
					pst.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}
