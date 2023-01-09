/*
	JS 연산자
		1. 산술연산자
			-> 	1. + : 더하기  2. - : 빼기    3. * : 곱하기  4. / : 나누기  5. % : 나머지
		
		2. 연결 연산자
			-> 	1. 숫자 + 숫자 : 산술  2. 문자 + 문자 : 연결  3. 문자 + 숫자 : 연결
		
		3. 비교연산자
			-> 	1. >  초과   				2. <  미만   
				3. >= 이상   				4. <= 이하    
				5. == 같다[데이터만 비교]		===[데이터/자료형 비교]
				6. !=같지않다/아니다			!==[데이터/자료형 비교]
		
		4. 관계연산자 : 비교연산자가 2개 이상일때
			-> 	* 주의할점      1<3<5   범위 비교 불가능 =>    1<3 && 3<5
                1. && : and : 그리고 모두 이면서 면서 이고 	[비교 연산자가 모두 참이면 참]
                    사탕 이면서 초콜릿 먹을래 => 2개 먹기		
                2. || : or : 이거나 거나 하나라도 또는		[비교 연산자가 하나라도 참이면 참]
                    사탕 이거나 초콜릿 먹을래 => 1개 혹은 2개 먹기
                3. ! : 부정 : true -> false / false -> true[비교 연산자가 참이면 거짓]
		
		5.대입연산자
			-> 	1. =    :오른쪽 데이터를 왼쪽에 대입
                2. +=   :오른쪽 데이터를 왼쪽데이터와 더한후에 왼쪽에 대입
                3. -=   :오른쪽 데이터를 왼쪽데이터와 빼기후에 왼쪽에 대입
                /= *= %=
                    // 연산자 : 1. +더하기   2. =대입   [더하면서 대입 못함 ]
                    // vs 정수 = 정수 + 10
                    // 연산자 다수일때 연산자 처리 우선순위
                        // 1. 정수 + 10       [ 더하기 ]
                        // 2. 정수 = 결과     [ 대입 ]
                        
		6. 증감연산자
			->	++ : 1증가    ++변수    : 선위증가   /  변수++ : 후위증가
                -- : 1감소    --변수    : 선위감소  /   변수-- : 후위감소		 
                       
		7. 삼항연산자 [ 항이 3개 ] : 조건이 참이면 참을 출력 거짓이면 거짓을 출력
        	->	1. 조건 ? 참 : 거짓      [ 조건이 true이면 참 출력 , false 이면 거짓 출력 ]
               	2. 중첩
               		조건1 ? 참1 : 조건2 ? 참2 : 거짓
               	
*/
//1. 산술연산자
console.log(3+3)			//숫자 + 숫자
console.log('더하기 : '+10+3)	//문자 + 숫자 -> 문자 + 숫자 -> 문자 
console.log('더하기 : '+(10+3))//(숫자 + 숫자) -> 숫자 + 문자 -> 문자
console.log('빼기 : '+(10-3))
console.log('곱하기 : '+(10*3))
console.log('나누기 : '+(10/3))
console.log('나머지 : '+(10%3))//몫 제외한 나머지
		
//2. 비교연산자
console.log('초과 : '+(10>3))
console.log('미만 : '+(10<3))
console.log('이상 : '+(10>=3))
console.log('이하 : '+(10<=3))
console.log('같다 : '+(3==3))
console.log('같지않다 : '+(10!==3))

//3. 관계연산자
console.log('&& : '+(10>3 && 10>5))
console.log('|| : '+(10>3 || 3>5))
console.log('! : '+!(10>3))

//4. 대입 연산자
let data1 = 10 //선언과 동시에 대입

data1 += 2 // 10+2 -> 12대입
console.log('+=대입 후 : ' + data1)
data1 -= 5
console.log('-=대입 후 : ' + data1)
data1 *= 2
console.log('*=대입 후 : ' + data1)
data1 /= 3
console.log('/=대입 후 : ' + data1)
data1 %= 3
console.log('%=대입 후 : ' + data1)

let html = '<h3> js 작성된 코드</h3>'	// html 마크업 저장할 변수 선언
html += '<div> 안녕하세요 </div>'		// 변수에 마크업 추가
document.write(html);				// 해당 변수 값을 html 출력

//5. 증감연산자
let data2 = 10
console.log('변수 값 : ' + data2)
console.log('변수 값++ : ' + data2++)
console.log('변수 값 : ' + data2)
console.log('++변수 값 : ' + ++data2)
console.log('변수 값-- : ' + data2--)
console.log('변수 값 : ' + data2)
console.log('--변수 값 : ' + --data2)

//6. 삼항연산자
let 나이 = 38;
let 나이대 = 나이<=19 ? '청소년' : '성인'
console.log(나이대)
let 점수 = 78
let 등급 = 	점수>=90 ? 'A등급':
			점수>=80 ? 'B등급':
			점수>=70 ? 'C등급': '탈락'
console.log(등급)			

/*
	문제 1
	1. 국어, 영어, 수학 점수를 입력받아 각 변수에 저장
	2. 총점, 평균 출력
*/
/*
let value1 = Number(prompt('국어점수 입력'))
let value2 = Number(prompt('영어점수 입력'))
let value3 = Number(prompt('수학점수 입력'))
let total = value1+value2+value3
console.log('총점 : '+ total)
console.log('평균 : '+total/3)
*/
/*
	문제 2 : prompt 함수로 반지름을 입력받아서 원넓이[반지름*반지름*3.14] 출력
	문제 3 : prompt 함수로 두 실수를 입력받아서 앞 실수의 값이 뒤 실수의 몇 %인지 출력
	문제 4 : prompt 함수로 정수를 입력받아 홀수/짝수 여부 출력
	문제5 : prompt 함수 로 정수를 입력받아 7배수이면 true / 아니면 false 출력
	문제6 : prompt 함수 로 십만원 단위의 금액을 입력받아 지폐 개수 세기 
		- 356789		결과 : 십만원3장 만원5장 천원6장 
	문제7 : prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 와 일치하면 
			결과 : true 출력 아니면 false 출력 
	문제8 : prompt 함수로 두 정수를 입력받아 홀수 이면서 짝수이면 true 아니면 false 출력
*/
/*
let 반지름 = Number(prompt('반지름 입력'))
console.log('문제2 원넓이 : '+ 반지름*반지름*3.14)*/
/*
let 실수1 = Number(prompt('실수 입력'))
let 실수2 = Number(prompt('실수 입력'))
console.log('문제3 몇 %? : '+ (실수1/실수2)*100 + '%')*/
/*
let 정수1 = Number(prompt('정수 입력'))
let 나머지1 = 정수1%2
console.log('문제4 홀수? : '+ 나머지1==1)*/
/*
let 정수2 = Number(prompt('정수 입력'))
let 나머지2 = 정수2%7
console.log('문제5 7배수? : '+ 나머지2==0)*/
/*
몫 구하기 : parseInt()
let 돈 = Number(prompt('금액 입력'))
let 나머지돈1 = (돈-(돈%100000))/100000
let 나머지돈2 = (돈-100000*나머지돈1-돈%10000)/10000
let 나머지돈3 = (돈-100000*나머지돈1-10000*나머지돈2-돈%1000)/1000
console.log('문제6 지폐 개수? : '+'십만원 : '+나머지돈1+' 만원 : '+나머지돈2+' 천원 : '+나머지돈3 )*/
/*
let 아이디 = prompt('아이디 입력')
let 비밀번호 = prompt('비밀번호 입력')
let 아이디확인 = 'admin'
let 비밀번호확인 = '1234'
console.log('아이디 비밀번호 일치? : ' + ((아이디==아이디확인)&&(비밀번호==비밀번호확인)))*/
/*
let 정수1 = Number(prompt('정수 입력'))
let 정수2 = Number(prompt('정수 입력'))
let 나머지1 = 정수1%2
let 나머지2 = 정수2%2
console.log('짝수? : ' + (((나머지1==0)&&(나머지2==1))||((나머지1==1)&&(나머지2==0))))*/

let data10 = prompt('정수를 입력하시오')
let 홀짝 = (data10%2)==0 ? '짝수' : '홀수'
console.log('홀수? 짝수? : ' + 홀짝)	

let data11 = prompt('정수1를 입력하시오')
let data12 = prompt('정수2를 입력하시오')
let 큰수 = (data11>data12) ? data11 : (data11==data12) ? '둘이 같은 숫자입니다.' : data12
console.log('더 큰수? : ' + 큰수)

let data13 = prompt('정수1를 입력하시오')
let data14 = prompt('정수2를 입력하시오')
let data15 = prompt('정수3를 입력하시오')
let 최고큰수 = 	(data13>data14 && data13>data15) ? data13 :
				(data14>data13 && data14>data15) ? data14 : data15
console.log('가장 큰수? : ' + 최고큰수)
let max = data13
max = max<data14 ? data14 : max
max = max<data15 ? data15 : max
console.log('가장 큰수? : ' + max)
		
let data16 = prompt('정수1를 입력하시오')
let data17 = prompt('정수2를 입력하시오')
let data19 = prompt('정수3를 입력하시오')
let 제일큰수 = 	(data16>data17 && data16>data19) ? data16 :
				(data17>data16 && data17>data19) ? data17 : data19
let 제일작은수 = 	(data16<data17 && data16<data19) ? data16 :
				(data17<data16 && data17<data19) ? data17 : data19	
let 중간수 = 		(data16!=제일큰수 && data16!=제일작은수) ? data16 :
				(data17!=제일큰수 && data17!=제일작은수) ? data17 : data19
console.log('오름차순 : ' + 제일작은수 + 중간수 + 제일큰수)

