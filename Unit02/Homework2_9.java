package Unit02;

import java.util.Scanner;

public class Homework2_9 {

    public static void main(String[] args) {
	GuessNumber2 g=new GuessNumber2();
	System.out.println("counter is "+g.counter);
    }

}

class GuessNumber2{
    
    int counter=0;
    
    public GuessNumber2() {
	
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