let list = [];

function addToList() {
	let element = document.getElementById("input").value;
	list.push(element);
	updateList();
}

function removeFromList() {
	list.pop();
	updateList();
}

function clearList() {
	list = [];
	updateList();
}

function updateList() {
	let listElements = document.getElementById("list-elements");
	listElements.innerHTML = "";
	list.forEach((element) => {
		let div = document.createElement("div");
		div.innerText = element;
		listElements.appendChild(div);
	});
}

function addRandomToList() {
	let randomNum = Math.floor(Math.random() * 100) + 1;
	list.push(randomNum);
	updateList();
}

function addToList() {
	let size = parseInt(document.getElementById("size-input").value);
	if (list.length >= size) {
		alert("LISTA CHEIA");
		return;
	}
	let element = document.getElementById("input").value;
	list.push(element);
	updateList();
}

function addRandomToList() {
	let size = parseInt(document.getElementById("size-input").value);
	if (list.length >= size) {
		alert("LISTA CHEIA");
		return;
	}
	let random = Math.floor(Math.random() * 100) + 1;
	list.push(random);
	updateList();
}
