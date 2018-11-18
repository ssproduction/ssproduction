package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.jdbcx.JdbcConnectionPool;

public abstract class AbstractConnection {

	private static JdbcConnectionPool cp;
	private static Connection con;
	private static Statement st;
	private static PreparedStatement ps;

//create and return Connection object
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		cp = JdbcConnectionPool.create("jdbc:h2:~/test", "sa", "sa");
		con = cp.getConnection();
		return con;
	}

	// create and return Statement object
	public static Statement getSt() throws SQLException {
		st = con.createStatement();
		return st;
	}

	// close all connections
	public static void closeCon() throws SQLException {
		con.close();
	}

	public static PreparedStatement getPs() {
		return ps;
	}

}
