package Day17;

import java.util.Calendar;
import java.util.Scanner;

public class Ex3_달력 {
	public static void main(String[] args) {
		Ex3_달력 ex3_달력= new Ex3_달력(); ex3_달력.run();
	}
	
	// 1. 달력함수
	
	void run() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.printf("======================= %d년 %d월 =======================\n",year,month);
			System.out.println("일\t|월\t|화\t|수\t|목\t|금\t|토\t|");
			
			cal.set(year, month-1, 1);
			int sweek = cal.get(Calendar.DAY_OF_WEEK);
			
			int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			
			for(int i = 1 ; i<sweek ; i++) {
				System.out.print("\t|");
			}
			for(int i = 1 ; i <=eday ; i++) {
				System.out.printf("%2d\t|",i);
				if(sweek%7 == 0)System.out.println( );sweek++;
			}
			System.out.println("\n=========================================================");
			System.out.println("1.이전달 2.다음달 3.검색"); int ch = scanner.nextInt();
			if(ch==1) {
				month--;
				if(month<1) {
					month=12;
					year--;
				}
			}else if(ch==2) {
				month++;
				if(month>12) {
					month = 1;
					year++;
				}
			}else if(ch==3) {
				System.out.println("연도 : "); int inputY = scanner.nextInt();
				System.out.println("월 : "); int inputM = scanner.nextInt();
				if( inputY>=1900 && inputY<=9999 && inputM>=1 && inputM<=12) {
					year = inputY; month = inputM;
				}else{
					System.out.println("출력할 수 없는 달력입니다.");
				}
			}
		
		}
	}
}
