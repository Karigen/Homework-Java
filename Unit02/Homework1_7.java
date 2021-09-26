package Unit02;

import java.util.Arrays;

public class Homework1_7 {

    public static void main(String[] args) {
	int[] arr= {9,8,7,6,5,4,3,2,1}; 
	System.out.print("before:");
	Tools.print(arr);
	
	System.out.print("after:");
	Tools.print(Tools.reverse(arr));
	Tools.print(arr);
    }

}

class Tools {
    public static int[] reverse(int[] arr) {
	for (int i = 0; i < arr.length/2; i++) {
	    int temp=arr[i];
	    arr[i]=arr[arr.length-1-i];
	    arr[arr.length-1-i]=temp;
	}
	return arr;
    }
    
    public static void print(int[] arr) {
	System.out.println("arr"+Arrays.toString(arr));
    }
    
}