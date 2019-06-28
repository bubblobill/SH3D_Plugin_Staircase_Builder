package com.eteks.test;
/*
Holds the requirements and limitations for building staircases
Default values are from the Australian building code.
*/
public interface BuildingCode {
	public int minRisersPerFlight = 2;
	public int maxRisersPerFlight = 18;
	public int maxRisersInLine = 36; // must turn after this many steps in a line
	public double minDirectionChange = 30;
	public double minAngle = 20;    // angle of stairs
	public double maxAngle = 45;
	public double minAngleRec = 30; // recommended minimum angle
	public double maxAngleRec = 38; // recommended maximum angle
	public double min2RplusG = 550; // calculated alternative to angle 2 x Rising + Going
	public double max2RplusG = 700;
	public double minHeadRoom = 200;
	public double minRising = 11.5; // rising = step height
	public double maxRising = 19;
	public boolean openRising = true; // is an riser open or transparent
	public double minGoing = 24;	// going = step length not including overhang
	public double maxGoing = 35.5;
	public double minWidth = 60;
	public double minTreadDepth = 18.5;
	public double maxTreadGap = 3;
	public double maxGap = 12.5;	// maximum size of object that can fit through any gap in the staircase
	public double maxGapRails = maxGap; // maximum gap between rails (rails used instead of balusters)
	public double minBannisterHeight = 90;
	public double minWidthBetweenBannisters = 55;
	public double maxWidthForSingleBannister = 100; // must have two bannisters if exceeded
	public double minHeightRequiringBarrier = 100; // must have a barrier if the height is exceeded
	public double minBarrierHeight = 86.5;
	public double minLandingBarrierHeight = 100;
	public double minLanding = 75; // landing must be at least this long
	public double minRiseForThresholdLanding = 570; // Threshold landing relates to staircases ending at a door
	public int minRisersForThresholdLanding = 3;
	public int maxWindersForQuarterLanding = 3; // Winders are turning steps
}
