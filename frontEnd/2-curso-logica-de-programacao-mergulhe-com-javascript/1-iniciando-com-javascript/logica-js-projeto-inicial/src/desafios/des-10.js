//10. Agora, caso a idade seja maior ou igual que 18, exiba um alerta com a mensagem "Pode tirar a habilitação!".
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const idade = rl.question('Digite sua idade: ', (idade) => {
    let idadeConvertida = parseInt(idade);
    if (idadeConvertida >= 18) {
        console.log(`Idade = ${idadeConvertida}. Você pode tirar habilitação!`);
        
    } else {
        console.log(`Idade = ${idadeConvertida}. Você não pode tirar habilitação!`);
    }
    rl.close();
});

