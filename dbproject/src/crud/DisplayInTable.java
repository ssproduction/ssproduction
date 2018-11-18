package crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import AbstractExecuteQuery.ExecuteQuery;

public class DisplayInTable  {

	private ResultSet rs;
	private static int count = 0;
	
	public DisplayInTable() throws SQLException, ClassNotFoundException {
		
		rs=new ExecuteQuery().selectQuery();
				
		if (count++ == 0) {}
		else {
			//clear table data except first time execution
			UI.model.setRowCount(0);
		}
		
		while (rs.next()) {
			UI.model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4)});
		}
		AbstractConnection.closeCon();
	}
}
