package com.visa.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/visa_trg_db";
	private static String USER = "root";
	private static String PWD = "mysqlroot";
	//only once load that's why static
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USER,PWD);
	}
	//closing no need to tell user that is why no throws
	public static void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
