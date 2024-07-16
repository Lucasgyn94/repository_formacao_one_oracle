// 8. Use um prompt para perguntar o nome do usuário e armazená-lo na variável nome.


const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Digite seu nome: ', (nomeUsuario) => {
    console.log(`Você digitou ${nomeUsuario}`)
});