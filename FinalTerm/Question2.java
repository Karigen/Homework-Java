package FinalTerm;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 2.
 * 用下面的指令写一个程序:
 * 1)用TCP socket写一个客户端程序，它向服务器发送一个String对象，其中包含“Hello World!”，然后退出。
 * 	注意使用异常处理。
 * 	不需要线程。
 * 2)用TCP socket编写多线程服务器程序。
 * 	服务器监听端口为8000。
 * 	当客户端连接到服务器时，服务器会创建一个新线程来服务客户端。
 * 	在线程中，程序接收String对象并将该对象保存在一个名为“String .dat”的文件中。
 * 请注意，当多个线程写入同一个文件时，需要对这些线程进行同步以避免错误。
 */

public class Question2 {

    public static void main(String[] args) {

    }

}

class Server implements Runnable {
    private ServerSocket serverSocket;

    public Server() throws IOException {
	this(new ServerSocket(8000));
    }

    public Server(ServerSocket serverSocket) {
	super();
	this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
	while (true) {
	    final Socket socket;
	    try {
		socket = serverSocket.accept();
		new Thread() {
		    public void run() {
			InputStream is = null;
			FileOutputStream fos = null;
			synchronized (this) {
			    try {
				is = socket.getInputStream();
				byte[] buffer = new byte[1024];
				int len = -1;
				fos = new FileOutputStream("text.txt");
				while ((len = is.read(buffer)) != -1) {
				    fos.write(buffer, 0, len);
				}
				fos.flush();
			    } catch (IOException e) {
				e.printStackTrace();
			    } finally {
				if (fos != null) {
				    try {
					fos.close();
				    } catch (IOException e) {
					e.printStackTrace();
				    }
				}

				if (is != null) {
				    try {
					is.close();
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
		}.start();
	    } catch (IOException e1) {
		e1.printStackTrace();
	    }
	}
    }

}

class Client {
    private Socket socket;

    public Client() throws UnknownHostException, IOException {
	this(new Socket("127.0.0.1", 8000));
    }

    public Client(Socket socket) {
	super();
	this.socket = socket;
    }

    public void send(String message) {
	DataOutputStream dos = null;
	try {
	    dos = new DataOutputStream(socket.getOutputStream());
	    dos.writeUTF(message);
	    dos.flush();
	    socket.shutdownOutput();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (dos != null) {
		try {
		    dos.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
    }
}