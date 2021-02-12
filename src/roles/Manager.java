package roles;

import features.Employee;

public class Manager extends Employee {
    private String subsidy;
    private double allowance;

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

    @Override
    public double getSalary() {
        return super.getSalary() * Integer.parseInt(getSubsidy()) + getAllowance();
    }

    @Override
    public void printEmployee() {
        super.printEmployee();
        System.out.println(" - Bonificacao : R$ " + super.getSalary() * Integer.parseInt(getSubsidy()) + "%");
        System.out.println(" - Ajuda de Custo: R$ " + getAllowance());
        System.out.println(" - Salario (TOTAL): R$ " + getSalary());
    }
}
