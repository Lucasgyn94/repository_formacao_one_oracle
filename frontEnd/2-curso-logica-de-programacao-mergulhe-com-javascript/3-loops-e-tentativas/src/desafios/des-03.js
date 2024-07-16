// 3. Crie um programa de contagem regressiva. Peça um número e conte deste número até 0, usando um loop while no console do navegador.
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
let zero = 0;

const numero_usuario = rl.question('Digite o número: ', (numero) => {
    while(numero >= 0) {
        console.log(numero);
        numero--;
    }
    rl.close();
})

