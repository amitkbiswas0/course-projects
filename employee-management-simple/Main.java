import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //creating array-lists to store all employee data
        ArrayList<SalariedEmployee> sEmployee = new ArrayList<SalariedEmployee>();
        ArrayList<HourlyEmployee> hEmployee = new ArrayList<HourlyEmployee>();
        ArrayList<CommissionEmployee> cEmployee = new ArrayList<CommissionEmployee>();

        //universal scanner instance
        Scanner scanner = new Scanner(System.in);

        //program starts
        while (true) {

            System.out.println("Enter an option :");
            System.out.println("1 : Add Employee Record");
            System.out.println("2 : View Employee Record");
            System.out.println("3 : Update Employee Record");
            System.out.println("0 : Exit");

            //added scanner.nextLine() after every scanner.nextInt() to avoid a bug in Java
            int choice = scanner.nextInt();
            scanner.nextLine();

            //exit code 0
            if (choice == 0) break;
            else if (choice == 1) {
                while (true) {

                    System.out.println("Enter 0 to exit adding employee.\nAny other key to continue!");

                    int checker = scanner.nextInt();
                    scanner.nextLine();

                    //checker for exit code 0
                    if (checker != 0) {

                        System.out.println("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter ID: ");
                        int ID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter Joining date: ");
                        String date = scanner.nextLine();

                        System.out.println("Enter employee type: ");
                        System.out.println("1 : Salaried");
                        System.out.println("2 : Hourly");
                        System.out.println("3 : Commission");

                        int type = scanner.nextInt();
                        scanner.nextLine();

                        if (type == 1) {
                            boolean idFound = false;
                            //checking if ID already exists
                            for (int i = 0; i < sEmployee.size(); i++) {
                                if (sEmployee.get(i).getEmployeeID() == ID) {
                                    System.out.println("ID already exists in this Catagory.\nEnter another ID!");
                                    idFound = true;
                                }
                            }

                            // go back to main option if ID found
                            if (idFound == true) break;

                            System.out.println("Enter Salary: ");
                            int salary = scanner.nextInt();
                            scanner.nextLine();
                            //creating instance and adding to array-list
                            SalariedEmployee salariedEmployee = new SalariedEmployee(name, ID, date, salary);
                            sEmployee.add(salariedEmployee);

                        } else if (type == 2) {

                            System.out.println("Enter Salary per hour: ");
                            int salaryPerHour = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter Hours worked: ");
                            int hoursWorked = scanner.nextInt();
                            scanner.nextLine();
                            //creating instance and adding to array-list
                            HourlyEmployee hourlyEmployee = new HourlyEmployee(name, ID, date, salaryPerHour, hoursWorked);
                            hEmployee.add(hourlyEmployee);

                        } else if (type == 3) {

                            System.out.println("Enter Commission per Project: ");
                            int commissionPerProject = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter number of Projects: ");
                            int numberOfProjects = scanner.nextInt();
                            scanner.nextLine();
                            //creating instance and adding to array-list
                            CommissionEmployee commissionEmployee = new CommissionEmployee(name, ID, date, numberOfProjects, commissionPerProject);
                            cEmployee.add(commissionEmployee);

                        } else {
                            System.out.println("Enter a valid type");
                        }
                    } else break;  //if checker not 0, break while loop
                }
            } else if (choice == 2) {
                while (true) {

                    System.out.println("Enter 0 to exit viewing employee.\nAny other key to continue!");

                    int checker = scanner.nextInt();
                    scanner.nextLine();

                    if (checker != 0) {

                        System.out.println("Enter ID: ");
                        int ID = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter Employee type: ");
                        System.out.println("1 : Salaried");
                        System.out.println("2 : Hourly");
                        System.out.println("3 : Commissioned");

                        int type = scanner.nextInt();
                        scanner.nextLine();

                        if (type == 1) {
                            //to check if employee found
                            boolean found = false;
                            for (int i = 0; i < sEmployee.size(); i++) {
                                if (sEmployee.get(i).getEmployeeID() == ID) {
                                    found = true;
                                    System.out.println("Employee Name: " + sEmployee.get(i).getName());
                                    System.out.println("Employee ID: " + sEmployee.get(i).getEmployeeID());
                                    System.out.println("Employee Joining Date: " + sEmployee.get(i).getJoiningDate());
                                    System.out.println("Employee Salary: " + sEmployee.get(i).getSalary());
                                }
                            }
                            if (!found) System.out.println("No employee in this category with this ID!");
                        } else if (type == 2) {
                            boolean found = false;
                            for (int i = 0; i < hEmployee.size(); i++) {
                                if (hEmployee.get(i).getEmployeeID() == ID) {
                                    found = true;
                                    System.out.println("Employee Name: " + hEmployee.get(i).getName());
                                    System.out.println("Employee ID: " + hEmployee.get(i).getEmployeeID());
                                    System.out.println("Employee Joining Date: " + hEmployee.get(i).getJoiningDate());
                                    System.out.println("Employee Salary Per hour: " + hEmployee.get(i).getSalaryPerHour());
                                    System.out.println("Employee Hours Worked: " + hEmployee.get(i).getHoursWorked());
                                }
                            }
                            if (!found) System.out.println("No employee in this category with this ID!");
                        } else if (type == 3) {
                            boolean found = false;
                            for (int i = 0; i < cEmployee.size(); i++) {
                                if (cEmployee.get(i).getEmployeeID() == ID) {
                                    found = true;
                                    System.out.println("Employee Name: " + cEmployee.get(i).getName());
                                    System.out.println("Employee ID: " + cEmployee.get(i).getEmployeeID());
                                    System.out.println("Employee Joining Date: " + cEmployee.get(i).getJoiningDate());
                                    System.out.println("Employee Number of Projects: " + cEmployee.get(i).getNumberOfProjects());
                                    System.out.println("Employee Commission per Project:  " + cEmployee.get(i).getCommissionPerProject());
                                }
                            }
                            if (!found) System.out.println("No employee in this category with this ID!");
                        }
                    } else break;  //if checker not 0, break while loop
                }
            } else if (choice == 3) {
                while (true) {

                    System.out.println("Enter 0 to exit updating employee.\nAny other key to continue!");

                    int checker = scanner.nextInt();
                    scanner.nextLine();

                    if (checker != 0) {

                        System.out.println("Enter ID: ");
                        int ID = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter Employee type: ");
                        System.out.println("1 : Salaried");
                        System.out.println("2 : Hourly");
                        System.out.println("3 : Commissioned");

                        int type = scanner.nextInt();
                        scanner.nextLine();

                        if (type == 1) {
                            boolean found = false;
                            boolean idCheck = false;
                            for (int i = 0; i < sEmployee.size(); i++) {
                                if (sEmployee.get(i).getEmployeeID() == ID) {
                                    found = true;

                                    //taking new values as input
                                    System.out.println("Enter New ID: ");
                                    int newID = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter New Name: ");
                                    String newName = scanner.nextLine();
                                    System.out.println("Enter New Joining Date: ");
                                    String newJoiningDate = scanner.nextLine();
                                    System.out.println("Enter New Salary: ");
                                    int newSalary = scanner.nextInt();
                                    scanner.nextLine();

                                    //check if new ID already exists as no two
                                    //employee can have same IDs
                                    for (int j = 0; j < sEmployee.size(); j++) {
                                        if (sEmployee.get(j).getEmployeeID() == newID) {
                                            System.out.println("Same ID already exists. Rolling back to previous data!");
                                            idCheck = true;
                                            break;
                                        }
                                    }
                                    if (idCheck) break;
                                    //set new values
                                    sEmployee.get(i).setEmployeeID(newID);
                                    sEmployee.get(i).setName(newName);
                                    sEmployee.get(i).setJoiningDate(newJoiningDate);
                                    sEmployee.get(i).setSalary(newSalary);

                                    //showing updated values
                                    System.out.println("Employee Name: " + sEmployee.get(i).getName());
                                    System.out.println("Employee ID: " + sEmployee.get(i).getEmployeeID());
                                    System.out.println("Employee Joining Date: " + sEmployee.get(i).getJoiningDate());
                                    System.out.println("Employee Salary: " + sEmployee.get(i).getSalary());
                                }
                            }
                            if (!found) System.out.println("No employee in this category with this ID!");
                        } else if (type == 2) {
                            boolean found = false;
                            boolean idCheck = false;
                            for (int i = 0; i < hEmployee.size(); i++) {
                                if (hEmployee.get(i).getEmployeeID() == ID) {
                                    found = true;

                                    //taking new values as input
                                    System.out.println("Enter New ID: ");
                                    int newID = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter New Name: ");
                                    String newName = scanner.nextLine();
                                    System.out.println("Enter New Joining Date: ");
                                    String newJoiningDate = scanner.nextLine();
                                    System.out.println("Enter New Hours Worked: ");
                                    int newHoursWorked = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter New Salary Per Hour: ");
                                    int newSalaryPerHour = scanner.nextInt();
                                    scanner.nextLine();

                                    //check if new ID already exists as no two
                                    //employee can have same IDs
                                    for (int j = 0; j < hEmployee.size(); j++) {
                                        if (hEmployee.get(j).getEmployeeID() == newID) {
                                            System.out.println("Same ID already exists. Rolling back to previous data!");
                                            break;
                                        }
                                    }
                                    if (idCheck) break;
                                    //set new values
                                    hEmployee.get(i).setEmployeeID(newID);
                                    hEmployee.get(i).setName(newName);
                                    hEmployee.get(i).setJoiningDate(newJoiningDate);
                                    hEmployee.get(i).setHoursWorked(newHoursWorked);
                                    hEmployee.get(i).setSalary(newSalaryPerHour);

                                    //show new values
                                    System.out.println("Employee Name: " + hEmployee.get(i).getName());
                                    System.out.println("Employee ID: " + hEmployee.get(i).getEmployeeID());
                                    System.out.println("Employee Joining Date: " + hEmployee.get(i).getJoiningDate());
                                    System.out.println("Employee Salary Per hour: " + hEmployee.get(i).getSalaryPerHour());
                                    System.out.println("Employee Hours Worked: " + hEmployee.get(i).getHoursWorked());
                                }
                            }
                            if (!found) System.out.println("No employee in this category with this ID!");
                        } else if (type == 3) {
                            boolean found = false;
                            boolean idCheck = false;
                            for (int i = 0; i < cEmployee.size(); i++) {
                                if (cEmployee.get(i).getEmployeeID() == ID) {
                                    found = true;

                                    //taking new values as input
                                    System.out.println("Enter New ID: ");
                                    int newID = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter New Name: ");
                                    String newName = scanner.nextLine();
                                    System.out.println("Enter New Joining Date: ");
                                    String newJoiningDate = scanner.nextLine();
                                    System.out.println("Enter New Hours Worked: ");
                                    int newNumberOfProjects = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter New Salary Per Hour: ");
                                    int newCommissionPerProject = scanner.nextInt();
                                    scanner.nextLine();

                                    //check if new ID already exists as no two
                                    //employee can have same IDs
                                    for (int j = 0; j < cEmployee.size(); j++) {
                                        if (cEmployee.get(j).getEmployeeID() == newID) {
                                            System.out.println("Same ID already exists. Rolling back to previous data!");
                                            break;
                                        }
                                    }
                                    if (idCheck) break;
                                    //set new values
                                    cEmployee.get(i).setEmployeeID(newID);
                                    cEmployee.get(i).setName(newName);
                                    cEmployee.get(i).setJoiningDate(newJoiningDate);
                                    cEmployee.get(i).setNumberOfProjects(newNumberOfProjects);
                                    cEmployee.get(i).setCommissionPerProject(newCommissionPerProject);

                                    //show new values
                                    System.out.println("Employee Name: " + cEmployee.get(i).getName());
                                    System.out.println("Employee ID: " + cEmployee.get(i).getEmployeeID());
                                    System.out.println("Employee Joining Date: " + cEmployee.get(i).getJoiningDate());
                                    System.out.println("Employee Number of Projects: " + cEmployee.get(i).getNumberOfProjects());
                                    System.out.println("Employee Commission per Project:  " + cEmployee.get(i).getCommissionPerProject());
                                }
                            }
                            if (!found) System.out.println("No employee in this category with this ID!");
                        }
                    } else break;  //if checker not 0, break while loop
                }
            } else break; //exit code 0 to exit the program
        }
    }
}