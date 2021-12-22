package Unit09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Homework13_c {

    public static void main(String[] args) throws Exception {
	Socket s = new Socket("127.0.0.1", 6666);//0.0.0.0 all 0.0.0.0:0 all
	DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	dos.writeDouble(456);
	DataInputStream dis=new DataInputStream(s.getInputStream());
	System.out.println(dis.readUTF());

	Thread.sleep(1000);

	s.shutdownInput();
	dis.close();
	dos.close();
	s.close();
    }

}
