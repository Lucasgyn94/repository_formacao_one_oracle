package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Filme;
import br.com.alura.screenmatch.model.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Filme filme1 = new Filme();

        filme1.setNome("Poderoso chefao");
        filme1.setAnoDeLancamento(2004);
        filme1.setDuracaoEmMinutos(120);
        filme1.setIncluidoNoPlano(true);

        System.out.println(filme1.toString());

        filme1.avalia(5);
        filme1.avalia(5);
        System.out.println(filme1.pegaMedia());

        System.out.println("Total de avaliaçoes: " + filme1.getTotalDeAvaliacoes());

        Serie flash = new Serie();
        flash.setNome("Flash");
        flash.setAnoDeLancamento(2010);
        flash.exibeFichaTecnica();
        flash.setTemporada(10);
        flash.setEpisodiosPorTemporada(10);
        flash.setMinutosPorEpisodio(50);
        System.out.println("Duraçao para assistir flash: " + flash.getDuracaoEmMinutos());

        Filme filme2 = new Filme();

        filme2.setNome("Avatar");
        filme2.setAnoDeLancamento(2024);
        filme2.setDuracaoEmMinutos(200);
        filme2.setIncluidoNoPlano(true);

        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
        calculadoraDeTempo.inclui(filme1);
        calculadoraDeTempo.inclui(filme2);
        calculadoraDeTempo.inclui(flash);
        int tempoTotal = calculadoraDeTempo.getTempoTotal();
        System.out.println("Tempo total de filme: " + tempoTotal);

        FiltroRecomendacao filtroRecomendacao = new FiltroRecomendacao();
        filtroRecomendacao.filtra(filme1);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(flash);
        episodio.setTotalVisualizacoes(300);
        filtroRecomendacao.filtra(episodio);

        var filmeDoLucas = new Filme();
        filmeDoLucas.setDuracaoEmMinutos(200);
        filmeDoLucas.setNome("Dogville");
        filmeDoLucas.setAnoDeLancamento(2003);
        filmeDoLucas.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoLucas);
        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);

        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme da lista: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);

        System.out.println("ToString do filme: " + listaDeFilmes.get(0).getNome());

        var filmeDoTampinha = new Filme("Tampinha", 2005);
        System.out.println(filmeDoTampinha);

        System.out.println(flash);
    }
}