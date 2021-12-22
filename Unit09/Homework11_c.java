package Unit09;

import java.io.DataOutputStream;
import java.net.Socket;

public class Homework11_c {

    public static void main(String[] args) throws Exception {
	Socket s = new Socket("localhost", 6666);
	DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	dos.write("123".getBytes());

	Thread.sleep(1000);

	dos.close();
	s.close();
    }

}
