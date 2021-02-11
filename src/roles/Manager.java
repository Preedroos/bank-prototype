package roles;

public class Manager extends Employee{
    private float subsidy;
    private double allowance;

    public float getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(float subsidy) {
        this.subsidy = subsidy;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    @Override
    public double getSalary() {
        return super.getSalary() * (1 + getSubsidy()) + getAllowance();
    }

    @Override
    public void print() {
        super.print();
        System.out.println(" - Bonificacao : R$ " + super.getSalary() * getSubsidy());
        System.out.println(" - Ajuda de Custo: R$ " + getAllowance());
        System.out.println(" - Salario (TOTAL): R$ " + getSalary());
    }
}
