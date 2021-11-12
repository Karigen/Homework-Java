package Unit06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Homework06 {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	RandomAccessFile raf = null;
	try {
	    raf = new RandomAccessFile("test6.txt", "rw");
	    int[] arr = { 1, 2, 3, 4, 5 };
	    for (int i : arr) {
		raf.writeInt(i);
	    }
	    raf.seek(raf.length() - 4);
	    System.out.println(raf.readInt());
	} catch (FileNotFoundException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	} finally {
	    if (raf != null) {
		try {
		    raf.close();
		} catch (IOException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    }
	}
    }

}
