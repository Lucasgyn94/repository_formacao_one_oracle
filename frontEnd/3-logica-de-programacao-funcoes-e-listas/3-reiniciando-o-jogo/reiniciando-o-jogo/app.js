let numeroSecreto = sortearNumeroAleatorio();
let chuteUsuario = verificaChuteUsuario();
let tentativas = 1;

console.log(numeroSecreto);
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

function sortearNumeroAleatorio() {
    let numeroSecredo = parseInt(Math.floor(Math.random() * 10 + 1));
    return numeroSecredo;
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
    numeroSecreto = sortearNumeroAleatorio();
    limparCampo();
    tentativas = 1;
    exibirMensagem()
    desabilitarBotaoNovoJogo();
}