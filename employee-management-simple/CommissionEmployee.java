public class CommissionEmployee extends Employee {

    private int numberOfProjects;
    private int commissionPerProject;

    public CommissionEmployee(String name, int ID, String joiningDate, int numberOfProjects, int commissionPerProject) {
        super(name, ID, joiningDate);
        this.numberOfProjects = numberOfProjects;
        this.commissionPerProject = commissionPerProject;
    }

    public int getNumberOfProjects() {
        return numberOfProjects;
    }

    public void setNumberOfProjects(int numberOfProjects) {
        this.numberOfProjects = numberOfProjects;
    }

    public int getCommissionPerProject() {
        return commissionPerProject;
    }

    public void setCommissionPerProject(int commissionPerProject) {
        this.commissionPerProject = commissionPerProject;
    }
}
