package 과제.과제11;

import java.util.ArrayList;

public class Controller {
	private static Controller controller = new Controller();
	private Controller() {};
	public static Controller getInstance() {return controller;}
	private static ArrayList<ProductDto> basketlist = ProductDao.getInstance().list();
	
	//제품등록
	public boolean registration(String pname, int pprice, int pstock) {
		ProductDto dto = new ProductDto(0, pname, pprice, pstock);
		return ProductDao.getInstance().registration(dto);
	}
	
	//제품출력
	public ArrayList<ProductDto> list() {
		return ProductDao.getInstance().list();
	}
	
	//제품정보수정
	public boolean productUpdate(int pno, String pname, int pprice) {
		return ProductDao.getInstance().productUpdate(pno, pname, pprice);
	}
	
	//제품재고변경
	public boolean stockUpdate(int pno, int pstock) {
		return ProductDao.getInstance().stockUpdate(pno, pstock);
	}
	
	//제품삭제
	public boolean delete(int pno) {
		return ProductDao.getInstance().delete(pno);
	}
	
	//결제
	public boolean pay() {
		for( ProductDto d : basketlist) {
			d.setPstock(d.getPstock()-d.getBasket());
			ProductDao.getInstance().stockUpdate(d.getPno(), d.getPstock()-d.getBasket());
			d.setBasket(0);
		}
		return false;
	}
	
	//장바구니 출력
	public ArrayList<ProductDto> bList() {
		return basketlist;
	}
	//장바구니 추가
	public boolean backet(int pno, int basket) {
		for( ProductDto d : basketlist) {
			if(d.getPno()== pno) {
				if(d.getBasket()+basket>d.getPstock()) {
					return false;
				}
				d.setBasket(d.getBasket()+basket);
			}
		}
		System.out.println(basketlist);
		return true;
	}
	
	//@번의 재고
	public int stock(int pno) {
		return ProductDao.getInstance().stock(pno);
	}
}
