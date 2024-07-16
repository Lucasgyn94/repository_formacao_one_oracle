package controller;

import model.Conta;
import view.Menu;
import java.util.Scanner;

public class ControllerConta {

    private Conta conta;
    private Menu menu;
    private Scanner scanner;

    public ControllerConta() {
        conta = new Conta("Lucas Ferreira da Silva", "Corrente", 5000.00);
        menu = new Menu();
        scanner = new Scanner(System.in);
    }

    // Na classe ControllerConta.java
    public void iniciar() {
        int opcao;
        do {
            opcao = menu.mostrarMenu();

            switch (opcao) {
                case 1: consultarSaldos();
                    break;
                case 2: receberValor();
                    break;
                case 3: transferirValor();
                    break;
                case 4: consultarRelatorioTransferencias();
                    break;
                case 5:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 5);
        menu.fecharScanner();
    }


    private void consultarSaldos() {
        System.out.println(conta.toString());
    }

    private void receberValor() {
        System.out.println("Digite o valor a ser recebido: ");
        double valor = scanner.nextDouble();
        conta.depositar(valor);
        System.out.println("Valor recebido com sucesso!");
    }


    private void transferirValor() {
        System.out.println("Digite o valor a ser transferido: ");
        double valor = scanner.nextDouble();
        System.out.println("Digite o nome do destinatário: ");
        scanner.nextLine(); // Limpar o buffer do scanner
        String nomeDestinatario = scanner.nextLine();
        Conta destinatario = new Conta(nomeDestinatario, "Corrente", 0);
        if (conta.transferirValor(destinatario, valor)) {
            System.out.println("Transferência realizada com sucesso!");
            conta.registrarTransferencia(nomeDestinatario, valor); // Registrar a transferência
        } else {
            System.out.println("Transferência não realizada!");
        }
    }
    private void consultarRelatorioTransferencias() {
        conta.gerarRelatorioDeTransferencia();
    }
}
