package lab2.project3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
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
	InetSocketAddress dest = new InetSocketAddress("127.0.0.1", 8888);
	String[] choice = { "ʯͷ", "����", "��" };
	Map<String, String> choices = new HashMap<String, String>();
	choices.put("ʯͷ", "rock\t");
	choices.put("����", "scissors");
	choices.put("��", "paper\t");
	int scoreA = 0;
	int scoreB = 0;

	try {
	    serverSocket = new ServerSocket(6666);
	    datagramSocket = new DatagramSocket(7777);
	    socket = serverSocket.accept();
	    dis = new DataInputStream(socket.getInputStream());
	    dos = new DataOutputStream(socket.getOutputStream());

	    // ����
	    Random random = new Random();
	    int count = 1;
	    while (count < 3) {
		count = (int) (random.nextDouble() * 10);
	    }

	    System.out.println("\tThread A\t\t\t\tThread B");
	    System.out.println("Round\tSleep\tRandom\t\tPoints\t\tSleep\tRandom\t\tPoints");
	    System.out.println("\ttime\tselection\tobtained\ttime\tselection\tobtained");
	    System.out.println("--------------------------------------------------------------------------------");

	    for (int i = 0; i < count;) {
		dos.writeUTF("��ʼ");
		sendPacket = new DatagramPacket("��ʼ".getBytes(), 0, "��ʼ".getBytes().length, dest);
		datagramSocket.send(sendPacket);
		receivePacket = new DatagramPacket(new byte[1024], 1024);

		String kidASleepTime = dis.readUTF();
		datagramSocket.receive(receivePacket);
		String kidBSleepTime = new String(receivePacket.getData(), 0, receivePacket.getLength());
		receivePacket = new DatagramPacket(new byte[1024], 1024);

		String kidA = dis.readUTF();
		datagramSocket.receive(receivePacket);
		String kidB = new String(receivePacket.getData(), 0, receivePacket.getLength());

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

		i++;

		// �Ƚ�
		if (resA == resB) {// ƽ��
		    System.out.printf("%d\t%sms\t%s\t%d\t\t%sms\t%s\t%d\n", i, kidASleepTime, choices.get(kidA), 1,
			    kidBSleepTime, choices.get(kidB), 1);
		    scoreA += 1;
		    scoreB += 1;
		} else if (resA == (resB - 1 + choice.length) % 3) {// AӮ
		    System.out.printf("%d\t%sms\t%s\t%d\t\t%sms\t%s\t%d\n", i, kidASleepTime, choices.get(kidA), 2,
			    kidBSleepTime, choices.get(kidB), 0);
		    scoreA += 2;
		} else {// BӮ
		    System.out.printf("%d\t%sms\t%s\t%d\t\t%sms\t%s\t%d\n", i, kidASleepTime, choices.get(kidA), 0,
			    kidBSleepTime, choices.get(kidB), 2);
		    scoreB += 2;
		}
	    }

	    // ���ͽ�����־
	    dos.writeUTF("����");
	    sendPacket = new DatagramPacket("����".getBytes(), 0, "����".getBytes().length, dest);
	    datagramSocket.send(sendPacket);

	    // shutdown?
	    dos.flush();
	    socket.shutdownOutput();

	    System.out.println("--------------------------------------------------------------------------------");

	    // ���
	    if (scoreA > scoreB) {
		System.out.println("A is the winner");
	    } else if (scoreA < scoreB) {
		System.out.println("B is the winner");
	    } else {
		System.out.printf("%d : %d draw", scoreA, scoreB);
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
