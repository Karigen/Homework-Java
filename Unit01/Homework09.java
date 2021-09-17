package Unit01;

import java.util.Arrays;

public class Homework09 {

    public static void main(String[] args) {
	//1.
	int[]arr1=new int[10];
	for (int i = 0; i < arr1.length; i++) {
	    arr1[i]=(int)(Math.random()*100);
	}
	System.out.println("arr1="+Arrays.toString(arr1));
	
	//2.
	int[]arr2=new int[10];
	for (int i = 0; i < arr2.length; i++) {
	    arr2[i]=-1;
	}
	for (int i = 0; i < 10; i++) {
	    while (true) {
		int temp=(int)(Math.random()*10);
		if (!isExist(arr2, temp)) {
		    arr2[i]=temp;
		    break;
		}
	    }
	}
	System.out.println("arr2="+Arrays.toString(arr2));
	
	Homework10.bubbleSort(arr2);
	System.out.println("arr2="+Arrays.toString(arr2));
    }
    public static boolean isExist(int[] arr,int i) {
	for (int j : arr) {
	    if (j==i) {
		return true;
	    }
	}
	return false;
    }
}
