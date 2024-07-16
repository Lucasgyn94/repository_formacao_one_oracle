package model;

public class Transferencia {
    private String nomeDoDestinatario;
    private double valorDeTransferencia;

    public Transferencia(String nomeDoDestinatario, double valorDeTransferencia) {
        this.nomeDoDestinatario = nomeDoDestinatario;
        this.valorDeTransferencia = valorDeTransferencia;
    }

    public String getNomeDoDestinatario() {
        return nomeDoDestinatario;
    }

    public double getValorDeTransferencia() {
        return valorDeTransferencia;
    }


}
