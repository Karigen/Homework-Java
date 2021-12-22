package Unit09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Homework10_c {// implements Constants {

    //Socket对象存储对方信息
    public static void main(String[] args) throws Exception {
	// 此处为服务方的IP地址和端口号
	Socket s = new Socket("localhost", 6666);// 目标主机IP和port,发送时是随机本机port
	
	DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	dos.writeDouble(456);
	
//	DataInputStream dis=new DataInputStream(s.getInputStream());
//	System.out.println(dis.readChar());
//	System.out.println("c:" + s.getPort());

	Thread.sleep(1000);

	dos.close();
	s.close();
    }

//    public static void main(String[] args) throws Exception {
//	Socket s = new Socket("localhost", PORT);
//
//	System.out.println(s);
//
//	DataOutputStream dos = new DataOutputStream(s.getOutputStream());
//
//	while (true) {
//	    dos.writeDouble(99.99);
//	    Thread.sleep(1000);
//	}
//    }

}
