alert('### Jogo de Adivinhação ###');

let numero_aleatorio = 5;
let chute = parseInt(prompt('Digite o número: '));
console.log(numero_aleatorio);

if (chute === numero_aleatorio) {
    alert(`Parábens, você acertou! Número Sorteado = ${numero_aleatorio}`);
} else {
    alert(`Você errou! Número sorteado = ${numero_aleatorio}`);
}