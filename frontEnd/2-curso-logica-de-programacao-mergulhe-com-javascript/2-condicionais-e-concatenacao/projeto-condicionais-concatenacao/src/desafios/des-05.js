// 5. Peça ao usuário para inserir seu nome usando prompt. Em seguida, mostre um alerta de boas-vindas usando esse nome.
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let nome_usuario = rl.question('Digite seu nome: ', (nome) => {
    console.log(`Olá ${nome}`);
})