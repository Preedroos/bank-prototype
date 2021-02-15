package features;

public class Account {
    private static int numAccount=0;
    private int numAgency;
    private double balance;
    private int access;

    public Account() {
        numAccount++;
        this.balance = 0;
    }

    public int getNumAccount() {
        return numAccount;
    }

    public int getNumAgency() {
        return numAgency;
    }

    public void setNumAgency(int numAgency) {
        this.numAgency = numAgency;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public void withdraw(double value) {
//implementação
    }

    public void deposit(double value) {
//implementação
    }

    public void consultBalance() {
//implementação
    }

    public void history() {
//implementação
    }

    public void printAccount() {
        System.out.println(" - Conta: " + getNumAccount());
        System.out.println(" - Agencia: " + getNumAgency());
        System.out.println(" - Saldo: R$ " + getBalance());
    }
}