package webapp.java;

import java.util.ArrayList;

public class Matcher{
	
	  String first;
	  ArrayList<String> second;
	  
	  ArrayList<Boolean> resultsList = new ArrayList<Boolean>();
	  
	  public Matcher(String first, ArrayList<String> second) {
		  this.first = first;
		  this.second = second;
	  }
	  
	  // Match String first with all values inside ArrayList second
	  public ArrayList<Boolean> Match() {
		  for (int i = 0; i < second.size(); i ++) {
			  if (second.get(i) != null) {
				  resultsList.add((second.get(i).toLowerCase()).matches("(.*)"+first.toLowerCase()+"(.*)"));
			  }
			  else {
				  resultsList.add(false);
			  }
		  }
		  return resultsList;
	  }
}