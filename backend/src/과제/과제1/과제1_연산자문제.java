package 과제.과제1;

import java.util.Scanner;

public class 과제1_연산자문제 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 1. 
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		
		// 2. 
		System.out.println("작성자 : ");
		String data1 = scanner.next();
		System.out.println("내용 : ");
		String data2 = scanner.next();
		System.out.println("날짜 : ");
		String data3 = scanner.next();
		
		System.out.println(" --------------방문록--------------------");
		System.out.println(" |  순번  | 작성자 |    내용    |    날짜    |");
		System.out.printf(" |  1   |%5s|%10s|%10s|",data1,data2,data3);
		System.out.println("  ----------------------------------------");
		
		// 3. 
		System.out.println("기본급 : ");
		int data4 = scanner.nextInt();
		System.out.println("수당 : ");
		int data5 = scanner.nextInt();
		
		int 실수령액 = data4 + data5 - (data4/10);
		
		System.out.println(실수령액);
		
		// 4. 
		System.out.println("금액 : ");
		int data6 = scanner.nextInt();
		
		System.out.println("십만원권 : " + data6/100000 + "장");
		System.out.println("만원권 : " + (data6%100000)/10000 + "장");
		System.out.println("천원권 : " + (data6%10000)/1000 + "장");
		System.out.println("백원권 : " + (data6%1000)/100 + "장");
		
		// 5.
		System.out.println("5번 정수 : ");
		int data7 = scanner.nextInt();
		
		String result1 = (data7%7==0) ? "O" : "X";
		System.out.println(result1);
		
		// 6.
		
		System.out.println("6번 정수 : ");
		int data8 = scanner.nextInt();
		
		String result2 = (data8%2!=0) ? "O" : "X";
		System.out.println(result2);
		
		
		// 7. 
		System.out.println("7번 정수 : ");
		int data9 = scanner.nextInt();
		
		String result3 = (data9%7==0 && data9%2==0) ? "O" : "X";
		System.out.println(result3);
		
		// 8.
		System.out.println("8번 정수 : ");
		int data10 = scanner.nextInt();
		
		String result4 = (data10%7==0 || data10%2!=0) ? "O" : "X";
		System.out.println(result4);
		
		// 9.
		System.out.println("9번 정수1 : ");
		int data11 = scanner.nextInt();
		System.out.println("9번 정수2 : ");
		int data12 = scanner.nextInt();

		
		int result5 = (data11>data12)? data11 : data12;
		System.out.println(result5);
		
		// 10.
		System.out.println("10번 반지름 : ");
		int data13 = scanner.nextInt();
		
		System.out.println("원 넓이 : "+(data13*data13*3.14));
		
		// 11.
		System.out.println("11번 실수1 : ");
		double data14 = scanner.nextDouble();
		System.out.println("11번 실수2 : ");
		double data15 = scanner.nextDouble();
		
		double result6 = data14%data15;
		System.out.println("결과 : " + result6);
		
		// 12.
		System.out.println("12번 정수1 : ");
		int data16 = scanner.nextInt();
		System.out.println("12번 정수2 : ");
		int data17 = scanner.nextInt();
		System.out.println("12번 정수3 : ");
		int data18 = scanner.nextInt();
		
		System.out.println("사다리꼴 넓이" + ((data16*data17)*data18/2));
		
		// 13.
		System.out.println("키 : ");
		int data19 = scanner.nextInt();
		
		System.out.println("표준체중 : "+ ((data19-100)*0.9));
		
		// 14.
		System.out.println("키 : ");
		int data20 = scanner.nextInt();
		System.out.println("몸무게 : ");
		int data21 = scanner.nextInt();
		
		float re = (data21/((data20/100) * (data20/100)));
		
		System.out.println("BMI : "+re);
		
		// 15.
		System.out.println("인치 : ");
		int data22 = scanner.nextInt();
		
		System.out.println(data22*2.54);
		
		// 16.
		System.out.println("중간고사 : ");
		int data23 = scanner.nextInt();
		System.out.println("기말고사 : ");
		int data24 = scanner.nextInt();
		System.out.println("수행평가 : ");
		int data25 = scanner.nextInt();
		
		float result7 = (float) (data23*0.3);
		float result8 = (float) (data24*0.3);
		float result9 = (float) (data25*0.4);
		
		System.out.println("중간고사 : "+result7);
		System.out.println("기말고사 : "+result8);
		System.out.println("수행고사 : "+result9);
		
		// 17.
		int x = 10;
		int y = x-- + 5 + --x;
		System.out.printf(" x의 값 : %d , y의값 :  %d ", x, y);
		// x 1감소(9) -> 앞에 x에 5더하기(9+5=14) 
			//	-> 앞의 결과갚에 x 더하기(14+9=23) -> x 1감소
			//출력되는 값 x= 8 y = 23
		
		// 18.
		System.out.println("나이 : ");
		int data26 = scanner.nextInt();
		
		String result10 = (data26>=40) ? "중년" : 
								(data26>=20)?  "성인" : 
										(data26>=10) ? "학생" : "";
		
		System.out.println(result10);
		
		//19. 
		System.out.println("국어 : ");
		int data27 = scanner.nextInt();
		System.out.println("영어 : ");
		int data28 = scanner.nextInt();
		System.out.println("수학 : ");
		int data29 = scanner.nextInt();
		
		int result11 = data27 + data28 + data29;
		float result12 = result11/3;
		
		System.out.println("총점 : "+result11);
		System.out.println("평균 : "+result12);
		
		// 20.
		System.out.println("아이디 : ");
		String data30 = scanner.next();
		System.out.println("비밀번호 : ");
		String data31 = scanner.next();
		
		String result13 = (data30.equals("admin" )&&data31.equals("1234")) ? "로그인 성공" : "로그인 실패";
		
		System.out.println(result13);
		
		// 21.
		System.out.println("21번 정수1 : ");
		int data32 = scanner.nextInt();
		System.out.println("21번 정수2 : ");
		int data33 = scanner.nextInt();
		System.out.println("21번 정수3 : ");
		int data34 = scanner.nextInt();
	
		int result14 = (data32>data33 && data32>data34) ? data32 : 
							(data33>data32 && data33>data34) ? data33 : data34;
		
		System.out.println(result14);
		
		// 22. 
		System.out.println("가위='0', 바위='1',보='2'  : ");
		int data35 = scanner.nextInt();
		System.out.println("가위='0', 바위='1',보='2'  : ");
		int data36 = scanner.nextInt();
		
		String result15 = (data35==data36) ? "무승부" :
						(data35==0 && data36==1 || data35==1 && data36==2 || data35==2 && data36==0) ? "플레이어 2승리": "플레이어 1승리";
		
		System.out.println(result15);
	}
}
