console.log('view')
getBoard()
function getBoard(){
	let bno = document.querySelector('.bno').innerHTML;
	
	$.ajax({
		url: "/jspweb/board/info",
		method : "get",
		data : {"type":2,"bno":bno} ,
		success : (r)=>{
			console.log('ajax통신');
			console.log( r );	// 응답 결과 데이터 확인 
			
			document.querySelector('.infobox').innerHTML=r.bdate+'/'+
				r.bview+
				'/<button type="button" onclick="bIncrease('+2+')">'+r.bup+'</button>'+
				'/<button type="button" onclick="bIncrease('+3+')">'+r.bdown;+'</button>'
			document.querySelector('.pimgbox').innerHTML=r.mid+'/'+r.mimg;
			document.querySelector('.btitle').innerHTML=r.btitle;
			document.querySelector('.bcontent').innerHTML=r.bcontent;
			
			if(r.bfile == null){
				document.querySelector('.bfile').innerHTML='';
			}else{
				let html = `${r.bfile} <button type="button" onclick="bdownload('${r.bfile}')"> 다운로드 </button>`
				document.querySelector('.bfile').innerHTML=html;
			}
			if(memberinfo.mid == r.mid){
				html =`	<button type="button" onclick="bdelete(${bno},${r.cno})">삭제</button>
						<button type="button" onclick="bupdate(${bno})">수정</button>`
						
				document.querySelector('.btnbox').innerHTML = html
			}
		}
	})
}

function bdownload(bfile){
	console.log('bdownload'+bfile)
	/*
	$.ajax({
		url: "/jspweb/filedownload",
		method : "get",
		data : {"bfile":bfile} ,
		success : (r)=>{
			console.log('ajax통신');
			console.log( r );	// 응답 결과 데이터 확인 
		}
	})
	*/
	
	location.href="/jspweb/filedownload?bfile="+bfile;
}
bIncrease(1)
function bIncrease(type){
	let bno = document.querySelector('.bno').innerHTML
	
	$.ajax({
		url: "/jspweb/board/view",
		method : "get",
		data : {"type":type,"bno":bno} ,
		success : (r)=>{
			console.log('ajax통신');
			console.log( r );	// 응답 결과 데이터 확인
			getBoard()
		}
	})
}

function bdelete(bno,cno){
	$.ajax({
		url: "/jspweb/board/info",
		method : "delete",
		data : {"bno":bno} ,
		success : (r)=>{
			console.log('ajax통신');
			console.log( r );
			
			if(r=='true'){
				location.href="/jspweb/board/list.jsp?cno="+cno;
			}
		}
	})
}

function bupdate(bno){
	location.href='/jspweb/board/update.jsp?bno='+bno
}

