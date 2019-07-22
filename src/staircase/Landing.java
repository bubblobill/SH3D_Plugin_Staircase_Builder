package staircase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import building_codes.BuildParameters;
// Landing: The flat area of flooring at the top and bottom of a staircase leading to rooms.
public class Landing implements Serializable{
	private static final long serialVersionUID = -1508852352114778707L;

	public enum LandingType {
		quarter, half, threeQuarter, full
	};
	// Half Landing: The flat area of flooring where a stairway makes a 180 degree turn between main floors.

	private BuildParameters bParam;

	double length = 75;
	double fascia = 30; //Fascia: The vertical covering under the edge of an exposed landing which covers the gap between ceiling and floor.
	static double angle = 0;
	LandingType landingtype = LandingType.quarter;

	public class Windings {
		int numWindings = 0;
		List<Winder> windings = new ArrayList<>(numWindings);
	}

	// Winder: step used in turn
	public class Winder {
		int numWindings = 0;
		int windingNumber = 0;
		private double angle = numWindings > 0 ? (90+Landing.angle) / numWindings : 0;
		double startAngle = windingNumber * angle;
		double endAngle = (windingNumber + 1) * angle;
		// boolean quadrilateral = numWindings > 0 ? (startAngle<45) && (endAngle>45) :
		// false;
		double landingLength = bParam.getLandingLength();
		double stairsWidth = bParam.getTreadWidth();

		double cornerAngle = Landing.angle + Math.toDegrees(Math.atan(bParam.getMinLandingLength() / bParam.getMinWidth()));

		boolean quadrilateral = numWindings > 0 ? (startAngle < cornerAngle) && (endAngle > cornerAngle) : false;

	}

}
