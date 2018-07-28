const addFoodButton = document.querySelector('.add-food button');
const addFoodInput = document.querySelector('.add-food input');
const foodList = document.querySelector('.food-list ul');

const xhr = new XMLHttpRequest()
xhr.onreadystatechange = function(){
	if(xhr.readyState===4 && xhr.status ===200){
		const res = xhr.responseText
		foodList.innerHTML = res
	}
}

addFoodButton.addEventListener('click', function() {
	postFoodList(addFoodInput.value)
	addFoodInput.value = ""
})

function postFoodList(inventoryItemName){
	xhr.open('POST', '/home', true)
	xhr.send()
}



//add html submit button to partial to send list to recipe repository