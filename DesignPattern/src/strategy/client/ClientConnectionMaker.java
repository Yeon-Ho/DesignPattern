package strategy.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import strategy.library.dao.ConnectionMaker;

public class ClientConnectionMaker implements ConnectionMaker{

	@Override
	public Connection getConnection() {
			
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	
	
}
