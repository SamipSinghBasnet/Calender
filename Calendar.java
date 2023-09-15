/*
@author Samip ,Archit, Kenji, Tiffany
version 6.0
 */
//Class Calendar prints out calendar  to the user input
public class Calendar {
    //instance variables
    private  int month;
    private int year;
    private int numberOfDays;
    private int numberOfWeeks;
    private int startingDay;

    /*
    @ param int month, int year
    Calendar constructor
     */
    public Calendar(int month, int year) {
        this.month = month;
        this.year = year;


    }

    /*
    @param none
    @return none
    this method displays the day of a week in one line
     */
    public void displayHeader() {
        String header = " Su  Mo  TU  We  Th  Fr  Sa ";
        System.out.println(header);

    }
    /*
    @param none
    @ return none
    this method prints the day in month
     */
    public void displayCalendar() {
        int currentDay = 1;
        for (int week = 0; week < numberOfWeeks; week++) {

            if (week == 0) {
                for (int day = 0; day < 7; day++) {
                    if (day < startingDay) {
                        System.out.printf("%4s", " ");
                    } else {
                        System.out.printf("%4d", currentDay);
                        currentDay++;
                    }
                }
            } else {

                for (int day = 0; day < 7; day++) {
                    if (currentDay <= numberOfDays) {
                        System.out.printf("%4d", currentDay);
                        currentDay++;
                    } else {
                        System.out.printf("%4s", " ");
                    }
                }
            }
            System.out.println();
        }
    }

    /*
     * @param none
     * @return none
     * Method that will set the variable numberOfDays
     * equal to the number of days in the month entered
     */
    public void calculateDays() {
        switch (month) {
            case 4: case 6: case 9: case 11:
                numberOfDays = 30;
                break;
            case 2:
                numberOfDays = 28;
                break;
            default:
                numberOfDays = 31;
        }
        if (month == 2) {
            if ((year%4 == 0 && year%100 != 0) || year%400 == 0) {
                numberOfDays = 29;
            }
        }
        System.out.println("Number of days = " + numberOfDays);
    }

    /*
     * @param int month, int day, int year
     * @return int day
     * Method that calculates starting day  of week for the month
     */
    public int firstDay(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31 * m) / 12) % 7;
        startingDay =d;
        System.out.println("Starting Day = "+d );
        return d;

    }
    /*
     * @param none
     * @return none
     * Method calculateWeeks that counts number of week in the month based
     * on day of the week the starting day of the month
     */
    public void calculateWeek() {
        if (startingDay == 0 && numberOfDays == 28)
            numberOfWeeks = 4;
        else if ((startingDay == 6)&& numberOfDays ==30){
            numberOfWeeks =6 ;
        }
        else if ((startingDay == 5 || startingDay == 6) && numberOfDays == 31) {
            numberOfWeeks = 6;
        }
        else {
            numberOfWeeks = 5;
        }
        System.out.println("Number of weeks = " + numberOfWeeks);
    }
}



