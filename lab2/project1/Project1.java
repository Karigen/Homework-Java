package lab2.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 * ��дһ���������鿴������͸��´洢�����ݿ��е���Ա��Ϣ��
 * �����ֻʹ�����������鿴/����/������Ϣ������ҪGUI��
 * ���û�ѡ�񡰲鿴��ѡ��ʱ��������ʾ����ָ��ID�ļ�¼��
 * ���û�ѡ�񡰲��롱ѡ��ʱ���������һ���¼�¼��
 * ���û�ѡ�񡰸��¡�ѡ��ʱ�����򽫸���ָ��ID�ļ�¼��
 * create table Staff (
 * id char(4) not null,
 * lastName varchar(15),
 * firstName varchar(15),
 * telephone char(10),
 * email varchar(40),
 * primary key (id)
 * ); 
 * �����ʹ���κ���ϲ�������ݿ����ϵͳ����Microsoft Access, mysql, sqlite�ȡ�
 */

public class Project1 {

    public static void main(String[] args) throws Exception {
	String option = null;
	Scanner scanner = new Scanner(System.in);

	System.out.println("��ӭ����yyh�ļ������ݿ�ͻ���");
	Class.forName("com.mysql.cj.jdbc.Driver");

	System.out.print("�Ƿ�ʹ��Ĭ���˺ŵ�¼(��/��):");
	String isDefault = scanner.nextLine();
	Connection connection = null;
	Statement statement = null;

	try {
	    if ("��".equals(isDefault)) {
		String url = null;
		String user = null;
		String password = null;// outter �ܷ��� inner

		System.out.print("���url:");
		url = scanner.nextLine();

		System.out.print("����û���:");
		user = scanner.nextLine();

		System.out.print("�������:");
		password = scanner.nextLine();

		connection = DriverManager.getConnection(url, user, password);
		statement = connection.createStatement();
	    } else {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2_p1", "root", "root");
		statement = connection.createStatement();
	    }

	    loop: while (true) {
		System.out.println("�鿴\t����\t����\t�˳�");
		System.out.print("ѡ������еĲ���:");
		option = scanner.nextLine();
		switch (option) {
		case "�鿴":
		    System.out.println("ѡ����Ҫ�鿴���ֶ�:");
		    String field = scanner.nextLine();
		    System.out.println("������Ҫ��ѯ������:");
		    String queryConditions = scanner.nextLine();
		    ResultSet resultSet = statement
			    .executeQuery("SELECT " + field + " FROM staff WHERE " + queryConditions + ";");
		    System.out.println("��ѯ���Ϊ:");
		    while (resultSet.next()) {
			for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			    System.out.print(resultSet.getString(i) + "\t");
			}
			System.out.println();
		    }
		    break;
		case "����":
		    System.out.println("�������ֶε�ֵ:");
		    String value = scanner.nextLine();
		    statement.execute("INSERT INTO staff VALUE(" + value + ");");
		    break;
		case "����":
		    System.out.println("�������µ�ֵ:");
		    String newValue = scanner.nextLine();
		    System.out.println("������Ҫ��ѯ������");
		    String updateConditions = scanner.nextLine();
		    statement.execute("UPDATE staff SET " + newValue + " WHERE " + updateConditions + ";");
		    break;
		case "�˳�":
		    System.out.println("�ټ�,XD");
		    break loop;
		default:
		    System.out.println("Ooops �������");
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (statement != null) {
		statement.close();
	    }

	    if (connection != null) {
		connection.close();
	    }

	    if (scanner != null) {
		scanner.close();
	    }
	}
    }

}
