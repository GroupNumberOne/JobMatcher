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
import webapp.java.Search_Results_HTML;

/**
 * Servlet implementation class Search_CV_Results
 */
@WebServlet("/Search_CV_Results")
public class Search_CV_Results extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Executer executer;

	private String rijbewijsInput;
	private String itKennisInput;
	private String woonplaatsInput;
	private String opleidingInput;
	private String beroepInput;
	private int plaatsRangeInput;

	ArrayList<String> woonplaatsResults;
	ArrayList<Integer> rijbewijsResults;
	ArrayList<Integer> opleidingResults;
	ArrayList<Integer> beroepResults;
	ArrayList<Integer> itKennisResults;
	
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
		
		hm = executer.addToHashmapPlaats(woonplaatsResults, hm, plaatsRangeInput, woonplaatsInput);
		hm = executer.addToHashmap(rijbewijsResults, hm, 100);
		hm = executer.addToHashmap(opleidingResults, hm, 100);
		hm = executer.addToHashmap(beroepResults, hm, 100);
		hm = executer.addToHashmap(itKennisResults, hm, 100);
		
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
            	AL = executer.selectRow(keyValue);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            x += 1;
            keyValue += 1;
            hmString += ("Rankingplaats: "+x+"<br />" + "<br />" + AL.get(0) + "<br />" + "<br />" );
            //"Plaats: " + keyValue + "<br />" + " Matchingscore: " + value
        }
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// read form fields
		setWoonplaatsInput(request.getParameter("woonplaatsInput"));
		setRijbewijsInput(request.getParameter("rijbewijsInput"));
		setOpleidingInput(request.getParameter("opleidingInput"));
		setBeroepInput(request.getParameter("beroepInput"));
		setItKennisInput(request.getParameter("itKennisInput"));
		setPlaatsRangeInput("0");
		setPlaatsRangeInput(request.getParameter("plaatsRangeInput"));
		
		executer = new Executer();
		
		try {
			woonplaatsResults = executer.selectQuery("woonplaats","cv");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rijbewijsResults = matchResults(rijbewijsInput, "rijbewijs", "cv");
		opleidingResults = matchResults(opleidingInput, "opleiding", "cv");
		beroepResults = matchResults(beroepInput, "beroep", "cv");
		itKennisResults = matchResults(itKennisInput, "it_kennis", "cv");
		createResultsHM();

		// get response writer
		PrintWriter writer = response.getWriter();

		// build HTML code
		String htmlResponse = "<h2>Resultaten</h2>";
		htmlResponse += "<h3>Hoogst scorende matches</h3>" + hmString;

		Search_Results_HTML template = new Search_Results_HTML();
		htmlResponse = template.getHTML(htmlResponse);
		
		// print
		writer.println(htmlResponse);

	}

	public String getWoonplaatsInput() {
		return woonplaatsInput;
	}

	public void setWoonplaatsInput(String woonplaatsInput) {
		this.woonplaatsInput = woonplaatsInput;
	}

	public String getRijbewijsInput() {
		return rijbewijsInput;
	}

	public void setRijbewijsInput(String rijbewijsInput) {
		this.rijbewijsInput = rijbewijsInput;
	}
	
	public String getOpleidingInput() {
		return rijbewijsInput;
	}

	public void setOpleidingInput(String opleidingInput) {
		this.opleidingInput = opleidingInput;
	}
	
	public String getBeroepInput() {
		return beroepInput;
	}

	public void setBeroepInput(String BeroepInput) {
		this.beroepInput = BeroepInput;
	}

	public int getPlaatsRangeInput() {
		return plaatsRangeInput;
	}

	public void setPlaatsRangeInput(String plaatsRangeInput) {
		this.plaatsRangeInput = Integer.parseInt(plaatsRangeInput);
	}

	public String getItKennisInput() {
		return itKennisInput;
	}

	public void setItKennisInput(String itKennisInput) {
		this.itKennisInput = itKennisInput;
	}
}