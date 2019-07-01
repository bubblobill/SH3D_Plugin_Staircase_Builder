package com.eteks.Staircase_Constructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Staircase {
	// Defines the staircase being constructed
	double  rise = 0;
	double  run = 0;
	public List<Flight> flights = new ArrayList<>();

	public class Flight {
		double rise = 0;
		double run = 0;

		boolean includeTopStep = true;
		List<Step> steps = new ArrayList<>();
		Landing landing = new Landing();
		Banister banister = new Banister();

		NewelPost newelPost = new NewelPost();
		Boolean useBalusters = true;
		Balusters balusters = new Balusters();
		Boolean useBaseRail = true;
		Baserail baserail = new Baserail();
		Boolean useRails = false;
		Rails rails = new Rails();

		Boolean useInnerString = true;
		StringInner innerString = new StringInner();
		Boolean useOuterString = true;
		StringOuter outerString = new StringOuter();
		Boolean useUnderString = true;
		List<StringUnder> understrings = new ArrayList<>();
	}

	public class Step {
		double going = 0;
		double rising = 0;
		double height = 0;
		double width = 0;
		double nosing = 0;
		double gap = 0;
		List<Curtail> curtail = new ArrayList<>();
	}

	public class Curtail {
		public int shape = 0;
		public double stepWidth = 0;
	}

	public class Rails {
		List<Rail> rails = new ArrayList<>();
	}

	private class Rail {
		public Profile profile = null;
		public double height;
		public double width;
	}

	public class Banister {
		Rail profile = new Rail();
	}

	public class Baserail {
		Rail profile = new Rail();
	}

	public class NewelPost {
		public double finial = 0;
		public Profile newelPost = null;
		public double width;
		public double depth;
		public double volute = 0;
	}

	public class Landing {
		double length = 0;
		double fascia = 0;
		double angle = 90;
		boolean quarterLanding = true;
	}

	public class Windings {
		int count = 0;
		double angle = count > 0 ? 90 / count : 0;
	}

	public class Stringer {
		double height = 30;
		double width = 3;
		Profile profile = null;
	}

	public class StringInner {
		Stringer stringInner = new Stringer();
	}

	public class StringOuter {
		Stringer stringInner = new Stringer();
	}

	public class StringUnder {
		Stringer stringInner = new Stringer();
	}

	public class Balusters {
		List<Baluster> balusters = new ArrayList<>();
	}

	public class Baluster {
		double height = 0;
		double width = 0;
		double thickness = 0;
		Profile profile = null;
	}

    /**
     *
     * @param bCode
     * @param rise
     */
    public Staircase(BuildingCode bCode, double rise) throws Exception {
        // sets the initial values for Staircase based on the total Rise and the building code employed

        // values used from building code
        final int minRisers = bCode.minRisersPerFlight;
        final double minRising =  bCode.minRising;
        final double maxRising =  bCode.maxRising;
        final int    maxRisersPerFlight =  bCode.maxRisersPerFlight;
        final double minGoing =  bCode.minGoing;
        final double maxGoing =  bCode.maxGoing;
        final double minWidth =  bCode.minWidth;
        final double minLanding =  bCode.minLanding;

        int maxSteps = (int) Math.ceil(rise / minRising); // similarly for the most number of possible steps

        //Working out the best initial step height
        double stepRising=maxRising; // set it to a number that won't work, just in case.
        //----------------------------------------
        // find all possible step heights within bounds
        Set<Integer> possibleValues=new HashSet<>();
        for(int x=minRisers; x<=maxSteps; x++) {
            if(rise/x<=maxRising && rise/x>=minRising){
                possibleValues.add(x);
            }
        }
        // it shouldn't be possible to get an empty set, but still we wikk wrap with an if.
        if (!possibleValues.isEmpty()) {
            double target = (minRising + maxRising)/2; // this is my arbitrary target value
            // and apparently this will loop and test and assign the closest value
            stepRising = possibleValues.stream()
                    .min(Comparator.comparingDouble(d -> Math.abs(d-target)))
                    .orElseThrow(() -> new Exception("No value present"));  
        }
        // all of which may give us a useful number of steps
        int numSteps = (int) Math.round(rise/stepRising);
        int stepCount = numSteps; // for counting steps later

        // which we will use to determine the initial number of flights
        int minFlights = (int) Math.ceil(numSteps / maxRisersPerFlight); // least number of flights that must be used

        int[] stepsPerFlight=new int[minFlights]; // array of size minFlights to contain number of steps assigned to each flight
        boolean[] landingsRequired=new boolean[minFlights-1]; // array of size minFlights-1 to contain landing flags

        if (minFlights>1) {
                // distribute steps between flights and flag landings
                int flightsRemaining = minFlights;
                for (int x = 0; x < minFlights; x++){
                    flightsRemaining -= x; 
                    stepsPerFlight[x] = (int) Math.ceil(stepCount/flightsRemaining);
                    stepCount -= stepsPerFlight[x];
                    landingsRequired[x] = x+1 < minFlights; // no landing required on last flight
                }
        } else {
                stepsPerFlight[0] = stepCount;
        }

        // Define the default step, calculated rising, average going and other arbitrary values
        Step step = new Step();
        step.going = (minGoing + maxGoing)/2;
        step.rising = stepRising;
        step.height = 3.5;
        step.width = minWidth;
        step.nosing = 0;
        step.gap = 0;

        // Fill the flights
        // ----------------------
        // Create a list container
        List<Flight> allFlights = new ArrayList<>();
        // loop through number of flights
        for (int i = 0; minFlights >= i; i++) {

            // create a list of steps
            List<Step> flightsteps = new ArrayList<>();
            // and assign default step to each one in the list
            for (int j = 0; j < stepsPerFlight[i]; j++) {
                    flightsteps.set(j, step);
            }

            // now create the flight and fill it up
            Flight flight = new Flight();
            flight.rise=stepsPerFlight[i]*step.rising;
            flight.run= landingsRequired[i] ? stepsPerFlight[i]*step.going + minLanding: stepsPerFlight[i]*step.going ;
            flight.includeTopStep = true;
            flight.steps = flightsteps;
            flight.landing = new Landing();
            if(landingsRequired[i]) {				
                    flight.landing.angle=90;
                    flight.landing.fascia=30;
                    flight.landing.length=minLanding;
                    flight.landing.quarterLanding=true;
            }
            //TODO: convert these placeholders into smarter versions
            flight.banister = new Banister();
            flight.newelPost = new NewelPost();
            flight.useBalusters = true;
            flight.balusters = new Balusters();
            flight.useBaseRail = true;
            flight.baserail = new Baserail();
            flight.useRails = false;
            flight.rails = new Rails();
            flight.useInnerString = true;
            flight.innerString = new StringInner();
            flight.useOuterString = true;
            flight.outerString = new StringOuter();
            flight.useUnderString = true;

            allFlights.add(i, flight);
        }

        this.flights = allFlights;	
        this.rise = rise;
        this.run = allFlights.get(0).run;
    }
}