package lab2.project2;

import java.util.Random;

/*
 * 开发一个多线程程序。
 * 1. 程序中有三个线程。
 * 2. 线程A和线程B分别休眠一个随机时间(不超过1秒)，然后各自产生一个随机字符(限制在'a'-'z');
 * 3. 线程C然后比较线程A和线程b产生的两个字符。
 *    产生较大字符(根据其ASCII码)的线程将得到2分，产生较小字符的线程将得到0分。
 *    如果两个字符相等，那么每个线程得到1分。
 * 4. 线程C以以下格式打印结果。您可以使用控制台或GUI作为程序的UI。最终结果:A(或B或None)为获胜者(提示:不需要打印表格框架)
 * 5. 重复步骤2 -步骤4至少3次(这意味着N不小于3)
 * 6. 最后，线程C分别比较线程A和线程B获得的总积分，以确定谁是赢家:A(或B或None)是赢家。
 * 7. 这三个线程中至少有一个必须继承自Thread类;三个线程中至少有一个必须实现Runnable接口。
 * 8. 您不允许使用默认主线程作为您的3个线程之一。也就是说，您必须显式地创建3个线程。
 * 9. 也许你需要使用一个或多个方法，例如:sleep();wait();notify();notifyall();join();等。
 */

public class Project2 {

    public static void main(String[] args) {
	Random random = new Random();// 资源复用避免浪费
	Server server = new Server(random);
	Client c1 = new Client(server, random);
	Thread t1 = new Thread(c1);
	Client c2 = new Client(server, random);
	Thread t2 = new Thread(c2);
	server.setC1(c1);
	server.setC2(c2);

	t1.start();
	t2.start();
	server.start();
    }

}

class Server extends Thread {// 后来发现原来还得是以服务端为主,客户端为辅,服务端NB

    private Random random;
    private boolean isRun;
    private Client c1;
    private Client c2;

    public Server(Random random) {
	this.random = random;
	this.isRun = true;
    }

    public boolean isRun() {
	return isRun;
    }

    public void setC1(Client c1) {
	this.c1 = c1;
    }

    public void setC2(Client c2) {
	this.c2 = c2;
    }

    @Override
    public void run() {
	int count = -1;
	while (count < 3) {
	    count = (int) (random.nextDouble() * 10);
	}

	System.out.println("\tThread A\t\t\t\tThread B");
	System.out.println("Round\tSleep\tRandom\t\tPoints\t\tSleep\tRandom\t\tPoints");
	System.out.println("\ttime\tcharacter\tobtained\ttime\tcharacter\tobtained");
	System.out.println("--------------------------------------------------------------------------------");

	for (int i = 0; i < count;) {
	    if (c1.isFinished() && c2.isFinished()) {
		i++;
		if (c1.getResult() > c2.getResult()) {
		    System.out.printf("%d\t%d\t%c\t\t%d\t\t", i, c1.getSleepTime(), c1.getResult(), 2);
		    c1.setScore(c1.getScore() + 2);
		    System.out.printf("%d\t%c\t\t%d\n", c2.getSleepTime(), c2.getResult(), 0);
		} else if (c1.getResult() < c2.getResult()) {
		    System.out.printf("%d\t%d\t%c\t\t%d\t\t", i, c1.getSleepTime(), c1.getResult(), 0);
		    System.out.printf("%d\t%c\t\t%d\n", c2.getSleepTime(), c2.getResult(), 2);
		    c2.setScore(c2.getScore() + 2);
		} else {
		    System.out.printf("%d\t%d\t%c\t\t%d\t\t", i, c1.getSleepTime(), c1.getResult(), 1);
		    c1.setScore(c1.getScore() + 1);
		    System.out.printf("%d\t%c\t\t%d\n", c2.getSleepTime(), c2.getResult(), 1);
		    c2.setScore(c2.getScore() + 1);
		}

		c1.setFinished(false);
		c2.setFinished(false);
		synchronized (this) {
		    this.notifyAll();
		}
	    } else {
		try {
		    Thread.sleep(250);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}

	isRun = false;

	// 为什么注释掉也会客户端线程也会结束?--偶然性(但是概率较大),为了以防万一,就留着吧
	synchronized (this) {
	    this.notifyAll();
	}

	System.out.println("--------------------------------------------------------------------------------");

	// 输出最终结果
	if (c1.getScore() > c2.getScore()) {
	    System.out.println("A is the winner");
	} else if (c1.getScore() < c2.getScore()) {
	    System.out.println("B is the winner");
	} else {
	    System.out.printf("%d : %d draw", c1.getScore(), c2.getScore());
	}
    }

}

class Client implements Runnable {

    private Server server;
    private Random random;
    private char result;
    private boolean isFinished;
    private int score;
    private long sleepTime;

    public Client(Server server, Random random) {
	this.server = server;
	this.random = random;
	this.result = '\u0000';
	this.isFinished = false;
	this.score = 0;
	this.sleepTime = -1;
    }

    public char getResult() {
	return result;
    }

    public boolean isFinished() {
	return isFinished;
    }

    public void setFinished(boolean isFinished) {
	this.isFinished = isFinished;
    }

    public int getScore() {
	return score;
    }

    public void setScore(int score) {
	this.score = score;
    }

    public long getSleepTime() {
	return sleepTime;
    }

    @Override
    public void run() {
	while (server.isRun()) {
	    try {
		sleepTime = random.nextInt(1000);
		Thread.sleep(sleepTime);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	    result = (char) (random.nextInt(26) + 'a');
	    isFinished = true;

	    synchronized (server) {
		try {
		    server.wait();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

}