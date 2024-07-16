package br.com.alura.compras.modelos;

import java.util.ArrayList;

public class CartaoDeCredito {
    private double saldo;
    private double limite;
    private ArrayList<Compra> compras;

    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    // metodo para lançar compra
    public boolean lancaCompra(Compra compra) {
        if (this.saldo >= compra.getValor()) {
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        } else {
            return false;
        }
    }
    // getters
    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }
}
