package Unit02;

import java.util.Calendar;

public class Homework2_8 {

    public static void main(String[] args) {
	var cal1 = Calendar.getInstance();
	var cal2 = Calendar.getInstance();
	cal1.set(1949, 10, 1);
	cal2.set(2021, 10, 1);
	long millis=cal2.getTimeInMillis()-cal1.getTimeInMillis();
	
	long days=(millis/1000/3600/24);
	System.out.println("days:"+days);
    }

}
