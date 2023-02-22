package Day15.Ex8_DB연동;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DB연동 {
	//DriverManager.getConnection : 해당 주소디비와 연결 성공시 성공한 DB구현객체 반환
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public DB연동() {
		try {
			
			conn=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/java","root","1234");
			System.out.println("[연동 성공]");
			
		} catch (Exception e) {	System.out.println(e.getMessage());}
	}
	
	public static void main(String[] args) {
		DB연동 db연동 = new DB연동();
	}
}
