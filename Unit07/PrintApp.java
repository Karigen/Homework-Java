package Unit07;

public class PrintApp {
    SyncObj syncObj = new SyncObj();

    public static void main(String[] args) {
	var printApp = new PrintApp();

	// var printCharThread = new PrintCharThread();
	// var t = new PrintNumThread();
	// var printNumThread = new Thread(t);
	//
	// printCharThread.start();
	// printNumThread.start();
	// var executor = Executors.newCachedThreadPool();
	var charThread = printApp.new PrintCharThread();
	var numThread = printApp.new PrintNumThread();
	
//	var charThread = new PrintApp().PrintCharThread();
//	var numThread = new PrintApp().PrintNumThread();
	
//	var charThread = new printApp.PrintCharThread();
//	var numThread = new printApp.PrintNumThread();
//	
//	var charThread = new PrintApp.PrintCharThread();
//	var numThread = new PrintApp.PrintNumThread();

	charThread.setNumThread(numThread);
	charThread.start();
	numThread.start();
	// executor.execute(charThread);
	// executor.execute(numThread);
	// executor.shutdownNow();
	System.out.println("Main finished!");

    }

    class SyncObj {
    }

    // Method 1: Inherit from Thread class
    class PrintCharThread extends Thread {
	PrintNumThread numThread = null;

	public void setNumThread(PrintNumThread numThread) {
	    this.numThread = numThread;
	}

	@Override
	public void run() {
	    try {
		Thread.sleep(1000);
		syncObj.notify();
		printChar();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}

	private void printChar() throws InterruptedException {
	    for (int i = 0; i < 26; i++) {
		System.out.print((char) ('a' + i) + " ");
		if (i == 'o' - 'a') {
		    numThread.join();
		}
	    }
	}
    }

    // Method 2: [x]implement Runnable interface, 只有thread类才有join()函数
    class PrintNumThread extends Thread {
	@Override
	public void run() {
	    try {
		syncObj.wait();
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    printNum();
	}

	private void printNum() {
	    for (int i = 0; i < 26; i++) {
		System.out.print(i + 1 + " ");
	    }
	}
    }
}