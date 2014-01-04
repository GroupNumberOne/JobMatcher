package webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.java.Executer;
import webapp.java.Search_CV_HTML;

/**
 * Servlet implementation class Search_CV_Results
 */
@WebServlet("/Search_VAC_Results")
public class Search_VAC_Results extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Executer executer;

	private String plaatsInput;
	private String itKennisInput;
	private String functieInput;
	private String niveauInput;
	private String omschrijvingInput;
	private String kennisInput;
	private String dienstVerbandInput;
	private int plaatsRangeInput;

	ArrayList<Integer> plaatsResults;
	ArrayList<Integer> itKennisResults;
	ArrayList<Integer> functieResults;
	ArrayList<Integer> niveauResults;
	ArrayList<Integer> omschrijvingResults;
	ArrayList<Integer> kennisResults;
	ArrayList<Integer> dienstVerbandResults;
	
	Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
	String hmString ="";

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
		hmString = "";
		
		hm = executer.addToHashmap(plaatsResults, hm, 200);
		hm = executer.addToHashmap(itKennisResults, hm, 100);
		hm = executer.addToHashmap(functieResults, hm, 100);
		hm = executer.addToHashmap(niveauResults, hm, 100);
		hm = executer.addToHashmap(omschrijvingResults, hm, 100);
		hm = executer.addToHashmap(kennisResults, hm, 100);
		hm = executer.addToHashmap(dienstVerbandResults, hm, 100);
		
        hm = Executer.sortByValues(hm);
        
        Set mapSet = (Set) hm.entrySet();
        Iterator mapIterator = mapSet.iterator();
          
        int x = 0;
        ArrayList<String> AL = null;
        
        while (mapIterator.hasNext() && x < 10) {
            Map.Entry mapEntry = (Map.Entry) mapIterator.next();
            // getKey Method of HashMap access a key of map
            Integer keyValue = (Integer) mapEntry.getKey();
            //getValue method returns corresponding key's value
            Integer value = (Integer) mapEntry.getValue();

            try {
            	AL = executer.selectRowVAC(keyValue);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            hmString += ("Plaats: " + keyValue + "<br />" + " Matchingscore: " + value + "<br />" + "<br />" + AL.get(0) + "<br />" + "<br />" );
            x += 1;
        }
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// read form fields
		setPlaatsInput(request.getParameter("plaatsInput"));
		setItKennisInput(request.getParameter("itkennisInput"));
		setFunctieInput(request.getParameter("functieInput"));
		setNiveauInput(request.getParameter("niveauInput"));
		setOmschrijvingInput(request.getParameter("omschrijvingInput"));
		setKennisInput(request.getParameter("kennisInput"));
		setDienstVerbandInput(request.getParameter("dienstverbandInput"));
		setPlaatsRangeInput(request.getParameter("plaatsRangeInput"));

		executer = new Executer();
		
		plaatsResults = matchResults(plaatsInput, "plaats","vacatures");
		itKennisResults = matchResults(itKennisInput, "it_kennis", "vacatures");
		functieResults = matchResults(functieInput, "functie", "vacatures");
		niveauResults = matchResults(niveauInput, "niveau", "vacatures");
		omschrijvingResults = matchResults(omschrijvingInput, "omschrijving", "vacatures");
		kennisResults = matchResults(kennisInput, "kennis", "vacatures");
		dienstVerbandResults = matchResults(dienstVerbandInput, "dienstverband", "vacatures");
		
		createResultsHM();

		// get response writer
		PrintWriter writer = response.getWriter();

		// build HTML code
		String htmlResponse = "<h2>Resultaten</h2>";
		htmlResponse += "<h3>Hoogst scorende matches</h3>"
				+ hmString;
		htmlResponse += "<h3>Plaats: " + plaatsInput
				+ "</h3> Matches gevonden op plaats: " + plaatsResults
				+ "<br /> <br />";
		htmlResponse += "<h3>IT Kennis: " + itKennisInput
				+ "</h3> Matches gevonden op plaats: " + itKennisResults
				+ "<br /> <br />";
		htmlResponse += "<h2>Functie: " + functieInput
				+ "</h3> Matches gevonden op plaats: " + functieResults
				+ "<br /> <br />";
		htmlResponse += "<h2>Niveau: " + niveauInput
				+ "</h3> Matches gevonden op plaats: " + niveauResults
				+ "<br /> <br />";
		htmlResponse += "<h2>Omschrijving: " + omschrijvingInput
				+ "</h3> Matches gevonden op plaats: " + omschrijvingResults
				+ "<br /> <br />";
		htmlResponse += "<h2>Kennis: " + kennisInput
				+ "</h3> Matches gevonden op plaats: " + kennisResults
				+ "<br /> <br />";
		htmlResponse += "<h2>Dienstverband: " + dienstVerbandInput
				+ "</h3> Matches gevonden op plaats: " + dienstVerbandResults
				+ "<br /> <br />" + plaatsRangeInput;

		Search_CV_HTML html = new Search_CV_HTML();
		htmlResponse = html.getHTML(htmlResponse);
		
		// print
		writer.println(htmlResponse);

	}

	public String getPlaatsInput() {
		return plaatsInput;
	}

	public void setPlaatsInput(String plaatsInput) {
		this.plaatsInput = plaatsInput;
	}

	public String getItKennisInput() {
		return itKennisInput;
	}

	public void setItKennisInput(String itKennisInput) {
		this.itKennisInput = itKennisInput;
	}

	public String getFunctieInput() {
		return functieInput;
	}

	public void setFunctieInput(String functieInput) {
		this.functieInput = functieInput;
	}

	public String getNiveauInput() {
		return niveauInput;
	}

	public void setNiveauInput(String niveauInput) {
		this.niveauInput = niveauInput;
	}

	public String getOmschrijvingInput() {
		return omschrijvingInput;
	}

	public void setOmschrijvingInput(String omschrijvingInput) {
		this.omschrijvingInput = omschrijvingInput;
	}

	public String getKennisInput() {
		return kennisInput;
	}

	public void setKennisInput(String kennisInput) {
		this.kennisInput = kennisInput;
	}

	public String getDienstVerbandInput() {
		return dienstVerbandInput;
	}

	public void setDienstVerbandInput(String dienstVerbandInput) {
		this.dienstVerbandInput = dienstVerbandInput;
	}

	public int getPlaatsRangeInput() {
		return plaatsRangeInput;
	}

	public void setPlaatsRangeInput(String plaatsRangeInput) {
		this.plaatsRangeInput = Integer.parseInt(plaatsRangeInput);
	}
}