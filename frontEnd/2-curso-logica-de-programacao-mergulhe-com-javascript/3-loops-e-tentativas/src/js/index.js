alert('Bem vindo ao jogo de adivinhação!');

let numero_aleatorio = 5;
let chute = 0;
let tentativas = 0;

while(chute != numero_aleatorio) {
    let chute = prompt('Digite o número: ');
    if (parseInt(chute) === numero_aleatorio) {
        alert(`Parabéns, você acertou com ${tentativas} tentativas!`);
    } else {
        alert('Tente novamente!');
    }
    tentativas++;
}