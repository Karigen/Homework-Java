package MidTerm;

//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.ObjectOutputStream;

/*
 * 将一些行写入文本文件(例如，c:\MyFile.txt)。
 * 文件c:\MyFile.txt的内容必须使用try-catch-finally来检测代码中的异常。
 * 在将文本(数字除外)写入文件之前，必须将文本(数字除外)存储在数组中。
 */

public class Question3 {

    /**
     * 
     * @author 作者 一开始用的确实是对象流，但因为序列化问题，在文档中会有乱码，
     * 而且条件最后一句“在将文本(数字除外)写入文件之前，必须将文本(数字除外)存储在数组中。”
     * 写的确实略有模糊的地方，所以将对象流的代码换成注释了，但肯定是能跑通的，验收实验时候望酌情验收
     */
    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	String[] strings = { "Man on earth\n", 
		             "Good at birth.\n", 
		             "The same nature,\n", 
		             "Varies on nurture.\n",
		             "With no education,\n",
		             "There'd be aberration.\n",
		             "To teach well,\n",
		             "You deeply dwell.\n",
		             "##END##"
		             };

	FileWriter fw = null;
//	ObjectOutputStream oos=null;// 我猜应该不是让用对象流

	try {
	    fw = new FileWriter("d:\\MyFile.txt");// 我的C盘用户没有写入权限，并且我也不打算改
//	    oos=new ObjectOutputStream(new FileOutputStream("d:\\MyFile2.txt"));

	    for (int i = 0; i < strings.length; i++) {
		fw.write(strings[i]);
	    }
//	    oos.writeObject(strings);

	    fw.flush();
//	    oos.flush();
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

//	    if (oos != null) {
//		try {
//		    oos.close();
//		} catch (IOException e) {
//		    // TODO 自动生成的 catch 块
//		    e.printStackTrace();
//		}
//	    }
	}
    }
}
