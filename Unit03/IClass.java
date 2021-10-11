package Unit03;

public class IClass {

    public static void main(String[] args) {
	//1
	//Object[] abjArr1=new int[50];
	Object[] abjArr2=new Integer[50];
	Object[] abjArr3=new String[50];
	Object[] abjArr4=new Object[50];
	
	//2
	Integer[] list1 = {12, 24, 55, 1};
	Double[] list2 = {12.4, 24.0, 55.2, 1.0};
	int[] list3 = {1, 2, 3};

	printArray(list1);
	printArray(list2);
	//printArray(list3);
	
	//3
	new Person().printPerson();
	new Student().printPerson();
	
	//4
	new Person().printPerson();
	new Student().printPerson();
    }
    
    public static void printArray(Object[] list) {
	   for (Object o: list){
	     System.out.print(o + " ");
	     System.out.println();
	   }
    }
}

/*

class Student extends Person {
    @Override
    public String getInfo() {
      return "Student";
    }
  }

  class Person {
    public String getInfo() {
      return "Person";
    }

    public void printPerson() {
      System.out.println(getInfo());
    }
  }

*/

class Student extends Person {
    private String getInfo() {
      return "Student";
    }
  }

  class Person {
    private String getInfo() {
      return "Person";
    }

    public void printPerson() {
      System.out.println(getInfo());
    }
  }