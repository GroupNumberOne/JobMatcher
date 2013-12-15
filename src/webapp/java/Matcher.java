package webapp.java;

import java.util.ArrayList;

public class Matcher{
	
	  String first;
	  ArrayList<String> second;
	  
	  ArrayList<Integer> resultsList = new ArrayList<Integer>();
	  
	  public Matcher(String first, ArrayList<String> second) {
		  this.first = first;
		  this.second = second;
	  }
	  
	  // Match String first with all values inside ArrayList second
	  public ArrayList<Integer> Match() {
		  for (int i = 0; i < second.size(); i ++) {
			  if (second.get(i) != null) {
				  if((second.get(i).toLowerCase()).matches("(.*)"+first.toLowerCase()+"(.*)")){
				  resultsList.add(i + 1);
				  }
			  }
			  else {
				  //resultsList.add(false);
			  }
		  }
		  return resultsList;
	  }
}