/*
8. Crie uma variável "numero" e peça um valor com prompt verifique se é positivo, negativo ou zero. 
Use if-else para imprimir a respectiva mensagem.

*/

let numero = prompt("Digite um número: ");

if (numero > 0) {
    console.log(`O número ${numero} é positivo!`);
} else if (numero < 0) {
    console.log(`O número ${numero} é negativo!`);
} else {
    console.log(`O número ${numero} é zero!`);
}