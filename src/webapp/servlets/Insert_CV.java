package webapp.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Insert CV through web
 */
@WebServlet("/Insert_CV")
public class Insert_CV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String voornaam;
	private String achternaam;
	private String tussenvoegsels;
	private String opleiding;
	private Integer jarenWerkervaring;
	private String woonplaats;
	private String cursussen;
	private String it_kennis;
	private String taalid;
	private Boolean rijbewijs;
	private String url;
	private String beroep;	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setVoornaam(request.getParameter("voornaamInput"));
		setAchternaam(request.getParameter("achternaamInput"));
		setTussenvoegsels(request.getParameter("tussenvoegselsInput"));
		setOpleiding(request.getParameter("opleidingInput"));
		//setJarenWerkervaring(request.getParameter("jarenWerkervaringInput"));
		setWoonplaats(request.getParameter("woonplaatsInput"));
		setCursussen(request.getParameter("cursussenInput"));
		setIt_kennis(request.getParameter("it-kennisInput"));
		setRijbewijs(request.getParameter("rijbewijsInput"));
		setBeroep(request.getParameter("beroepInput"));
	
		// get response writer
		PrintWriter writer = response.getWriter();
		
		// build HTML code
		String htmlResponse = "<html> <h1>Resultaten</h1>";
		htmlResponse += "Naam: " + getVoornaam()
				+ "<br /> <br />";
		htmlResponse += "Achternaam: " + getAchternaam() 
				+ "<br /> <br />";
		htmlResponse += "Tussenvoegsels: " + getTussenvoegsels() 
				+ "<br /> <br />";
		htmlResponse += "Opleiding: " + getOpleiding() 
				+ "<br /> <br />";
		htmlResponse += "jarenWerkervaring: " + getJarenWerkervaring() 
				+ "<br /> <br />";
		htmlResponse += "Woonplaats: " + getWoonplaats() 
				+ "<br /> <br />";
		htmlResponse += "Cursussen: " + getCursussen() 
				+ "<br /> <br />";
		htmlResponse += "IT-kennis: " + getIt_kennis() 
				+ "<br /> <br />";
		htmlResponse += "Rijbewijs: " + isRijbewijs()
				+ "<br /> <br />";
		htmlResponse += "Beroep: " + getBeroep() 
				+ "<br /> <br />";
		
		htmlResponse += "</html>";
		
		// print
		writer.println(htmlResponse);
	}
	
	public String getVoornaam() {
		return voornaam;
	}
	
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getTussenvoegsels() {
		return tussenvoegsels;
	}

	public void setTussenvoegsels(String tussenvoegsels) {
		this.tussenvoegsels = tussenvoegsels;
	}

	public String getOpleiding() {
		return opleiding;
	}

	public void setOpleiding(String opleiding) {
		this.opleiding = opleiding;
	}

	public Integer getJarenWerkervaring() {
		return jarenWerkervaring;
	}

	public void setJarenWerkervaring(Integer jarenWerkervaring) {
		this.jarenWerkervaring = jarenWerkervaring;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public String getCursussen() {
		return cursussen;
	}

	public void setCursussen(String cursussen) {
		this.cursussen = cursussen;
	}

	public String getIt_kennis() {
		return it_kennis;
	}

	public void setIt_kennis(String it_kennis) {
		this.it_kennis = it_kennis;
	}

	public String getTaalid() {
		return taalid;
	}

	public void setTaalid(String taalid) {
		this.taalid = taalid;
	}

	public Boolean isRijbewijs() {
		return rijbewijs;
	}

	public void setRijbewijs(String string) {
		rijbewijs = false;
		if (string != null) {
			rijbewijs = true;
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBeroep() {
		return beroep;
	}

	public void setBeroep(String beroep) {
		this.beroep = beroep;
	}
}
