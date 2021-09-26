package Unit02;

//var类型，自动推导类似auto
public class Homework1_8 {

    public static void main(String[] args) {
	int[][] arr=new int[3][3];
	
	//!!random!!
	
	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[i].length; j++) {
		arr[i][j]=3*i+j+1;
	    }
	}
	print(arr);
    }
    
    public static void print(int[][]arr) {
	for (int[] a1 : arr) {
	    for (int i : a1) {
		System.out.print(i+" ");
	    }
	    System.out.println();
	}
    }

}
