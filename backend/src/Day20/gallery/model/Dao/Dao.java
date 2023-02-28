package Day20.gallery.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public Dao() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/boardDB","root","1234");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}
