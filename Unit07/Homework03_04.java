package Unit07;

public class Homework03_04 {

    public static void main(String[] args) {
//	printChar();
//
//	System.out.println();
//
//	printNum();

	PrintChar pc = new PrintChar();
	Thread pn = new Thread(new PrintNum(pc));

	pc.start();
	pn.start();
    }

//    public static void printChar() {
//	for (int i = 0; i < 26; i++) {
//	    System.out.print((char) ('a' + i) + " ");
//	}
//    }
//
//    public static void printNum() {
//	for (int i = 0; i < 26; i++) {
//	    System.out.print(1 + i + " ");
//	}
//    }

}

class PrintChar extends Thread {

    @Override
    public void run() {
	for (int i = 0; i < 26; i++) {
	    System.out.print((char) ('a' + i) + " ");

	    // After thread1 prints 'o', it yields to thread2
	    if ('o' == 'a' + i) {
		Thread.yield();
	    }
	}
    }
}

class PrintNum implements Runnable {

    private PrintChar pc;

    public PrintNum(PrintChar pc) {
	this.pc = pc;
    }

    @Override
    public void run() {
	for (int i = 0; i < 26; i++) {
	    System.out.print(1 + i + " ");

	    // After thread2 prints number 20, it waits to join thread1
	    if (20 == 1 + i) {
		try {
		    pc.join();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

}