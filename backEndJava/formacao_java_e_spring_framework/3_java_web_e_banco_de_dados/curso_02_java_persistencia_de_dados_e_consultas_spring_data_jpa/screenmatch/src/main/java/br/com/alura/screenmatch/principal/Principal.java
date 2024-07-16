package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.*;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6e596daa";

    private List<DadosSerie> dadosSeries = new ArrayList<>();
    private final SerieRepository repositorio;
    private List<Serie> series = new ArrayList<>();

    Optional<Serie> serieBusca;

    public Principal(SerieRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcaoUsuario = -1;

        while (opcaoUsuario != 0) {
            var menu = """
                    [1]-\t Buscar Series
                    [2]-\t Buscar Episodios
                    [3]-\t Listar Series Buscadas
                    [4]-\t Buscar Series por Titulo
                    [5]-\t Buscar Series por Ator
                    [6]-\t Top 5 Series
                    [7]-\t Buscar Series por Catetoria
                    [8]-\t Filtrar Series
                    [9]-\t Buscar Episodio Por Trecho
                    [10]-\t Top 5 episodios da Serie
                    [11]-\t Buscar episodios a partir de uma data
                    [11]-\t Limpar Series Buscadas
                    [0]-\t Sair
                    """.stripIndent();

            System.out.println(menu);
            opcaoUsuario = leitura.nextInt();
            leitura.nextLine();

            switch (opcaoUsuario) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    BuscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarSeriePorAtor();
                    break;
                case 6:
                    buscarTop5Series();
                    break;
                case 7:
                    buscarSeriesPorCategoria();
                    break;
                case 8:
                    filtrarSeriesPorTemporadaEAvaliacao();
                    break;
                case 9:
                    buscarEpisodioPorTrecho();
                    break;
                case 10:
                    topEpisodiosPorSerie();
                    break;
                case 11:
                    BuscarEpisodioDepoisDeUmaData();
                    break;
                case 12:
                    limparBusca();
                    break;

                case 0:
                    System.out.println("Saindo..");
                    break;
                default:
                    System.out.println("Opçao invalida!");
            }
        }
    }



    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        Serie serie = new Serie(dados);

        repositorio.save(serie);
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da serie para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        return conversor.obterDados(json, DadosSerie.class);
    }

    private void BuscarEpisodioPorSerie() {
        listarSeriesBuscadas();
        System.out.println("Escolha uma serie pelo nome: ");
        var nomeSerie = leitura.nextLine();

        Optional<Serie> serie = repositorio.findByTituloContainingIgnoreCase(nomeSerie);
        /*
        Optional<Serie>  serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nomeSerie.toLowerCase()))
                .findFirst();
        */
        if(serie.isPresent()) {
            var serieEncontrada = serie.get();
            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumoApi.obterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numeroTemporada(), e)))
                    .collect(Collectors.toList());

            serieEncontrada.setEpisodios(episodios);
            repositorio.save(serieEncontrada);

        } else {
            System.out.println("Serie nao encontrada!");
        }


    }

    private void listarSeriesBuscadas() {
        series = repositorio.findAll();
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);


    }

    private void limparBusca() {
        repositorio.deleteAll();
        System.out.println("Séries buscadas removidas do banco de dados.");

    }

    private void buscarSeriePorTitulo() {
        System.out.println("Escolha um trecho ou nome da serie: ");
        var nomeSerie = leitura.nextLine();

        serieBusca = repositorio.findByTituloContainingIgnoreCase(nomeSerie);

        if (serieBusca.isPresent()) {
            System.out.println("\nDados da busca: " + serieBusca.get());
        } else {
            System.out.println("Serie nao encontrada!");
        }
    }

    private void buscarSeriePorAtor() {
        System.out.println("Digite o nome do autor para busca: ");
        var nomeAutor = leitura.nextLine();
        System.out.println("Avaliaçoes a partir de que valor");
        var avaliacao = leitura.nextDouble();

        List<Serie> seriesEncontradas = repositorio.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAutor, avaliacao);

        System.out.println("Series em que o autor " + nomeAutor + " trabalhou ");
        seriesEncontradas.forEach(s ->
                System.out.println(s.getTitulo() + " - Avaliaçao: " + s.getAvaliacao()));
    }

    private void buscarTop5Series() {
        List<Serie> serieTop = repositorio.findTop5ByOrderByAvaliacaoDesc();
        serieTop.forEach(s ->
                System.out.println(s.getTitulo() + " - Avaliaçao: " + s.getAvaliacao()));
    }

    private void buscarSeriesPorCategoria() {
        System.out.println("Deseja buscar séries de que categoria/gênero? ");
        var nomeGenero = leitura.nextLine();

        try {
            Categoria categoria = Categoria.fromPortugues(nomeGenero);
            List<Serie> seriesEncontradas = repositorio.findByGenero(categoria);

            if (seriesEncontradas.isEmpty()) {
                System.out.println("Nenhuma serie encontrada para a categoria " + nomeGenero);
            } else {
                System.out.println("Series encontradas para a categoria " + nomeGenero + ":");
                seriesEncontradas.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }




    }

    private void buscarSeriesPorCategoria1() {
        System.out.println("Deseja buscar séries de que categoria/gênero? ");
        var nomeGenero = leitura.nextLine();

        try {
            Categoria categoria = Categoria.fromPortugues(nomeGenero); // Usa o novo método fromPortugues
            List<Serie> seriesEncontradas = repositorio.findByGenero(categoria);

            if (seriesEncontradas.isEmpty()) {
                System.out.println("Nenhuma série encontrada para a categoria: " + nomeGenero);
            } else {
                System.out.println("Séries encontradas para a categoria " + nomeGenero + ":");
                seriesEncontradas.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Trata o caso de categoria não encontrada
        }
    }

    private void filtrarSeriesPorTemporadaEAvaliacao() {
        System.out.println("Deseja filtrar series de ate quantas temporadas? ");
        var totalTemporadas = leitura.nextInt();
        leitura.nextLine();

        System.out.println("Com avaliaçao a partir de qual valor?");
        var avaliacao = leitura.nextDouble();
        leitura.nextLine();

        List<Serie> filtroSeries = repositorio.seriesPorTemporadaEAvaliacao(totalTemporadas, avaliacao);

        System.out.println("\n### Series filtradas ###");
        filtroSeries.forEach(s ->
                System.out.println(s.getTitulo() + " - Avaliaçao: " + s.getAvaliacao()));

        System.out.println();


    }

    private void buscarEpisodioPorTrecho() {
        System.out.println("Digite um trecho do episodio para a busca: ");
        var trechoEpisodio = leitura.nextLine();

        List<Episodio> episodiosEncontrados = repositorio.episodioPorTrecho(trechoEpisodio);
        episodiosEncontrados.forEach(e ->
                        System.out.printf("Serie: %s - Temporada %s - Episodio %s- %s\n", e.getSerie().getTitulo(), e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()));
    }

    private void topEpisodiosPorSerie() {
        buscarSeriePorTitulo();
        if (serieBusca.isPresent()) {
            Serie serie = serieBusca.get();
            List<Episodio> topEpisodios = repositorio.topEpisodiosPorSerie(serie);
            topEpisodios.forEach(e ->
                    System.out.printf("Serie: %s - Temporada %s - Episodio %s - %s - Avaliacao %s\n",
                            e.getSerie().getTitulo(), e.getTemporada(),
                            e.getNumeroEpisodio(), e.getTitulo(), e.getAvaliacao()));
        }
    }

    private void BuscarEpisodioDepoisDeUmaData() {
        buscarSeriePorTitulo();
        if (serieBusca.isPresent()) {
            Serie serie = serieBusca.get();
            System.out.println("Digite o ano limite de lancamento: ");
            var anoLimiteLancamento = leitura.nextInt();
            leitura.nextLine();

            List<Episodio> episodiosAno = repositorio.episodiosPorSerieEAno(serie, anoLimiteLancamento);
            episodiosAno.forEach(System.out::println);
        }
    }


}
