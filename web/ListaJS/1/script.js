// Variáveis
var a = 10;
var b = 5;
var c = 1;
var d;

// a) Operações
c = b--;
b = a++;
a = 5 + "1";
d = "1" + "1";

// Atualizar o conteúdo HTML com os valores das variáveis
document.getElementById("valorA").textContent = a;
document.getElementById("valorB").textContent = b;
document.getElementById("valorC").textContent = c;
document.getElementById("valorD").textContent = d;

// b) Informações sobre o autor
var autor = "Caio Ricardo Lincoln Afonso";
var palavraChave = "JavaScript";
var descricao = "Atividades sobre JavaScript";

// c) Título da página
var tituloPagina = "JavaScript";
