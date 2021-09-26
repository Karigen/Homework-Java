package Unit02;

import java.util.Scanner;

public class Homework2_12 {

    public static void main(String[] args) {

    }

}

class GuessNumber4{
    
    int counter=0;
    
    static int numberOfObjects=0;
    
    public GuessNumber4() {
	numberOfObjects++;
    }
    
    public GuessNumber4(int i) {
	numberOfObjects++;
    }
    
    public GuessNumber4(char c) {
	this(1);
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