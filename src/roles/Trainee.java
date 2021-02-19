package roles;

import features.Employee;

public class Trainee extends Employee {
    private double foodVouchers;
    private double transportationTicket;

    public Trainee(String firstName, String lastName, String cpf) {
        setFirstName(firstName);
        setLastName(lastName);
        setCpf(cpf);
        setFoodVouchers(1);
        setTransportationTicket(1);
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
        System.out.println("furando alguns documentos...");
        try {
            Thread.sleep(3000);
            System.out.println("* Arquivo Feito!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void coffee() {
        System.out.println("colocando po do cafe...");
        try {
            Thread.sleep(3000);
            System.out.println("* Cafe Pronto!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void watche() {
        System.out.println("olhando o relogio...");
        try {
            Thread.sleep(3000);
            System.out.println("* Bora trabaia!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void bathroom() {
        System.out.println("usando o banheiro...");
        try {
            Thread.sleep(3000);
            System.out.println("* Bora trabaia!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        System.out.println("+--------------------------+");
    }

    @Override
    public void printAccount() {
        super.printEmployee(true);
        super.printAccount();
    }
}