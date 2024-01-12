package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCoonection {

	Connection con ;
	
	public DatabaseCoonection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thy","root","");
			this.con=con ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

}
