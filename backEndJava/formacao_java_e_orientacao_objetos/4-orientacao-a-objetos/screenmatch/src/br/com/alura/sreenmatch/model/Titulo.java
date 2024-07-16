package br.com.alura.sreenmatch.model;

public class Titulo {
    protected String nome;
    protected int anoDeLancamento;
    protected boolean incluidoNoPlano;
    protected double somaDasAvaliacoes;
    protected int totalDeAvaliacoes;
    protected int duracaoEmMinutos;


    // getters
    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {

        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {

        return incluidoNoPlano;
    }

    public int getTotalDeAvaliacoes() {

        return totalDeAvaliacoes;
    }

    public double getSomaDasAvaliacoes() {

        return somaDasAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    // setters


    public void setNome(String nome) {

        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {

        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {

        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setSomaDasAvaliacoes(double somaDasAvaliacoes) {

        this.somaDasAvaliacoes = somaDasAvaliacoes;
    }

    public void setTotalDeAvaliacoes(int totalDeAvaliacoes) {

        this.totalDeAvaliacoes = totalDeAvaliacoes;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    // outros metodos
    public void exibeFichaTecnica() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Ano de lançamento; " + this.anoDeLancamento);
    }

    public void avalia(double nota) {
        this.somaDasAvaliacoes += nota;
        this.totalDeAvaliacoes++;
    }
    public double pegaMedia() {

        return this.somaDasAvaliacoes / this.totalDeAvaliacoes;
    }

}
