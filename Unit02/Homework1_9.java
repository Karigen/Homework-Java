package Unit02;

import java.util.Arrays;

public class Homework1_9 {

    public static void main(String[] args) {
	char[][] arr= {	{'a', 'b', 'c', 'd'}, 
			{'x', 'y', 'z'}, 
			{'1', '2'}	} ;
	
	for (int i = 0; i < arr.length; i++) {
	    System.out.println("��"+(i+1)+"�У�"+Arrays.toString(arr[i])+" ����Ϊ��"+arr[i].length);
	}
    }

}
