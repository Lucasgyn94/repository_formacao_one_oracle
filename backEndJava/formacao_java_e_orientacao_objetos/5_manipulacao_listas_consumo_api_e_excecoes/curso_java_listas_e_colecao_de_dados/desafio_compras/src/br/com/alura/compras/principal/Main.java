package br.com.alura.compras.principal;

import br.com.alura.compras.modelos.CartaoDeCredito;
import br.com.alura.compras.modelos.Compra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o limite do cartao: ");
        double limite = entrada.nextDouble();
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite a descriçao da compra: ");
            String descricao = entrada.next();

            System.out.println("Digite o valor da compra: ");
            double valor = entrada.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartaoDeCredito.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada com sucesso!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = entrada.nextInt();
            } else {
                System.out.println("Saldo insuficiente");
                sair = 0;
            }
            System.out.println("================================");
            System.out.println("COMPRAS REALIZADAS\n");
            for (Compra c : cartaoDeCredito.getCompras()) {
                System.out.println(c.getDescricao() + " - " + c.getValor());
            }

            System.out.println("\n=============================");

            System.out.println("\nSaldo do cartao de credito: " + cartaoDeCredito.getSaldo());
        }

        entrada.close();
    }
}