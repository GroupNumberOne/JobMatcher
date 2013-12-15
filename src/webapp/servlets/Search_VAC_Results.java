package webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.java.Executer;

/**
 * Servlet implementation class Search_VAC_Results
 */
@WebServlet("/Search_VAC_Results")
public class Search_VAC_Results extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Executer executer;

	private String plaatsInput;

	ArrayList<String> plaatsSelect;
	ArrayList<Integer> plaatsResults;

	public void matchplaats() throws ServletException {
		executer = new Executer();
		try {
			// plaatsSelect = executer.selectQuery("plaats","vacatures");
			plaatsResults = executer.Match(plaatsInput, "plaats", "vacatures");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String niveauInput;

	ArrayList<String> niveauSelect;
	ArrayList<Integer> niveauResults;

	public void matchNiveau() throws ServletException {
		executer = new Executer();
		try {
			// niveauSelect = executer.selectQuery("niveau","vacatures");
			niveauResults = executer.Match(niveauInput, "niveau", "vacatures");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// read form fields
		setplaatsInput(request.getParameter("plaatsInput"));
		setniveauInput(request.getParameter("niveauInput"));

		matchplaats();
		matchNiveau();

		// get response writer
		PrintWriter writer = response.getWriter();

		// build HTML code
		String htmlResponse = "<html> <h1>Resultaten</h1>";
		htmlResponse += "<h2>plaats: " + plaatsInput
				+ "</h2> Matches gevonden op plaats: " + plaatsResults
				+ "<br /> <br />";
		htmlResponse += "<h2>Niveau: " + niveauInput
				+ "</h2> Matches gevonden op plaats: " + niveauResults
				+ "<br /> <br />";
		htmlResponse += "</html>";

		// print
		writer.println(htmlResponse);
	}

	public String getplaatsInput() {
		return plaatsInput;
	}

	public void setplaatsInput(String plaatsInput) {
		this.plaatsInput = plaatsInput;
	}

	public String getniveauInput() {
		return niveauInput;
	}

	public void setniveauInput(String niveauInput) {
		this.niveauInput = niveauInput;
	}
}