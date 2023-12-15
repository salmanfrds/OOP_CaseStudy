import java.util.ArrayList;
import java.util.Scanner;

public class App {

    //hakimi
    public static void calculateSalary(ArrayList<Employee> employeeList){

    }

    //salman
    private static void checkInOrOut(ArrayList<Employee> employeeList) {

    }

    //naqash
    private static void regEmployee(ArrayList<Employee> employeeList) {

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
