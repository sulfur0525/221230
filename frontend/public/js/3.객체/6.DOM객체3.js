

	//1
const textarea = document.querySelector('textarea')
const h3 = document.querySelector('h3')
	//2
textarea.addEventListener('keyup', (event) => {
	//3
	h3.innerHTML = `글자 수 : ${textarea.value.length}`
	//4
	console.log(event)
	console.log(event.altKey)
	console.log(event.ctrlKey)
	console.log(event.shiftKey)
	console.log(event.code)
	console.log(event.key)
})

	textarea.style.position = 'absolute'
	let x = 0
	let y = 0
	let block = 30;

print()
function print(){
	textarea.style.left = `${x*block}px`
	textarea.style.top = `${y*block}px`
}


document.addEventListener('keydown', (e) => {
	if(control){
		let key = e.keyCode;
		console.log(e.keyCode)
		if(key == 37){x--}
		else if(key == 38){	y--}
		else if(key == 39){	x++}
		else if(key == 40){	y++}
		print()
	}
})

let control = true;

document.querySelector('.moving').addEventListener('click',()=>{
	control = !control
})













