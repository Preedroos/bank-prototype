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

    // MENU PRINCIPAL (BANCO)
    private void showBankMenu() {
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

    // MENU (CONTA)
    private void showAccountMenu(Client client) {
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
                    System.out.print(" + Valor: R$ ");
                    if (client.withdraw(reader.nextDouble())) {
                        System.out.println("* Saque Realizado!");
                    } else {
                        System.out.println("~ Saldo Insuficiente ou Valor Invalido!");
                    }
                    break;
                case "2":
                    System.out.print(" + Valor: R$ ");
                    if (client.deposit(reader.nextDouble())) {
                        System.out.println("* Deposito Realizado!");
                    } else {
                        System.out.println("~ Valor Invalido!");
                    }
                    break;
                case "3":
                    System.out.print(" + CPF Destino: ");
                    String receiverCPF = reader.next();
                    System.out.print(" + Valor: R$ ");
                    transfer(client, receiverCPF, reader.nextDouble());
                    break;
                case "4":
                    client.consultBalance();
                    break;
                case "5":
                    client.history();
                    break;
                default:
                    System.out.println("~ Opcao Invalida!");
            }
        }
    }

    // MENU (ESTAGIARIO)
    private void showTraineeMenu(Trainee trainee) {
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
                    System.out.println("~ Opcao Invalida!");
            }
        }
    }

    // MENU (CAIXA)
    private void showCashierMenu(Cashier cashier) {
        reader = new Scanner(System.in);
        menu:
        while (true) {
            System.out.printf("\n@funcionario: %s - (caixa)\n\n", cashier.getCpf());
            System.out.println("  1 - Exibir Conta");
            System.out.println("  2 - Historico da Conta");
            System.out.print("\n  0 - Sair do Usuario\n  > ");
            switch (reader.next()) {
                case "0":
                    break menu;
                case "1":
                    System.out.print(" + CPF da Conta: ");
                    String cpf = reader.next();
                    if (!isCPFAvailable(cpf)) {
                        printAccount(cpf);
                    }
                    break;
                case "2":
                    history();
            }
        }
    }

    // MENU (GERENTE)
    private void showManagerMenu(Manager manager) {
        reader = new Scanner(System.in);
        menu:
        while (true) {
            System.out.printf("\n@funcionario: %s - (gerente)\n\n", manager.getCpf());
            System.out.println("  1 - Exibir Conta");
            System.out.println("  2 - Historico da Conta");
            System.out.println("  3 - Excluir Conta");
            System.out.println("  4 - Exibir Funcionario");
            System.out.println("  5 - Demitir Funcionario");
            System.out.print("\n  0 - Sair do Usuario\n  > ");
            String cpf;
            switch (reader.next()) {
                case "0":
                    break menu;
                case "1":
                    System.out.print(" + CPF da Conta: ");
                    cpf = reader.next();
                    if (!isCPFAvailable(cpf)) {
                        printAccount(cpf);
                    }
                    break;
                case "2":
                    history();
                    break;
                case "3":
                    manager.deleteAccount();
                    break;
                case "4":
                    System.out.print(" + CPF do Funcionario: ");
                    cpf = reader.next();
                    if (!isCPFAvailable(cpf)) {
                        printEmployee(cpf);
                    }
                    break;
                case "5":
                    manager.dismissEmployee();
                    break;
            }
        }
    }

    // MENU - 'ENTRAR'
    private void login() {
        reader = new Scanner(System.in);
        System.out.println("\n# { Entre }");
        System.out.print(" + CPF: ");
        String cpf = reader.next();
        cpf = cpf.replaceAll("-", "");
        cpf = cpf.replaceAll("\\.", "");
        menu:
        if (isCPFValid(cpf)) {
            for (Client client : clients) {
                if (cpf.equals(client.getCpf())) {
                    showAccountMenu(client);
                    break menu;
                }
            }
            for (Trainee trainee : trainees) {
                if (cpf.equals(trainee.getCpf())) {
                    showTraineeMenu(trainee);
                    break menu;
                }
            }
            for (Cashier cashier : cashiers) {
                if (cpf.equals(cashier.getCpf())) {
                    showCashierMenu(cashier);
                    break menu;
                }
            }
            for (Manager manager : managers) {
                if (cpf.equals(manager.getCpf())) {
                    showManagerMenu(manager);
                    break menu;
                }
            }
            System.out.println("~ CPF Invalido!");
        }
    }

    // MENU - 'REGISTRAR'
    private void register() {
        reader = new Scanner(System.in);
        System.out.println("\n# { Registro }");
        System.out.print(" + Nome: ");
        String firstName = reader.nextLine();
        System.out.print(" + Sobrenome: ");
        String lastName = reader.nextLine();
        System.out.print(" + CPF: ");
        String cpf = reader.nextLine();
        cpf = cpf.replaceAll("-", "");
        cpf = cpf.replaceAll("\\.", "");
        if (isCPFValid(cpf) && isCPFAvailable(cpf)) {
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
                    cashiers.add(cashier);
                    System.out.println("* Conta Criada!");
                    break;
                case "3":
                    Manager manager = new Manager(firstName, lastName, cpf);
                    System.out.print(" + Salario: R$ ");
                    manager.setSalary(reader.nextDouble());
                    managers.add(manager);
                    System.out.println("* Conta Criada!");
                    break;
                default:
                    System.out.println("~ Opcao Invalida!");
                    break;
            }
        }
    }

    // MENU - 'SOBRE'
    private void about() {
        System.out.println("\n# { Sobre }");
        System.out.println(" - Muito pra pouco...");
    }

    // VALIDANDO CPF - (VALIDADE)
    private boolean isCPFValid(String cpf) {
        if (cpf != null && cpf.length() == 11) {
            return true;
        } else {
            System.out.println("~ CPF Invalido");
            return false;
        }
    }

    // VALIDANDO CPF - (DISPONIBILIDADE)
    private boolean isCPFAvailable(String cpf) {
        for (Client client : clients) {
            if (cpf.equals(client.getCpf())) {
                return false;
            }
        }
        for (Trainee trainee : trainees) {
            if (cpf.equals(trainee.getCpf())) {
                return false;
            }
        }
        for (Cashier cashier : cashiers) {
            if (cpf.equals(cashier.getCpf())) {
                return false;
            }
        }
        for (Manager manager : managers) {
            if (cpf.equals(manager.getCpf())) {
                return false;
            }
        }
        return true;
    }

    // METODOS CONTAS - TRANSFERENCIA
    private void transfer(Account account, String receiverCPF, double value) {
        if (account.withdraw(value)) {
            for (Client client : clients) {
                if (receiverCPF.equals(client.getCpf())) {
                    client.deposit(value);
                    System.out.println("* Transferencia Realizada!");
                    break;
                }
            }
            for (Trainee trainee : trainees) {
                if (receiverCPF.equals(trainee.getCpf())) {
                    trainee.deposit(value);
                    System.out.println("* Transferencia Realizada!");
                    break;
                }
            }
            for (Cashier cashier : cashiers) {
                if (receiverCPF.equals(cashier.getCpf())) {
                    cashier.deposit(value);
                    System.out.println("* Transferencia Realizada!");
                    break;
                }
            }
            for (Manager manager : managers) {
                if (receiverCPF.equals(manager.getCpf())) {
                    manager.deposit(value);
                    System.out.println("* Transferencia Realizada!");
                    break;
                }
            }
        } else {
            System.out.println("~ Valor Invalido ou Saldo Insuficiente!");
        }
    }

    // METODOS CONTAS - EXIBICAO
    private void printAccount(String cpf) {
        search:
        if (isCPFValid(cpf)) {
            for (Client client : clients) {
                if (cpf.equals(client.getCpf())) {
                    client.printAccount();
                    break search;
                }
            }
            for (Trainee trainee : trainees) {
                if (cpf.equals(trainee.getCpf())) {
                    trainee.printAccount();
                    break search;
                }
            }
            for (Cashier cashier : cashiers) {
                if (cpf.equals(cashier.getCpf())) {
                    cashier.printAccount();
                    break search;
                }
            }
            for (Manager manager : managers) {
                if (cpf.equals(manager.getCpf())) {
                    manager.printAccount();
                    break search;
                }
            }
        }
    }

    // METODOS CONTAS - HISTORICO
    private void history() {

    }

    // METODOS EMPREGADOS - EXIBICAO
    private void printEmployee(String cpf) {
        search:
        if (isCPFValid(cpf)) {
            for (Trainee trainee : trainees) {
                if (cpf.equals(trainee.getCpf())) {
                    trainee.printEmployee();
                    break search;
                }
            }
            for (Cashier cashier : cashiers) {
                if (cpf.equals(cashier.getCpf())) {
                    cashier.printEmployee();
                    break search;
                }
            }
            for (Manager manager : managers) {
                if (cpf.equals(manager.getCpf())) {
                    manager.printEmployee();
                    break search;
                }
            }
        }
    }
}