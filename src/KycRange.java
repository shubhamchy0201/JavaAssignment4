import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class KycRange {

    public static void findRange(String inputSignUpDate, String inputCurrentDate) {

        try {
            Date signUpDate, currentDate;
            String stringStartDate, stringEndDate;
            Date startDate;
            Date endDate;
            //Date to string convertion
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            signUpDate = dateFormatter.parse(inputSignUpDate);
            currentDate= dateFormatter.parse(inputCurrentDate);
            //checking the validity of date
            if(signUpDate.after(currentDate)) {
                System.out.println("No range");
            }
            else {
                startDate = signUpDate;
                //setting sign up year to start date
                startDate.setYear(currentDate.getYear());
                //creating calendar object->Return curent date instance
                Calendar calendar = Calendar.getInstance();
                //setting startdate as calender current date
                calendar.setTime(startDate);
                //subtracting 30 days from the calender date
                //Calendar.Date return date of calendar
                calendar.add(Calendar.DATE, -30);
                startDate=calendar.getTime();
                //adding 60 days to the calender date
                calendar.add(Calendar.DATE, 60);
                endDate=calendar.getTime();
                //verify the end date if end date passes the current date than set as current date
                if(endDate.after(currentDate)) {
                    endDate=currentDate;
                }

                //changing date object to string
                stringStartDate=dateFormatter.format(startDate);
                stringEndDate=dateFormatter.format(endDate);
                //printing the dates
                System.out.println(stringStartDate+" "+stringEndDate);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the signup Date and current date in format dd-mm-yyyy");
        String signUpDay=sc.nextLine();
        String currentDay=sc.nextLine();
        findRange(signUpDay,currentDay);

        /*
        findRange("16-07-1998", "27-06-2017");
        findRange("04-02-2016", "04-04-2017");
        findRange("04-05-2017", "04-04-2017");
        findRange("04-04-2015", "04-04-2016");
        findRange("04-04-2015", "15-03-2016");
        */
    }
}
