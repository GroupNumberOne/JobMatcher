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
 * Servlet implementation class DBTester
 */
@WebServlet("/Search_VAC_Results")
public class Search_VAC_Results extends HttpServlet {
	
	private static final long serialVersionUID = 1L;  
	private Executer executer;
	
	private String plaatsInput;
	private String niveauInput;
	
	ArrayList<String> plaatsSelect;
	ArrayList<Integer> plaatsResults;
	
	public void matchplaats() throws ServletException {
		executer = new Executer();
		try {
			//plaatsSelect = executer.selectQuery("plaats","vacatures");
			plaatsResults = executer.Match(plaatsInput,"plaats","vacatures");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
	
	ArrayList<String> rijbewijsSelect;
	ArrayList<Integer> rijbewijsResults;
	
	public void matchRijbewijs() throws ServletException {
		executer = new Executer();
		try {
			//rijbewijsSelect = executer.selectQuery("niveau","cv");
			rijbewijsResults = executer.Match(niveauInput,"niveau","cv");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		out.println("<h1>Awesome Shizzle!</h1>Database output: " + results + "<br /> <br /> Check op matches: " + results2);
//	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read form fields
        setplaatsInput(request.getParameter("plaatsInput"));
        setniveauInput(request.getParameter("niveauInput"));
        
        matchplaats();
        matchRijbewijs();
        
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlResponse = "<html> <h1>Resultaten</h1>";
        htmlResponse += "<h2>plaats: "+plaatsInput+"</h2> Matches gevonden op plaats: " + plaatsResults + "<br /> <br />";
        htmlResponse += "<h2>Niveau: "+niveauInput+"</h2> Matches gevonden op plaats: " + rijbewijsResults + "<br /> <br />";
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