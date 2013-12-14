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
	
	private String box1;
	private String box2;
	private String box3;
	
	ArrayList<String> select1;
	ArrayList<Boolean> results1;
	
	public void voeruit() throws ServletException {
		executer = new Executer();
		try {
			select1 = executer.selectQuery(box1,box2);
			results1 = executer.Match(box3,box1,box2);
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
        setBox1(request.getParameter("box1"));
        setBox2(request.getParameter("box2"));
        setBox3(request.getParameter("box3"));
        
        voeruit();
        
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlResponse = "<html>";
        htmlResponse += "<h1>Awesome Shizzle!</h1>Database output: " + select1 + "<br /> <br /> Check op matches: " + results1;
        htmlResponse += "</html>";
        
        // print
        writer.println(htmlResponse);
        
	}

	public String getBox1() {
		return box1;
	}

	public void setBox1(String box1) {
		this.box1 = box1;
	}

	public String getBox2() {
		return box2;
	}

	public void setBox2(String box2) {
		this.box2 = box2;
	}

	public String getBox3() {
		return box3;
	}

	public void setBox3(String box3) {
		this.box3 = box3;
	}

}
