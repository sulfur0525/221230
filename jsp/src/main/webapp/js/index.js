let productlist = [
	{img: 'img/book1.jpg' ,title : '호랭떡집', size: '210*265mm', price: 16500 , discount: 0.1 ,like: 10 , review: 7},
	{img: 'img/book2.jpg' ,title : '희망의 끈', size: '128*188mm', price: 18800 , discount: 0.1 ,like: 10 , review: 4},
	{img: 'img/book3.jpg' ,title : '아무도 모를 것이다', size: '128*195mm', price: 17000 , discount: 0.1 ,like: 8.5 , review: 2},
	{img: 'img/book4.jpg' ,title : '기대의 발견', size: '145*215mm', price: 18000 , discount: 0.1 ,like: 10 , review: 10},
	{img: 'img/book5.jpg' ,title : '세이노의 가르침', size: '152*223mm', price: 7200 , discount: 0.1 ,like: 9.8 , review: 0},
	{img: 'img/book6.jpg' ,title : '미스터 프레지던트', size: '145*215mm', price: 22000 , discount: 0.1 ,like: 9.8 , review: 5}
]

product_print()

function product_print(){
	let html = ''
	
	productlist.forEach((o,i)=> {
		html +=`
			<div class="item">
				<div class ="imgbox">
				<img src="${o.img}">
				</div>
				<div class="item_info">
					<div class="item_title">${o.title}</div>
					<div class="item_size">${o.size}</div>
					<div class="item_price">${o.price.toLocaleString()}원</div>
					<span class="item_sale">${parseInt(o.price*(1-o.discount)).toLocaleString()}원</span>
					<span class="item_discount">${parseInt(o.discount*100)}%</span>
				</div>
				<div class="item_bottom">
					<div>
						<span class="badge rounded-pill text-bg-warning">편집자 선택</span>
						<span class="badge rounded-pill text-bg-info">양탄자 배송</span>
					</div>
					<div class="item_review">별점(${o.like}) 리뷰(${o.review})</div>
				</div>
			</div>
			`
	})
	
	
	document.querySelector('.itembox').innerHTML=html
}