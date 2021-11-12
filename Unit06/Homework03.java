package Unit06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Homework03 {

    public static void main(String[] args) {
	FileOutputStream fos = null;
	FileInputStream fis = null;
	BufferedWriter bw = null;
	BufferedReader br = null;

//	byte[] bytes = { 97, 98, 99, 100, 101 };

	try {
	    fos = new FileOutputStream("test3.txt");
//	    fos.write(bytes);
//	    fos.flush();

	    bw = new BufferedWriter(new OutputStreamWriter(fos));
	    bw.write("ABCDE");
	    bw.flush();

	    fis = new FileInputStream("test3.txt");
	    br = new BufferedReader(new InputStreamReader(fis));
//	    byte[] read=new byte[2];
//	    int len=-1;
//	    while ((len=fis.read(read))!=-1) {
//		System.out.print(new String(read, 0, len));
//	    }
	    String s = null;
	    while ((s = br.readLine()) != null) {
		System.out.println(s);
	    }
	} catch (FileNotFoundException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	} finally {
	    if (fos != null) {
		try {
		    fos.close();
		} catch (IOException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    }

	    if (fis != null) {
		try {
		    fis.close();
		} catch (IOException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    }

	    if (bw != null) {
		try {
		    bw.close();
		} catch (IOException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    }
	    if (br != null) {
		try {
		    br.close();
		} catch (IOException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    }
	}
    }
}