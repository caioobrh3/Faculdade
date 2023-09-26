class Node {
	constructor(value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

class BinaryTree {
	constructor() {
		this.root = null;
	}

	insert(value) {
		if (this.root === null) {
			this.root = new Node(value);
		} else {
			this.insertNode(this.root, value);
		}
	}

	insertNode(node, value) {
		if (value < node.value) {
			if (node.left === null) {
				node.left = new Node(value);
			} else {
				this.insertNode(node.left, value);
			}
		} else {
			if (node.right === null) {
				node.right = new Node(value);
			} else {
				this.insertNode(node.right, value);
			}
		}
	}

	remove(value) {
		this.root = this.removeNode(this.root, value);
	}

	removeNode(node, value) {
		if (node === null) {
		  return null;
		} else if (value < node.value) {
		  node.left = this.removeNode(node.left, value);
		  return node;
		} else if (value > node.value) {
		  node.right = this.removeNode(node.right, value);
		  return node;
		} else {
		  if (node.left === null && node.right === null) {
			return null;
		  } else if (node.left === null) {
			return node.right;
		  } else if (node.right === null) {
			return node.left;
		  } else {
			const minNode = this.findMinNode(node.right);
			node.value = minNode.value;
			node.right = this.removeNode(node.right, minNode.value);
			return node;
		  }
		}
	  }
	  
	  

	findMinNode(node) {
		if (node.left === null) {
			return node;
		} else {
			return this.findMinNode(node.left);
		}
	}

	clearTree() {
		this.root = null;
	}

	updateTree() {
		let treeElements = document.getElementById("tree-elements");
		treeElements.innerHTML = "";
		this.traverseInOrder(this.root, (node) => {
			let div = document.createElement("div");
			div.innerText = node.value;
			treeElements.appendChild(div);
		});
	}

	traverseInOrder(node, callback) {
		if (node !== null) {
			this.traverseInOrder(node.left, callback);
			callback(node);
			this.traverseInOrder(node.right, callback);
		}
	}

	insertRandom() {
		let randomNum = Math.floor(Math.random() * 100) + 1;
		this.insert(randomNum);
		this.updateTree();
	}
}

let tree = new BinaryTree();

function insert() {
	let value = document.getElementById("input").value;
	if (isNaN(value)) {
		alert("Insira um valor numérico válido.");
		return;
	}
	tree.insert(Number(value));
	tree.updateTree();
	document.getElementById("input").value = "";
}

function remove() {
	let value = document.getElementById("input").value;
	if (isNaN(value)) {
		alert("Insira um valor numérico válido.");
		return;
	}
	tree.remove(Number(value));
	tree.updateTree();
	document.getElementById("input").value = "";
}

function clearTree() {
	tree.clearTree();
	tree.updateTree();
	document.getElementById("input").value = "";
}

function insertRandom() {
	tree.insertRandom();
}
