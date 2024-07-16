package br.com.alura.my_musics.models;

public class Musica extends Audio{
    private String album;
    private String cantor;
    private String genero;

    // getters

    public String getAlbum() {
        return album;
    }

    public String getCantor() {
        return cantor;
    }

    public String getGenero() {
        return genero;
    }

    // setters

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public double getClassificacao() {
        if (this.getTotalReproducoes() > 200) {
            return 10;
        } else {
            return 7;
        }
    }
}
