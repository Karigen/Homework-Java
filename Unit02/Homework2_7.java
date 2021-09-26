package Unit02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework2_7 {

    public static void main(String[] args) throws ParseException {
	var myFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	Date nationalDay=myFormat.parse("1949-10-01 10:00:00");
	System.out.println("nationalDay:"+nationalDay);
    }

}
