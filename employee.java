import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Employee{
    private String employeeID;
    private String name;
    private Date startTime;
    private Date endTime;
    private Double[] hoursArray = new Double[22];
    private Double Hours;

    public Employee(String employeeID) {
        this.employeeID = employeeID;
    }
    
    public String getEmployeeID(){
        return this.employeeID;
    }

    public void setEmployeeID(String employeeID){
        this.employeeID = employeeID;
    }

    public void clockIn(){
        this.startTime = Calendar.getInstance().getTime();
    }
    
    public void clockOutInput(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter hours: ");
        int hours = input.nextInt();

        System.out.print("Enter minutes: ");
        int minutes = input.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, 0);

        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));

        this.endTime = calendar.getTime();
    }

    public void clockOutReal(){
        this.endTime = Calendar.getInstance().getTime();
    }

    public double calculateHours() {
        long result = this.endTime.getTime() - this.startTime.getTime();
        double hours = (double) result / (1000 * 60 * 60);

        this.Hours = hours;
        return hours;
    }

    public Double getHours(){
        return Hours;
    }

    public Double[] getHoursArray() {
        return hoursArray;
    }

    public void storeHours(Double hours){
        for (int i = 0; i < hoursArray.length; i++) {
            if (hoursArray[i] == null) {
                hoursArray[i] = hours;
                return;
            } else {
                System.out.println("Array is full. Cannot add more hours.");
            }
        }
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime(){
        return this.startTime;
    }
    
    public Date getEndTime(){
        return this.endTime;
    }
}
