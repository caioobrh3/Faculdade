
const opcoesEntrada = [
    { nome: "coxinha de frango", imagem: "https://cdn0.tudoreceitas.com/pt/posts/1/9/1/coxinha_simples_191_orig.jpg" },
    { nome: "porção de pastel", imagem: "https://media-cdn.tripadvisor.com/media/photo-s/0e/da/e5/b5/porcao-de-pastel-com.jpg" },
    { nome: "Bolinho de Bacalhau", imagem: "https://anamariabraga.globo.com/wp-content/uploads/2017/11/bolinhodebacalhaudorei-29321.jpg" }
];

const opcoesPratoPrincipal = [
    { nome: "feijoada completa", imagem: "https://acarnequeomundoprefere.com.br/uploads/media/image/frimesa-receitas-eisbein-1.jpg" },
    { nome: "Moqueca de Peixe", imagem: "https://receitasrapidas.org/wp-content/webp-express/webp-images/uploads/2023/03/moqueca-de-peixe-com-os-acompanhamentos-perfeitos.jpg.webp" },
    { nome: "Carne de Sol com Aipim", imagem: "https://cdn0.tudoreceitas.com/pt/posts/4/3/7/carne_de_sol_acebolada_9734_orig.jpg" },
    { nome: "Baião de Dois", imagem: "https://i.ytimg.com/vi/yCh8VoQiYm8/maxresdefault.jpg" },
    { nome: "Bobó de Camarão", imagem: "https://receitasrapidas.org/wp-content/uploads/2023/03/Bobo-de-camarao-1.jpg" }
];

const opcoesSobremesa = [
    { nome: "Brigadeiro", imagem: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQp3XyH6XvFtermyFC2Gj7ecf2o1g0eXpPX1w&usqp=CAU" },
    { nome: "Pudim de Leite Condensado", imagem: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgFv3l31oEDUSs7uY41K62J8pYx6SA8yua4w&usqp=CAU" },
    { nome: "Cocada", imagem: "https://static.itdg.com.br/images/auto-auto/74fba6242a9e5774c6de951c8468d4d4/dicas-para-a-cocada-perfeita.jpg" }
];

//Seções 
const entradaSection = document.getElementById("entrada");
const pratoPrincipalSection = document.getElementById("prato-principal");
const sobremesaSection = document.getElementById("sobremesa");
const menuFinalSection = document.getElementById("menu-final");

//criar opções de escolha
function criarOpcoes(opcoes, section) {
    opcoes.forEach(opcao => {
        const opcaoElement = document.createElement("div");
        opcaoElement.classList.add("opcao");

        const imagemElement = document.createElement("img");
        imagemElement.src = opcao.imagem;
        imagemElement.alt = opcao.nome;

        const nomeElement = document.createElement("p");
        nomeElement.textContent = opcao.nome;

        opcaoElement.appendChild(imagemElement);
        opcaoElement.appendChild(nomeElement);
        
        opcaoElement.addEventListener("click", () => escolherPrato(opcao, section));
        section.appendChild(opcaoElement);
    });
}

//escolher um prato
function escolherPrato(prato, section) {
    const pratoEscolhidoElement = document.createElement("div");
    pratoEscolhidoElement.classList.add("prato-escolhido");

    const imagemElement = document.createElement("img");
    imagemElement.src = prato.imagem;
    imagemElement.alt = prato.nome;

    const nomeElement = document.createElement("p");
    nomeElement.textContent = prato.nome;

    pratoEscolhidoElement.appendChild(imagemElement);
    pratoEscolhidoElement.appendChild(nomeElement);

    menuFinalSection.appendChild(pratoEscolhidoElement);
    section.style.display = "none";
}

const resetButton = document.getElementById("reset-btn");

function reiniciarSelecoes() {
    entradaSection.style.display = "block";
    pratoPrincipalSection.style.display = "block";
    sobremesaSection.style.display = "block";
    menuFinalSection.innerHTML = "";
}

resetButton.addEventListener("click", reiniciarSelecoes);

criarOpcoes(opcoesEntrada, entradaSection);
criarOpcoes(opcoesPratoPrincipal, pratoPrincipalSection);
criarOpcoes(opcoesSobremesa, sobremesaSection);