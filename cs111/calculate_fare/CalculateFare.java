/**
 *  COSC 111 - Programming Assignment 1
 *  Calculating a ride sharing fare from a GPS track.
 * 
 *  Zachary Bessette, Crystal Valentine
 *  10/30/2015
 *
 */

public class CalculateFare {
    
    //The drift to tolerate in a stationary track.    
    private static final double DRIFT_TOLERANCE = 5.0 / 5280;

    // The number of seconds per part of the track to examine.
    private static final int PART_LENGTH = 15;

    // The rates -- "final" means they cannot be changed
    private static final double MINUTE_RATE = 0.25;
    private static final double MILE_RATE = 1.25;

    public static void main(String[] args) {

	// Read in the GPS trace from the file track.txt
	Trackpoint[] track = GPSTrack.trackFromFile("track_2_complete.txt");

	// If the trace could not be loaded, give an error message and quit
	if (track == null) {
	    System.err.println("Could not load track");
	    System.exit(0);
	}

	double totalDistance = 0.0;
	double waitTime = 0.0;
	double fare = 0.0;
	
	// TO DO

	int numberOfTimes = track.length / 15;//determines how many 15 second 
	                                      //intervals there are

	int lastArray = track.length % 15;//determines how long the last
	                                  //interval is

	int firstValue = 0;//represents the first value of each 15sec interval
	int holderValue = 0;//used to create the new split array

	//create the new split array with the appropriate number of values
	Trackpoint [][] newTrack = new Trackpoint [numberOfTimes+1][16];

	//for loop used to effectively create the new array splitting up time
	//intervals
	for(int i = 0; i <= numberOfTimes; i++){
	    for(int j=firstValue; j <= firstValue+15; j++){
		if (j<track.length) {//as long as j is less than the length of the track
		newTrack [i][holderValue] = track [j];
		holderValue++;
		}
	    }
	    firstValue = firstValue + 15;
	    holderValue = 0;
	}//for loops to create whole arrray


	//The following section is used to determine waitTime

	int intervalsStationary = 0;//stores how many intervals were stationary
	//for loop to check the number of intercals that were stationary
	for(int i = 0; i < numberOfTimes; i++){
	    if(isStationary(newTrack [i]))
		intervalsStationary++;
	}//for loop

	waitTime = intervalsStationary / 4.0;

	//accounts for last interval that isn't 15 seconds
	if(isStationary(newTrack[numberOfTimes]))
	    waitTime = waitTime + lastArray / 60.0;


	//The following section determines the distance traveled

	//for loop to compile the distance traveled by the vehicle
	//during each 15 second interval
	for(int i = 0; i < numberOfTimes; i++){
	    if(isStationary(newTrack[i]) == false){
		if(newTrack[i]!= null)
		    totalDistance = totalDistance + trackLength(newTrack[i]);
	    }
	}

	//accounts for the last interval that isn't 15 seconds
	if(isStationary(newTrack[numberOfTimes]) == false)
	    totalDistance = totalDistance+trackLength(newTrack[numberOfTimes]);
		

	//determines the fare of the ride
	fare = (0.25 * waitTime) + (1.25 * totalDistance);

	//used to round the fare instead of truncate
	//I used *100 and /100.0 to round to 2 decimal places
	double roundedFare = Math.round(fare*100)/ 100.0;

	  
	// Print out the total stationary time, total distance, and total fare
	// rounded to two decimal places
	System.out.printf("Wait time: %.2f\n", waitTime);
	System.out.printf("Distance: %.2f\n", totalDistance);
	System.out.printf("Fare: %.2f\n", roundedFare);
    } // main

    /*
     * Determines if the given part of a GPS track is stationary except
     * for a small amount of drift resulting from errors in the signal.
     * The track is considered stationary if all points are within some
     * small distance of the first point.
     *
     * The parameter trackPart an array of GPS trackpoints in chronological
     * order
     * The method will return true if and only if the track is stationary
     */


    //returns a boolean denoting whether the vehicle was stationary
    public static boolean isStationary(Trackpoint[] trackPart) {
	boolean stationary = true;
	for(int i = 1; i < trackPart.length; i++){
	    if(trackPart[i]!=null){//if the value stored in trackPart is not null
		if(Math.abs(trackPart[0].distance(trackPart[i])) >= 5.0/5280){
		    stationary = false;
		}
	    }
	}
	return stationary;
    } // isStationary



    /*
     * Returns the total distance of the given part of a GPS track.
     * Total distance is calculated by adding the distance between
     * all pairs of consecutive points in the track.
     *
     * The parameter trackPart an array of GPS trackpoints in chronological order
     * The method return the total distance covered by the track
     */


    //returns a double denoting how far the vehicle traveled. 
    public static double trackLength(Trackpoint[] trackPart) {
	double distanceTraveled = 0;
	for(int i = 0; i < trackPart.length-1; i++){
	    if(trackPart[i+1]!=null){//accounts for the null values in the last part of the array
		double difference = trackPart[i].distance(trackPart[i+1]);
		double absdifference = Math.abs(difference);
		distanceTraveled = absdifference + distanceTraveled;
	    }
	}
	return distanceTraveled;
    } // trackLength


    //method returns the time the car spent stationary (i.e. wait time)
    public static int timeStationary(Trackpoint[] trackPart) {
	int timeStationary = 0;
	for(int i = 0; i < trackPart.length; i++){
	    if(trackPart[i].distance(trackPart[i+1]) <= 5.0/5280)
		timeStationary++;
	}
	return timeStationary;
    }//timeStationary


}//Class
