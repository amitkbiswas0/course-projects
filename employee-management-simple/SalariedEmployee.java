public class SalariedEmployee extends Employee {

    private int salary;

    public SalariedEmployee(String name, int ID, String joiningDate, int salary) {
        super(name, ID, joiningDate);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
