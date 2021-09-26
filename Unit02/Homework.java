package Unit02;

//import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.Date;

public class Homework {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	//var myFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//Date nationalDay=myFormat.parse("1949-10-01 15:00:00");
	//var thisNationalDay=myFormat.parse("2021-10-01 15:00:00");
	var cal1 = Calendar.getInstance();
	var cal2 = Calendar.getInstance();
	cal1.set(1949, 10, 1);
	cal2.set(2021, 10, 1);
	long millis=cal2.getTimeInMillis()-cal1.getTimeInMillis();
	
	//var millis=thisNationalDay.getMillisOf(thisNationalDay)-nationalDay.getMillisOf(nationalDay);
	long days=(millis/1000/3600/24);
	System.out.println("days:"+days);
    }

}

class MyDate{
    
}