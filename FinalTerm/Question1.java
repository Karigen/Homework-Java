package FinalTerm;

/*
 * 1.
 * 设计一个名为Person的类及其两个子类Student和Employee。
 * 创建Employee的Staff子类。
 * 一个人有一个姓名、地址、电话号码和电子邮件地址。
 * 一个学生有自己的班级(大一、大二、大三或大四)。
 * 将状态定义为常量。
 * 员工有办公室，有薪水。
 * 工作人员有头衔。
 * 重写每个类中的toString()方法以显示类名和人员名。
 * 编写测试程序，创建Person、Student、Employee和Staff。
 * 将这四个对象存储在Person数组中，并通过数组元素引用调用它们的toString()方法。
 */

public class Question1 {

    public static void main(String[] args) {
	Person[] persons = new Person[4];
	persons[0] = new Person("王二狗", "北京", "110", "110@110.cn");
	persons[1] = new Student("李二狗", "天津", "120", "120@120cn", ClassStatus.Sophomore);
	persons[2] = new Employee("刘二狗", "上海", "999", "999@999.cn", "999感冒灵", 10000);
	persons[3] = new Staff("赵二狗", "重庆", "119", "119@119.cn", "119热线", 20000, "HXD");

	for (Person person : persons) {
	    System.out.println(person);
	}
    }

}

class Person {

    public String name;
    public String address;
    public String phoneNumber;
    public String emailAddress;

    public Person() {

    }

    public Person(String name, String address, String phoneNumber, String emailAddress) {
	super();
	this.name = name;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
	return "Person [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", emailAddress="
		+ emailAddress + "]";
    }

}

enum ClassStatus {
    FreshMan, Sophomore, Junior, Senior
}

class Student extends Person {

    public final ClassStatus classStatus;

    public Student(ClassStatus classStatus) {
	super();
	this.classStatus = classStatus;
    }

    public Student(String name, String address, String phoneNumber, String emailAddress, ClassStatus classStatus) {
	super(name, address, phoneNumber, emailAddress);
	this.classStatus = classStatus;
    }

    @Override
    public String toString() {
	return "Student [classStatus=" + classStatus + ", name=" + name + ", address=" + address + ", phoneNumber="
		+ phoneNumber + ", emailAddress=" + emailAddress + "]";
    }

}

class Employee extends Person {

    public String office;
    public int salary;

    public Employee() {
	super();
    }

    public Employee(String name, String address, String phoneNumber, String emailAddress, String office, int salary) {
	super(name, address, phoneNumber, emailAddress);
	this.office = office;
	this.salary = salary;
    }

    @Override
    public String toString() {
	return "Employee [office=" + office + ", salary=" + salary + ", name=" + name + ", address=" + address
		+ ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + "]";
    }

}

class Staff extends Employee {

    public String title;

    public Staff() {
	super();
    }

    public Staff(String name, String address, String phoneNumber, String emailAddress, String office, int salary,
	    String title) {
	super(name, address, phoneNumber, emailAddress, office, salary);
	this.title = title;
    }

    @Override
    public String toString() {
	return "Staff [title=" + title + ", office=" + office + ", salary=" + salary + ", name=" + name + ", address="
		+ address + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + "]";
    }

}