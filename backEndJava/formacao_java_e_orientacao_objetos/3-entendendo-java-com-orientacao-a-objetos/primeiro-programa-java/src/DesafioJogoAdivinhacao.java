import java.util.Scanner;

public class DesafioJogoAdivinhacao {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        int numeroTentativas = 5;
        int chuteUsuario = 0;
        int numeroAleatorioSorteado = (int) Math.floor(Math.random() * 100 + 1);

        System.out.println("Numero sorteado: " + numeroAleatorioSorteado);
        System.out.println();

        while (numeroTentativas >= 0) {
            System.out.println("Adivinhe o numero sorteado: ");
            chuteUsuario = leitura.nextInt();

            if (numeroAleatorioSorteado > chuteUsuario) {
                System.out.println("Numero aleatorio e maior!");
            } else if (numeroAleatorioSorteado < chuteUsuario) {
                System.out.println("Numero aleatorio e menor!");
            } else if (numeroAleatorioSorteado == chuteUsuario) {
                System.out.println("Parabens, voce acertou!");
            }

            numeroTentativas--;

            System.out.println("Tentativas Restantes: " + numeroTentativas);

            if (numeroTentativas == 0) {
                System.out.println("Voce perdeu!");
            }

            System.out.println();
        }

        leitura.close();
    }

}

/*
Agora é com você! Pratique os conceitos que foram ensinados ao longo dessa aula com o seguinte desafio:

Crie um programa que simula um jogo de adivinhação, que deve gerar um número aleatório entre 0 e 100 e pedir para que o usuário tente adivinhar o número, em até 5 tentativas. A cada tentativa, o programa deve informar se o número digitado pelo usuário é maior ou menor do que o número gerado.

Dicas:

Para gerar um número aleatório em Java: new Random().nextInt(100);
Utilize o Scanner para obter os dados do usuário;
Utilize uma variável para contar as tentativas;
Utilize um loop para controlar as tentativas;
Utilize a instrução break; para interromper o loop.

* */
