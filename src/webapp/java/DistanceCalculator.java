package webapp.java;

public class DistanceCalculator {
	private double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;
		return (dist);
	}

    //  converts decimal degrees to radians
    private double deg2rad(double deg) {
    	return (deg * Math.PI / 180.0);
    }

    // converts radians to decimal degrees  
    private double rad2deg(double rad) {
    	return (rad * 180.0 / Math.PI);
    }
	    
    public double getDistance(double lat1, double lon1, double lat2, double lon2) {
	    return(distance(lat1, lon1, lat2, lon2));
    }
}