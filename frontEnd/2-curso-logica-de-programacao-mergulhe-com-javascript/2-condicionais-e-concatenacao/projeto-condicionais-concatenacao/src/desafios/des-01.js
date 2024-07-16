//1. Pergunte ao usuário qual é o dia da semana. 
//Se a resposta for "Sábado" ou "Domingo", mostre "Bom fim de semana!". 
//Caso contrário, mostre "Boa semana!".
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let dia_semana = rl.question('Qual é o dia da semana? ', (dia_semana) => {
    if (dia_semana === 'sábado' || dia_semana === 'sabado' || dia_semana === 'domingo') {
        console.log('Bom final de semana!');
    } else {

        console.log('Boa semana!');
    }

    rl.close();
});