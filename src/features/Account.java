package features;

public class Account {
    private static int cont = 0;
    private int numAccount;
    private int numAgency;
    private double balance;
    private int access;

    public Account() {
        setNumAccount(++cont);
        this.balance = 0;
    }

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

    public boolean withdraw(double value) {
        if (value > 0 && value <= getBalance()) {
            setBalance(getBalance() - value);
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(double value) {
        if (value > 0) {
            setBalance(getBalance() + value);
            return true;
        } else {
            return false;
        }
    }

    public void consultBalance() {
        System.out.println(" - Saldo: R$ " + getBalance());
    }

    public void history() {
//implementação
    }

    public void printAccount() {
        System.out.println(" - Conta: " + getNumAccount());
        System.out.println(" - Agencia: " + getNumAgency());
        System.out.println(" - Saldo: R$ " + getBalance());
        System.out.println("+--------------------------+");
    }
}