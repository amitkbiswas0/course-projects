public class HourlyEmployee extends Employee {

    private int salaryPerHour;
    private int hoursWorked;

    public HourlyEmployee(String name, int ID, String joiningDate, int salaryPerHour, int hoursWorked) {
        super(name, ID, joiningDate);
        this.salaryPerHour = salaryPerHour;
        this.hoursWorked = hoursWorked;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalary(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
