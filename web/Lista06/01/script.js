// Autor: Caio Ricado Lincolna Afonso
// Palavras-chave: web, 200022135
// Descrição: Atividades sobre JavaScript

function checkAge() {
    const age = parseInt(document.getElementById('age').value);
    let resultText = '';

    if (age >= 3 && age <= 10) {
        resultText = 'Faixa etária: 3 a 10 anos';
    } else if (age >= 11 && age <= 25) {
        resultText = 'Faixa etária: 11 a 25 anos';
    } else if (age >= 36 && age <= 55) {
        resultText = 'Faixa etária: 36 a 55 anos';
    } else if (age >= 56 && age <= 100) {
        resultText = 'Faixa etária: 56 a 100 anos';
    } else {
        resultText = 'Idade fora das faixas especificadas';
    }

    document.getElementById('result').textContent = resultText;
}
