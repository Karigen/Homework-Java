package lab1.project1;

import java.util.ArrayList;
import java.util.List;

/*
 * �������Ӧ��˰���ö�6��Ԫ��100��Ԫ֮�䣬���ꡢ��Ϊһ��ԪΪ�����˰������Ƴ�������:
 * 
 * �ύ������Ŀ:
 * 1. ����:�����Լ���������������(���磬ʲô�����룬������������Ҫ����ʲô����Ҫ�洢ʲô���ݼ�������)��
 * 2. ���:��Ӣ���α�����������������������Ĳ��衣
 * 3. ����:��Javaʵ�ֽ��������
 * 4. ����:�ύtax���ǰ20����Ļ��ͼ��
 */

public class Project1 {

    public static void main(String[] args) {
	// ��ȥ6��֮���
	int[] incomeLimits = { 0, 36000, 144000, 300000, 420000, 660000, 960000, Integer.MAX_VALUE };
	double[] taxRate = { 0, 0.03, 0.1, 0.2, 0.25, 0.3, 0.35, 0.45 };
	double[] taxLimits = new double[8];// [0.0, 1080.0, 11880.0, 43080.0, 73080.0, 145080.0, 250080.0,
					   // 1.7976931348623157E308]

	// �����������׶�����Ҫ�ύ��˰������
	// �Ҿ������ļ����е�dp��ζ��
	for (int i = 1; i < taxLimits.length - 1; i++) {
	    taxLimits[i] = taxLimits[i - 1] + (incomeLimits[i] - incomeLimits[i - 1]) * taxRate[i];
	}
	taxLimits[taxLimits.length - 1] = Double.MAX_VALUE;

	// ���ڽ��ձ��,��ʵ֮������õ�ͬ�ڶ�ά����,���ǻ��Ǿ����ü��ϰ�
	List<String[]> taxTable = new ArrayList<String[]>(100);

	// ��ͷ,��ʵ��String��format��������,����Ϊ��ǿ��ÿ�����ݵĶ�����(����Ҳ������ȫ����),��û��,�������Ҹ�����
	String[] head1 = { "Annual Taxable\t", "|Annual Tax\t", "|Monthly Taxable", "|Monthly Tax\n" };
	String[] head2 = { "Income\t\t", "|\t\t", "|Income\t\t", "|\n" };
	taxTable.add(head1);
	taxTable.add(head2);

	String[] result = null;
	int temp = -1;// -6��
	double tax = -1;// ʵ��˰��

	for (int i = 60000, j = i / 12; i <= 1000000; i += 10000, j = i / 12) {
	    result = new String[4];

	    // ʵ��������
	    result[0] = i + "\t\t";

	    // ��6��
	    temp = i - 60000;

	    // ������˰��
	    for (int k = 1; k < taxLimits.length; k++) {

		// ������ô�Ҷ���������ѭ��,���Ըɴ��д����ѭ��������
		if (temp <= incomeLimits[0]) {
		    tax = taxLimits[0];
		    result[1] = "|" + Math.round(tax) + "\t\t";
		    break;
		}

		// ���볬��6��ļ��㷽��
		if (temp <= incomeLimits[k]) {
		    tax = (taxLimits[k - 1] + (temp - incomeLimits[k - 1]) * taxRate[k]);
		    result[1] = "|" + Math.round(tax) + "\t\t";
		    break;
		}
	    }

	    // ƽ��������
	    result[2] = "|" + j + "\t\t";

	    // ƽ����˰��
	    result[3] = "|" + Math.round((tax / 12)) + "\n";

	    // ������
	    taxTable.add(result);
	}

	// ��ӡ���
	for (String[] strings : taxTable) {
	    for (String string : strings) {
		System.out.print(string);
	    }
	}
    }
}