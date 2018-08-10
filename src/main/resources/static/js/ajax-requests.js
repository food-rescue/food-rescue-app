const addFoodButton = document.querySelector('.add-food button');
const addFoodInput = document.querySelector('.add-food input');
const foodList = document.querySelector('.food-list ul');
const clearInventoryButton = document.querySelector('.food-list button');

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
	clearInventoryButton.style.visibility = "visible"
})


clearInventoryButton.addEventListener('click', function() {	
	removeFoodList()
	clearInventoryButton.style.visibility = "hidden"
})


function postFoodList(inventoryItemName){
	xhr.open('POST', '/index/add-food/' + inventoryItemName, true)	
	xhr.send()
}

function removeFoodList(){
	xhr.open('POST', '/index/clear-inventory', true)	
	xhr.send()
}






