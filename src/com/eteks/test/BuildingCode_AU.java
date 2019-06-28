package com.eteks.test;

public class BuildingCode_AU implements BuildingCode{
	// Values related to Australian Standards for stairs
	// National Construction Code 2016 - Building Code of Australia (for Class 2 to 9 buildings)
	// Australian Standard AS1657-2018 - https://www.stepform.com.au/as1675-2018/stairs-detail.html
	static boolean accessibleStair = false;    // Required Stairway (public use etc.) use _Acc if true
	static boolean requiredStair = false;      // Required Stairway (public use etc.) use _Req if true
	static boolean infreqNonHabitable = false; // Infrequent Non-Habitable use _INH if true
	static boolean auStandard = false;         // Australian Standard AS1657-2018 same as INH as at 2019
	
	private static final int     minRisersPerFlight = 2;
	private static final int     maxRisersPerFlight = 18;
	private static final int     maxRisersInLine = 36;
	private static final double  minDirectionChange = 30;
	private static final double  minAngle = 20;
	private static final double  maxAngle = 45;
	private static final double  minAngleRec = 30;  // recommended minimum angle
	private static final double  maxAngleRec = 38;  // recommended maximum angle
	
	
	private static final double  min2RplusG_AS = 540;
	private static final double  min2RplusG_NH = min2RplusG_AS;
	private static final double  min2RplusG = infreqNonHabitable ? min2RplusG_NH : auStandard ? min2RplusG_AS : 550;
	private static final double  max2RplusG = 700;

	private static final double  minHeadRoom = 200;
	
	private static final double  minRising_AS = 13;
	private static final double  minRising_NH = minRising_AS;
	private static final double  minRising = infreqNonHabitable ? minRising_NH : auStandard ?  minRising_AS :  11.5;
	private static final double  maxRising_AS = 22.5;
	private static final double  maxRising_NH = maxRising_AS;
	private static final double  maxRising = infreqNonHabitable ? maxRising_NH : auStandard ? maxRising_AS : 19;

	private static final boolean openRising_ACC = false;
	private static final boolean openRising = accessibleStair ? openRising_ACC : true;

	private static final double  minGoing_AS = 21.5;
	private static final double  minGoing_NH = minGoing_AS;
	private static final double  minGoing_Req = 25;
	private static final double  minGoing = infreqNonHabitable ? minGoing_NH : requiredStair ? minGoing_Req : auStandard ? minGoing_AS : 24;
	private static final double  maxGoing = 35.5;
	
	private static final double  minWidth_Acc = 100;
	private static final double  minWidth = accessibleStair ? minWidth_Acc :  60;

	private static final double  minTreadDepth = 18.5;
	private static final double  maxTreadGap = 3;

	private static final double  maxGap_NH = 30;
	private static final double  maxGap = infreqNonHabitable ? maxGap_NH : 12.5;
	
	private static final double  maxGapRails_NH = 46;
	private static final double  maxGapRails = infreqNonHabitable ? maxGapRails_NH : maxGap;
	
	private static final double  minBannisterHeight = 90;
	
	private static final double  minWidthBetweenBannisters_Acc = 100;
	private static final double  minWidthBetweenBannisters = accessibleStair ? minWidthBetweenBannisters_Acc : 55;
	
	private static final double  maxWidthForSingleBannister_Acc = 0;
	private static final double  maxWidthForSingleBannister = accessibleStair ? maxWidthForSingleBannister_Acc : 100;

	private static final double  minHeightRequiringBarrier_Acc = 0;
	private static final double  minHeightRequiringBarrier = accessibleStair ? minHeightRequiringBarrier_Acc : 100;
	
	private static final double  minBarrierHeight = 86.5;
	private static final double  minLandingBarrierHeight = 100;
	
	private static final double  minLanding_NH = 60;
	private static final double  minLanding = infreqNonHabitable ? minLanding_NH : 75;

	private static final double  minRiseForThresholdLanding = 570;
	private static final int     minRisersForThresholdLanding = 3;
	private static final int     maxWindersForHalfLanding = 3;

	public  void setAccessibleStair(boolean accessibleStair) {
		BuildingCode_AU.accessibleStair = accessibleStair;
	}
	public  void setRequiredStair(boolean requiredStair) {
		BuildingCode_AU.requiredStair = requiredStair;
	}
	public  void setInfreqNonHabitable(boolean infreqNonHabitable) {
		BuildingCode_AU.infreqNonHabitable = infreqNonHabitable;
	}
	public  void setAuStandard(boolean auStandard) {
		BuildingCode_AU.auStandard = auStandard;
	}

	public BuildingCode_AU() {
	}
}
