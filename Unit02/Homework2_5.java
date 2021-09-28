package Unit02;

import java.util.Scanner;

public class Homework2_5 {

    public static void main(String[] args) {
	var guessNumber=new GuessNumber1();
	System.out.println("generate number");
	var g=guessNumber.generateNumber();
	System.out.println("input a number:");
	var m=guessNumber.getNumber();
	
	if (m<g) {
	    System.out.println("smaller");
	} else if(m>g) {
	    System.out.println("bigger");
	} else {
	    System.out.println("bingo");
	}
    }

}

class GuessNumber1{
    
    public GuessNumber1() {
	
    }
    
    public int generateNumber() {
	int number=(int)(Math.round(Math.random()*10));
	return number;
    }
    
    public int getNumber() {
	var scanner =new Scanner(System.in);
	int g=scanner.nextInt();
	scanner.close();
	return g;
    }
}