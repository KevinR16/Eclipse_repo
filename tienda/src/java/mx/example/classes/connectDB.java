package mx.example.classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
	String user, password, host, port, database;
	String url;

	public connectDB(String user, String password, String host, String port, String database) {
		super();
		this.user = user;
		this.password = password;
		this.host = host;
		this.port = port;
		this.database = database;
	}

	public Connection connect() {
		String url = null;
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://" + host + ":" + port + "/" + database;
			connection = DriverManager.getConnection(url, user, password);
//			boolean valid = connection.isValid(50000);
//			System.out.println(valid ? "TEST OK" : "TEST FAIL");
		} catch (java.sql.SQLException sqle) {
			System.out.println("Error al conectar con la base de datos (" + url + "): " + sqle);
		}catch (ClassNotFoundException ex) {
			System.out.println("Error al registrar el driver de MySQL: " + ex);
		}
		return connection;
	}
}
