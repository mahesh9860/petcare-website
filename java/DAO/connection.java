package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	private static Connection con=null;

	public Connection getConnection() {
		//Connection con=null;
		
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				System.out.println("Connection to database.."+con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
			System.out.println("ConnectionTodatabase");
		
		return con;
	}
}
