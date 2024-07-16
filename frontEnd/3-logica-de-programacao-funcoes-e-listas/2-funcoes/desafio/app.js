//1. Criar uma função que exibe "Olá, mundo!" no console.

function mensagemOlaMundo () {
    console.log("Olá mundo!");
}

// 2. Criar uma função que recebe um nome como parâmetro e exibe "Olá, [nome]!" no console.
function recebeNome(nome) {
    console.log(`Olá ${nome}`);
}

//3. Criar uma função que recebe um número como parâmetro e retorna o dobro desse número.
function dobraNumero(numero) {
    return numero * 2;

}

//4. Criar uma função que recebe três números como parâmetros e retorna a média deles;

function calculaMedia(n1, n2, n3) {
    let soma = n1 + n2 + n3;
    let media = soma / 3;
    return media;
}

//console.log(`Média = ${calculaMedia(7,7,7)}`);

//5. Criar uma função que recebe dois números como parâmetros e retorna o maior deles.
function retornaMaiorNumero(n1, n2) {
    return n1 > n2 ? `Maior número: ${n1}`: `Maior número: ${n2}`;
}

//console.log(retornaMaiorNumero(20, 10));

//6. Criar uma função que recebe um número como parâmetro e 
// retorna o resultado da multiplicação desse número por ele mesmo.

function retornaMultiplicacao(n1) {
    let multiplicacao = n1 * n1;
    return multiplicacao;
}

console.log(retornaMultiplicacao(10));