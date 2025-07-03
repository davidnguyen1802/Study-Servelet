package product.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQL_config {
	private static String url = "jdbc:mysql://localhost:3307/product_app";
	private static String username = "root";
	private static String password = "180205";

	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: Cannot connect to DB" + e.getMessage());
		}
		return connection;
		
	}
}
