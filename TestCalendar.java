//imports scanner Library
import java.util.Scanner;
//this class test the class Calendar
public class TestCalendar {
    //Main method
    public static void main(String[] args) {
        //Declares Scanner
        Scanner in =new Scanner(System.in);
        System.out.println("Please enter a month and a year separated by  A space:");
        int month = in.nextInt();
        int year = in.nextInt();
        //Sets month and year input in Calendar cal
        Calendar cal = new Calendar(month,year);
        cal.firstDay(month, 1, year);
        cal.calculateDays();
        cal.calculateWeek();
        cal.displayHeader();
        cal.displayCalendar();
    }
}
