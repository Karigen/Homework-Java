package Unit07;

public class Homework05 {

    public static void main(String[] args) {

	SyncObj so = new SyncObj();

	Thread at = new Thread(new AddThread(so));
	Thread st = new Thread(new SubThread(so));

	at.start();
	st.start();
    }

}

class AddThread implements Runnable {

    private SyncObj x;

    public AddThread(SyncObj x) {
	this.x = x;
    }

    @Override
    public void run() {

	try {
	    Thread.sleep(1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	synchronized (x) {
	    x.notify();
	}
	
	for (int i = 0; i < 20; i++) {
	    add();
	}
    }

    private void add() {
	synchronized (x) {
	    x.value++;
	    System.out.print(x.value + " ");
	}
    }

}

class SubThread implements Runnable {

    private SyncObj x;

    public SubThread(SyncObj x) {
	this.x = x;
    }

    @Override
    public void run() {
	synchronized (x) {
	    try {
		x.wait();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}

	for (int i = 0; i < 20; i++) {
	    sub();
	}
    }

    private void sub() {
	synchronized (x) {
	    x.value--;
	    System.out.print(x.value + " ");
	}
    }

}

class SyncObj {
    int value = 0;
}