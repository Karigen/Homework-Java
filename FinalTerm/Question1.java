package FinalTerm;

/*
 * 1.
 * ���һ����ΪPerson���༰����������Student��Employee��
 * ����Employee��Staff���ࡣ
 * һ������һ����������ַ���绰����͵����ʼ���ַ��
 * һ��ѧ�����Լ��İ༶(��һ����������������)��
 * ��״̬����Ϊ������
 * Ա���а칫�ң���нˮ��
 * ������Ա��ͷ�Ρ�
 * ��дÿ�����е�toString()��������ʾ��������Ա����
 * ��д���Գ��򣬴���Person��Student��Employee��Staff��
 * �����ĸ�����洢��Person�����У���ͨ������Ԫ�����õ������ǵ�toString()������
 */

public class Question1 {

    public static void main(String[] args) {
	Person[] persons = new Person[4];
	persons[0] = new Person("������", "����", "110", "110@110.cn");
	persons[1] = new Student("�����", "���", "120", "120@120cn", ClassStatus.Sophomore);
	persons[2] = new Employee("������", "�Ϻ�", "999", "999@999.cn", "999��ð��", 10000);
	persons[3] = new Staff("�Զ���", "����", "119", "119@119.cn", "119����", 20000, "HXD");

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