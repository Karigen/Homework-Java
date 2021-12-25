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
 * �������ָ��дһ������:
 * 1)��TCP socketдһ���ͻ��˳����������������һ��String�������а�����Hello World!����Ȼ���˳���
 * 	ע��ʹ���쳣����
 * 	����Ҫ�̡߳�
 * 2)��TCP socket��д���̷߳���������
 * 	�����������˿�Ϊ8000��
 * 	���ͻ������ӵ�������ʱ���������ᴴ��һ�����߳�������ͻ��ˡ�
 * 	���߳��У��������String���󲢽��ö��󱣴���һ����Ϊ��String .dat�����ļ��С�
 * ��ע�⣬������߳�д��ͬһ���ļ�ʱ����Ҫ����Щ�߳̽���ͬ���Ա������
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