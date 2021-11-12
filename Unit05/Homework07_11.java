package Unit05;

import java.util.Scanner;

public class Homework07_11 {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	double dividend = scanner.nextDouble();// 被除数
	double divisor = scanner.nextDouble();// 除数
//
//	if (divisor == 0) {
//	    throw new ArithmeticException();
//	}
//
	try {
	    System.out.println(dividend + " / " + divisor + " = " + division(dividend, divisor));
	} catch (MyException e) {
	    // TODO: handle exception
	    System.out.println(e.getMessage());

	    dividend = setDividend(scanner);

	    System.out.println(dividend + " / " + divisor + " = " + division(dividend, divisor));
	} catch (ArithmeticException e) {
	    // TODO: handle exception
	    System.out.println(e.getMessage());
	} finally {
	    System.out.println("the division is over");
	}
    }

    public static double division(double dividend, double divisor) {
	if (dividend == 0) {
	    throw new MyException("the dividend is 0");
	}

	return dividend / divisor;
    }

    public static double setDividend(Scanner scanner) {
	double newDividend = scanner.nextDouble();

	assert newDividend != 0 : "newDividend can't be 0";

	return newDividend;
    }

}

class MyException extends ArithmeticException {
    private String note;

    public MyException() {
	// TODO 自动生成的构造函数存根
    }

    public MyException(String message) {
	// TODO 自动生成的构造函数存根
	super(message);
	this.note = message;
    }
}
