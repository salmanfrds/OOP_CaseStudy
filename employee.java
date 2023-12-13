import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee{
    private int employee;
    private Date startTime;
    private Date endTime;
    private double hour;
    private double salary;

    public int getEmployee(){
        return this.employee;
    }

    public void setEmployee(int employee){
        this.employee = employee;
    }

    public void clockIn(){
        // this.startTime = Calendar.getInstance().getTime();
        this.startTime = new GregorianCalendar(2018, Calendar.JUNE, 25, 5, 0)
      .getTime();
    }
    
    public void clockOut(){
        // this.endTime = Calendar.getInstance().getTime();
        this.endTime =new GregorianCalendar(2018, Calendar.JUNE, 27,23 , 0)
      .getTime();
    }

    public double calculateHours(){
        var result = this.endTime.getTime() - this.startTime.getTime();
        this.hour = (result / (1000*60*60)) % 24;
        return this.hour;
    }
    public double calculateSeconds(){
        var result = this.endTime.getTime() - this.startTime.getTime();
        long seconds_difference = (result / 1000)% 60;   
        return seconds_difference;
    }
}
