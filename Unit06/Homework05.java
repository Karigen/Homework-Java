package Unit06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class Homework05 {

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;

	try {
	    oos = new ObjectOutputStream(new FileOutputStream("test5"));
	    List list = new LinkedList();
	    list.add("ABCDE");
	    list.add(new Integer(5));
	    oos.writeObject(list);
	    oos.flush();

	    ois = new ObjectInputStream(new FileInputStream("test5"));
	    Object obj = ois.readObject();
	    if (obj instanceof List) {
		List read = (List) obj;

		for (Object object : read) {
		    System.out.println(object);
		}
	    }
	} catch (FileNotFoundException e) {
	    // TODO �Զ����ɵ� catch ��
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO �Զ����ɵ� catch ��
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    // TODO �Զ����ɵ� catch ��
	    e.printStackTrace();
	} finally {
	    if (oos != null) {
		try {
		    oos.close();
		} catch (IOException e) {
		    // TODO �Զ����ɵ� catch ��
		    e.printStackTrace();
		}
	    }
	    if (ois != null) {
		try {
		    ois.close();
		} catch (IOException e) {
		    // TODO �Զ����ɵ� catch ��
		    e.printStackTrace();
		}
	    }
	}
    }

}
