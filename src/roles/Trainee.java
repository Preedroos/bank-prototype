package roles;

public class Trainee extends Employee {
    private double foodVouchers;
    private double transportationTicket;

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

    @Override
    public double getSalary() {
        return super.getSalary() + getFoodVouchers() + getTransportationTicket();
    }

    @Override
    public void print() {
        super.print();
        System.out.println(" - Vale Alimentacao: R$ " + getFoodVouchers());
        System.out.println(" - Vale Transporte: R$ " + getTransportationTicket());
        System.out.println(" - Salario (TOTAL): R$ " + getSalary());
    }
}