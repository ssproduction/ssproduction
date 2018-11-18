package AbstractExecuteQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import crud.AbstractConnection;
import crud.UI;

public class ExecuteQuery extends AbstractConnection {

	private PreparedStatement ps;

	public void saveQuery(HashMap<String, Object> h) throws ClassNotFoundException {
		try {
			ps = getCon().prepareStatement("Insert into pg values(?,?,?,?)");
			ps.setObject(1, h.get("name"));
			ps.setObject(2, h.get("age"));
			ps.setObject(3, h.get("address"));
			ps.setObject(4, h.get("adhar"));
			ps.executeUpdate();
			closeCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateQuery(HashMap<String, Object> h) throws ClassNotFoundException {
		try {
			ps = getCon().prepareStatement("UPDATE pg SET name = ?,age=?,address=?,adhar=? "
					+ "where name=? AND age=? AND address=? AND adhar=? ;");
			ps.setObject(1, h.get("name"));
			ps.setObject(2, h.get("age"));
			ps.setObject(3, h.get("address"));
			ps.setObject(4, h.get("adhar"));

			ps.setObject(5, UI.oldHm.get("name"));
			ps.setObject(6, UI.oldHm.get("age"));
			ps.setObject(7, UI.oldHm.get("address"));
			ps.setObject(8, UI.oldHm.get("adhar"));
			ps.executeUpdate();
			closeCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet selectQuery() throws SQLException, ClassNotFoundException {
		Statement st = getCon().createStatement();
		ResultSet rs;
		rs = st.executeQuery("select * from pg");
		return rs;
	}
}
