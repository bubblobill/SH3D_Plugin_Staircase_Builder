package com.eteks.test;
// Class holds the requirements and restrictions guiding stair design
public interface BuildingCode {
	public int minRisersPerFlight = 2;
	public int maxRisersPerFlight = 18;
	public int maxRisersInLine = 36;
	public double minDirectionChange = 30; // Direction change required after maxRisersInLine
	public double minAngle = 20;
	public double maxAngle = 45;
	public double minAngleRec = 30; // recommended minimum angle
	public double maxAngleRec = 38; // recommended maximum angle
	public double min2RplusG = 550; // 2 x Rising + Going = slope value
	public double max2RplusG = 700;
	public double minHeadRoom = 200;
	public double minRising = 11.5;
	public double maxRising = 19;
	public boolean openRising = true; // is open/transparent rising permitted
	public double minGoing = 24;
	public double maxGoing = 35.5;
	public double minWidth = 60;
	public double minTreadDepth = 18.5;
	public double maxTreadGap = 3; // gap between tread and next riser
	public double maxGap = 12.5;
	public double maxGapRails = maxGap;
	public double minBannisterHeight = 90;
	public double minWidthBetweenBannisters = 55;
	public double maxWidthForSingleBannister = 100;
	public double minHeightRequiringBarrier = 100;
	public double minBarrierHeight = 86.5;
	public double minLandingBarrierHeight = 100;
	public double minLanding = 75; // minimum landing length
	public double minRiseForThresholdLanding = 570; // Threshold landings are for doors
	public int minRisersForThresholdLanding = 3;
	public int maxWindersForHalfLanding = 3;
}
