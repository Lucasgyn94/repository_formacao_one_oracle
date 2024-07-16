package br.com.alura.screenmatch.model;


import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme() {

    }
    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    // getter
    public String getDiretor() {
        return diretor;
    }

    // setter

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }


    @Override
    public int getClassificacao() {
        return (int) this.pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " - (" + this.getAnoDeLancamento() + ")";
    }
}
