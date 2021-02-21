package roles;

import features.Employee;

public class Manager extends Employee {
    private String subsidy;
    private double allowance;

    public Manager(String firstName, String lastName, String cpf) {
        setFirstName(firstName);
        setLastName(lastName);
        setCpf(cpf);
        setSubsidy("1%");
        setAllowance(1);
        setAccess(3);
    }

    public String getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(String subsidy) {
        this.subsidy = subsidy.replaceAll("%", "");
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public void deleteAccount() {

    }

    public void dismissEmployee() {

    }

    @Override
    public double getSalary() {
        return super.getSalary() + (super.getSalary() * Double.parseDouble(getSubsidy()) / 100) + getAllowance();
    }

    @Override
    public void printEmployee() {
        super.printEmployee();
        System.out.printf(" - Bonificacao (%s) : R$ %f\n", getSubsidy() + "%", super.getSalary() * (Double.parseDouble(getSubsidy()) / 100));
        System.out.println(" - Ajuda de Custo: R$ " + getAllowance());
        System.out.println(" - Salario (TOTAL): R$ " + getSalary());
        System.out.println("+--------------------------+");
    }

    @Override
    public void printAccount() {
        super.printEmployee(true);
        super.printAccount();
    }
}
