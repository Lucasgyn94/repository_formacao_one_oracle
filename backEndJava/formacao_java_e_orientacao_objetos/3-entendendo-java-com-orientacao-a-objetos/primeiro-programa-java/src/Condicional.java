
public class Condicional {

    public static void main(String[] args) {

        int anoDeLancamento = 2022;
        boolean incluirNoPlano = true;
        double notaDoFilme = 8.1;
        String tipoPlano = "plus";

        if (anoDeLancamento >= 2022) {
        System.out.println("Lançamento que os clientes estao assistindo!");
        } else {
            System.out.println("Filme retro que vale a pena assistir!");
        }

        if (incluirNoPlano == true && tipoPlano.equals("plus")) {
            System.out.println("Filme liberado");
        } else {
            System.out.println("Deve pagar a locaçao");
        }
    }
}
