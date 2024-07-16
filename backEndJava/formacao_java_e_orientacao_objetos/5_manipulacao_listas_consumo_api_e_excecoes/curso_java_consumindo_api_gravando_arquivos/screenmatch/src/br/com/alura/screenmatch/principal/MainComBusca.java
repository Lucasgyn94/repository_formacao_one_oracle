package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.model.Titulo;
import br.com.alura.screenmatch.service.TituloService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        TituloService tituloService = new TituloService();
        List<Titulo> titulos = new ArrayList<>();
        String filme = "";

        while (!filme.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para busca ou (sair) para encerrar o programa!?");
            filme = leitura.nextLine();

            if (filme.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                Titulo meuTitulo = tituloService.buscarTitulo(filme);
                System.out.println("Título já convertido:");
                System.out.println(meuTitulo);
                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço: ");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nFilmes buscados:");
        for (Titulo titulo : titulos) {
            System.out.println(titulo);
        }

        tituloService.salvarTitulos(titulos);

        System.out.println("O programa finalizou corretamente!");
        leitura.close();
    }
}
