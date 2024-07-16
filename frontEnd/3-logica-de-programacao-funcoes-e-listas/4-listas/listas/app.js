let listaDeNumerosSorteados = [];
let limiteNumeros = 3;

let numeroSecreto = gerarNumeroAleatorio();
let chuteUsuario = verificaChuteUsuario();
let tentativas = 1;


console.log(`Númro secreto: ${numeroSecreto}`);

function exibirTextoNaTela(tag, texto) {
    if (tag !== null && texto !== null) {
        let titulo = document.querySelector(tag);
        titulo.innerHTML = texto;
    } else {
        console.log("Tag ou texto não informado!");
    }
}

function exibirMensagem() {
    exibirTextoNaTela("h1", "Jogo do Número Secreto");
    exibirTextoNaTela("p", "Escolha um número entre 1 e 10");
}

exibirMensagem();

function verificarChute() {
    let chute = document.querySelector("input").value;
    let palavraTentativa = tentativas > 1 ? "tentativas" : "tentativa";
    let mensagemTentativas = `Parabéns, você acertou o número secreto em ${tentativas} ${palavraTentativa}!`;
    if (chute == numeroSecreto) {
        exibirTextoNaTela("h1", "Acertou!");
        exibirTextoNaTela("p", mensagemTentativas);
        habilitarBotaoNovoJogo();
    } else if (chute > numeroSecreto) {
        exibirTextoNaTela("p", "O número secreto é menor!" );

    } else if (chute < numeroSecreto) {
        exibirTextoNaTela("p", "O número secreto é maior!");

    }
    //tentativas = tentativas + 1;
    tentativas++;
    limparCampo();
}

function habilitarBotaoNovoJogo() {
    let campo = document.getElementById("reiniciar");
    campo.removeAttribute("disabled");
}


function desabilitarBotaoNovoJogo() {
    let campo = document.getElementById("reiniciar");
    campo.setAttribute("disabled", true);
}

function verificaChuteUsuario() {
    let valorInput = document.querySelector(".container__input");
    let chuteUsuario = parseInt(valorInput.textContent);
    return chuteUsuario;
}

function limparCampo() {
    chute = document.querySelector("input");
    chute.value = '';
}

function reiniciarJogo() {
    numeroSecreto = gerarNumeroAleatorio();
    limparCampo();
    tentativas = 1;
    exibirMensagem()
    desabilitarBotaoNovoJogo();
}

function gerarNumeroAleatorio() {
    let numeroEscolhildo = parseInt(Math.floor(Math.random() * limiteNumeros + 1));
    let qtdDeElementosNaLista = listaDeNumerosSorteados.length;
    
    if (qtdDeElementosNaLista == limiteNumeros) {
        listaDeNumerosSorteados = [];
    }

    if (listaDeNumerosSorteados.includes(numeroEscolhildo)) {
        return gerarNumeroAleatorio();
    } else {
        listaDeNumerosSorteados.push(numeroEscolhildo);
        console.log(listaDeNumerosSorteados);
        return numeroEscolhildo;
    }
}