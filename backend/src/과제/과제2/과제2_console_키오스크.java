package 과제.과제2;

import java.util.Scanner;

public class 과제2_console_키오스크 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int menu1_price = 300; int menu1_cnt=10;
		int menu2_price = 400; int menu2_cnt=8;
		int menu3_price = 500; int menu3_cnt=15;
		
		int menu1_ch =0;
		int menu2_ch =0;
		int menu3_ch =0;
		
		int sum = 0;
				
		while(true) {
		
			System.out.println("----------키오스크----------");
			System.out.println("1.콜라 2.사이다 3.환타 4.결제");
			
			int ch = scanner.nextInt();
			
			if(ch==1) {
				if(menu1_cnt==0) {
					System.out.println("재고부족");
				}else {
					System.out.println("콜라를 선택하셨습니다.");
					menu1_ch+=1;
					menu1_cnt--;
					System.out.println(menu1_ch);
				}
			}else if(ch==2) {
				if(menu2_cnt==0) {
					System.out.println("재고부족");
				}else {
					System.out.println("사이다를 선택하셨습니다.");
					menu2_ch++;
					menu2_cnt--;
				}
			}else if(ch==3) {
				if(menu3_cnt==0) {
					System.out.println("재고부족");
				}else {
					System.out.println("환타를 선택하셨습니다.");
					menu3_ch++;
					menu3_cnt--;
				}
			}else if(ch==4) {
				System.out.println("-------장바구니------");
				System.out.println("-------------------");
				System.out.printf("%5s %4s %4s \n","제품명","수량","가격");
				
				if(menu1_ch!=0) {
					System.out.printf("%5s %4d %5d \n","콜라",menu1_ch,menu1_ch*menu1_price);
				}
				if(menu2_ch!=0) {
					System.out.printf("%5s %4d %5d \n","사이다",menu2_ch,menu2_ch*menu2_price);
				}
				if(menu3_ch!=0) {
					System.out.printf("%5s %4d %5d \n","환타",menu3_ch,menu3_ch*menu3_price);
				}
				
				sum = (menu1_ch*menu1_price)+(menu2_ch*menu2_price)+(menu3_ch*menu3_price);
				System.out.println("    총 가격 : "+sum);
				
				System.out.println("1.결제 2.취소");
				int ch2= scanner.nextInt();
				
				if(ch2==1) {
					System.out.println("돈을 넣어주세요");
					int money = scanner.nextInt();
					
					if(money<sum) {
						System.out.println("금액이 부족하여 결제 취소 되었습니다.");
						sum =0;
						menu1_cnt += menu1_ch;
						menu2_cnt += menu2_ch;
						menu3_cnt += menu3_ch;
						menu1_ch =0;
						menu2_ch =0;
						menu3_ch =0;
					}else {
						System.out.println("결제 성공");
						sum =0;
						menu1_ch =0;
						menu2_ch =0;
						menu3_ch =0;
					}
				}else if(ch2==2) {
					System.out.println("결제 취소 되었습니다.");
					sum =0;
					menu1_cnt += menu1_ch;
					menu2_cnt += menu2_ch;
					menu3_cnt += menu3_ch;
					menu1_ch =0;
					menu2_ch =0;
					menu3_ch =0;
				}else {
					System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
				}
			}else {
				System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
			}
	
		}
		
	}
}
