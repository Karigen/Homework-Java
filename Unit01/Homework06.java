package Unit01;

public class Homework06 {

    public static void main(String[] args) {
	//1.
	int result1=0;
	int count1=0;
	while (count1<=10) {
	    result1+=count1;
	    count1++;
	}
	System.out.println("result1="+result1);
	
	//2.
	int result2=0;
	int count2=0;
	do {
	    result2+=count2;
	    count2++;
	} while (count2<=10);
	System.out.println("result2="+result2);
	
	//3.
	int result3=0;
	for (int i = 0; i <= 10; i++) {
	    result3+=i;
	}
	System.out.println("result3="+result3);
	
	//4.
	int result4=0;
	int[]arr=new int[10];
	for (int i = 0; i < arr.length; i++) {
	    arr[i]+=i+1;
	}
	for (int i : arr) {
	    result4+=i;
	}
	System.out.println("result4="+result4);
    }

}
