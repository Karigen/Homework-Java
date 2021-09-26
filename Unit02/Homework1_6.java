package Unit02;

import java.util.Scanner;

public class Homework1_6 {

    public static void main(String[] args) {
	MainClass.main(null);
    }

}

class Myclass2 {
    private int one=1;
    private static int two=2;
    
    public int getOne() {
        return one;
    }
    
    public void setOne(int one) {
        this.one = one;
    }
    
    public static int getTwo() {
        return two;
    }
    
    public static void setTwo(int two) {
        Myclass2.two = two;
    }
}

class MainClass{
    public static void main(String[] args) {
	Myclass2 m2=new Myclass2();
	
	Scanner scanner=new Scanner(System.in);
	
	m2.setOne(scanner.nextInt());
	Myclass2.setTwo(scanner.nextInt());
	
	System.out.println("one is "+m2.getOne());
	System.out.println("two is "+Myclass2.getTwo());
	
	scanner.close();
    }
}