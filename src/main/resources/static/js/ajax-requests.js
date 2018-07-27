const addFoodButton = document.querySelector('.add-food button');

const xhr = new XMLHttpRequest()
xhr.onreadystatechange = function(){
	if(xhr.readyState===4 && xhr.status ===200){
		const res = xhr.responseText
		foodList.innerHTML = res
	}
}
