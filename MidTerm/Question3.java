package MidTerm;

//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.ObjectOutputStream;

/*
 * ��һЩ��д���ı��ļ�(���磬c:\MyFile.txt)��
 * �ļ�c:\MyFile.txt�����ݱ���ʹ��try-catch-finally���������е��쳣��
 * �ڽ��ı�(���ֳ���)д���ļ�֮ǰ�����뽫�ı�(���ֳ���)�洢�������С�
 */

public class Question3 {

    /**
     * 
     * @author ���� һ��ʼ�õ�ȷʵ�Ƕ�����������Ϊ���л����⣬���ĵ��л������룬
     * �����������һ�䡰�ڽ��ı�(���ֳ���)д���ļ�֮ǰ�����뽫�ı�(���ֳ���)�洢�������С���
     * д��ȷʵ����ģ���ĵط������Խ��������Ĵ��뻻��ע���ˣ����϶�������ͨ�ģ�����ʵ��ʱ������������
     */
    public static void main(String[] args) {
	// TODO �Զ����ɵķ������
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
//	ObjectOutputStream oos=null;// �Ҳ�Ӧ�ò������ö�����

	try {
	    fw = new FileWriter("d:\\MyFile.txt");// �ҵ�C���û�û��д��Ȩ�ޣ�������Ҳ�������
//	    oos=new ObjectOutputStream(new FileOutputStream("d:\\MyFile2.txt"));

	    for (int i = 0; i < strings.length; i++) {
		fw.write(strings[i]);
	    }
//	    oos.writeObject(strings);

	    fw.flush();
//	    oos.flush();
	} catch (IOException e) {
	    // TODO �Զ����ɵ� catch ��
	    e.printStackTrace();
	} finally {
	    if (fw != null) {
		try {
		    fw.close();
		} catch (IOException e) {
		    // TODO �Զ����ɵ� catch ��
		    e.printStackTrace();
		}
	    }

//	    if (oos != null) {
//		try {
//		    oos.close();
//		} catch (IOException e) {
//		    // TODO �Զ����ɵ� catch ��
//		    e.printStackTrace();
//		}
//	    }
	}
    }
}
