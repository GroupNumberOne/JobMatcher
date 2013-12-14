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
	
	ArrayList<String> results;
	ArrayList<Boolean> results2;
	
	public void init() throws ServletException {
		executer = new Executer();
		try {
			results = executer.selectQuery("rijbewijs","cv");
			results2 = executer.Match("t","rijbewijs","cv");
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlResponse = "<html>";
        htmlResponse += "<h2>Your username is: " + username + "<br/>";      
        htmlResponse += "Your password is: " + password + "</h2>";    
        htmlResponse += "</html>";
        htmlResponse += "<h1>Awesome Shizzle!</h1>Database output: " + results + "<br /> <br /> Check op matches: " + results2;
         
        // print
        writer.println(htmlResponse);
	}

}
