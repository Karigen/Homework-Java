package Unit01;

public class Homework10 {

    public static void main(String[] args) {

    }
    public static void bubbleSort(int[] arr) {
	int temp=0;
	boolean isChange=false;
	for (int i = 0; i < arr.length-1; i++) {
	    for (int j = 0; j < arr.length-1-i; j++) {
		if (arr[j]>arr[j+1]) {
		    isChange=true;
		    temp=arr[j];
		    arr[j]=arr[j+1];
		    arr[j+1]=temp;
		}
	    }
	    if (!isChange) {
		break;
	    }
	}
    }
}
