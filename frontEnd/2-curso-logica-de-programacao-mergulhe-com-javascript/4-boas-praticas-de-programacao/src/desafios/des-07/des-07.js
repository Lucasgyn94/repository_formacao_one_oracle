/*
7. Peça ao usuário para inserir sua idade com prompt. Com base na idade inserida, 
utilize um if para verificar se a pessoa é maior ou menor de idade, exibindo uma mensagem apropriada no console.

*/

let idade = prompt("Digite a sua idade: ");

if (idade >= 18) {
    console.log(`Você possui ${idade}. Maior de idade!`);
} else {
    console.log(`Você possui ${idade}. Menor de idade!`);
}