import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite seu filme favorito: ");
        String filmeFavorito = leitura.nextLine();

        System.out.println("Digite o ano de lançamento do filme: ");
        int anoDeLancamento = leitura.nextInt();

        System.out.println("Digite a avaliaçao para o filme: ");
        double avaliacaoFilme = leitura.nextDouble();

        System.out.println(filmeFavorito);
        System.out.println(anoDeLancamento);
        System.out.println(avaliacaoFilme);


        leitura.close();
    }
}
