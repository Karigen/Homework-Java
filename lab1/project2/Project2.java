package lab1.project2;

/*
 * 1. ������Ϊside1��side2��side3��˫�����ֶΣ�Ĭ��ֵΪ1.0����ʾ�����ε������ߡ�
 * 2. ����Ĭ�������ε��޲������캯����
 * 3. ʹ��ָ���ı�1����2�ͱ�3���������εĹ��캯����
 * 4. �������������ֶε�getter������
 * 5. һ����ΪgetArea()�ķ�����������������ε������
 * 6. һ����ΪgetPerimeter()�ķ�����������������ε��ܳ���
 * 7. ��ΪtoString()�ķ��������������ε��ַ���������
 * 
 * �����̳���Exception�࣬Ӧ��������������:
 * 1. ���������ֶ�side1��side2��side3����ʾ�����ε������ߡ�
 * 2. �洢��Ϣ��Illegal Sides�����޲������캯��
 * 3. �洢�ɲ������ݵ��Զ�����Ϣ�Ĺ��캯��
 * 4. ����getMessage()���������ַ�����Illegal Sides: side1, side2, side3�������С�sideX���������εıߵ�ֵ��
 * 5. ���ù��캯������һ��Triangle����ʱ�����ߡ�����κ�һ��������0���׳�IllegalSideException
 * 
 * ���ư�����Triangle, GeometricObject��IllegalSideException��UMLͼ
 * 
 * ʵ���ࡣ��дһ�����Գ��򣬴�������Triangle����
 * һ���Ǳ�1,1.5,1��������ɫ��ɫ������棬����ʾ��(��toString())��������ܳ�����ɫ���Ƿ���䡣
 * ��һ���Ǳ�- 1,0,1����������IllegalSideException�쳣����ӡ�쳣��Ϣ��
 */

public class Project2 {

    public static void main(String[] args) throws Exception {
	Triangle t1 = null;
	Triangle t2 = null;

	try {
	    t1 = new Triangle(1, 1.5, 1, "yellow", true);
	    System.out.println("�� : " + t1);
	    System.out.println("��� : " + t1.getArea());
	    System.out.println("�ܳ� : " + t1.getPerimeter());
	    System.out.println("��ɫ : " + t1.getColor());
	    System.out.println("�Ƿ���� : " + t1.getIsFilled());

	    t2 = new Triangle(-1, 0, 1, null, false);
	    System.out.println("t1.toString() : " + t2);
	    System.out.println("��� : " + t2.getArea());
	    System.out.println("�ܳ� : " + t2.getPerimeter());
	    System.out.println("��ɫ : " + t2.getColor());
	    System.out.println("�Ƿ���� : " + t2.getIsFilled());
	} catch (IllegalSideException e) {
	    // �ڴ˴��������,���ν�����ÿ��쳣��ջ��Ϣ
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
	return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));// ���׹�ʽ
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
    // ��ʵ��д��С��ҵ,�ò������л��汾��,�������и�Warning
    private static final long serialVersionUID = -1L;

    private double side1;
    private double side2;
    private double side3;

    private String information;

    public IllegalSideException() {
	// ��׼JavaԴ��д��
	super();
    }

    public IllegalSideException(String information) {
	// ��׼JavaԴ��д��
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