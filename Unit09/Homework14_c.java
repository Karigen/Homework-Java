package Unit09;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Homework14_c {

    public static void main(String[] args) throws Exception {
	DatagramSocket ds = new DatagramSocket(5555);
	byte[] buf = "3.14".getBytes();
	DatagramPacket sdp = new DatagramPacket(buf, 0, buf.length, new InetSocketAddress("127.0.0.1", 6666));
	ds.send(sdp);
	DatagramPacket rdp = new DatagramPacket(buf, 0, buf.length);
	ds.receive(rdp);
	System.out.println(new String(rdp.getData()));

	Thread.sleep(1000);

	ds.close();
    }

}
