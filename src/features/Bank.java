package features;

import roles.Cashier;
import roles.Client;
import roles.Manager;
import roles.Trainee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    static Scanner reader;
    static Checker checker;
    public List<Client> clients;
    public List<Trainee> trainees;
    public List<Cashier> cashiers;
    public List<Manager> managers;

    public Bank() {
        reader = new Scanner(System.in);
        checker = new Checker();
        clients = new ArrayList<>();
        trainees = new ArrayList<>();
        cashiers = new ArrayList<>();
        managers = new ArrayList<>();

        showBankMenu();
        showClientMenu();
        showTraineeMenu();
        showCashierMenu();
        showManagerMenu();
    }

    public void showBankMenu() {
        System.out.println("\n[ BEM-VINDO(A) AO PROTOTIPO DE BANCO! ]\n");
        System.out.println("  1 - Entrar");
        System.out.println("  2 - Registrar");
        System.out.println("  3 - Sobre");
        System.out.print("\n  0 - Sair\n  > ");
        switch (reader.next()) {
            case "0":
                System.exit(0);
            case "1":
                login();
                break;
            case "2":
                register();
                break;
            case "3":
                about();
                break;
            default:
                System.out.println("* Entrada Invalida!");
                showBankMenu();
        }
    }

    public void showClientMenu() {
        System.out.println("\n@cliente: %s %s - %s\n");
        System.out.println("  1 - Sacar");
        System.out.println("  2 - Depositar");
        System.out.println("  3 - Transferir");
        System.out.println("  4 - Consultar Saldo");
        System.out.println("  5 - Historico da Conta");
        System.out.print("\n  0 - Sair da Conta\n  > ");
    }

    public void showTraineeMenu() {
        System.out.println("\n@funcionario: %s - (estagiario)\n");
        System.out.println("  1 - Fazer Arquivo");
        System.out.println("  2 - Fazer Café");
        System.out.println("  3 - Olhar o Relogio");
        System.out.println("  4 - Ir ao Banheiro");
        System.out.print("\n  0 - Sair do Usuario\n  > ");
    }

    public void showCashierMenu() {
        System.out.println("\n@funcionario: %s - (caixa)\n");
        System.out.println("  1 - Exibir Contas");
        System.out.println("  2 - Historico da Conta");
        System.out.print("\n  0 - Sair do Usuario\n  > ");
    }

    public void showManagerMenu() {
        System.out.println("\n@funcionario: %s - (gerente)\n");
        System.out.println("  1 - Exibir Contas");
        System.out.println("  2 - Historico da Conta");
        System.out.println("  3 - Excluir Conta");
        System.out.println("  4 - Exibir Funcionarios");
        System.out.println("  5 - Demitir Funcionario");
        System.out.print("\n  0 - Sair do Usuario\n  > ");
    }

    public void login() {

    }

    public void register() {

    }

    public void about() {

    }
}