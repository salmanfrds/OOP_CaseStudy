import java.util.ArrayList;
import java.util.Scanner;

public class App {

    //hakimi
    public static void calculateSalary(ArrayList<Employee> employeeList){

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
    public void regEmployee(ArrayList<Employee> employeeList) {
   Scanner sc = new Scanner(System.in);
  System.out.println("Enter the employee name: ");
  String name = sc.nextLine();
  System.out.println("Enter the employee ID: ");
  int id = sc.nextInt();
  System.out.println("Enter the employee designation: ");
  String designation = sc.next();
  Employee emp = new Employee(name, id, designation);

employeeList.add(emp);
System.out.println("Employee registered successfully.");
    

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
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Check in or Check out");
            System.out.println("2. Register new employee");
            System.out.println("3. Calculate Salary");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

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
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
