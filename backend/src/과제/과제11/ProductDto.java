package 과제.과제11;

import java.util.ArrayList;

import Day15.Ex9_MVC패턴.MemberDto;

public class ProductDto {
	
	private int pno;
	private String pname;
	private int pprice;
	private int pstock;
	private int basket;
	
	
	public ProductDto() {}

	public ProductDto(int pno, String pname, int pprice, int pstock) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.pstock = pstock;
	}
	

	public ProductDto(int pno, int basket) {
		super();
		this.pno = pno;
		this.basket = basket;
	}

	public ProductDto(int pno, String pname, int pprice, int pstock, int basket) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.pstock = pstock;
		this.basket = basket;
	}

	

	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + ", pstock=" + pstock + ", basket="
				+ basket + "]";
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPstock() {
		return pstock;
	}

	public void setPstock(int pstock) {
		this.pstock = pstock;
	}

	public int getBasket() {
		return basket;
	}

	public void setBasket(int basket) {
		this.basket = basket;
	}
	
	
}
