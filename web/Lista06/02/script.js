// Autor: Caio Ricado Lincolna Afonso
// Palavras-chave: web, 200022135
// Descrição: Atividades sobre JavaScript

function checkForm() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (username.trim() === '' || password.trim() === '') {
        document.getElementById('result').textContent = 'Por favor, preencha todos os campos.';
    } else {
        document.getElementById('result').textContent = 'Formulário preenchido com sucesso!';
    }
}