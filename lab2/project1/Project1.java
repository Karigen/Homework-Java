package lab2.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 编写一个程序来查看、插入和更新存储在数据库中的人员信息。
 * 你可以只使用命令行来查看/插入/更新信息。不需要GUI。
 * 当用户选择“查看”选项时，程序将显示具有指定ID的记录。
 * 当用户选择“插入”选项时，程序插入一条新记录。
 * 当用户选择“更新”选项时，程序将更新指定ID的记录。
 * create table Staff (
 * id char(4) not null,
 * lastName varchar(15),
 * firstName varchar(15),
 * telephone char(10),
 * email varchar(40),
 * primary key (id)
 * ); 
 * 你可以使用任何你喜欢的数据库管理系统，如Microsoft Access, mysql, sqlite等。
 */

public class Project1 {

    public static void main(String[] args) throws Exception {
	String option = null;
	Scanner scanner = new Scanner(System.in);

	System.out.println("欢迎来到yyh的简易数据库客户端");
	Class.forName("com.mysql.cj.jdbc.Driver");

	System.out.print("是否使用默认账号登录(是/否):");
	String isDefault = scanner.nextLine();
	Connection connection = null;
	Statement statement = null;

	try {
	    if ("否".equals(isDefault)) {
		String url = null;
		String user = null;
		String password = null;// outter 能访问 inner

		System.out.print("你的url:");
		url = scanner.nextLine();

		System.out.print("你的用户名:");
		user = scanner.nextLine();

		System.out.print("你的密码:");
		password = scanner.nextLine();

		connection = DriverManager.getConnection(url, user, password);
		statement = connection.createStatement();
	    } else {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2_p1", "root", "root");
		statement = connection.createStatement();
	    }

	    loop: while (true) {
		System.out.println("查看\t加入\t更新\t退出");
		System.out.print("选择想进行的操作:");
		option = scanner.nextLine();
		switch (option) {
		case "查看":
		    System.out.println("选择想要查看的字段:");
		    String field = scanner.nextLine();
		    System.out.println("输入想要查询的条件:");
		    String queryConditions = scanner.nextLine();
		    ResultSet resultSet = statement
			    .executeQuery("SELECT " + field + " FROM staff WHERE " + queryConditions + ";");
		    System.out.println("查询结果为:");
		    while (resultSet.next()) {
			for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			    System.out.print(resultSet.getString(i) + "\t");
			}
			System.out.println();
		    }
		    break;
		case "加入":
		    System.out.println("请输入字段的值:");
		    String value = scanner.nextLine();
		    statement.execute("INSERT INTO staff VALUE(" + value + ");");
		    break;
		case "更新":
		    System.out.println("请输入新的值:");
		    String newValue = scanner.nextLine();
		    System.out.println("输入想要查询的条件");
		    String updateConditions = scanner.nextLine();
		    statement.execute("UPDATE staff SET " + newValue + " WHERE " + updateConditions + ";");
		    break;
		case "退出":
		    System.out.println("再见,XD");
		    break loop;
		default:
		    System.out.println("Ooops 你输错了");
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
