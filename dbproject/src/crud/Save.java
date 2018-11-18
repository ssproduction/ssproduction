package crud;

import java.sql.SQLException;
import java.util.HashMap;

import AbstractExecuteQuery.ExecuteQuery;

public class Save extends AbstractConnection {

	ExecuteQuery eq = new ExecuteQuery();

	public Save(HashMap<String, Object> h) throws ClassNotFoundException, SQLException {

		eq.saveQuery(h);

		new DisplayInTable();
	}
}
