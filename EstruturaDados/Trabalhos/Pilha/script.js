const stack = [];
const maxSize = 10;

const addElement = () => {
	const input = document.getElementById("input");
	const value = input.value;
	if (value === "") {
		alert("Por favor, insira um valor válido.");
	} else if (stack.length >= maxSize) {
		alert("Pilha cheia.");
	} else {
		stack.push(value);
		updateStack();
		input.value = "";
	}
}

const removeElement = () => {
	if (stack.length === 0) {
		alert("Pilha vazia.");
	} else {
		stack.pop();
		updateStack();
	}
}

const addRandom = () => {
	if (stack.length >= maxSize) {
		alert("Pilha cheia.");
	} else {
		const random = Math.floor(Math.random() * 100) + 1;
		stack.push(random);
		updateStack();
	}
}

const updateStack = () => {	const stackElements = document.getElementById("stack-elements");
if (stack.length === 0) {
    stackElements.innerHTML = "<p>Vazio</p>";
} else {
    let elements = "";
    for (let i = stack.length - 1; i >= 0; i--) {
        elements += `<p>${stack[i]}</p>`;
    }
    stackElements.innerHTML = elements;
}
}

const sizeInput = document.getElementById("size");
sizeInput.addEventListener("change", () => {
maxSize = sizeInput.value;
if (stack.length > maxSize) {
    stack.splice(0, stack.length - maxSize);
    updateStack();
}
});

document.getElementById("add").addEventListener("click", addElement);
document.getElementById("remove").addEventListener("click", removeElement);
document.getElementById("random").addEventListener("click", addRandom);

updateStack();

