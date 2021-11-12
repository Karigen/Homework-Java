package Unit06;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Homework02 {

    public static void main(String[] args) {
	FileWriter fw = null;
	PrintWriter pw = null;
	FileReader f1 = null;
	FileReader f2 = null;

	try {
	    fw = new FileWriter("test1.txt");
	    pw = new PrintWriter("test2.txt");

	    fw.write("ABCDEFG");
	    pw.write("HIGKLMN");

	    fw.flush();
	    pw.flush();

	    f1 = new FileReader("test1.txt");
	    f2 = new FileReader("test2.txt");

	    char[] chars = new char[5];
	    int len = -1;
	    while ((len = f1.read(chars)) != -1) {
		System.out.print(new String(chars, 0, len));
	    }

	    System.out.println();

	    while ((len = f2.read(chars)) != -1) {
		System.out.print(new String(chars, 0, len));
	    }

	} catch (IOException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	} finally {
	    if (fw != null) {
		try {
		    fw.close();
		} catch (IOException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    }

	    if (pw != null) {
		pw.close();
	    }

	    if (f1 != null) {
		try {
		    f1.close();
		} catch (IOException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    }

	    if (f2 != null) {
		try {
		    f2.close();
		} catch (IOException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    }
	}
    }

}
