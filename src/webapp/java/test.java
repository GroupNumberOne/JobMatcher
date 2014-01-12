package webapp.java;

public class test {
	public static void main(String[] args) {
		Executer executer = new Executer();
		DistanceCalculator testdist = new DistanceCalculator();
		
		double[] drek = null;
		try {
				drek = executer.getLatLong("eindhoven");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
		
		Double latitude = drek[0];
		Double longitude = drek[1];
		
		System.out.println("Latitude: "+drek[0]);
		System.out.println("Longitude: "+drek[1]);
		
		System.out.println(testdist.getDistance(52.3702,4.89517,51.9242,4.48178));
//		
//		Double distance = testdist.getDistance(latitude,longitude,53.120405,6.679688);
//		System.out.println("Afstand: "+distance +" KM");
//		
//		ArrayList<String> woonplaatsSelect;
//		
//		try {
//			woonplaatsSelect = executer.selectQuery("plaats","vacatures");
//			System.out.println(woonplaatsSelect.get(5));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
