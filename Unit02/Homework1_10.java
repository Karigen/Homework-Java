package Unit02;

import java.lang.reflect.Field;

public class Homework1_10 {

    public static void main(String[] args) {
	
	int i1=1,i2=2;
	
	System.out.println("before");
	System.out.println("i1="+i1);
	System.out.println("i2="+i2);
	
	swap(i1, i2);
	
	System.out.println("after");
	System.out.println("i1="+i1);
	System.out.println("i2="+i2);
	
	
	
	Integer I1=1,I2=2;
	
	System.out.println("before");
	System.out.println("I1="+I1);
	System.out.println("I2="+I2);
	
	swap2(I1, I2);
	
	System.out.println("after");
	System.out.println("I1="+I1);
	System.out.println("I2="+I2);
    }
    
    public static void swap(int i1, int i2) {
	int temp=i1;
	i1=i2;
	i2=temp;
    }
    
    //´óÎí--´«Öµ
    public static void swap1(Integer I1, Integer I2) {
	Integer temp=I1;
	I1=I2;
	I2=temp;
    }
    
    public static void swap2(Integer I1, Integer I2) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int temp = I1;
            field.setInt(I1, I2);
            field.setInt(I2, temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
