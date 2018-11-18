package crud;



import java.sql.SQLException;
import java.util.HashMap;

import AbstractExecuteQuery.ExecuteQuery;

public class Update extends AbstractConnection  {
	
	ExecuteQuery eq = new ExecuteQuery();
	public Update(HashMap <String,Object> h) throws ClassNotFoundException, SQLException {
	
		eq.updateQuery(h);
			new DisplayInTable();
	}
}