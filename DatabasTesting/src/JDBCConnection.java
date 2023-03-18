import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = DriverManager.getConnection("jdbc:mysql://"+"localhost"+":"+"3306"+"/qadbtselenium", "ishita", "ishita");
		
		Statement s =  conn.createStatement();
		
		ResultSet rs = s.executeQuery("select * from employeeinfo where id =1");
		rs.next();
		System.out.println("hello");
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString("age"));
		System.out.println(rs.getString("location"));

	}

}
	