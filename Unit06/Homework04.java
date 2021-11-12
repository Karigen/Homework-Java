package Unit06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Homework04 {

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������
	DataOutputStream dos = null;
	DataInputStream dis = null;

	try {
	    dos = new DataOutputStream(new FileOutputStream("test4"));

	    byte[] arr = { 97, 98, 99, 100, 101 };

	    dos.write(arr);

	    dos.flush();

	    dis = new DataInputStream(new FileInputStream("test4"));

	    byte[] read = null;
	    read = dis.readAllBytes();
	    System.out.println(Arrays.toString(read));
	} catch (FileNotFoundException e) {
	    // TODO �Զ����ɵ� catch ��
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO �Զ����ɵ� catch ��
	    e.printStackTrace();
	} finally {
	    if (dos != null) {
		try {
		    dos.close();
		} catch (IOException e) {
		    // TODO �Զ����ɵ� catch ��
		    e.printStackTrace();
		}
	    }
	    if (dis != null) {
		try {
		    dis.close();
		} catch (IOException e) {
		    // TODO �Զ����ɵ� catch ��
		    e.printStackTrace();
		}
	    }
	}
    }

}
