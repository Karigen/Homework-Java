package Unit01;

public class Homework08 {

    public static void main(String[] args) {
	dataType(3.5);
	dataType(3.50);
	dataType(0.0);
	dataType(0);
	dataType(0.);
	dataType(3d);
	dataType(3f);
	dataType('c');
    }
    public static void dataType(int i) {
	System.out.println("int:"+i);
    }
    
    public static void dataType(float f) {
	System.out.println("float:"+f);
    }
    
    public static void dataType(double d) {
	System.out.println("double:"+d);
    }
    
    public static void dataType(char c) {
	System.out.println("char:"+c);
    }
}
