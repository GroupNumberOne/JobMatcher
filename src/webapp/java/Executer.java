package webapp.java;

import java.sql.SQLException;
import java.util.ArrayList;

public class Executer {
	
	ArrayList<String> Output;
	QueryHandler qh;
	Matcher match;
	
	// SQL query, SELECT "column" from "table"
	public ArrayList<String> selectQuery(String column, String table) throws SQLException {
		DBConnectorSingleton dbcs = DBConnectorSingleton.getInstance("145.24.222.158", "5432", "INFPRJ01-56", "postgres", "GroeP1");
		
		QueryHandler qh = new QueryHandler(dbcs.getDBConn());
		Output = qh.doSelect(column, table);

		return Output;
	}
	
	// MATCH "word to match", "column", "table"
	public ArrayList<Integer> Match(String WoordOmTeMatchen, String column, String table) throws SQLException {
		ArrayList<String> selectResults = selectQuery(column,table);
		Matcher matcher = new Matcher(WoordOmTeMatchen,selectResults);

		return matcher.Match();
	}
}