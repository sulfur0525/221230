package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public Dao() {
		try {
			//해당 mysql 드라이버 찾기
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("연동성공");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
