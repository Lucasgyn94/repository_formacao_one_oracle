import br.com.alura.sreenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.sreenmatch.calculos.FiltroRecomendacao;
import br.com.alura.sreenmatch.model.Episodio;
import br.com.alura.sreenmatch.model.Filme;
import br.com.alura.sreenmatch.model.Serie;

public class Main {
    public static void main(String[] args) {

        //Filmes filme1 = new Filmes("Matrix", true, 2004, 5.0, 0, 120);
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
    }
}