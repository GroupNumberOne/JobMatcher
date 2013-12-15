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
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;  
	private Executer executer;
	
	private String woonplaatsInput;
	private String tableInput;
	private String rijbewijsInput;
	
	ArrayList<String> woonplaatsSelect;
	ArrayList<Integer> woonplaatsResults;
	
	public void matchWoonplaats() throws ServletException {
		executer = new Executer();
		try {
			woonplaatsSelect = executer.selectQuery("woonplaats",tableInput);
			woonplaatsResults = executer.Match(woonplaatsInput,"woonplaats",tableInput);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
	
	ArrayList<String> rijbewijsSelect;
	ArrayList<Integer> rijbewijsResults;
	
	public void matchRijbewijs() throws ServletException {
		executer = new Executer();
		try {
			rijbewijsSelect = executer.selectQuery("rijbewijs",tableInput);
			rijbewijsResults = executer.Match(rijbewijsInput,"rijbewijs",tableInput);
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
        setwoonplaatsInput(request.getParameter("woonplaatsInput"));
        settableInput(request.getParameter("tableInput"));
        setRijbewijsInput(request.getParameter("rijbewijs"));
        
        matchWoonplaats();
        matchRijbewijs();
        
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlResponse = "<html> <h1>Resultaten</h1>";
        htmlResponse += "<h2>Woonplaats: "+woonplaatsInput+"</h2> Matches gevonden op plaats: " + woonplaatsResults + "<br /> <br />";
        htmlResponse += "<h2>Rijbewijs: "+rijbewijsInput+"</h2> Matches gevonden op plaats: " + rijbewijsResults + "<br /> <br />";
        htmlResponse += "</html>";
        
        // print
        writer.println(htmlResponse);
	}

	public String getwoonplaatsInput() {
		return woonplaatsInput;
	}

	public void setwoonplaatsInput(String woonplaatsInput) {
		this.woonplaatsInput = woonplaatsInput;
	}

	public String gettableInput() {
		return tableInput;
	}

	public void settableInput(String tableInput) {
		this.tableInput = tableInput;
	}

	public String getRijbewijsInput() {
		return rijbewijsInput;
	}

	public void setRijbewijsInput(String rijbewijsInput) {
		this.rijbewijsInput = rijbewijsInput;
	}
}