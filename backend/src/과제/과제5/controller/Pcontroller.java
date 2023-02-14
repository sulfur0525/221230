package 과제.과제5.controller;

import java.util.ArrayList;

import 과제.과제5.model.Product;

public class Pcontroller {
	// 싱글톤
	private static Pcontroller pc = new Pcontroller();
	private Pcontroller() {}
	public static Pcontroller getInstance() {return pc;}
	
	private ArrayList<Product> productDB = new ArrayList<>();
	
	
	//1. 상품등록
	
	public boolean write(String title, int price, String content) {
		if(Mcontroller.getInstance().getLogSession()==null) {
			return false;
		}
		int pNo = -1;
		
		if(productDB.size()==0) {
			pNo = 0;
		}else {
			pNo =productDB.get(productDB.size()).getpNo()+1;
		}
		
		Product product = new Product(pNo, title, price, content, Mcontroller.getInstance().getLogSession().getmNo());
		
		productDB.add(product);
		
		return true;
	}
	
	// 2. 글출력
		public ArrayList<Product> getList( ){
			return productDB;
		}
		
	// 3. 글상세
	public Product getBoard(int pNo) {
		int no = -1;
		for(int i = 0 ; i< productDB.size(); i++) {
			if(pNo==productDB.get(i).getpNo()) {
				no = i;
			}
		}
		return productDB.get(no);
	}
	
	// 4. 상품 삭제
	public boolean pDelete(int pNo) {
		if(Mcontroller.getInstance().getLogSession().getmNo()!=productDB.get(pNo).getmNo()) {
			return false;
		}else {
			productDB.remove(pNo);
			return true;
		}
	}
	
	
	//5. 상품 수정
	public boolean update(int pNo, String pName,int price,String pContent) {
		if(Mcontroller.getInstance().getLogSession().getmNo()!=productDB.get(pNo).getmNo()) {
			return false;
		}else {
			productDB.get(pNo).setpName(pName);
			productDB.get(pNo).setPrice(price);
			productDB.get(pNo).setpContent(pContent);
			return true;
		}
	}
}
