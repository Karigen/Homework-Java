package Unit09;

import java.net.InetAddress;

public class Homework12 {

    public static void main(String[] args) throws Exception {
	InetAddress ia = InetAddress.getByName("www.bupt.edu.cn");

	System.out.println(ia.getCanonicalHostName());
	System.out.println(ia.getHostAddress());
	System.out.println(ia.getHostName());
    }

}
