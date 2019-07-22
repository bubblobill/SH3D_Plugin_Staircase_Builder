package building_codes;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BuildingCode_NoLimits extends BuildingCode implements Serializable {
	// all sensible restrictions removed
	private static final int     minRisersPerFlight = 1;
	private static final int     maxRisersPerFlight = 999999;
	private static final int     maxRisersInLine = 999999;
	private static final double  minDirectionChange = 0;
	private static final double  minAngle = 0;
	private static final double  maxAngle = 89.99;
	private static final double  minAngleRec = 30;
	private static final double  maxAngleRec = 38;	
	private static final double  min2RplusG = 0.01;
	private static final double  max2RplusG = 99999;
	private static final double  minHeadRoom = 1;	
	private static final double  minRising = 1;
	private static final double  maxRising = 9999;	
	private static final boolean openRising = true;
	private static final double  minGoing = 1;
	private static final double  maxGoing = 9999;
	private static final double  minWidth = 1;
	private static final double  minTreadDepth = 1;
	private static final double  maxTreadGap = 9999;
	private static final double  maxGap = 9999;
	private static final double  maxGapRails = maxGap;	
	private static final double  minBannisterHeight = 0;
	private static final double  minWidthBetweenBannisters = 9999;
	private static final double  maxWidthForSingleBannister = 99999;	
	private static final double  minHeightRequiringBarrier = 0;	
	private static final double  minBarrierHeight = 0;
	private static final double  minLandingBarrierHeight = 0;	
	private static final double  minLandingLength = 1;
	private static final double  minRiseForThresholdLanding = 9999;
	private static final int     minRisersForThresholdLanding = 9999;
	private static final int     maxWindersForQuarterLanding = 99;
	private static final int     maxQuarterLandingsWithWinders = 999;

	public BuildingCode_NoLimits() {
		super(false, null, null, minRisersPerFlight, maxRisersPerFlight,
				maxRisersInLine, minDirectionChange, minAngle, maxAngle, minAngleRec, maxAngleRec, min2RplusG, max2RplusG,
				minHeadRoom, minRising, maxRising, openRising, minGoing, maxGoing, minWidth, minTreadDepth, maxTreadGap, maxGap,
				maxGapRails, minBannisterHeight, minWidthBetweenBannisters, maxWidthForSingleBannister,
				minHeightRequiringBarrier, minBarrierHeight, minLandingLength, minLandingBarrierHeight,
				minRiseForThresholdLanding, minRisersForThresholdLanding, maxWindersForQuarterLanding,
				maxQuarterLandingsWithWinders);
	}

	public BuildingCode_NoLimits(int minRisersPerFlight, int maxRisersPerFlight, int maxRisersInLine,
			double minDirectionChange, double minAngle, double maxAngle, double minAngleRec, double maxAngleRec,
			double min2RplusG, double max2RplusG, double minHeadRoom, double minRising, double maxRising,
			boolean openRising, double minGoing, double maxGoing, double minWidth, double minTreadDepth,
			double maxTreadGap, double maxGap, double maxGapRails, double minBannisterHeight,
			double minWidthBetweenBannisters, double maxWidthForSingleBannister, double minHeightRequiringBarrier,
			double minBarrierHeight, double minLandingLength, double minLandingBarrierHeight,
			double minRiseForThresholdLanding, int minRisersForThresholdLanding, int maxWindersForQuarterLanding,
			int maxQuarterLandingsWithWinders) {
		super(false, null, null, minRisersPerFlight, maxRisersPerFlight,
				maxRisersInLine, minDirectionChange, minAngle, maxAngle, minAngleRec, maxAngleRec, min2RplusG, max2RplusG,
				minHeadRoom, minRising, maxRising, openRising, minGoing, maxGoing, minWidth, minTreadDepth, maxTreadGap, maxGap,
				maxGapRails, minBannisterHeight, minWidthBetweenBannisters, maxWidthForSingleBannister,
				minHeightRequiringBarrier, minBarrierHeight, minLandingLength, minLandingBarrierHeight,
				minRiseForThresholdLanding, minRisersForThresholdLanding, maxWindersForQuarterLanding,
				maxQuarterLandingsWithWinders);
	}
}
