import java.util.Scanner;

public class LoopWhile {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        double mediaAvaliacao = 0;
        double nota = 0;

        System.out.println("Quantos filmes voce deseja avaliar? ");
        int quantidadeDeFilmes = leitura.nextInt();

        int contador = 0;
        while (contador < quantidadeDeFilmes) {
            System.out.println(String.format("Digite a %dº nota: ", contador + 1));
            nota = leitura.nextDouble();

            mediaAvaliacao += nota;

            contador++;



        }

        System.out.println("Media: " + mediaAvaliacao / quantidadeDeFilmes);

        leitura.close();
    }

}
