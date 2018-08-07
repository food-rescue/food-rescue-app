const addFoodButton = document.querySelector('.add-food button');
const addFoodInput = document.querySelector('.add-food input');
const foodList = document.querySelector('.food-list ul');
const clearInventoryButton = document.querySelector('.food-list button');
const removeInventoryItemX = document.getElementById('.food-list x');


const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function(){
	if(xhr.readyState===4 && xhr.status ===200){
		const res = xhr.responseText
		foodList.innerHTML = res
	}
}

xhr.open('POST', '/index/show-inventory', true)	
xhr.send()

addFoodButton.addEventListener('click', function() {
	postFoodList(addFoodInput.value)
	addFoodInput.value = ""
})


clearInventoryButton.addEventListener('click', function() {	
	removeFoodList()	
})

removeInventoryItemX.addEventListener('click', function() {
	removeFoodItem()
})


function postFoodList(inventoryItemName){
	xhr.open('POST', '/index/add-food/' + inventoryItemName, true)	
	xhr.send()
}

function removeFoodList(){
	xhr.open('POST', '/index/clear-inventory', true)	
	xhr.send()
}

function removeFoodItem(inventoryItemId) {
	xhr.open('POST', '/index/food-list' + inventoryItemName, true)	
	xhr.send()
}









