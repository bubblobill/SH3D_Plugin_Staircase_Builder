package staircase;

import java.util.ArrayList;
import java.util.List;

import building_codes.BuildParameters;
import staircase.Landing.LandingType;

public class Staircase {
	// Defines the staircase being constructed
	double rise = 0;
	double run = 0;
	public List<Flight> flights = new ArrayList<>();

	public Staircase(BuildParameters bCode, double rise) {

		int stepCount;
		int minSteps;
		
		//double maxSteps = Math.ceil(rise / bCode.getMinRising());
		stepCount = minSteps = (int) Math.ceil(rise / bCode.getMaxRising());
		int minFlights = (int) Math.ceil((double)minSteps / bCode.getMaxRisersPerFlight());
		System.out.println("stepCount"+stepCount+ "minSteps"+minSteps);
		int[] stepsPerFlight = new int[minFlights];
		boolean[] landingsRequired = new boolean[minFlights];

		if (minFlights > 1) {
			// TODO: distribute steps between flights evenly
			for (int x = 0; x < minFlights; x++) {
				stepsPerFlight[x] = stepCount >= bCode.getMaxRisersPerFlight() ? bCode.getMaxRisersPerFlight() : stepCount;
				stepCount -= bCode.getMaxRisersPerFlight();
				landingsRequired[x] = true;
			}
		} else {
			stepsPerFlight[0] = stepCount;
		}
		

		Step step = new Step();
		step.setGoing((bCode.getMinGoing() + bCode.getMaxGoing()) / 2);
		step.setRising(bCode.getMaxRising());
		step.setTreadThickness(3.5);
		step.setTreadWidth(bCode.getMinWidth());
		step.setTreadNosing(0);
		step.setTreadGap(0);

		List<Flight> flights = new ArrayList<>();
		for (int i = 0; i < minFlights; i++) {
			List<Step> flightsteps = new ArrayList<>();
			for (int j = 0; j < stepsPerFlight[i]; j++) {
				System.out.println("Staircase"+j+"steps");
				flightsteps.add(j, step);
			}
			Flight flight = new Flight();
			flight.rise = stepsPerFlight[i] * step.getRising();
			flight.run = landingsRequired[i] ? stepsPerFlight[i] * step.getGoing() + bCode.getMinLandingLength()
					: stepsPerFlight[i] * step.getGoing();
			flight.includeTopStep = true;
			flight.steps = flightsteps;
			flight.landing = new Landing();
			if (landingsRequired[i]) {
				Landing.angle = 90;
				flight.landing.fascia = 30;
				flight.landing.length = bCode.getMinLandingLength();
				flight.landing.landingtype = LandingType.quarter;
			}
			// TODO: convert these placeholders into smarter versions
			flight.banister = new Banister();
			flight.newelPost = new NewelPost();
			flight.useBalusters = true;
			flight.balusters = new Balusters();
			flight.useBaseRail = true;
			flight.baserail = new Baserail();
			flight.useRails = false;
			flight.rails = new Rails();
			flight.useInnerString = true;
			flight.innerString = new StringerInner();
			flight.useOuterString = true;
			flight.outerString = new StringerOuter();
			flight.useUnderString = true;

			flights.add(i, flight);
			System.out.println("Staircase"+i+"flights");
		}

		this.flights = flights;
		this.rise = rise;
		this.run = flights.get(0).run;
	}

}