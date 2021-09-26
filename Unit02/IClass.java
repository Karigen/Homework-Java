package Unit02;

public class IClass {
    
    /* Task 1

     * 1. Create a SimpleCircle class

     * 2. Use a static member to count the instances

     * 3. In main(), create some instances, output the number of the instances

     */

    /* Task 2

     * In main()

     * 1. Create an array of Object (SimpleCircle)

     * 2. Print each circle's area by calling SimpleCircle's member "getArea()"

     * 3. Print the number of the instances of SimpleCircle

     */

    /* Task 3

     * 1. Implement finalize()

     * 2. Modify the codes in main() to set all object reference to null and call gc()

     */

    public static void main(String[] args) {
	
	//Task 1
	SimpleCircle c1=new SimpleCircle();
	SimpleCircle c2=new SimpleCircle();
	SimpleCircle c3=new SimpleCircle();
	
	System.out.println("the number of the instances is "+SimpleCircle.getNumberOfObjects());
	
	//Task 2
	SimpleCircle[] ca=new SimpleCircle[2];
	
	ca[0]=new SimpleCircle(1);
	ca[1]=new SimpleCircle(2);
	
	for (int i = 0; i < ca.length; i++) {
	    System.out.println("simplecircle"+(i+1)+"'s area is "+ca[i].getArea());
	}
	
	System.out.println("the number of the instances is "+SimpleCircle.getNumberOfObjects());
	
	// gc
	
	c1=null;
	c2=null;
	c3=null;

	for (int i = 0; i < ca.length; i++) {

	    ca[i] = null;
	    
	    System.gc();
	    
	    // 下面这条语句会执行被回收对象中被override的finalize方法

	    System.runFinalization();
	    
	    }
	
	System.out.println("the number of the instances is "+SimpleCircle.getNumberOfObjects());
	    
    }

}

class SimpleCircle{
    
    private double radius=0;
    
    private static int count=0;
    
    public SimpleCircle(){
	count++;
    }
    
    public SimpleCircle(double radius) {
	this.radius=radius;
	count++;
    }
    
    public static int getNumberOfObjects() {
	return count;
    }
    
    public double getArea() {
	return Math.PI*this.radius*this.radius;
    }
    
    protected void finalize() {
	count--;
    }
}
