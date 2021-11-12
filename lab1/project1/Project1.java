package lab1.project1;

import java.util.ArrayList;
import java.util.List;

/*
 * 编制年度应纳税所得额6万元至100万元之间，以年、月为一万元为间隔的税则表，编制程序如下:
 * 
 * 提交下列项目:
 * 1. 分析:用你自己的语言重述问题(例如，什么是输入，如果有输出，需要计算什么，需要存储什么数据及其类型)。
 * 2. 设计:用英语或伪代码清楚地描述解决这个问题的步骤。
 * 3. 编码:用Java实现解决方案。
 * 4. 测试:提交tax表的前20行屏幕截图。
 */

public class Project1 {

    public static void main(String[] args) {
	// 减去6万之后的
	int[] incomeLimits = { 0, 36000, 144000, 300000, 420000, 660000, 960000, Integer.MAX_VALUE };
	double[] taxRate = { 0, 0.03, 0.1, 0.2, 0.25, 0.3, 0.35, 0.45 };
	double[] taxLimits = new double[8];// [0.0, 1080.0, 11880.0, 43080.0, 73080.0, 145080.0, 250080.0,
					   // 1.7976931348623157E308]

	// 计算各个收入阶段所需要提交的税款上限
	// 我觉着这块的计算有点dp的味道
	for (int i = 1; i < taxLimits.length - 1; i++) {
	    taxLimits[i] = taxLimits[i - 1] + (incomeLimits[i] - incomeLimits[i - 1]) * taxRate[i];
	}
	taxLimits[taxLimits.length - 1] = Double.MAX_VALUE;

	// 用于接收表格,其实之后的作用等同于二维数组,但是还是尽量用集合吧
	List<String[]> taxTable = new ArrayList<String[]>(100);

	// 表头,其实用String的format方法就行,但我为了强调每个数据的独立性(好像也不是完全独立),就没用,绝不是我给忘了
	String[] head1 = { "Annual Taxable\t", "|Annual Tax\t", "|Monthly Taxable", "|Monthly Tax\n" };
	String[] head2 = { "Income\t\t", "|\t\t", "|Income\t\t", "|\n" };
	taxTable.add(head1);
	taxTable.add(head2);

	String[] result = null;
	int temp = -1;// -6万
	double tax = -1;// 实际税收

	for (int i = 60000, j = i / 12; i <= 1000000; i += 10000, j = i / 12) {
	    result = new String[4];

	    // 实际年收入
	    result[0] = i + "\t\t";

	    // 减6万
	    temp = i - 60000;

	    // 计算年税收
	    for (int k = 1; k < taxLimits.length; k++) {

		// 反正怎么找都会进入这个循环,所以干脆就写在这循环里面了
		if (temp <= incomeLimits[0]) {
		    tax = taxLimits[0];
		    result[1] = "|" + Math.round(tax) + "\t\t";
		    break;
		}

		// 收入超过6万的计算方法
		if (temp <= incomeLimits[k]) {
		    tax = (taxLimits[k - 1] + (temp - incomeLimits[k - 1]) * taxRate[k]);
		    result[1] = "|" + Math.round(tax) + "\t\t";
		    break;
		}
	    }

	    // 平均月收入
	    result[2] = "|" + j + "\t\t";

	    // 平均月税收
	    result[3] = "|" + Math.round((tax / 12)) + "\n";

	    // 加入表格
	    taxTable.add(result);
	}

	// 打印表格
	for (String[] strings : taxTable) {
	    for (String string : strings) {
		System.out.print(string);
	    }
	}
    }
}