import java.util.ArrayList;
import java.util.Scanner;

public class App {

    //Mohamad Nur Hakimi bin Asmadi (2213091)
    public static void calculateSalary(ArrayList<Employee> employeeList) {
        Scanner input = new Scanner(System.in);
    
        System.out.println("Enter employee ID to calculate salary: ");
        String employeeID = input.next();
    
        Employee employee = findEmployee(employeeList, employeeID);
    
        if (employee != null) {
            if (employee.getStartTime() == null || employee.getEndTime() == null) {
                System.out.println("Employee has not checked in or out. Cannot calculate salary");
            } else {
                double hoursWorked = employee.calculateHours();
                employee.storeHours(hoursWorked);
    
                if (hoursWorked < 1.0) {
                    System.out.println("Working hours are less than 1 hour. Cannot calculate salary");
                    employee.reset();
                } else {
                    double grossSalary = 6 * hoursWorked;
                    double epfContribution = 0.11 * grossSalary;
                    double netSalary = grossSalary - epfContribution;
    
                    System.out.println("");
                    System.out.println("Employee ID: " + employee.getEmployeeID());
                    System.out.println("Employee Name: " + employee.getName());
                    System.out.println("Employee Hours Worked: " + String.format("%.1f", hoursWorked));
                    System.out.println("Gross Salary: RM " + String.format("%.1f", grossSalary));
                    System.out.println("EPF Contribution (11%): RM " + String.format("%.1f", epfContribution));
                    System.out.println("Net Salary (after EPF deduction): RM " + String.format("%.1f", netSalary));
                    System.out.println("");
    
                    employee.reset();
                }
            }
    
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Firdaus Muahammad Salman (2223281)
    public static void checkInOrOut(ArrayList<Employee> employeeList) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        String employeeID = input.next();

        Employee employee = findEmployee(employeeList, employeeID);

        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("");
            System.out.println("1. Check-in");
            System.out.println("2. Input Check-out time");
            System.out.println("3. Check-out using current time");
            System.out.println("");

            System.out.print("Enter your choice: ");
            int checkChoice = input.nextInt();

            switch (checkChoice) {
                case 1:
                    if (employee.getStartTime() == null) {
                        employee.clockIn();
                        System.out.println("Checked in successfully.");
                        break;
                    } else {
                        System.out.println("Employee has already checked in!!");
                    }
                    break;
                case 2:
                    if (employee.getEndTime() == null) {
                        employee.clockOutInput();
                        System.out.println("Checked out with user-set time successfully.");
                        break;
                    } else {
                        System.out.println("Employee has already checked out!!");
                    }
                    break;
                case 3:
                    if (employee.getEndTime() == null) {
                        employee.clockOutReal();
                        System.out.println("Checked out with real-time successfully.");
                        break;
                    } else {
                        System.out.println("Employee has already checked out!!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Naqash Mohd Aouf (2224251)
    public static void regEmployee(ArrayList<Employee> employeeList) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Enter the employee name: ");
            String name = input.nextLine();
            System.out.println("Enter the employee ID: ");
            String id = input.nextLine();

            Employee emp = new Employee(id);
            emp.setName(name);
            employeeList.add(emp);

            System.out.println("");
            System.out.println("Employee registered successfully.");
            System.out.println("Do you want to register another employee?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");
            System.out.println("");

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    choice = 1;
                    break;
            }
            input.nextLine();

        } while (choice == 1);
    }

    // Firdaus Muahammad Salman (2223281)
    public static Employee findEmployee(ArrayList<Employee> employeeList, String employeeID) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID().equals(employeeID)) {
                return employee;
            }
        }
        return null;
    }

    //Mohamad Nur Hakimi bin Asmadi (2213091)
    public static void hoursRecord(ArrayList<Employee> employeeList) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter employee ID to show Hours Records (First 22 records): ");
        String employeeID = input.next();

        Employee employee = findEmployee(employeeList, employeeID);

        if (employee != null) {
            System.out.println("");
            System.out.println("Employee Working Hours Records (First 22 records):");
            System.out.println("------------------------------------------------");
            System.out.println("Employee ID: " + employee.getEmployeeID());
            System.out.println("Employee name: " + employee.getName());

            double totalHours = 0.0;
            for (int i = 0; i < employee.getHoursArray().length; i++) {
                if (employee.getHoursArray()[i] == null) {
                    double randomHours = 1 + (Math.random() * 12);
                    System.out.println("Hours worked on day " + (i + 1) + "\t: " + String.format("%.2f", randomHours) + " hrs" + "\tRandom Generated");
                    totalHours += randomHours;
                } else {
                    var hours = employee.getHoursArray()[i];
                    System.out.println("Hours worked on day " + (i + 1) + "\t: " + String.format("%.2f", hours) + " hrs");
                    totalHours += hours;
                }
            }

            System.out.println("------------------------------------------------");
            System.out.println("Total hours worked: " + String.format("%.2f", totalHours) + " hrs");
            totalSalary(totalHours);

            } else {
                System.out.println("Employee not found.");
        }
    }

    // Firdaus Muahammad Salman (2223281)
    public static void main(String[] args) throws Exception {
        ArrayList<Employee> employeeList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int exit = 1;
        System.out.println("--------Welcome!!----------\n Please choose appropriate options. ");
        while (exit != 0) {
            System.out.println("");
            System.out.println("Main Menu:");
            System.out.println("1. Register new employee");
            System.out.println("2. Check in or Check out");
            System.out.println("3. Calculate Salary");
            System.out.println("4. Employee working hours record(first 22 records)");
            System.out.println("0. Exit");
            System.out.println("");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    regEmployee(employeeList);
                    break;
                case 2:
                    checkInOrOut(employeeList);
                    break;
                case 3:
                    calculateSalary(employeeList);
                    break;
                case 4:
                    hoursRecord(employeeList);
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    exit = 0;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        input.close();
    }

    public static void totalSalary(double totalHours) {
        double salaryPerHour = 6.0;
        double grossSalary = totalHours * salaryPerHour;
        double epfContribution = grossSalary * 0.11;
        double netSalary = grossSalary - epfContribution;
    
        System.out.println("------------------------------------------------");
        System.out.println("Gross Salary: RM " + String.format("%.2f", grossSalary));
        System.out.println("EPF Contribution (11%): RM " + String.format("%.2f", epfContribution));
        System.out.println("Net Salary (after EPF deduction): RM " + String.format("%.2f", netSalary));
    }
}
