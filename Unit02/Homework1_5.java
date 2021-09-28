package Unit02;

public class Homework1_5 {

    public static void main(String[] args) {
	MyClass1.main(null);
    }

}

class MyClass1 {
    private int one=1;
    private static int two=2;
    
    public static void main(String[] args) {
	MyClass1 m1=new MyClass1();
	System.out.println("one is "+m1.one);
	System.out.println("two is "+two);
    }
}