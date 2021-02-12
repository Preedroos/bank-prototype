package features;

public class Employee extends Account {
    private String firstName;
    private String lastName;
    private String cpf;
    private String email;
    private String phone;
    private String address;
    private double salary;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void printEmployee() {
        System.out.println(" - Nome: " + getFirstName());
        System.out.println(" - Sobrenome: " + getLastName());
        System.out.println(" - CPF: " + getCpf());
        System.out.println(" - Email: " + getEmail());
        System.out.println(" - Telefone: " + getPhone());
        System.out.println(" - Endereco: " + getAddress());
        System.out.println(" - Salario (BASE): R$ " + getSalary());
    }

//  OVERLOAD - printEmployee()
    public void printEmployee(boolean visitCard) {
        System.out.println(" - Nome: " + getFirstName());
        System.out.println(" - Email: " + getEmail());
        System.out.println(" - Telefone: " + getPhone());
    }
}