package webapp.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryHandler {

	private Connection databaseConnection;

	ArrayList<String> result = new ArrayList<String>();

	QueryHandler(Connection conn) {
		databaseConnection = conn;
	}

	// SQL query, INSERT "values" into "columns" in "table"
	public void doInsert(String values, String columns, String table) {

		try {
			Statement st = databaseConnection.createStatement();
			st.executeUpdate("INSERT INTO " + table + " (" + columns + ") "
					+ "VALUES (" + values + ")");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	// SQL query, SELECT "column" from "table"
	public ArrayList<String> doSelect(String column, String table) {
		String query = "SELECT " + column + " FROM " + table + " ORDER BY id";

		try {
			Statement st = databaseConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String str = rs.getString(column.toString());
				result.add(str);
			}

			st.close();
			rs.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return result;
	}
	
	public double[] getLatLong(String plaats) {
		if (plaats.contains("'") == true){
			plaats = plaats.replaceAll("'", "''");
		}
		
		String query = "SELECT latitude,longitude FROM geocodes WHERE city = '"+plaats+"' ORDER BY id ";
		double[] resultArray = new double[2];
		
		try {
			Statement st = databaseConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Double lat = rs.getDouble("latitude");
				Double lon = rs.getDouble("longitude");
				resultArray[0] = lat;
				resultArray[1] = lon;
			}

			st.close();
			rs.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return resultArray;
	}

	public ArrayList<String> selectRow(Integer rowID) {
		rowID -= 1;
		String query = "SELECT * FROM cv ORDER BY id LIMIT 1 OFFSET " + rowID;

		try {
			Statement st = databaseConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String vn = "Niet opgegeven";
				String tv = "Niet opgegeven";
				String an = "Niet opgegeven";
				String wp = "Niet opgegeven";
				String ol = "Niet opgegeven";
				int jw = rs.getInt("jaren_werkervaring");
				Boolean rb = rs.getBoolean("rijbewijs");
				String url = "Niet opgegeven";
				
				if (rs.getString("voornaam")!=null){
					vn = rs.getString("voornaam");
				}
				
				if (rs.getString("tussenvoegsels")!=null){
					tv = rs.getString("tussenvoegsels");
				}
				
				if (rs.getString("achternaam")!=null){
					an = rs.getString("achternaam");
				}

				if (rs.getString("woonplaats")!=null){
					wp = rs.getString("woonplaats");
				}

				if (rs.getString("opleiding")!=null){
					ol = rs.getString("opleiding");
				}
				
				if (rs.getString("url")!=null){
					url = rs.getString("url");
				}
				
				rb = rs.getBoolean("rijbewijs");

				String totalString = 
					"<table border='1'>" 
						+ "<tr>"
							+ "<td>Voornaam</td><td>"+vn+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Tussenvoegsels</td><td>"+tv+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Achternaam</td><td>"+an+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Opleiding</td><td>"+ol+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Jaren werkervaring</td><td>"+jw+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Woonplaats</td><td>"+wp+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Rijbewijs</td><td>"+rb+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Bron</td><td><a href='"+url
						+ "'target='_blank'>Klik hier om dit cv te bekijken</a>"
					+ "</table>";
				result.add(totalString);
			}

			st.close();
			rs.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return result;
	}
	
	public ArrayList<String> selectRowVAC(Integer rowID) {
		String query = "SELECT * FROM vacatures ORDER BY id LIMIT 1 OFFSET " + rowID;

		try {
			Statement st = databaseConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String plaats = "Niet opgegeven";
				String it_kennis = "Niet opgegeven";
				String functie = "Niet opgegeven";
				String niveau = "Niet opgegeven";
				String omschrijving = "Niet opgegeven";
				String kennis = "Niet opgegeven";
				String dienstverband = "Niet opgegeven";
				String url = "Niet opgegeven";
				
				if (rs.getString("plaats")!=null){
					plaats = rs.getString("plaats");
				}
				
				if (rs.getString("it_kennis")!=null){
					it_kennis = rs.getString("it_kennis");
				}
				
				if (rs.getString("functie")!=null){
					functie = rs.getString("functie");
				}

				if (rs.getString("niveau")!=null){
					niveau = rs.getString("niveau");
				}

				if (rs.getString("omschrijving")!=null){
					omschrijving = rs.getString("omschrijving");
				}
				
				if (rs.getString("kennis")!=null){
					kennis = rs.getString("kennis");
				}
				
				if (rs.getString("dienstverband")!=null){
					dienstverband = rs.getString("dienstverband");
				}
				
				if (rs.getString("url")!=null){
					url = rs.getString("url");
				}

				String totalString = 
					"<table border='1'>" 
						+ "<tr>"
							+ "<td>Plaats</td><td>"+plaats+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>IT Kennis</td><td>"+it_kennis+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Functie</td><td>"+functie+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Niveau</td><td>"+niveau+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Omschrijving</td><td>"+omschrijving+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Kennis</td><td>"+kennis+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Dienstverband</td><td>"+dienstverband+"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Bron</td><td><a href='"+url
						+ "'target='_blank'>Klik hier om deze vacature te bekijken</a>"
					+ "</table>";
				result.add(totalString);
			}

			st.close();
			rs.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return result;
	}
}