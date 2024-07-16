alert('Boas Vindas ao jogo do número secreto!');

let numeroSecreto = 5;

function armazenarChute() {
    let chute = prompt('Escolha um número entre 1 e 10');

    if (numeroSecreto == chute) {
        alert('Isso aí, você acertou!');
        
    } else if (numeroSecreto <= chute) {
        alert('Número secreto menor que sorteado!');
        armazenarChute();
    } else {
        alert('Número maior que sorteado!');
        armazenarChute();
    }
}

armazenarChute();

