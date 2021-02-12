package features;

public class Account {
    private int numAccount;
    private int numAgency;
    private String password;
    private double balance;

    public int getNumAccount() {
        return numAccount;
    }

    public void setNumAccount(int numAccount) {
        this.numAccount = numAccount;
    }

    public int getNumAgency() {
        return numAgency;
    }

    public void setNumAgency(int numAgency) {
        this.numAgency = numAgency;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double value) {
        if (value > 0) {
            this.balance = getBalance() + value;
        } else {
            System.out.println("! Valor Invalido.");
        }
    }

    public void withdraw(double value) {
        if (value > 0 && value <= getBalance()) {
            this.balance = getBalance() - value;
        } else {
            System.out.println("! Valor Invalido.");
        }
    }

    public void printClient() {
        System.out.println(" - Conta: " + getNumAccount());
        System.out.println(" - Agencia: " + getNumAgency());
        System.out.println(" - Senha: " + getPassword());
        System.out.println(" - Saldo: R$ " + getBalance());
    }
}