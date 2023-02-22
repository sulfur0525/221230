package 과제.과제11;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class View {
	Scanner scanner = new Scanner(System.in);
	
	private static View view = new View();
	private View() {};
	public static View getInstance() {return view;}
	
	//메인화면
	public void index() {
		while (true) {
			try {
				System.out.println("----------키오스크---------------------------------------------");
				System.out.println("1.관리자 | 2.사용자");
				int ch = scanner.nextInt();
				if(ch==1) {admin();}
				else if(ch==2) {user();}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			} catch (Exception e) {
				System.out.println("프로그램내 오류 발생 : 관리자에게 문의");
			}
			
			
		}
	}
	
	
	//관리자 페이지
	public void admin() {
		while (true) {
			try {
				System.out.println("----------관리자 페이지------------------------------------------");
				System.out.println("1.제품등록 | 2.제춤출력 | 3.제품정보수정 | 4.제품재고변경 | 5.제품삭제 | 6.돌아가기");
				int ch = scanner.nextInt();
				if(ch==1) {registration();}
				else if(ch==2) {list();}
				else if(ch==3) {productUpdate();}
				else if(ch==4) {stockUpdate();}
				else if(ch==5) {delete();}
				else if(ch==6) {return;}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			} catch (Exception e) {
				System.out.println("프로그램내 오류 발생 : 관리자에게 문의");
			}
			
		}
	}
	
	//제품등록
	public void registration() {
		System.out.println("제품이름 : "); String pname = scanner.next();
		System.out.println("제품가격 : ");	int pprice = scanner.nextInt();
		System.out.println("제품재고 : "); int pstock = scanner.nextInt();
		boolean result = Controller.getInstance().registration(pname, pprice, pstock);
		if(result) {System.out.println("[제품등록 성공]");}
		else {System.out.println("[제품등록 실패]");}
	}
	//제품출력
	public void list() {
		ArrayList<ProductDto> result = Controller.getInstance().list();
		System.out.println("번호\t|\t이름\t|\t가격\t|\t재고");
		for(ProductDto d : result) {
			System.out.println(d.getPno()+"\t|\t"+d.getPname()+"\t|\t"+d.getPprice()+"\t|\t"+d.getPstock());
		}
	}
	//제품정보수정
	public void productUpdate() {
		System.out.println("제품번호 : "); int pno = scanner.nextInt();
		System.out.println("새로운 제품이름 : "); String pname = scanner.next();
		System.out.println("새로운 제품가격 : ");	int pprice = scanner.nextInt();
		boolean result = Controller.getInstance().productUpdate(pno, pname, pprice);
		if(result) {System.out.println("[제품정보 변경 성공]");}
		else {System.out.println("[제품정보 변경 실패]");}
	}
	//제품재고변경
	public void stockUpdate() {
		System.out.println("제품번호 : "); int pno = scanner.nextInt();
		System.out.println("새로운 재고 : ");	int pstock = scanner.nextInt();
		boolean result = Controller.getInstance().stockUpdate(pno, pstock);
		if(result) {System.out.println("[재고 변경 성공]");}
		else {System.out.println("[재고 변경 실패]");}
	}
	//제품삭제
	public void delete() {
		System.out.println("제품번호 : "); int pno = scanner.nextInt();
		boolean result = Controller.getInstance().delete(pno);
		if(result) {System.out.println("[삭제 성공]");}
		else {System.out.println("[삭제 실패]");}
	}
	
	//소비자페이지
	public void user() {
		while (true) {
			try {
				System.out.println("----------사용자----------------------------------------------");
				ArrayList<ProductDto> result = Controller.getInstance().list();
				System.out.println("번호\t|\t이름\t|\t가격\t|\t상태");
				for(ProductDto d : result) {
					System.out.println(d.getPno()+"\t|\t"+d.getPname()+"\t|\t"+d.getPprice()+"\t|\t"+(d.getPstock()!=0 ? "판매중" : "재고부족"));
				}
				System.out.println();
				System.out.println("0.결제 | 제품번호.장바구니담기 | -1.뒤로가기");
				int ch = scanner.nextInt();
				if(ch==0) {pay();}
				else if(ch==-1) {return;}
				else {basket(ch);}
				
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			} catch (Exception e) {
				System.out.println("프로그램내 오류 발생 : 관리자에게 문의");
			}
		}
	}
	
	
	// 결제
	public void pay() {
		ArrayList<ProductDto> bList = Controller.getInstance().bList();
		System.out.println("번호\t|\t이름\t|\t가격\t|\t수량");
		for(ProductDto d : bList) {
			if(d.getBasket()!=0) {
				System.out.println(d.getPno()+"\t|\t"+d.getPname()+"\t|\t"+d.getPprice()+"\t|\t"+d.getBasket());
			}		
		}
		Controller.getInstance().pay();
		
		System.out.println("[ 결제완료 ]");
	}
	
	// 제품번호선택(장바구니)
	public void basket(int ch) {
		if(Controller.getInstance().stock(ch)==0) {
			System.out.println("[ 재고 부족 ]");
			System.out.println("[ 장바구니 담기 실패 ]");
		}else {
			int bno = 1;
			boolean result = Controller.getInstance().backet(ch, bno);
			if(result) {
				System.out.println("[ 장바구니 담기 성공 ]");
			}else {
				System.out.println("[ 재고보다 많은 수를 담을 수 없습니다. ]");
				System.out.println("[ 장바구니 담기 실패 ]");
			}
		}
	}
	
	
}
