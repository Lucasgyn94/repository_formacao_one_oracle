package br.com.alura.sreenmatch.model;

import br.com.alura.sreenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

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
}
