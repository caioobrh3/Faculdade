// script.js
function verificarNumero() {
    var numero = parseInt(prompt("Digite um número inteiro:"));

    if (isNaN(numero)) {
        alert("Por favor, digite um número válido.");
    } else if (numero > 0) {
        alert("O número é positivo.");
    } else if (numero < 0) {
        alert("O número é negativo.");
    } else {
        alert("O número é zero.");
    }
}
