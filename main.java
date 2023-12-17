import java.util.ArrayList;
import java.util.Scanner;

public class App {

    //hakimi
    public static void calculateSalary(ArrayList<Employee> employeeList){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter employee ID to calculate salary: ");
        String employeeID = input.next();

        Employee employee = findEmployee(employeeList, employeeID);
        {
            if(employee != null){
                if(employee.clockIn() == null || employee.clockOutReal() == null){
                    throw new IllegalStateException("Employee has not checked in or out. Cannot calculate salary");
                }

                double hourlyRate = 6.0;
                double hoursWorked = employee.calculateHours(); 

                if(hoursWorked < 1.0){
                    throw new IllegalArgumentException("Working hours are less than 1 hour. Cannot calculate salary");
                }

                double salary = hourlyRate * hoursWorked; 

                double epfContribution = 0.11 * salary;
                salary -= epfContribution;

                System.out.println("Employee ID: " + employee.getEmployeeID());
                System.out.println("Employee Name: " + employee.getName());
                System.out.println("Employee Hours Worked: " + hoursWorked);
                System.out.println("Total salary (after EPF deduction): RM " + salary);
            }
             else{
                System.out.println("Employee not found.");
             }
        }
        input.close();
        return;
    }


    //salman
    private static void checkInOrOut(ArrayList<Employee> employeeList) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        String employeeID = input.next();

        Employee employee = findEmployee(employeeList, employeeID);

        if (employee == null) {
            System.out.println("Employee not found.");
        }

        System.out.println("1. Check-in");
        System.out.println("2. Input Check-out time");
        System.out.println("3. Check-out using current time");

        System.out.print("Enter your choice: ");
        int checkChoice = input.nextInt();

        switch (checkChoice) {
            case 1:
                employee.clockIn();
                System.out.println("Checked in successfully.");
                break;
            case 2:
                employee.clockOutInput();
                System.out.println("Checked out with user-set time successfully.");
                break;
            case 3:
                employee.clockOutReal();
                System.out.println("Checked out with real-time successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        //input.nextLine();
        input.close();
    }

    //naqash
    private static void regEmployee(ArrayList<Employee> employeeList) {
        Scanner input = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("Enter the employee name: ");
            String name = input.nextLine();
            System.out.println("Enter the employee ID: ");
            int id = 0;
            
            Employee emp = new Employee(id);
            emp.setName(name);
            employeeList.add(emp);

            System.out.println("Employee registered successfully.");
            System.out.println("Do you want to register another employee?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    choice = 0;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    choice = 1;
                    break;
            }
            input.nextLine();

        } while (choice == 1);
        input.close();
    }           

    private static Employee findEmployee(ArrayList<Employee> employeeList, String employeeID) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID().equals(employeeID)) {
                return employee;
            }
        }
        return null;
    }
    
    public static void main(String[] args) throws Exception {
        ArrayList<Employee> employeeList = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Check in or Check out");
            System.out.println("2. Register new employee");
            System.out.println("3. Calculate Salary");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    checkInOrOut(employeeList);
                    break;
                case 2:
                    regEmployee(employeeList);
                    break;
                case 3:
                    calculateSalary(employeeList);
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    input.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
