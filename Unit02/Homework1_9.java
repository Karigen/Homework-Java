package Unit02;

import java.util.Arrays;

public class Homework1_9 {

    public static void main(String[] args) {
	char[][] arr= {	{'a', 'b', 'c', 'd'}, 
			{'x', 'y', 'z'}, 
			{'1', '2'}	} ;
	
	for (int i = 0; i < arr.length; i++) {
	    System.out.println("第"+(i+1)+"行："+Arrays.toString(arr[i])+" 长度为："+arr[i].length);
	}
    }

}
