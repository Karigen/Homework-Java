package Unit02;

import java.util.Scanner;

public class Homework2_11 {

    public static void main(String[] args) {
	System.out.println("numberOfObjects is "+GuessNumber3.numberOfObjects);
    }

}

class GuessNumber3{
    
    int counter=0;
    
    static int numberOfObjects=0;
    
    public GuessNumber3() {
	numberOfObjects++;
    }
    
    public int generateNumber() {
	int number=(int)(Math.round(Math.random()*10));
	return number;
    }
    
    public int getNumber() {
	var scanner =new Scanner(System.in);
	int x=scanner.nextInt();
	scanner.close();
	counter++;
	return x;
    }
}