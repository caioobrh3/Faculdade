function mostrarTabuada() {
    var input = prompt("Digite um número para ver a tabuada:");
    
    if (input !== null && !isNaN(input)) {
        var numero = parseInt(input);
        var tabuada = "";

        for (var i = 1; i <= 10; i++) {
            tabuada += numero + " x " + i + " = " + (numero * i) + "\n";
        }

        alert("Tabuada de " + numero + ":\n" + tabuada);
    } else {
        alert("Por favor, digite um número válido.");
    }
}
