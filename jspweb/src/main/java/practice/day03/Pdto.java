package practice.day03;

public class Pdto {
	private int pno;
	private String product;
	private int price;
	
	public Pdto() {
		// TODO Auto-generated constructor stub
	}

	public Pdto(int pno, String product, int price) {
		super();
		this.pno = pno;
		this.product = product;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Pdto [pno=" + pno + ", product=" + product + ", price=" + price + "]";
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
