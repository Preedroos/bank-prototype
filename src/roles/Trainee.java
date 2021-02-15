package roles;

import features.Employee;

public class Trainee extends Employee {
    private double foodVouchers;
    private double transportationTicket;

    public Trainee(String firstName, String lastName, String cpf) {
        setFirstName(firstName);
        setLastName(lastName);
        setCpf(cpf);
        setAccess(1);
    }

    public double getFoodVouchers() {
        return foodVouchers;
    }

    public void setFoodVouchers(double foodVouchers) {
        this.foodVouchers = foodVouchers;
    }

    public double getTransportationTicket() {
        return transportationTicket;
    }

    public void setTransportationTicket(double transportationTicket) {
        this.transportationTicket = transportationTicket;
    }

    public void archive() {
//implementação
    }

    public void coffee() {
//implementação
    }

    public void watche() {
//implementação
    }

    public void bathroom() {
//implementação
    }

    @Override
    public double getSalary() {
        return super.getSalary() + getFoodVouchers() + getTransportationTicket();
    }

    @Override
    public void printEmployee() {
        super.printEmployee();
        System.out.println(" - Vale Alimentacao: R$ " + getFoodVouchers());
        System.out.println(" - Vale Transporte: R$ " + getTransportationTicket());
        System.out.println(" - Salario (TOTAL): R$ " + getSalary());
    }
}