package webapp.java;

import java.io.StringReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;


public class Geocode {
	public Double[] getCoordinates(String addr) throws Exception
	{
	    // build a URL
	    String s = "http://services.gisgraphy.com//geocoding/geocode?address=";
	    s += URLEncoder.encode(addr, "UTF-8");
	    s += "&country=NL";
	    URL url = new URL(s);
	 
	    // read from the URL
	    Scanner scan = new Scanner(url.openStream());
	    String str = new String();
	    while (scan.hasNext())
	        str += scan.nextLine();
	    scan.close();
	    
	    XPathFactory xpathFactory = XPathFactory.newInstance();
	    XPath xpath = xpathFactory.newXPath();

	    InputSource source = new InputSource(new StringReader(str));
	    Document doc = (Document) xpath.evaluate("/", source, XPathConstants.NODE);
	    String lat = xpath.evaluate("/results/result/lat", doc);
	    String lng = xpath.evaluate("/results/result/lng", doc);
	    
	    Double[] ar = new Double[2];
	    ar[0] = Double.parseDouble(lat);
	    ar[1] = Double.parseDouble(lng);
		return ar;
	}
}
