package webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

import webapp.java.Executer;

/**
 * Servlet implementation class Search_CV_Results
 */
@WebServlet("/Search_CV_Results")
public class Search_CV_Results extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Executer executer;

	private String woonplaatsInput;

	ArrayList<String> woonplaatsSelect;
	ArrayList<Integer> woonplaatsResults;

	public void matchWoonplaats() throws ServletException {
		executer = new Executer();
		try {
			// woonplaatsSelect = executer.selectQuery("woonplaats","cv");
			woonplaatsResults = executer.Match(woonplaatsInput, "woonplaats",
					"cv");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String rijbewijsInput;

	ArrayList<String> rijbewijsSelect;
	ArrayList<Integer> rijbewijsResults;

	public void matchRijbewijs() throws ServletException {
		executer = new Executer();
		try {
			// rijbewijsSelect = executer.selectQuery("rijbewijs","cv");
			rijbewijsResults = executer
					.Match(rijbewijsInput, "rijbewijs", "cv");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	String drek;
	
	public void testFunction() {
		Multiset<Integer> myMultiset = HashMultiset.create();
		
		ArrayList<Integer> totalResults = new ArrayList<Integer>();
		totalResults.addAll(rijbewijsResults);
		totalResults.addAll(woonplaatsResults);
		
		for (int i = 0; i < totalResults.size(); i++) {
			if (totalResults.get(i) != null){
				myMultiset.add(totalResults.get(i));
			}
			else if (totalResults.get(i) == null){
				drek += "null detected";
			}
		}

		for (Integer type : Multisets.copyHighestCountFirst(myMultiset).elementSet()) {
			drek += ("**Positie: " + type + " Aantal: " + myMultiset.count(type) + "** ");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// read form fields
		setwoonplaatsInput(request.getParameter("woonplaatsInput"));
		setRijbewijsInput(request.getParameter("rijbewijs"));

		matchWoonplaats();
		matchRijbewijs();
		testFunction();

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
		htmlResponse += drek + "</html>";

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