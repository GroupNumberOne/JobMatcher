package webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.java.Executer;

/**
 * Servlet implementation class Search_CV_Results
 */
@WebServlet("/Search_CV_Results")
public class Search_CV_Results extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Executer executer;

	private String rijbewijsInput;
	private String woonplaatsInput;

	ArrayList<Integer> woonplaatsResults;
	ArrayList<Integer> rijbewijsResults;
	
	Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

	public ArrayList<Integer> matchResults(String input, String column, String table) throws ServletException {
		executer = new Executer();
		ArrayList<Integer> resultsVar = null;
		try {
			resultsVar = executer.Match(input, column, table);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultsVar;
	}

	public void createResultsHM() {
		hm.clear();
		
		hm = executer.addToHashmap(woonplaatsResults, hm, 100);
		hm = executer.addToHashmap(rijbewijsResults, hm, 50);
		
        hm = Executer.sortByValues(hm);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// read form fields
		setwoonplaatsInput(request.getParameter("woonplaatsInput"));
		setRijbewijsInput(request.getParameter("rijbewijs"));

		woonplaatsResults = matchResults(woonplaatsInput, "woonplaats", "cv");
		rijbewijsResults = matchResults(rijbewijsInput, "rijbewijs", "cv");
		createResultsHM();

		// get response writer
		PrintWriter writer = response.getWriter();

		// build HTML code
		String htmlResponse = "<html> <h1>Resultaten</h1>";
		htmlResponse += "<h2>Woonplaats: " + woonplaatsInput
				+ "</h2> Matches gevonden op plaats: " + woonplaatsResults
				+ "<br /> <br />";
		htmlResponse += "<h2>Rijbewijs: " + rijbewijsInput
				+ "</h2> Matches gevonden op plaats: " + rijbewijsResults
				+ "<br /> <br />";
		htmlResponse += "<h2>Aantal matchingpunten per entry gesorteerd max -> min</h2> "+hm + "</html>";

		// print
		writer.println(htmlResponse);

	}

	public String getwoonplaatsInput() {
		return woonplaatsInput;
	}

	public void setwoonplaatsInput(String woonplaatsInput) {
		this.woonplaatsInput = woonplaatsInput;
	}

	public String getRijbewijsInput() {
		return rijbewijsInput;
	}

	public void setRijbewijsInput(String rijbewijsInput) {
		this.rijbewijsInput = rijbewijsInput;
	}
}