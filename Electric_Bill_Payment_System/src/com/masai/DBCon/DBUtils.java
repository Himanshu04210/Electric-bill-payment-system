package com.masai.DBCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	
	public static Connection createConnectionBet() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rs = ResourceBundle.getBundle("database");
		con = DriverManager.getConnection(rs.getString("url"), rs.getString("user"), rs.getString("password"));
		return con;
	}
	
	
	public static void closeConnection(Connection con) throws SQLException {
		if(con != null) con.close();
	}
	
	
	public static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		if(!rs.isBeforeFirst() && rs.getRow() == 0) return true;
		return false;
	}

}
