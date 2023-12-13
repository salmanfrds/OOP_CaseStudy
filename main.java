public class main{
  public static double calculateSalary(Employee employee){

        var hour = employee.calculateHours();
        var salary = hour * 6 * 0.89;
        return salary;

    }
    public static void main(String[] args) throws Exception {
        var employee = new Employee();

        employee.clockIn();
        Thread.sleep(1000);
        employee.clockOut();

        var salary = calculateSalary(employee);
        System.out.println(salary);
    }
}
