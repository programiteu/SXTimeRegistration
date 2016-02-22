import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*
 * Date and Time in Java LocalDate and Calendar class
 */


class TestClass {
    public static void main(String[] args) {

        //LocalDate contains a date without time zone or time specification. Can be used for birthdays or holidays:
        LocalDate ld = LocalDate.of(2015, 1, 31);
        System.out.println(ld);

        //Parse String to LocalDate object to obtain a LocalDdate object from String input (e.g. from a database):
        String date = "1985-12-5";
        int year = Integer.parseInt(date.substring(0,date.indexOf("-")));
        int month = Integer.parseInt(date.substring(date.indexOf("-")+1,date.lastIndexOf("-")));
        int day = Integer.parseInt(date.substring(date.lastIndexOf("-")+1,date.length()));

        ld = LocalDate.of(year, month, day);
        System.out.println(ld);

        //Parse to Calendar object:
        Calendar x = new GregorianCalendar(); //Calendar class is abstract and subclassed by GregorianCalendar which can be instantiated (initial date is NOW)
        x.set(year, month-1, day, 0, 0, 0); // triple 0 parameters represents hours, minutes and seconds
        System.out.println("\nCalendar's to String: \n"+x);//Calendar's toString representation

        //parse to Date object for usefull toString representation:
        Date d = x.getTime();
        System.out.println("\nDate's to String: \n"+d);

        //Use parse method of localDate (works only with format "yyyy-MM-dd"):
        date = "2000-03-01";
        ld = LocalDate.parse(date);
        System.out.println(ld);

        //Use (overloaded) parse method with DateTimeFormatter for different String-date patterns:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        date = "25-03-1981";
        ld = LocalDate.parse(date, formatter);
        System.out.println(ld);

        //Get dates from Calendar objects:
        Calendar cal = Calendar.getInstance(); //date is NOW
        //Calendar works with sevaral fields refered to by ints: 1-year, 2-month, 5-dayOfMonth, 11-hoursOfDay, 12-minutes
        System.out.println("\nNOW: \nDATUM: "+cal.get(1)+" - "+cal.get(5)+" - "+(cal.get(2)+1)+"\nTIJD: "+cal.get(11)+" : "+cal.get(12));
        //use of ints above gives warning, should use Calendar's constants MONTH, YEAR, etc.:
        System.out.println("\nNOW: \nDATUM: "+cal.get(Calendar.YEAR)+" - "+cal.get(Calendar.DAY_OF_MONTH)+" - "+(cal.get(Calendar.MONTH)+1)+"\nTIJD: "+cal.get(Calendar.HOUR_OF_DAY)+" : "+cal.get(Calendar.MINUTE));

        cal.clear();
        //clear sets object to Epoch:
        System.out.println("\nEPOCH: \nDATUM: "+cal.get(Calendar.YEAR)+" - "+cal.get(Calendar.DAY_OF_MONTH)+" - "+(cal.get(Calendar.MONTH)+1)+"\nTIJD: "+cal.get(Calendar.HOUR_OF_DAY)+" : "+cal.get(Calendar.MINUTE));

        //Set dates and time in a calendar object (using scanner)
        int hour;
        int minute;

        Scanner scan = new Scanner(System.in);
        System.out.println("\nyear?");
        year = scan.nextInt();
        System.out.println("month?");
        month = scan.nextInt();
        System.out.println("day?");
        day = scan.nextInt();
        System.out.println("hour?");
        hour = scan.nextInt();
        System.out.println("minute?");
        minute = scan.nextInt();

        //Calendar's set method adds time to Epoch, this means for example you can set month to 88, it just adds 88 months to the current date and time.
        cal.set(year, month-1, day, hour, minute);
        System.out.println("\nWITH USER INPUT: \nDATUM: "+cal.get(Calendar.YEAR)+" - "+cal.get(Calendar.DAY_OF_MONTH)+" - "+(cal.get(Calendar.MONTH)+1)+"\nTIJD: "+cal.get(Calendar.HOUR_OF_DAY)+" : "+cal.get(Calendar.MINUTE));

        //Parse Calendar object to Date object using Calendar's getTime method:
        Date calendarDate;
        calendarDate= cal.getTime();
        System.out.println(calendarDate);
/*
        //Overview of Calendar Fields:
        System.out.println("ERA "+cal.get(0));
        System.out.println("YEAR "+cal.get(1));
        System.out.println("MONTH (-1) "+cal.get(2));
        System.out.println("WEEK OF YEAR "+cal.get(3));
        System.out.println("WEEK OF MONTH "+cal.get(4));
        System.out.println("DAY OF MONTH "+cal.get(5));
        System.out.println("DAY OF YEAR "+cal.get(6));
        System.out.println("DAY OF WEEK "+cal.get(7));
        System.out.println("DAY OF WEEK IN MONTH "+cal.get(8));
        System.out.println("AM / PM "+cal.get(9));
        System.out.println("HOUR (12) "+cal.get(10));
        System.out.println("HOUR (24) "+cal.get(11));
        System.out.println("MINUTE "+cal.get(12));
        System.out.println("SECOND "+cal.get(13));
        System.out.println("MILISECOND "+cal.get(14));
        System.out.println("ZONE_OFFSET (?) "+cal.get(15));
        System.out.println("DST_OFFSET (wintertijd) "+cal.get(16));
        //System.out.println("Nr OF DISTINCT FIELDS "+cal.get(17));
*/
    }
}
