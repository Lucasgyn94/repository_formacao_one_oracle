package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.Filme;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.model.Titulo;

import java.util.*;

public class MainComListas {

    public static void main(String[] args) {
        Filme filme1 = new Filme("O poderoso chefao", 2004);
        Filme filme2 = new Filme("Avatar", 2023);
        var filmeDoLucas = new Filme("Matrix", 2004);

        Serie flash = new Serie("Flash", 2015);

        filme1.avalia(9);
        filme2.avalia(6);
        filmeDoLucas.avalia(10);

        ArrayList<Titulo> lista = new ArrayList<Titulo>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filmeDoLucas);
        lista.add(flash);
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificaçao: " + filme.getClassificacao());
            }
        }

        // ordenando
        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Lucas Ferreira");
        buscaPorArtista.add("Jaqueline");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenaçao");
        System.out.println(buscaPorArtista);

        System.out.println("Lista de titulos ordenada");
        Collections.sort(lista);
        System.out.println(lista);

        System.out.println("Lista apos ordenaçao por ano:");
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);

        System.out.println("Lista com list: ");
        List<Titulo> lista_com_list = new LinkedList<>();
        lista_com_list.add(filme1);
        lista_com_list.add(filme2);
        lista_com_list.add(filmeDoLucas);
        lista_com_list.add(flash);
        for (Titulo item: lista_com_list) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificaçao: " + filme.getClassificacao());
            }
        }

    }
}
