package lab1.project2;

/*
 * 1. 三个名为side1、side2和side3的双数据字段，默认值为1.0，表示三角形的三条边。
 * 2. 创建默认三角形的无参数构造函数。
 * 3. 使用指定的边1、边2和边3创建三角形的构造函数。
 * 4. 所有三个数据字段的getter方法。
 * 5. 一个名为getArea()的方法，返回这个三角形的面积。
 * 6. 一个名为getPerimeter()的方法，返回这个三角形的周长。
 * 7. 名为toString()的方法，返回三角形的字符串描述。
 * 
 * 这个类继承了Exception类，应该满足以下条件:
 * 1. 包含数据字段side1、side2、side3，表示三角形的三条边。
 * 2. 存储信息“Illegal Sides”的无参数构造函数
 * 3. 存储由参数传递的自定义信息的构造函数
 * 4. 覆盖getMessage()函数返回字符串“Illegal Sides: side1, side2, side3”，其中“sideX”是三角形的边的值。
 * 5. 当用构造函数创建一个Triangle对象时，检查边。如果任何一方不大于0，抛出IllegalSideException
 * 
 * 绘制包含类Triangle, GeometricObject和IllegalSideException的UML图
 * 
 * 实现类。编写一个测试程序，创建两个Triangle对象。
 * 一个是边1,1.5,1，设置颜色黄色和填充真，并显示边(与toString())，面积，周长，颜色，是否填充。
 * 另一个是边- 1,0,1，它将触发IllegalSideException异常并打印异常消息。
 */

public class Project2 {

    public static void main(String[] args) throws Exception {
	Triangle t1 = null;
	Triangle t2 = null;

	try {
	    t1 = new Triangle(1, 1.5, 1, "yellow", true);
	    System.out.println("边 : " + t1);
	    System.out.println("面积 : " + t1.getArea());
	    System.out.println("周长 : " + t1.getPerimeter());
	    System.out.println("颜色 : " + t1.getColor());
	    System.out.println("是否填充 : " + t1.getIsFilled());

	    t2 = new Triangle(-1, 0, 1, null, false);
	    System.out.println("t1.toString() : " + t2);
	    System.out.println("面积 : " + t2.getArea());
	    System.out.println("周长 : " + t2.getPerimeter());
	    System.out.println("颜色 : " + t2.getColor());
	    System.out.println("是否填充 : " + t2.getIsFilled());
	} catch (IllegalSideException e) {
	    // 在此处作用相近,网课建议最好看异常堆栈信息
	    e.printStackTrace();
	    // System.out.println(e.getMessage());
	}
    }

}

abstract class GeometricObject {
    private String color;
    private boolean isFilled;

    public GeometricObject() {
	color = "white";
	isFilled = false;
    }

    public GeometricObject(String color, boolean isFilled) {
	this.color = color;
	this.isFilled = isFilled;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    public boolean getIsFilled() {
	return isFilled;
    }

    public void setIsFilled(boolean isFilled) {
	this.isFilled = isFilled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}

class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
	side1 = 1.0;
	side2 = 1.0;
	side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3, String color, boolean isFilled)
	    throws IllegalSideException {
	super(color, isFilled);

	if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
	    throw new IllegalSideException(side1, side2, side3, "Illegal Sides");
	}

	this.side1 = side1;
	this.side2 = side2;
	this.side3 = side3;
    }

    public double getSide1() {
	return side1;
    }

    public void setSide1(double side1) {
	this.side1 = side1;
    }

    public double getSide2() {
	return side2;
    }

    public void setSide2(double side2) {
	this.side2 = side2;
    }

    public double getSide3() {
	return side3;
    }

    public void setSide3(double side3) {
	this.side3 = side3;
    }

    public double getArea() {
	double p = (side1 + side2 + side3) / 2;
	return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));// 海伦公式
    }

    public double getPerimeter() {
	return side1 + side2 + side3;
    }

    @Override
    public String toString() {
	return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}

class IllegalSideException extends Exception {
    // 其实这写个小作业,用不着序列化版本号,但是他有个Warning
    private static final long serialVersionUID = -1L;

    private double side1;
    private double side2;
    private double side3;

    private String information;

    public IllegalSideException() {
	// 标准Java源码写法
	super();
    }

    public IllegalSideException(String information) {
	// 标准Java源码写法
	super(information);
    }

    public IllegalSideException(double side1, double side2, double side3, String information) {
	this.side1 = side1;
	this.side2 = side2;
	this.side3 = side3;
	this.information = information;
    }

    @Override
    public String getMessage() {
	return information + ": " + side1 + ", " + side2 + ", " + side3;
    }
}