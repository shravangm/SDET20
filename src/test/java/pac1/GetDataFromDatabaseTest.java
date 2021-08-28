package pac1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetDataFromDatabaseTest {

	public static void main(String[] args) throws Throwable {
		//Step 1 - register the driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Step 2 - establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
		
		//Step 3 - issue the statement
		Statement statement = connection.createStatement();
		
		//Step 4 - execute the query
		statement.executeQuery("select * from student_info");
		
		//Step 4 - execute the query
		ResultSet result = statement.executeQuery("select * from student_info");
		
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			}		
		
		//Step 5 - close the connection
		connection.close();
	}

}
