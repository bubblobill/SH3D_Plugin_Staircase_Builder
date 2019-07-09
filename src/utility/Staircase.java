package utility;

import java.util.ArrayList;
import java.util.List;

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

	private class Baluster {
		double height = 0;
		double width = 0;
		double thickness = 0;
		Profile profile = null;
	}

	public Staircase(BuildingCode bCode, double rise) {
		
		int stepCount;
		int minSteps;
		
		double maxSteps = Math.ceil(rise / bCode.minRising);
		stepCount = minSteps = (int) Math.ceil(rise / bCode.maxRising);
		int minFlights = (int) Math.ceil(minSteps / bCode.maxRisersPerFlight);

		int[] stepsPerFlight=new int[minFlights];
		boolean[] landingsRequired=new boolean[minFlights];

		if (minFlights>1) {
			//TODO: distribute steps between flights evenly
			for (int x = 0; x < minFlights; x++){
				stepsPerFlight[x] = stepCount >= bCode.maxRisersPerFlight ? bCode.maxRisersPerFlight : stepCount;
				stepCount -= bCode.maxRisersPerFlight;
				landingsRequired[x] = true;
			}
		} else {
			stepsPerFlight[0] = stepCount;
		}
		landingsRequired[minFlights] = false; // remove landing from last flight

		Step step = new Step();
		step.going = (bCode.minGoing + bCode.maxGoing)/2;
		step.rising = bCode.maxRising;
		step.height = 3.5;
		step.width = bCode.minWidth;
		step.nosing = 0;
		step.gap = 0;

		List<Flight> flights = new ArrayList<>();
		for (int i = 0; i < minFlights; i++) {
			List<Step> flightsteps = new ArrayList<>();
			for (int j = 0; j < stepsPerFlight[i]; j++) {
				flightsteps.set(j, step);
			}
			Flight flight = new Flight();
			flight.rise=stepsPerFlight[i]*step.rising;
			flight.run= landingsRequired[i] ? stepsPerFlight[i]*step.going + bCode.minLanding: stepsPerFlight[i]*step.going ;
			flight.includeTopStep = true;
			flight.steps = flightsteps;
			flight.landing = new Landing();
			if(landingsRequired[i]) {				
				flight.landing.angle=90;
				flight.landing.fascia=30;
				flight.landing.length=bCode.minLanding;
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

			flights.add(i, flight);
		}

		this.flights = flights;	
		this.rise = rise;
		this.run = flights.get(0).run;
	}

}