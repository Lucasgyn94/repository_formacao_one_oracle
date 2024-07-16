import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        System.out.println("Esse e o Screen Match");

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do filme: ");
        String nomeDoFilme = entrada.nextLine();

        System.out.println("Digite o ano de lançamento do filme: ");
        int anoDeLancamento = entrada.nextInt();

        System.out.println("Deseja incluir no Plano? Digite true ou false");
        boolean incluirNoPlano = entrada.nextBoolean();

        System.out.println("Digite a nota do Filme: ");
        double notaDoFilme = entrada.nextDouble();


        System.out.println("Nome do filme: " + nomeDoFilme);
        System.out.println("Ano de lançamento do filme: " + anoDeLancamento);
        System.out.println("Incluir no plano: " + incluirNoPlano);
        System.out.println("Nota do filme: " + notaDoFilme);
        entrada.close();

        double media = (6.5 + 7.8 + 9.0) / 3;
        System.out.println(String.format("Média: %.2f", media));

        int classificacao = (int) (media / 2);
        System.out.println("Classificaçao: " + classificacao);


    }
}