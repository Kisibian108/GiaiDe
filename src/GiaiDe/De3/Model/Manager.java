package GiaiDe.De3.Model;

public class Manager extends Staff {

    private double salary;
    private double coefficient;

    public Manager() {
    }

    public Manager(Integer id, Integer code, String name, String birthday, String address) {
        super(id, code, name, birthday, address);
    }

    public Manager(double salary, double coefficient) {
        this.salary = salary;
        this.coefficient = coefficient;
    }

    public Manager(Integer id, Integer code, String name, String birthday, String address, double salary, double coefficient) {
        super(id, code, name, birthday, address);
        this.salary = salary;
        this.coefficient = coefficient;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() +
                "salary=" + salary +
                ", coefficient=" + coefficient +
                '}';
    }

    @Override
    public String convertLine() {
        String COMMA = ",";
        return super.getId() + COMMA +
                super.getCode() + COMMA +
                super.getName() + COMMA +
                super.getBirthday() + COMMA +
                super.getAddress() + COMMA +
                this.getSalary() + COMMA +
                this.getCoefficient();
    }
}
