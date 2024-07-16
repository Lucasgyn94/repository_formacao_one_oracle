package br.com.alura.sreenmatch.model;

public class Serie extends Titulo{


    private int temporada;
    private int episodiosPorTemporada;
    private boolean serieAtiva;
    private int minutosPorEpisodio;

    // getters

    public int getTemporada() {
        return temporada;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public boolean isSerieAtiva() {
        return serieAtiva;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    // setters

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public void setSerieAtiva(boolean serieAtiva) {
        this.serieAtiva = serieAtiva;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return this.temporada * this.episodiosPorTemporada * this.minutosPorEpisodio;
    }

    
}
