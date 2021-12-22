package lab2.project3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;

public class Client {

    public static void main(String[] args) {
	Thread kidA = new Thread(new KidA());
	Thread kidB = new Thread(new KidB());
	kidA.start();
	kidB.start();
    }

}

class KidA implements Runnable {

    public KidA() {

    }

    @Override
    public void run() {
	Socket socket = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	String[] choice = { "石头", "剪刀", "布" };
	Random random = new Random();

	try {
	    socket = new Socket("127.0.0.1", 6666);
	    dis = new DataInputStream(socket.getInputStream());
	    dos = new DataOutputStream(socket.getOutputStream());

	    while (true) {
		String option = dis.readUTF();
		if ("开始".equals(option)) {
		    dos.writeUTF(choice[random.nextInt(3)]);
		} else {
		    break;
		}
	    }

	    socket.shutdownOutput();

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
	}
    }

}

class KidB implements Runnable {

    public KidB() {

    }

    @Override
    public void run() {
	DatagramSocket datagramSocket = null;
	DatagramPacket sendPacket = null;
	DatagramPacket receivePacket = null;
	String[] choice = { "石头", "剪刀", "布" };
	Random random = new Random();

	try {
	    datagramSocket = new DatagramSocket(8888);

	    while (true) {
		receivePacket = new DatagramPacket(new byte[1024], 1024);
		datagramSocket.receive(receivePacket);
		String option = new String(receivePacket.getData(), 0, receivePacket.getLength());
		if ("开始".equals(option)) {
		    String res = choice[random.nextInt(3)];
		    sendPacket = new DatagramPacket(res.getBytes(), 0, res.getBytes().length,
			    new InetSocketAddress("127.0.0.1", 7777));
		    datagramSocket.send(sendPacket);
		} else {
		    break;
		}
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (datagramSocket != null) {
		datagramSocket.close();
	    }
	}
    }

}