// Altere o conteúdo da tag h1 com document.querySelector e atribua o seguinte texto: Hora do Desafio.
let titulo = document.querySelector("h1");
titulo.innerHTML = "Hora do Desafio";


// Crie uma função que exiba no console a mensagem O botão foi clicado sempre que o botão Console for pressionado.

function mensagemBotaoConsole() {
    let button = document.querySelector(".button:nth-of-type(1)");
    button.addEventListener("click", () => {
        console.log(`O botão ${button.textContent} foi clicado!`);
    });    
}

mensagemBotaoConsole();

//Crie uma função que exiba um alerta com a mensagem: Eu amo JS, sempre que o botão Alerta for pressionado.

function mensagemAlerta() {
    let button = document.querySelector(".button:nth-of-type(2)");
    alert(`Esse é uma alerta! Eu amo JS!`);
    
}

mensagemBotaoConsole();

// Crie uma função que é executada quando o botão prompt é clicado, perguntando o nome de uma cidade do Brasil. 
//Em seguida, exiba um alerta com a mensagem concatenando a resposta com o texto: Estive em {cidade} e lembrei de você.

function mensagemPrompt() {
    let nomeCidade = prompt("Digite o nome de uma cidade do Brasil: ");
    if (nomeCidade !== null && nomeCidade !== "") {
        alert(`Estive em ${nomeCidade} e lembrei de você.`);
    }
}


let buttonPrompt = document.querySelector(".button:nth-of-type(3)");

buttonPrompt.addEventListener('click', mensagemPrompt);

// Ao clicar no botão soma, peça 2 números e exiba o resultado da soma em um alerta.

function soma() {
    let num1 = parseInt(prompt("Digite o primeiro número: "));
    let num2 = parseInt(prompt("Digite o segundo número: "));

    const soma = num1 + num2;

    alert(`A soma de ${num1} + ${num2} = ${soma}`);
}

let buttonSoma = document.querySelector(".button:nth-of-type(4");
buttonSoma.addEventListener("click", soma);