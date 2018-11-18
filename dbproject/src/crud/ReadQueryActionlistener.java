package crud;

import java.sql.SQLException;
import java.util.HashMap;

public class ReadQueryActionlistener {

	public ReadQueryActionlistener(HashMap<String, Object> hm) throws ClassNotFoundException, SQLException {
		if (hm.get("query").equals("save")) {
			new Save(hm);
		}
		if (hm.get("query").equals("update")) {
			new Update(hm);
		}
	}
}
