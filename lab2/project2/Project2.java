package lab2.project2;

import java.util.Random;

/*
 * ����һ�����̳߳���
 * 1. �������������̡߳�
 * 2. �߳�A���߳�B�ֱ�����һ�����ʱ��(������1��)��Ȼ����Բ���һ������ַ�(������'a'-'z');
 * 3. �߳�CȻ��Ƚ��߳�A���߳�b�����������ַ���
 *    �����ϴ��ַ�(������ASCII��)���߳̽��õ�2�֣�������С�ַ����߳̽��õ�0�֡�
 *    ��������ַ���ȣ���ôÿ���̵߳õ�1�֡�
 * 4. �߳�C�����¸�ʽ��ӡ�����������ʹ�ÿ���̨��GUI��Ϊ�����UI�����ս��:A(��B��None)Ϊ��ʤ��(��ʾ:����Ҫ��ӡ�����)
 * 5. �ظ�����2 -����4����3��(����ζ��N��С��3)
 * 6. ����߳�C�ֱ�Ƚ��߳�A���߳�B��õ��ܻ��֣���ȷ��˭��Ӯ��:A(��B��None)��Ӯ�ҡ�
 * 7. �������߳���������һ������̳���Thread��;�����߳���������һ������ʵ��Runnable�ӿڡ�
 * 8. ��������ʹ��Ĭ�����߳���Ϊ����3���߳�֮һ��Ҳ����˵����������ʽ�ش���3���̡߳�
 * 9. Ҳ������Ҫʹ��һ����������������:sleep();wait();notify();notifyall();join();�ȡ�
 */

public class Project2 {

    public static void main(String[] args) {
	Random random = new Random();// ��Դ���ñ����˷�
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

class Server extends Thread {// ��������ԭ���������Է����Ϊ��,�ͻ���Ϊ��,�����NB

    private Random random;//
    public boolean isRun;
    private Client c1;
    private Client c2;

    public Server(Random random) {
	this.random = random;
	this.isRun = true;
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

	for (int i = 0; i < count;) {
	    if (c1.isFinished && c2.isFinished) {
		if (c1.result > c2.result) {
		    System.out.printf("c1:˯��ʱ��:%d\t�ַ�:%c\t�÷�:%d\t", c1.sleepTime, c1.result, 2);
		    c1.score += 2;
		    System.out.printf("c2:˯��ʱ��:%d\t�ַ�:%c\t�÷�:%d\t", c2.sleepTime, c2.result, 0);
		    c2.score += 0;// ����
		    System.out.println();// ����
		    i++;
		} else if (c1.result < c2.result) {
		    System.out.printf("c1:˯��ʱ��:%d\t�ַ�:%c\t�÷�:%d\t", c1.sleepTime, c1.result, 0);
		    c1.score += 0;// ����
		    System.out.printf("c2:˯��ʱ��:%d\t�ַ�:%c\t�÷�:%d\t", c2.sleepTime, c2.result, 2);
		    c2.score += 2;
		    System.out.println();// ����
		    i++;
		} else {
		    System.out.printf("c1:˯��ʱ��:%d\t�ַ�:%c\t�÷�:%d\t", c1.sleepTime, c1.result, 1);
		    c1.score += 1;
		    System.out.printf("c2:˯��ʱ��:%d\t�ַ�:%c\t�÷�:%d\t", c2.sleepTime, c2.result, 1);
		    c2.score += 1;
		    System.out.println();// ����
		    i++;
		}

		c1.isFinished = false;
		c2.isFinished = false;
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

	// Ϊʲôע�͵�Ҳ��ͻ����߳�Ҳ�����?--żȻ��(���Ǹ��ʽϴ�),Ϊ���Է���һ,�����Ű�
	synchronized (this) {
	    this.notifyAll();
	}

	// ������ս��
	if (c1.score > c2.score) {
	    System.out.println("ʤ������c1");
	} else if (c1.score < c2.score) {
	    System.out.println("ʤ������c2");
	} else {
	    System.out.println("ƽ����");
	}
    }

}

class Client implements Runnable {

    private Server server;
    private Random random;//
    public char result;//
    public boolean isFinished;
    public int score;//
    public long sleepTime;

    public Client(Server server, Random random) {
	this.server = server;
	this.random = random;
	this.result = '\u0000';
	this.isFinished = false;
	this.score = 0;
	this.sleepTime = -1;
    }

    @Override
    public void run() {
	while (server.isRun) {
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