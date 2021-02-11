package features;

import roles.Employee;

public class Cash extends Employee {
    private float extraHourAmount;
    private double extraHourIncome;

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
    public void print() {
        super.print();
        System.out.println(" - Horas extras: R$ " + getExtraHourAmount() * getExtraHourIncome());
        System.out.println(" - Salario (TOTAL): R$ " + getSalary());
    }
}
