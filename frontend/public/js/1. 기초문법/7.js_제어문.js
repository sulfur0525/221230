/*
 	삼항연산자 : 조건 ? 참 : 거짓
 	제어문
 		IF : 만약에~~[경우의 수 판단]
 		1. 형태
 			1. IF( 조건 ) 참실행문;
            2. IF( 조건 ) { 참실행문1; 참실행문2; }
            	* 실행문 2개 이상일 때 중괄호 묶음처리 하자
            3. IF( 조건 )  참실행문;
               ELSE 거짓실행문;
            4. IF( 조건1 ) { 참실행문1; }
               ELSE IF( 조건2 ) { 참실행문2; }
               ELSE IF( 조건3 ) { 참실행문3; }
               ELSE { 거짓실행문; }
            5. if중첩
               if( 조건1 ) {
                   if( 조건 ) {  }
                   else{ }
               }else{
                   if( 조건 ) {  }
                   else{ }
               }

 	 
 */
//1. if 형태 1
if(10>3) console.log('[참1] 10이 더 크다')
if(10>20) console.log('[참2] 10이 더 크다')
if(10>20); console.log('[참3] 10이 더 크다')//X
/*
	; : 세미콜론 [명령어단위 마침표] / : : 콜론
	싱행문;
	실행문; 실행문;
	if() 참실행문;
	if(); 참실행문; [if()뒤에 ; 하지말기]
*/

//2. if
if(10>3) console.log('[참1]'); console.log('1. 10이 더 크다'); // X
if(10>20) console.log('[참2]'); console.log('2. 10이 더 크다'); // X
if(10>20) {console.log('[참3]'); console.log('3. 10이 더 크다');}

//3. if 형태3
if(10>3) {console.log('[참1] 10이 더 크다');}
else {console.log('[거짓1] 10이 더 작다');}
		//vs 삼항연산자 [코드가 길어지면 가독성 떨어짐]
10>3 ? console.log('[참2]') : console.log('[거짓2]')

//4. if 형태4
if(10>=20) {console.log('[참1] 10이 20이상이다');}
else if(10>=15) {console.log('[참2] 10이 15이상이다.');}
else if(10>=10) {console.log('[참3] 10이 10이상이다.');}
else {console.log('[거짓] 10이 10미만이다.');}
		//vs 삼항연산자 

/*
	1.
	2.
	
*/

let 정수 = Number(prompt('정수입력')) 
if(정수>=90)console.log('합격');
else console.log('탈락');

let 성별 = prompt('성별입력')
if(성별=='M'||성별=='m'||성별=='남'||성별=='남자')console.log('남자 이군요');
else if (성별=='W'||성별=='w'||성별=='여'||성별=='여자')console.log('여자 이군요');
else console.log('남자 : M,m,남,남자  여자 : W,w,여,여자 로 입력해주세요');

let 점수 = Number(prompt()) 
if(점수>=90)console.log('A등급');
else if (점수>=80)console.log('B등급');
else if (점수>=70)console.log('C등급');
else console.log('탈락');






