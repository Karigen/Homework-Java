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
	// �˴�Ϊ�����������Ķ˿ں�
	ServerSocket ss = new ServerSocket(6666);
	Socket s = ss.accept();// ��������socket����ʱ���������һ���˿ڵ�
	//����˷�������ʱͨ��ServerSocket����
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
//    		while(true){}//�Ŷ�ȡ�����
//		DataInputStream dis;
//		try {
//		    dis = new DataInputStream(s.getInputStream());
//		    System.out.println(dis.readDouble());
//		} catch (IOException e) {
//		    // TODO �Զ����ɵ� catch ��
//		    e.printStackTrace();
//		}
//	    }).start();
//	}	
//    }

}
