package roles;

import features.Account;

public class Client extends Account {
    private String firstName;
    private String lastName;
    private String cpf;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void printClient() {
        super.printClient();
        System.out.println(" - Nome: " + getFirstName());
        System.out.println(" - Sobrenome: " + getLastName());
        System.out.println(" - CPF: " + getCpf());
    }
}