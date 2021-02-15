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
    public List<Client> clients;
    public List<Trainee> trainees;
    public List<Cashier> cashiers;
    public List<Manager> managers;

    public Bank() {
        clients = new ArrayList<>();
        trainees = new ArrayList<>();
        cashiers = new ArrayList<>();
        managers = new ArrayList<>();
        showBankMenu();
    }

    public void showBankMenu() {
        reader = new Scanner(System.in);
        menu:
        while (true) {
            System.out.println("\n[ BEM-VINDO(A) AO PROTOTIPO DE BANCO! ]\n");
            System.out.println("  1 - Entrar");
            System.out.println("  2 - Registrar");
            System.out.println("  3 - Sobre");
            System.out.print("\n  0 - Sair\n  > ");
            switch (reader.next()) {
                case "0":
                    break menu;
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
                    System.out.println("Opcao Invalida!");
            }
        }
    }

    public void showAccountMenu(Client client) {
        reader = new Scanner(System.in);
        menu:
        while (true) {
            System.out.printf("\n@usuario: %s %s - %s\n\n", client.getFirstName(), client
                    .getLastName(), client.getCpf());
            System.out.println("  1 - Sacar");
            System.out.println("  2 - Depositar");
            System.out.println("  3 - Transferir");
            System.out.println("  4 - Consultar Saldo");
            System.out.println("  5 - Historico da Conta");
            System.out.print("\n  0 - Sair da Conta\n  > ");
            switch (reader.next()) {
                case "0":
                    break menu;
                case "1":
                    client.withdraw(100);
                    break;
                case "2":
                    client.deposit(100);
                    break;
                case "3":
//                    client.transfer();
                    break;
                case "4":
                    client.consultBalance();
                    break;
                case "5":
                    client.history();
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }
        }
    }

    public void showTraineeMenu(Trainee trainee) {
        reader = new Scanner(System.in);
        menu:
        while (true) {
            System.out.printf("\n@funcionario: %s - (estagiario)\n\n", trainee.getCpf());
            System.out.println("  1 - Fazer Arquivo");
            System.out.println("  2 - Fazer Café");
            System.out.println("  3 - Olhar o Relogio");
            System.out.println("  4 - Ir ao Banheiro");
            System.out.print("\n  0 - Sair do Usuario\n  > ");
            switch (reader.next()) {
                case "0":
                    break menu;
                case "1":
                    trainee.archive();
                    break;
                case "2":
                    trainee.coffee();
                    break;
                case "3":
                    trainee.watche();
                    break;
                case "4":
                    trainee.bathroom();
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }
        }
    }

    public void showCashierMenu(Cashier cashier) {
        reader = new Scanner(System.in);
        menu:
        while (true) {
            System.out.printf("\n@funcionario: %s - (caixa)\n\n", cashier.getCpf());
            System.out.println("  1 - Exibir Contas");
            System.out.println("  2 - Historico da Conta");
            System.out.print("\n  0 - Sair do Usuario\n  > ");
            switch (reader.next()) {
                case "0":
                    break menu;
                case "1":
                    cashier.printAccount();
                    break;
                case "2":
                    cashier.history();
            }
        }
    }

    public void showManagerMenu(Manager manager) {
        reader = new Scanner(System.in);
        menu:
        while (true) {
            System.out.printf("\n@funcionario: %s - (gerente)\n\n", manager.getCpf());
            System.out.println("  1 - Exibir Contas");
            System.out.println("  2 - Historico da Conta");
            System.out.println("  3 - Excluir Conta");
            System.out.println("  4 - Exibir Funcionarios");
            System.out.println("  5 - Demitir Funcionario");
            System.out.print("\n  0 - Sair do Usuario\n  > ");
            switch (reader.next()) {
                case "0":
                    break menu;
                case "1":
                    manager.printAccount();
                    break;
                case "2":
                    manager.history();
                    break;
                case "3":
                    manager.deleteAccount();
                    break;
                case "4":
                    manager.printEmployee();
                    break;
                case "5":
                    manager.dismissEmployee();
                    break;
            }
        }
    }

    public void login() {
        reader = new Scanner(System.in);
        System.out.println("\n# { Entre }");
        System.out.print(" + CPF: ");
        String cpf = reader.next();
        checkAccount(cpf);
    }

    public void register() {
        reader = new Scanner(System.in);
        System.out.println("\n# { Registro }");
        System.out.print(" + Nome: ");
        String firstName = reader.next();
        System.out.print(" + Sobrenome: ");
        String lastName = reader.next();
        System.out.print(" + CPF: ");
        String cpf = reader.next();
        cpf = cpf.replaceAll("-", "");
        cpf = cpf.replaceAll("\\.", "");
        if (!isRegistredAccount(cpf)) {
            registerRole(firstName, lastName, cpf);
        }
    }

    public void about() {

    }

    public void registerRole(String firstName, String lastName, String cpf) {
        System.out.println("|~~~~~~~~~~~~~~~~~~~~|");
        System.out.println("  0 - Cliente");
        System.out.println("  1 - Estagiário");
        System.out.println("  2 - Caixa");
        System.out.print("  3 - Gerente\n  > ");
        switch (reader.next()) {
            case "0":
                Client client = new Client(firstName, lastName, cpf);
                clients.add(client);
                System.out.println("* Conta Criada!");
                break;
            case "1":
                Trainee trainee = new Trainee(firstName, lastName, cpf);
                System.out.print(" + Salario: R$ ");
                trainee.setSalary(reader.nextDouble());
                trainees.add(trainee);
                System.out.println("* Conta Criada!");
                break;
            case "2":
                Cashier cashier = new Cashier(firstName, lastName, cpf);
                System.out.print(" + Salario: R$ ");
                cashier.setSalary(reader.nextDouble());
                System.out.println("* Conta Criada!");
                break;
            case "3":
                Manager manager = new Manager(firstName, lastName, cpf);
                System.out.print(" + Salario: R$ ");
                manager.setSalary(reader.nextDouble());
                System.out.println("* Conta Criada!");
                break;
            default:
                System.out.println("Opcao Invalida!");
                registerRole(firstName, lastName, cpf);
        }
    }

    public void checkAccount(String cpf) {
        menu:
        while (cpf != null && cpf.length() == 11) {
            if (clients.size() != 0) {
                for (Client client : clients) {
                    if (cpf.equals(client.getCpf())) {
                        showAccountMenu(client);
                        break menu;
                    }
                }
                System.out.println("CPF e/ou Senha Errado!");
            } else if (trainees.size() != 0) {
                for (Trainee trainee : trainees) {
                    if (cpf.equals(trainee.getCpf())) {
                        showTraineeMenu(trainee);
                        break menu;
                    }
                }
                System.out.println("CPF e/ou Senha Errado!");
            } else if (cashiers.size() != 0) {
                for (Cashier cashier : cashiers) {
                    if (cpf.equals(cashier.getCpf())) {
                        showCashierMenu(cashier);
                        break menu;
                    }
                }
                System.out.println("CPF e/ou Senha Errado!");
            } else if (managers.size() != 0) {
                for (Manager manager : managers) {
                    if (cpf.equals(manager.getCpf())) {
                        showManagerMenu(manager);
                        break menu;
                    }
                }
                System.out.println("CPF e/ou Senha Errado!");
            } else {
                System.out.println("CPF e/ou Senha Errado!");
            }
        }
    }

    public boolean isRegistredAccount(String cpf) {
        return false;
    }
}