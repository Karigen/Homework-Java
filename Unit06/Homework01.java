package Unit06;

import java.io.File;

public class Homework01 {

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������
	String patnName = "test.txt";
	File file = new File(patnName);
	if (file.exists()) {
	    System.out.println("�ļ�" + patnName + "����");
	    System.out.println("�ļ���С" + file.length()+"Bytes");
	    System.out.println("�ļ�����·��" + file.getAbsolutePath());
	    System.out.println("�ļ����ڷ������ڴ�С" + (file.getTotalSpace() / 1024 / 1024 / 1024) + "GB");
	    System.out.println("���������С" + (file.getFreeSpace() / 1024 / 1024 / 1024) + "GB");
	} else {
	    System.out.println("������");
	}
    }

}