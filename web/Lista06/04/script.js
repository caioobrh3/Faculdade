// Autor: Caio Ricado Lincolna Afonso
// Palavras-chave: web, 200022135
// Descrição: Atividades sobre JavaScript

function calculateIMC() {
    const weight = parseFloat(document.getElementById('weight').value);
    const height = parseFloat(document.getElementById('height').value);

    if (isNaN(weight) || isNaN(height) || weight <= 0 || height <= 0) {
        document.getElementById('result').textContent = 'Por favor, insira valores válidos para peso e altura.';
        return;
    }

    const imc = weight / (height * height);
    let resultText = '';

    if (imc < 16.9) {
        resultText = 'Muito abaixo do peso';
    } else if (imc >= 17 && imc <= 18.4) {
        resultText = 'Abaixo do peso';
    } else if (imc >= 18.5 && imc <= 24.9) {
        resultText = 'Peso normal';
    } else if (imc >= 25 && imc <= 29.9) {
        resultText = 'Acima do peso';
    } else {
        resultText = 'Obesidade';
    }

    document.getElementById('result').textContent = `Seu IMC é ${imc.toFixed(2)} - ${resultText}`;
}