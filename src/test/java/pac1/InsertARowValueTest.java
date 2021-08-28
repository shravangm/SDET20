package pac1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertARowValueTest {

	public static void main(String[] args) throws Throwable {
		Connection connection = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
			
			Statement statement = connection.createStatement();
			int insert = statement.executeUpdate("insert into student_info values('7', 'Mac', 'T', 'M')");
			
			if(insert==1) {
				System.out.println("Data is added successfully");
				} else {
				System.out.println("Data is not added");
				}
			
			int delete = statement.executeUpdate("delete from student_info where regno='2';");

			if(delete==1) {
			System.out.println("Data deleted successfully");
			} else {
			System.out.println("Data is not deleted");
			}
			
		} catch (Exception e) {

		}
		finally {
			connection.close();
		}
	}

}
