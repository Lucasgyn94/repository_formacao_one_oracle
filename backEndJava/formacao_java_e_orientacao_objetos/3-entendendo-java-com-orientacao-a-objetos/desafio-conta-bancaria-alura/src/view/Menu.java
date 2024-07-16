// Na classe Menu.java
package view;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("========================\n");
        System.out.println("Operações");
        System.out.println("1- Consultar saldos");
        System.out.println("2- Receber valor");
        System.out.println("3- Transferir valor");
        System.out.println("4- Exibir relatório de transferências");
        System.out.println("5- Sair");
        System.out.println("Digite a opção desejada:");
        System.out.println("\n========================");
        return scanner.nextInt();
    }

    public void fecharScanner() {
        scanner.close();
    }
}
