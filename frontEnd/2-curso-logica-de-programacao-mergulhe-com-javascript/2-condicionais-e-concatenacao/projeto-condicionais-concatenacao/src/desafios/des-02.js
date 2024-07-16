//2. Verifique se um número digitado pelo usuário é positivo ou negativo. Mostre um alerta informando.
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let numero_usuario = rl.question('Digite o número para saber se positivo ou negativo: ', (numero_usuario) => {
    if (numero_usuario >= 0) {
        console.log('O número é positivo!');
    } else {
        console.log('O número é negativo!');
    }
    rl.close();
});