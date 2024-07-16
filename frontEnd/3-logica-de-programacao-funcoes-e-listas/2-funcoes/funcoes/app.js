const numeroSecreto = sortearNumeroAleatorio();
const chuteUsuario = verificaChuteUsuario();

function exibirTextoNaTela(tag, texto) {
    if (tag !== null && texto !== null) {
        let titulo = document.querySelector(tag);
        titulo.innerHTML = texto;
    } else {
        console.log("Tag ou texto não informado!");
    }
}

exibirTextoNaTela("h1", "Jogo do Número Secreto");
exibirTextoNaTela("p", "Escolha um número entre 1 e 10");


function verificarChute() {
    let chute = document.querySelector("input").value;
    
    console.log(`Número secreto: ${numeroSecreto}`);
    if (parseInt(chute) === parseInt(numeroSecreto)) {
        alert("Parabéns, você acertou!");
    } else if (parseInt(chute) > parseInt(numeroSecreto)) {
        alert("Número maior!");
    } else if (parseInt(chute) <= parseInt(numeroSecreto)) {
        alert("Número é menor!");
    }
    
    console.log(numeroSecreto == chute);
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

