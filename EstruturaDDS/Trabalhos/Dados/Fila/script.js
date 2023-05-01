let queue = [];

function enqueue() {
	let element = document.getElementById("input").value;
	queue.push(element);
	updateQueue();
}

function dequeue() {
	queue.shift();
	updateQueue();
}

function clearQueue() {
	queue = [];
	updateQueue();
}

function updateQueue() {
	let queueElements = document.getElementById("queue-elements");
	queueElements.innerHTML = "";
	queue.forEach((element) => {
		let div = document.createElement("div");
		div.innerText = element;
		queueElements.appendChild(div);
	});
}

function enqueueRandom() {
	let randomNum = Math.floor(Math.random() * 100) + 1;
	queue.push(randomNum);
	updateQueue();
}

function enqueue() {
	let size = parseInt(document.getElementById("size-input").value);
	if (queue.length >= size) {
		alert("FILA CHEIA");
		return;
	}
	let element = document.getElementById("input").value;
	queue.push(element);
	updateQueue();
}

function enqueueRandom() {
	let size = parseInt(document.getElementById("size-input").value);
	if (queue.length >= size) {
		alert("FILA CHEIA");
		return;
	}
	let random = Math.floor(Math.random() * 100) + 1;
	queue.push(random);
	updateQueue();
}
