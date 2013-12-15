package webapp.java;

import java.sql.SQLException;
import java.util.ArrayList;

import webapp.java.Executer;

// JUST A TEST CLASS

public class MatchingTest {
	public static void main(String args[]) {

		Executer executer = new Executer();
		ArrayList<String> results;

		try {
			results = executer.selectQuery("woonplaats", "cv");

			Matcher matcher2 = new Matcher("Amsterdam", results);
			System.out.println(matcher2.Match());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
