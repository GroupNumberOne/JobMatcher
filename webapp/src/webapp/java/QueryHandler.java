package webapp.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryHandler {
	
	private Connection databaseConnection;
	
	private boolean voornaamDetected = false;
	private boolean achternaamDetected = false;
	private boolean tussenvoegselsDetected = false;
	private boolean opleidingDetected = false;
	private boolean jaren_werkervaringDetected = false;
	private boolean woonplaatsDetected = false;
	private boolean cursussenDetected = false;
	private boolean it_kennisDetected = false;
	private boolean taalidDetected = false;
	private boolean rijbewijsDetected = false;
	private boolean urlDetected = false;
	private boolean idDetected = false;
	private boolean beroepDetected = false;
	
	ArrayList<String> result = new ArrayList<String>();
	
	QueryHandler(Connection conn) {
		databaseConnection = conn;
	}
	
	// SQL query, INSERT "values" into "columns" in "table"
	public void doInsert(String values, String columns, String table) {
	    System.out.print("\n[INSERT WORDT UITGEVOERD]");
	    try
	    {
	      Statement st = databaseConnection.createStatement();
	      st.executeUpdate("INSERT INTO "+table+" ("+columns+") " +
	                       "VALUES ("+values+")");
	    }
	    catch (SQLException ex)
	    {
	      System.err.println(ex.getMessage());
	    }
	}
	
	// SQL query, SELECT "column" from "table"
	public ArrayList<String> doSelect(String columns, String table) {
		System.out.println("\n[SELECT WORDT UITGEVOERD]");
	    String query = "SELECT "+columns+" FROM "+table;
	    
	    String[] STANDARDcolumns = new String[]{"voornaam", "achternaam", "tussenvoegsels",
	    		"opleiding", "jaren_werkervaring", "woonplaats", "cursussen", "it_kennis",
	    		"taalid", "rijbewijs", "url", "id", "beroep"};
	    
	    for (int i = 0; i < 13; i++){
	    	if (columns.toLowerCase().matches("(.*)"+STANDARDcolumns[i]+"(.*)")) {
	    		switch (i) {
	            case 0:  voornaamDetected = true;
	                     break;
	            case 1:  achternaamDetected = true;
	                     break;
	            case 2:  tussenvoegselsDetected = true;
	                     break;
	            case 3:  opleidingDetected = true;
	                     break;
	            case 4:  jaren_werkervaringDetected = true;
	                     break;
	            case 5:  woonplaatsDetected = true;
	                     break;
	            case 6:  cursussenDetected = true;
	                     break;
	            case 7:  it_kennisDetected = true;
	                     break;
	            case 8:  taalidDetected = true;
	                     break;
	            case 9:  rijbewijsDetected = true;
	                     break;
	            case 10: urlDetected = true;
	                     break;
	            case 11: idDetected = true;
	                     break;
	            case 12: beroepDetected = true;
	                     break;
	            default: break;
	    		}
		    }
	    }
	    
	    try
	    {
	    	Statement st = databaseConnection.createStatement();
	    	ResultSet rs = st.executeQuery(query);
	    	while (rs.next())
	    	{	
	    		if (voornaamDetected) {
	    			String str = rs.getString("voornaam");
	    			result.add(str);
	    		}
	    		
	    		else if (achternaamDetected) {
	    			String str = rs.getString("achternaam");
	    			result.add(str);
	    		}
	    		
	    		else if (tussenvoegselsDetected) {
	    			String str = rs.getString("tussenvoegsels");
	    			result.add(str);
	    		}
	    		
	    		else if (opleidingDetected) {
	    			String str = rs.getString("opleiding");
	    			result.add(str);
	    		}
	    		
	    		else if (jaren_werkervaringDetected) {
	    			String str = rs.getString("jaren_werkervaring");
	    			result.add(str);
	    		}
	    		
	    		else if (woonplaatsDetected) {
	    			String str = rs.getString("woonplaats");
	    			result.add(str);
	    		}
	    		
	    		else if (cursussenDetected) {
	    			String str = rs.getString("cursussen");
	    			result.add(str);
	    		}
	    		
	    		else if (it_kennisDetected) {
	    			String str = rs.getString("it_kennis");
	    			result.add(str);
	    		}
	    		
	    		else if (taalidDetected) {
	    			String str = rs.getString("taalid");
	    			result.add(str);
	    		}
	    		
	    		else if (rijbewijsDetected) {
	    			String str = rs.getString("rijbewijs");
	    			result.add(str);
	    		}
	    		
	    		else if (urlDetected) {
	    			String str = rs.getString("url");
	    			result.add(str);
	    		}
	    		
	    		else if (idDetected) {
	    			String str = rs.getString("id");
	    			result.add(str);
	    		}
	    		
	    		else if (beroepDetected) {
	    			String str = rs.getString("beroep");
	    			result.add(str);
	    		}

	    		else if (woonplaatsDetected) {
	    			String wo = rs.getString("woonplaats");
	    			result.add(wo);
	    		}
	    	}
	    	st.close();
		    rs.close();
	    }
	    catch (SQLException ex){
	    	System.err.println(ex.getMessage());
	    }
		return result;
	}
}