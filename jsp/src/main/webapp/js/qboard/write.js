let 문의사항임시저장소 =[]

 function qboard_write(){
	 let board ={
		btitle : document.querySelector('.btitle').value , 
		bcontent :document.querySelector('.bcontent').value , 
		bwriter : document.querySelector('.bwriter').value , 
		bpassword : document.querySelector('.bpassword').value
	 }
	 
	 문의사항임시저장소.push(board)
	 
	 location.href='list.html'
 }
 
 $(document).ready(function() {
  $('#summernote').summernote( { 
	  
	  height : 300 , 
	  lang: 'ko-KR'  
	  
	});
});