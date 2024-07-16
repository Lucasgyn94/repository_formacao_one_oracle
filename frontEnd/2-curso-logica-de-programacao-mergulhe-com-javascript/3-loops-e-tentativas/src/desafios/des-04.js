// 4. Crie um programa de contagem progressiva. Peça um número e conte de 0 até esse número, usando um loop while no console do navegador.
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let contador = 0;
const numero_usuario = rl.question('Digite um número: ', (numero) => {
    while(numero >= contador) {
        console.log(contador);
        contador++;
    }
    rl.close();
});