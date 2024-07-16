/*Crie uma função que calcule o índice de massa corporal (IMC) de uma pessoa, 
a partir de sua altura, em metros, e peso, em quilogramas, 
que serão recebidos como parâmetro.

*/

function calcularIMC(altura, peso) {
    const IMC = peso / Math.pow(altura, 2);
    return IMC;
}

//console.log(calcularIMC(1.80, 90))

/*

Crie uma função que calcule o valor do fatorial de um número passado como parâmetro.

*/

function calcularFatorial(numero) {
    let fatorial = 1;
    for (let i = numero; i > 1; i--) {
        fatorial *= i;
    }
    return fatorial;
}

//console.log(calcularFatorial(2));

/*
Crie uma função que converte um valor em dólar, passado como parâmetro, 
e retorna o valor equivalente em reais. Para isso, 
considere a cotação do dólar igual a R$4,80.
*/

function converterDolarParaReal(valorDolar) {
    const cotacao = 4.80;
    let valorReal = valorDolar * cotacao;
    return valorReal;
}

//console.log(converterDolarParaReal(1));

/*
Crie uma função que mostre na tela a área e o perímetro de uma sala retangular, 
utilizando altura e largura que serão dadas como parâmetro.

*/

function calcularAreaEPerimetroSalaRetangular(altura, largura) {

    let area = altura * largura;
    let perimetro = 2 * (altura + largura);
    console.log(`
        Altura: ${altura} \n 
        Largura: ${largura} \n 
        Área: ${area} \n
        Perímetro: ${perimetro}
        `);
}

calcularAreaEPerimetroSalaRetangular(2, 3);

/*Crie uma função que mostre na tela a área e o perímetro de uma sala circular, 
utilizando seu raio que será fornecido como parâmetro. Considere Pi = 3,14.
*/

function calcularAreaEPerimetroSalaCircular(raio) {
    let area = Math.PI * Math.pow(raio, 2);
    let perimetro = 2 * Math.PI * raio;

    console.log(`
        Raio: ${raio} \n 
        Área: ${area} \n
        Perímetro: ${perimetro}
        `);
}

//calcularAreaEPerimetroSalaCircular(5);

/*
Crie uma função que mostre na tela a tabuada de um número dado como parâmetro.
*/

function tabuada(numero) {
    for (let i = 1; i <= 10; i++) {
        console.log(`${numero} x ${i} = ${numero * i}`);
    }
}

tabuada(2);