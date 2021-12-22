package Unit09;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Homework14_s {

    public static void main(String[] args) throws Exception {
	DatagramSocket ds = new DatagramSocket(6666);
	byte[] buf = new byte[1024];
	DatagramPacket rdp = new DatagramPacket(buf, 0, buf.length);
	ds.receive(rdp);
	System.out.println(Double.parseDouble(new String(rdp.getData())));
	DatagramPacket sdp = new DatagramPacket(rdp.getData(), 0, rdp.getLength(),
		new InetSocketAddress(rdp.getAddress(), rdp.getPort()));
	ds.send(sdp);

	Thread.sleep(1000);

	ds.close();
    }

}
