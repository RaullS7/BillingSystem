package DatabseConncection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConncection {
	private final static String USERNAME="root";
	private final static String PASSWORD="";
	private final static String DATABASE_NAME="billing_system";
	private final static String Driver_Name="com.mysql.jdbc.Driver";
	private final static String URL="jdbc:mysql://localhost/";
	
	
	public static Connection getConnection() throws Exception{
		Class.forName(Driver_Name);
		return DriverManager.getConnection(URL+DATABASE_NAME,USERNAME, PASSWORD);
	}
}
