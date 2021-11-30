package Unit07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Homework00 {

    public static void main(String[] args) {
//	printChar();
//	printNum();

//	PrintChar pc = new PrintChar();
//	PrintNum pn = new PrintNum();

//	pc.start();
//	pn.start();

//	try {
//	    pc.join();
//	    pn.join();
//	} catch (InterruptedException e) {
//	    e.printStackTrace();
//	}

//	pc.setPn(pn);
//	pn.setPc(pc);
//	
//	pc.start();
//	pn.start();
	
	//Õ–π‹-- ÷∂Ø
//	ExecutorService executor = Executors.newCachedThreadPool();
//	executor.execute(pc);
//	executor.execute(pn);
//	executor.shutdown();

//	System.out.println();
//	System.out.println("Main is over");
    }

    public static void printChar() {
	for (int i = 0; i < 26; i++) {
	    System.out.print((char) ('a' + i) + " ");
	}
    }

    public static void printNum() {
	for (int i = 0; i < 26; i++) {
	    System.out.print((1 + i) + " ");
	}
    }

}

//class PrintChar extends Thread {
//
//    private PrintNum pn;
//
//    @Override
//    public void run() {
//	for (int i = 0; i < 26; i++) {
//	    System.out.print((char) ('a' + i) + " ");
//
//	    if (i == 'o' - 'a') {
//		Thread.yield();
//	    }
//	}
//    }
//
//    public void setPn(PrintNum pn) {
//	this.pn = pn;
//    }
//
//}

//class PrintNum extends Thread {
//
//    private PrintChar pc;
//
//    @Override
//    public void run() {
//	for (int i = 0; i < 26; i++) {
//	    System.out.print((1 + i) + " ");
//
//	    if (i == 19) {
//		try {
//		    pc.join();
//		} catch (InterruptedException e) {
//		    e.printStackTrace();
//		}
//	    }
//	}
//    }
//
//    public void setPc(PrintChar pc) {
//	this.pc = pc;
//    }
//
//}

//class SyncObj{}