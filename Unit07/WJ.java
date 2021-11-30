//package Unit07;
//
//public class WJ {
//    static SyncObj syncObj = new SyncObj();
//
//    public static void main(String[] args) {
//
//	WJ printApp = new WJ();
//
//	PrintCharThread2 charThread = printApp.new PrintCharThread2();
//	PrintNumThread2 numThread = printApp.new PrintNumThread2();
//
//	charThread.setNumThread1(numThread);
//	charThread.start();
//	numThread.start();
//
//	System.out.println("Hello");
//	
//	try {
//	    Thread.sleep(1000);
//	} catch (InterruptedException e) {
//	    // TODO 自动生成的 catch 块
//	    e.printStackTrace();
//	}
//	
//	try {
//	    syncObj.notify();
//	} catch (Exception e) {
//	    // TODO 自动生成的 catch 块
//	    e.printStackTrace();
//	}
//
//    }
//
//    // 做一个同步对象
//    class SyncObj {
//
//    }
//
//    class PrintCharThread2 extends Thread {
//	PrintNumThread2 numThread1 = null;
//
//	public void setNumThread1(PrintNumThread2 numThread1) {
//	    this.numThread1 = numThread1;
//	}
//
//	@Override
//	public void run() {
//	    try {
//		Thread.sleep(1000);
//		PrintChar();
//	    } catch (InterruptedException e) {
//		e.printStackTrace();
//	    }
//
//	    synchronized (syncObj) {
//		syncObj.notify();
//	    }
//
//	}
//
//	private void PrintChar() throws InterruptedException {
//	    for (int i = 0; i < 26; i++) {
//		System.out.print((char) ('a' + i) + " ");
//		if (i == 'o' - 'a') {
//		    numThread1.join();
//		}
//	    }
//	    System.out.println();
//	}
//    }
//
//    class PrintNumThread2 extends Thread {
//	@Override
//	public void run() {
//	    synchronized (syncObj) {
//		try {
//		    syncObj.wait();
//		} catch (InterruptedException e) {
//		    e.printStackTrace();
//		}
//		PrintNum();
//	    }
//
//	}
//
//	private void PrintNum() {
//	    for (int i = 1; i <= 26; i++)
//		System.out.print(i + " ");
//	    System.out.println();
//	}
//    }
//
//}