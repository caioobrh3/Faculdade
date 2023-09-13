// Autor: Caio Ricado Lincolna Afonso
// Palavras-chave: web, 200022135
// Descrição: Atividades sobre JavaScript

function concatenateData() {
    const name = document.getElementById('name').value;
    const maritalStatus = document.getElementById('maritalStatus').value;
    const ageRange = document.getElementById('ageRange').value;

    const concatenatedData = `Nome: ${name}, Estado Civil: ${maritalStatus}, Faixa Etária: ${ageRange}`;

    document.getElementById('result').textContent = concatenatedData;
}