package 과제.과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {
	
	private static ProductDao dao = new ProductDao();
	public static ProductDao getInstance() {return dao;}
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//생성자에서 DB연결하기 -> 호출하면 바로 연동
	private ProductDao() {
		try {
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/과제11","root","1234");
				System.out.println("[ 연동 성공 ]");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//제품등록
	public boolean registration(ProductDto dto) {
		String sql = "insert into product(pname,pprice,pstock) value(?,?,?);";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,dto.getPname());
			ps.setInt(2, dto.getPprice());
			ps.setInt(3, dto.getPstock());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("DB오류"+e);
		}return false;
	}
	
	//제품출력
	public ArrayList<ProductDto> list() {
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "select * from product;";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				ProductDto dto = new ProductDto(
						rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("DB오류"+e);
		}return null;
	}
	
	//제품정보수정
	public boolean productUpdate(int pno, String pname, int pprice) {
		String sql = "update product set pname=? , pprice=? where pno=?;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2, pprice);
			ps.setInt(3, pno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("DB오류"+e);
		}return false;
	}
	
	//제품재고변경
	public boolean stockUpdate(int pno, int pstock) {
		String sql = "update product set pstock=? where pno=?;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pstock);
			ps.setInt(2, pno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("DB오류"+e);
		}return false;
	}
	
	//제품삭제
	public boolean delete(int pno) {
		String sql = "delete from product where pno=?;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("DB오류"+e);
		}return false;
	}
	
	//@번 재고찾기
	public int stock(int pno) {
		String sql = "select pstock from product where pno=?;";
		int srock = 0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pno);
			rs=ps.executeQuery();
			while (rs.next()) {
				srock = rs.getInt(1);
			}
			return srock;
		} catch (Exception e) {
			System.out.println("DB오류"+e);
		}return 0;
	}
	
	
}
