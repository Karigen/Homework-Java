package Unit09;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework11_s {

    public static void main(String[] args) throws Exception {
	ServerSocket ss = new ServerSocket(6666);
	Socket s = ss.accept();
//	DataInputStream dis = new DataInputStream(s.getInputStream());
	InputStream is = s.getInputStream();
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	byte[] buffer = new byte[1024];
	int len = -1;
	while ((len = is.read(buffer)) != -1) {
	    baos.write(buffer, 0, len);
	}
	System.out.println(baos.toString());

	Thread.sleep(1000);

	baos.close();
//	dis.close();
	is.close();
	s.close();
	ss.close();
    }

}
