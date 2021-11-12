package Unit06;

import java.io.File;

public class Homework01 {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	String patnName = "test.txt";
	File file = new File(patnName);
	if (file.exists()) {
	    System.out.println("文件" + patnName + "存在");
	    System.out.println("文件大小" + file.length()+"Bytes");
	    System.out.println("文件绝对路径" + file.getAbsolutePath());
	    System.out.println("文件所在分区所在大小" + (file.getTotalSpace() / 1024 / 1024 / 1024) + "GB");
	    System.out.println("分区空余大小" + (file.getFreeSpace() / 1024 / 1024 / 1024) + "GB");
	} else {
	    System.out.println("不存在");
	}
    }

}