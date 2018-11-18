package dbproject;

//Example JDBC program to insert value in table using Statement interface
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.jdbcx.JdbcConnectionPool;
public class CreatTbl
{
	public static void main(String[] args) {
		
		try{
			//loading driver
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName ("org.h2.Driver");

			//connecting to database
			JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:~/test", "sa", "sa");
			Connection con = cp.getConnection();

			//create st object and initialize with default value
			Statement st=con.createStatement();
			ResultSet rs;

			//preparing query
			String q="create table pg(name varchar2(20),age varchar2(20), address varchar2(50),  adhar varchar2(10))";
			String insert = "INSERT INTO pg VALUES ('balaji', '25', 'wadi', 'deeloper')";
			String select = "select * from pg";

			//submitting query to database for execution
//			st.executeUpdate(q);
			System.out.println("Table Created");
			
			st.executeUpdate(insert);
			System.out.println("data inserted");

			rs = st.executeQuery(select);
			System.out.println("table data");
			while(rs.next()) {
				String id = rs.getString((1));
				String name = rs.getString(2);
				String sal = rs.getString(3);
				String des = rs.getString(4);
				System.out.println(id+"\t|"+name+"\t|"+sal+"\t|"+des);
			}
			//cleanup (resource relies)
			rs.close();
			st.close();
			con.close();
		}
		catch(SQLException | ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
}