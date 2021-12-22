package Unit09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework13_s {

    public static void main(String[] args) throws Exception {
	ServerSocket ss = new ServerSocket(6666);
//	Socket s = ss.accept();
//	DataInputStream dis = new DataInputStream(s.getInputStream());
//	System.out.println(dis.readDouble());
	for (int i = 0; i < 100; i++) {
	    Thread.sleep(3000);
	    new Thread(new NetThread(ss.accept())).start();
	}
	
	Thread.sleep(1000);

//	dis.close();
//	s.close();
	ss.close();
    }

}

class NetThread implements Runnable{
    
    private Socket socket=null;
    
    public NetThread(Socket socket) {
	this.socket=socket;
    }

    @Override
    public void run() {
	DataInputStream dis=null;
	DataOutputStream dos=null;
	try {
	    dis=new DataInputStream(socket.getInputStream());
	    dos=new DataOutputStream(socket.getOutputStream());
	    double num=dis.readDouble();
//	    System.out.println(num);
	    dos.writeUTF(String.valueOf(num));
	} catch (IOException e) {
	    e.printStackTrace();
	    System.out.println(e.getMessage());
	} finally {
	    if (dos != null) {
		try {
		    dos.close();
		} catch (IOException e) {
		    // TODO 自动生成的 catch 块
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