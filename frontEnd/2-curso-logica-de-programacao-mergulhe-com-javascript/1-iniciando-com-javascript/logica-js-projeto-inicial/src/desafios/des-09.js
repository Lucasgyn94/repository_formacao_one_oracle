//9. Peça ao usuário para digitar sua idade usando um prompt e armazene-a na variável idade.
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let idade = rl.question('Digite sua idade: ', (idade) => {
    console.log(idade);
});