package lab2.project3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server implements Runnable {

    public Server() {

    }

    public static void main(String[] args) throws Exception {
	Thread server = new Thread(new Server());
	server.start();
    }

    @Override
    public void run() {
	ServerSocket serverSocket = null;
	DatagramSocket datagramSocket = null;
	Socket socket = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	DatagramPacket sendPacket = null;
	DatagramPacket receivePacket = null;
	String[] choice = { "石头", "剪刀", "布" };
	int scoreA = 0;
	int scoreB = 0;

	try {
	    serverSocket = new ServerSocket(6666);
	    datagramSocket = new DatagramSocket(7777);
	    socket = serverSocket.accept();
	    dis = new DataInputStream(socket.getInputStream());
	    dos = new DataOutputStream(socket.getOutputStream());

	    // 接收
	    Random random = new Random();
	    int count = 1;
	    while (count < 3) {
		count = (int) (random.nextDouble() * 10);
	    }

	    for (int i = 0; i < count;) {
		dos.writeUTF("开始");
		sendPacket = new DatagramPacket("开始".getBytes(), 0, "开始".getBytes().length,
			new InetSocketAddress("127.0.0.1", 8888));
		datagramSocket.send(sendPacket);
		receivePacket = new DatagramPacket(new byte[1024], 1024);

		datagramSocket.receive(receivePacket);
		String kidB = new String(receivePacket.getData(), 0, receivePacket.getLength());
		String kidA = dis.readUTF();

		int resA = -1;
		int resB = -1;
		for (int j = 0; j < choice.length; j++) {
		    if (choice[j].equals(kidA)) {
			resA = j;
		    }
		}
		for (int j = 0; j < choice.length; j++) {
		    if (choice[j].equals(kidB)) {
			resB = j;
		    }
		}

		// 比较
		if (resA == resB) {// 平手
		    System.out.printf("KidA出:%s\tKidB出:%s\tscoreA:%d\tscoreB:%d\t", kidA, kidB, 1, 1);
		    System.out.println();
		    scoreA += 1;
		    scoreB += 1;
		} else if (resA == (resB - 1 + choice.length) % 3) {// A赢
		    System.out.printf("KidA出:%s\tKidB出:%s\tscoreA:%d\tscoreB:%d\t", kidA, kidB, 2, 0);
		    System.out.println();
		    scoreA += 2;
		    scoreB += 0;
		} else {// B赢
		    System.out.printf("KidA出:%s\tKidB出:%s\tscoreA:%d\tscoreB:%d\t", kidA, kidB, 0, 2);
		    System.out.println();
		    scoreA += 0;
		    scoreB += 2;
		}
		i++;
	    }

	    // 发送结束标志
	    dos.writeUTF("结束");
	    sendPacket = new DatagramPacket("结束".getBytes(), 0, "结束".getBytes().length,
		    new InetSocketAddress("127.0.0.1", 8888));
	    datagramSocket.send(sendPacket);

	    // shutdown?
	    socket.shutdownOutput();

	    // 输出
	    if (scoreA > scoreB) {
		System.out.println("Kid A获胜");
	    } else if (scoreA < scoreB) {
		System.out.println("Kid B获胜");
	    } else {
		System.out.println("平手");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (dos != null) {
		try {
		    dos.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }

	    if (dis != null) {
		try {
		    dis.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }

	    if (socket != null) {
		try {
		    socket.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }

	    if (datagramSocket != null) {
		datagramSocket.close();
	    }

	    if (serverSocket != null) {
		try {
		    serverSocket.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

}
