package roles;

import features.Employee;

public class Cashier extends Employee {
    private float extraHourAmount;
    private double extraHourIncome;

    public Cashier(String firstName, String lastName, String cpf) {
        setFirstName(firstName);
        setLastName(lastName);
        setCpf(cpf);
        setAccess(2);
    }

    public float getExtraHourAmount() {
        return extraHourAmount;
    }

    public void setExtraHourAmount(float extraHourAmount) {
        this.extraHourAmount = extraHourAmount;
    }

    public double getExtraHourIncome() {
        return extraHourIncome;
    }

    public void setExtraHourIncome(double extraHourIncome) {
        this.extraHourIncome = extraHourIncome;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + getExtraHourAmount() * getExtraHourIncome();
    }

    @Override
    public void printEmployee() {
        super.printEmployee();
        System.out.println(" - Horas extras: R$ " + getExtraHourAmount() * getExtraHourIncome());
        System.out.println(" - Salario (TOTAL): R$ " + getSalary());
    }
}