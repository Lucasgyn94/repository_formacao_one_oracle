/*
3. Crie um sistema de pontuação para um jogo. 
Se a pontuação for maior ou igual a 100, mostre "Parabéns, você venceu!". Caso contrário, mostre "Tente novamente para ganhar.".
*/

const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let quantidade_pontos = rl.question('Digite a quantidade de pontos: ', (quantidade_pontos) => {
    if (quantidade_pontos >= 100) {
        console.log('Parabéns, você venceu!');
    } else {
        console.log('Tente novamente para ganhar!');
    }
    rl.close();
})