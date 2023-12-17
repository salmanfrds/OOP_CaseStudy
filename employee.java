import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Employee{
    private String employeeID;
    private Date startTime;
    private Date endTime;
    private ArrayList<Double> hoursList;
    private String name;

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

        System.out.print("Enter seconds: ");
        int seconds = input.nextInt();

        input.close();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, seconds);

        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));

        this.endTime = calendar.getTime();
    }

    public void clockOutReal(){
        this.endTime = Calendar.getInstance().getTime();
    }

    public double calculateHours() {
        long result = this.endTime.getTime() - this.startTime.getTime();
        double hours = (double) result / (1000 * 60 * 60);
        this.hoursList.add(hours);

        return hours;
    }

    public double calculateSeconds(){
        var result = this.endTime.getTime() - this.startTime.getTime();
        long seconds_difference = (result / 1000)% 60;   
        return seconds_difference;
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

