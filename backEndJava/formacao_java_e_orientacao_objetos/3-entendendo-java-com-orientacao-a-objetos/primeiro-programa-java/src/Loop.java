import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Quantas notas voce deseja cadastrar? ");
        int quantidadeDeNotas = leitura.nextInt();

        double[] arrayNotas = new double[quantidadeDeNotas];

        for (int i = 0; i < quantidadeDeNotas; i++) {
            System.out.println(String.format("Digite a %dº nota: ", i + 1));
            double nota = leitura.nextDouble();

            arrayNotas[i] = nota;

        }

        System.out.println("Notas cadastradas com sucesso!");

        double soma = 0.0;
        double media = 0.0;

        for (double nota : arrayNotas) {
            System.out.println(nota);
            soma += nota;
        }

        media = soma / quantidadeDeNotas;
        System.out.println("Media " + media);
        leitura.close();
    }
}
