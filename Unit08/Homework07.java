package Unit08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Homework07 {

    public static void main(String[] args) {
	String url = "jdbc:mysql://localhost:3306/Person";
	String user = "root";
	String password = "root";

	Connection connection = null;
	PreparedStatement ps = null;

	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    connection = DriverManager.getConnection(url, user, password);

	    String sql = "INSERT INTO person VALUES(\"Kitty\", 13, false);";
	    ps = connection.prepareStatement(sql);

	    ps.execute();
	} catch (ClassNotFoundException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	} catch (SQLException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	} finally {
	    if (connection != null) {
		try {
		    connection.close();
		} catch (SQLException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    }

	    if (ps != null) {
		try {
		    ps.close();
		} catch (SQLException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    }
	}

    }

}
