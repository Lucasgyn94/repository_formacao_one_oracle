package model;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String nomeDaConta;
    private String tipoDeConta;
    private double saldoDaConta;
    private List<Transferencia> listaDeTransferencia;

    public Conta() {

    }

    public Conta(String nomeDaConta, String tipoDeConta, double saldoDaConta) {
        this.nomeDaConta = nomeDaConta;
        this.tipoDeConta = tipoDeConta;
        this.saldoDaConta = saldoDaConta;
        this.listaDeTransferencia = new ArrayList<>();
    }

    public String getNomeDaConta() {
        return nomeDaConta;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    public double getSaldoDaConta() {
        return saldoDaConta;
    }

    public void depositar(double valor) {
        this.saldoDaConta += valor;
    }

    public boolean sacar(double valor) {
        if (this.saldoDaConta >= valor) {
            this.saldoDaConta -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente: " + this.saldoDaConta);
            return false;
        }
    }

    public boolean transferirValor(Conta contaDestino, double valor) {
        if (sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    public void registrarTransferencia(String nomeDoDestinatario, double valorDeTransferencia) {
        Transferencia transferencia = new Transferencia(nomeDoDestinatario, valorDeTransferencia);
        listaDeTransferencia.add(transferencia);
    }

    public void gerarRelatorioDeTransferencia() {
        System.out.println("-----------------");
        System.out.println("Relatorio de Transferencias: ");

        for(Transferencia transferencia : listaDeTransferencia) {
            System.out.println("*********");
            System.out.println((listaDeTransferencia.indexOf(transferencia) + 1) + "\nDestinatario: " + transferencia.getNomeDoDestinatario() +
                                "\nValor Transferido: $ " + transferencia.getValorDeTransferencia());
            System.out.println("*********\n");
        }
        System.out.println("\n-----------------");
    }


    @Override
    public String toString() {
        String texto =      "";
                texto +=    "===================================\n" +
                            "Nome: " + this.nomeDaConta + "\n" +
                            "Tipo de Conta: " + this.tipoDeConta + "\n" +
                            "Saldo da Conta: " + this.saldoDaConta + "\n" +
                            "=======================================";
        return  texto;
    }
}
