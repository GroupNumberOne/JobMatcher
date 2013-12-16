package webapp.java;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Executer {
	
	ArrayList<String> Output;
	QueryHandler qh;
	Matcher matcher;
	
	// SQL query, SELECT "column" from "table"
	public ArrayList<String> selectQuery(String column, String table) throws SQLException {
		DBConnectorSingleton dbcs = DBConnectorSingleton.getInstance(
				"145.24.222.158", "5432", "INFPRJ01-56", "postgres", "GroeP1");
		
		qh = new QueryHandler(dbcs.getDBConn());
		Output = qh.doSelect(column, table);

		return Output;
	}
	
	// MATCH "word to match", "column", "table"
	public ArrayList<Integer> Match(String WoordOmTeMatchen, String column, String table) throws SQLException {
		ArrayList<String> selectResults = selectQuery(column,table);
		matcher = new Matcher(WoordOmTeMatchen,selectResults);

		return matcher.Match();
	}
	
	public Map<Integer, Integer> addToHashmap(ArrayList<Integer> list, Map <Integer, Integer> hm, Integer score) {
		for (int i = 0; i < list.size(); i++) {
			if (hm.get(list.get(i)) != null) {
				hm.put(list.get(i), hm.get(list.get(i)) + score);
			}
			else {
				hm.put(list.get(i), score);
			}
		}
		return hm;
	}
	
	public static <K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map){
        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
      
        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {

            @Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
      
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
      
        for(Map.Entry<K,V> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
      
        return sortedMap;
    }
}