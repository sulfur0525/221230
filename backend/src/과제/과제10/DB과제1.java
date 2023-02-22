package 과제.과제10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DB과제1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection con=null;
		while (true) {
			try {
				System.out.println("1.DB연결 | 2.테이블 생성 | 3. 데이터 저장");
				int ch = scanner.nextInt();
				if(ch==1) {
					System.out.print("-- 연동할 DB명 입력 : ");	 String dbname = scanner.next();
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/"+dbname ,	// java에서 db생성 불가능때문에 db생성 하고난 후 실행 
							"root" , 
							"1234");
					 System.out.println(" ** 연결 성공 ");
				}else if(ch==2) {
					System.out.print(" -- SQL구문 입력 : ");
					scanner.nextLine();
					String sql = scanner.nextLine();
					//"create table product( pno int , pname varchar(20) , pex varchar(100), pprice int)";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.execute();
				}else if(ch==3) {
					System.out.println("제품번호 : ");	  	int pno = scanner.nextInt();
					System.out.println("제품명 : ");		String pname = scanner.next();
					System.out.println("제품설명 : ");	String pex =scanner.next();
					System.out.println("제품가격 : ");	  	int pprice = scanner.nextInt();
					
					 String sql = "insert into member values( ? , ? , ? , ?);";
					 PreparedStatement ps = con.prepareStatement(sql);
					 
					 ps.setInt( 1 ,  pno );		
					 ps.setString( 2 , pname );	
					 ps.setString( 3 , pex);
					 ps.setInt( 4 ,  pprice );
					 
					 ps.executeUpdate();
				}
			}catch ( InputMismatchException e) { // 2. try{} 에서 예외 발생하면 실행되는 코드 
				System.out.println(" [알수없는] 입력 입니다. ");
				scanner = new Scanner(System.in); // 기존에 입력된 데이터를 제거 
			}catch ( SQLException e ) {
				System.out.println(" [SQL 오류 : " + e );
			}catch ( Exception e) {
				System.out.println(" [ DB 연결 후 다시 실행 ]");
			}	
		}
	}
}	


