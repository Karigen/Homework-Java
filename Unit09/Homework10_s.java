package Unit09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//interface Constants {
//    public static int PORT = 6666;
//}

public class Homework10_s {// implements Constants {

    public static void main(String[] args) throws Exception {
	// 此处为服务器监听的端口号
	ServerSocket ss = new ServerSocket(6666);
	Socket s = ss.accept();// 本机接收socket连接时是随机分配一个端口的
	//服务端发送数据时通过ServerSocket发送
	DataInputStream dis = new DataInputStream(s.getInputStream());
	System.out.println(dis.readDouble());
	
//	DataOutputStream dos=new DataOutputStream(s.getOutputStream());
//	dos.writeChar('b');
//	System.out.println("s:" + s.getPort());

	Thread.sleep(1000);

	dis.close();
	s.close();
	ss.close();
    }

//    public static void main(String[] args) throws Exception {
//	ServerSocket ss = new ServerSocket(PORT);
//
//	System.out.println("Listening");
//	
//	while (true) {
//	    Socket s = ss.accept();
//	    new Thread(()->{
//		System.out.println(s.getInetAddress().toString() + s.getPort());
//
//    		while(true){}//放读取和输出
//		DataInputStream dis;
//		try {
//		    dis = new DataInputStream(s.getInputStream());
//		    System.out.println(dis.readDouble());
//		} catch (IOException e) {
//		    // TODO 自动生成的 catch 块
//		    e.printStackTrace();
//		}
//	    }).start();
//	}	
//    }

}
