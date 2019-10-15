package ecart;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	public Connection     condata() throws ClassNotFoundException, SQLException {
		
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart","root","");  
				
				  
			/*	if (con != null)
				{
					System.out.println("Connected");
				}
				else
				{
					System.out.println("not Connected");
				}*/
				return con;




			}

		


	}


