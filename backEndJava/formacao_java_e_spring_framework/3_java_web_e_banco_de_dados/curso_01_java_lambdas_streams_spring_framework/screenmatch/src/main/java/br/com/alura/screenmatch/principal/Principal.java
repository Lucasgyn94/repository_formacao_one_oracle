package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6e596daa";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private String nomeSerie = "";

    public void exibeMenu() {
        try {
            System.out.println("Digite o nome da série para ver as informações: ");
            nomeSerie = leitura.nextLine();
            String nomeSerieCodificado = URLEncoder.encode(nomeSerie, StandardCharsets.UTF_8.toString());
            String url = ENDERECO + nomeSerieCodificado + API_KEY;
            var json = consumoApi.obterDados(url);

            // Adicione este trecho para ver o retorno da API
            System.out.println("Resposta da API OMDb: ");
            System.out.println(json);

            DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
            System.out.println(dados);

            if (dados.totalTempordas() == null) {
                System.out.println("O número de temporadas não está disponível.");
                return;
            }

            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= dados.totalTempordas(); i++) {
                nomeSerieCodificado = URLEncoder.encode(nomeSerie, StandardCharsets.UTF_8.toString());
                url = ENDERECO + nomeSerieCodificado + "&Season=" + i + API_KEY;
                json = consumoApi.obterDados(url);

                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);

                // Filtrar episódios com número de episódio igual a 0
                List<DadosEpisodio> episodiosFiltrados = dadosTemporada.episodios().stream()
                        .filter(e -> e.numeroEpisodio() != 0)
                        .collect(Collectors.toList());

                DadosTemporada dadosTemporadaFiltrada = new DadosTemporada(dadosTemporada.numeroTemporada(), episodiosFiltrados);
                temporadas.add(dadosTemporadaFiltrada);
            }

            temporadas.forEach(System.out::println);

            temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

            List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                    .flatMap(t -> t.episodios().stream())
                    .collect(Collectors.toList());

            System.out.println("\nTop 10 episodios: ");
            dadosEpisodios.stream()
                    .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                    .peek(e -> System.out.println("Primeiro Filtro (N/A): " + e))
                    .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                    .peek(e -> System.out.println("\nOrdenaçao: " + e))
                    .limit(10)
                    .peek(e -> System.out.println("\nLimite:  " + e))
                    .map(e -> e.titulo().toUpperCase())
                    .peek(e -> System.out.println("\nMapeamento: " + e))
                    .forEach(System.out::println);

            System.out.println();

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(t -> t.episodios().stream()
                            .map(d -> new Episodio(t.numeroTemporada(), d)))
                    .collect(Collectors.toList());

            episodios.forEach(System.out::println);

            System.out.println();

            System.out.println("Digite um trecho do titulo do episodio: ");
            var trechoTitulo = leitura.nextLine();

            Optional<Episodio> episodioBuscado = episodios.stream()
                    .filter(e -> e.getTitulo().toLowerCase().contains(trechoTitulo.toLowerCase()))
                    .findFirst();

            if (episodioBuscado.isPresent()) {
                System.out.println("Episodio encontrado!");
                System.out.println("Temporada: " + episodioBuscado.get().getTemporada());
                System.out.println("Episodio: " + episodioBuscado.get().getNumeroEpisodio());
            } else {
                System.out.println("Episodio nao encontrado!");
            }

            System.out.println("A partir de que ano voce desejar ver os epis´ødios? ");
            var ano = leitura.nextInt();
            leitura.nextLine();

            LocalDate dataBusca = LocalDate.of(ano, 1, 1);
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            episodios.stream()
                    .filter(e -> e.getDataLancamento() != null
                            && e.getDataLancamento().isAfter(dataBusca))
                    .forEach(e -> System.out.println(
                            "Temporada: " + e.getTemporada() +
                                    "\tEpisodio: " + e.getTitulo() +
                                    "\tData de Lancamento: " + e.getDataLancamento().format(df)
                    ));

            /*Pegando avaliaçoes por temporada*/
            Map<Integer, Double> avaliacoesPorTemporada = episodios.stream()
                    .filter(e -> e.getAvaliacao() > 0.0)
                    .collect(Collectors.groupingBy(Episodio::getTemporada,
                            Collectors.averagingDouble(Episodio::getAvaliacao)));
            System.out.println("\nAvaliaçoes por temporada");
            System.out.println(avaliacoesPorTemporada);

            /*Coletando estatisticas*/
            DoubleSummaryStatistics estatistica = episodios.stream()
                    .filter(e -> e.getAvaliacao() > 0)
                    .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));

            System.out.println(estatistica);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao obter as informações da série: " + e.getMessage());
        } finally {
            leitura.close();
        }
    }
}
