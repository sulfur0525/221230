var IMP = window.IMP; // 생략 가능
IMP.init("imp76541280"); // 예: imp00000000a
 
let pay=0;
function setpay(pay1){
	pay=pay1
	alert('결제금액 선택')
} 

function requestPay() {
	if(pay==0){
		alert('충전금액을 선택해 주세요.')
		return;
	}else{
		IMP.request_pay({
			pg: "kcp.INIBillTst",
			pay_method: "card",
			merchant_uid: "ORD20180131-0000011",   // 주문번호
			name: "포인트",
			amount: pay,                         // 숫자 타입
			buyer_email: "gildong@gmail.com",
			buyer_name: "홍길동",
			buyer_tel: "010-4242-4242",
			buyer_addr: "서울특별시 강남구 신사동",
			buyer_postcode: "01181"
		}, function (rsp) { // callback
	    	if (rsp.success) {
	        // 결제 성공 시 로직
	    	} else {
				let info ={
					"content": '포인트충전',
					"point": pay,
					"mno": memberinfo.mno
				}
				
	       		$.ajax({
					url : "/jspweb/point" ,	// 서블릿 클래스의 @WebServlet("/member")
					method : "post" ,			// 메소드 선택
					data : info ,
					success : (r)=>{ 
						console.log( r );
						if( r == 'true'){
							alert('포인트 충전 성공');
						}else{ alert('포인트 충전 실패') }
					} // success end 
				}) // ajax end 
	    	}
		});
	}
}

IMP.certification({
    merchant_uid : 'merchant_' + new Date().getTime() //본인인증과 연관된 가맹점 내부 주문번호가 있다면 넘겨주세요
}, function(rsp) {
    if ( rsp.success ) {
    	 // 인증성공
        console.log(rsp.imp_uid);
        console.log(rsp.merchant_uid);
        
        $.ajax({
				type : 'POST',
				url : '/certifications/confirm',
				dataType : 'json',
				data : {
					imp_uid : rsp.imp_uid
				}
		 }).done(function(rsp) {
		 		// 이후 Business Logic 처리하시면 됩니다.
		 });
        	
    } else {
    	 // 인증취소 또는 인증실패
        var msg = '인증에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;

        alert(msg);
    }
});










