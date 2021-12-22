package Unit08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Homework06 {

    public static void main(String[] args) {
	String url = "jdbc:mysql://localhost:3306/Person";
	String user = "root";
	String password = "root";

	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    connection = DriverManager.getConnection(url, user, password);

	    String sql = "SELECT * FROM person;";
	    ps = connection.prepareStatement(sql);

	    rs = ps.executeQuery();
	    
	    while (rs.next()) {
		System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
	    }
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

	    if (rs != null) {
		try {
		    rs.close();
		} catch (SQLException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    }
	}

    }

}
