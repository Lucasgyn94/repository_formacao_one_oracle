alert('Bem-Vindo ao jogo de Adivinhação!');

//let numero_aleatorio = 5;
let numero_aleatorio = Math.floor(Math.random() * 10 + 1);
let acertou = false;
let tentativas = 1;

alert(`Número sorteado = ${numero_aleatorio}`);


while(!acertou) {
    let chute = prompt('Digite o número: ');
    chute = parseInt(chute);

    if (chute === numero_aleatorio) {
        acertou = true;
        break;
    } else if (chute > numero_aleatorio) {
        alert('Número maior que o sorteado!');
    } else{
        alert('Número menor que o sorteado!');
    }
    tentativas++;
}

let palavraTentativa = tentativas > 1 ? "tentativas" : "tentativa";

alert(`Parabéns, você acertou com ${tentativas} ${palavraTentativa}`);