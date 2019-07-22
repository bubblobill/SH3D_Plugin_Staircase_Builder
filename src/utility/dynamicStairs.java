package utility;


import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.Level;
import com.eteks.sweethome3d.plugin.Plugin;
import com.eteks.sweethome3d.plugin.PluginAction;

public class dynamicStairs extends Plugin {
	public class dynamicStairsAction extends PluginAction {

		public BuildingCode bCode; // Building code parameters, varies by location, set in setBuildingCode
		public Staircase staircase = new Staircase(); // Defines the actual staircase

		public dynamicStairsAction() {
			putPropertyValue(Property.NAME, "Create Stairs");
			putPropertyValue(Property.MENU, "Tools");
			// Enables the action by default
			setEnabled(true);
		}

		@Override
		public void execute() {
			setBuildingCode();
			
			Home home = getHome();
			Level level = home.getSelectedLevel();
			

			Staircase staircase = new Staircase();
			staircase.rise = level.getFloorThickness() + level.getHeight();

			double maxSteps = Math.ceil(staircase.rise / BuildingCode.minRising);
			double minSteps = Math.ceil(staircase.rise / BuildingCode.maxRising);
			double minFlights = Math.ceil(minSteps / BuildingCode.maxRisersPerFlight);

		}

		private void setBuildingCode() {
			// TODO: check locale somehow and set bCode according to code
			// BuildingCode_AU requires flags be set
			bCode = new  BuildingCode();
			// TODO: input values for accessibleStair, requiredStair, infreqNonHabitable, & auStandard
		}

	}

	public static class BuildingCode_AU {
		// Constants related to Australian Standards for stairs
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
		private static final double  min2RplusG = 550;
		private static final double  max2RplusG = 700;
		private static final double  minHeadRoom = 200;
		private static final double  minRising = 11.5;
		private static final double  minRising_AS = 13;
		private static final double  minRising_NH = minRising_AS;
		private static final double  maxRising = 19;
		private static final double  maxRising_AS = 22.5;
		private static final double  maxRising_NH = maxRising_AS;
		private static final boolean openRising = true;
		private static final boolean openRising_ACC = false;
		private static final double  minGoing_AS = 21.5;
		private static final double  minGoing_NH = minGoing_AS;
		private static final double  minGoing_Req = 25;
		private static final double  minGoing = 24;
		private static final double  maxGoing = 35.5;
		private static final double  minWidth = 60;
		private static final double  minWidth_Acc = 100;
		private static final double  minTreadDepth = 18.5;
		private static final double  maxTreadGap = 3;
		private static final double  maxGap = 12.5;
		private static final double  maxGap_NH = 30;
		private static final double  maxGapRails = maxGap;
		private static final double  maxGapRails_NH = 46;
		private static final double  minBannisterHeight = 90;
		private static final double  minWidthBetweenBannisters = 55;
		private static final double  minWidthBetweenBannisters_Acc = 100;
		private static final double  maxWidthForSingleBannister = 100;
		private static final double  maxWidthForSingleBannister_Acc = 0;
		private static final double  minHeightRequiringBarrier = 100;
		private static final double  minHeightRequiringBarrier_Acc = 0;
		private static final double  minBarrierHeight = 86.5;
		private static final double  minLandingBarrierHeight = 100;
		private static final double  minLanding = 75;
		private static final double  minLanding_NH = 60;
		private static final double  minRiseForThresholdLanding = 570;
		private static final int     minRisersForThresholdLanding = 3;
		private static final int     maxWindersForHalfLanding = 3;

		public static boolean isAccessibleStair() {
			return accessibleStair;
		}
		public static void setAccessibleStair(boolean accessibleStair) {
			BuildingCode_AU.accessibleStair = accessibleStair;
		}
		public static boolean isRequiredStair() {
			return requiredStair;
		}
		public static void setRequiredStair(boolean requiredStair) {
			BuildingCode_AU.requiredStair = requiredStair;
		}
		public static boolean isInfreqNonHabitable() {
			return infreqNonHabitable;
		}
		public static void setInfreqNonHabitable(boolean infreqNonHabitable) {
			BuildingCode_AU.infreqNonHabitable = infreqNonHabitable;
		}
		public static boolean isAuStandard() {
			return auStandard;
		}
		public static void setAuStandard(boolean auStandard) {
			BuildingCode_AU.auStandard = auStandard;
		}
		public static int getMinrisersperflight() {
			return minRisersPerFlight;
		}
		public static int getMaxrisersperflight() {
			return maxRisersPerFlight;
		}
		public static int getMaxrisersinline() {
			return maxRisersInLine;
		}
		public static double getMindirectionchange() {
			return minDirectionChange;
		}
		public static double getMinangle() {
			return minAngle;
		}
		public static double getMaxangle() {
			return maxAngle;
		}
		public static double getMinanglerec() {
			return minAngleRec;
		}
		public static double getMaxanglerec() {
			return maxAngleRec;
		}
		public static double getMin2rplusg() {
			return infreqNonHabitable ? min2RplusG_NH : auStandard ? min2RplusG_AS : min2RplusG;
		}
		public static double getMax2rplusg() {
			return max2RplusG;
		}
		public static double getMinheadroom() {
			return minHeadRoom;
		}
		public static double getMinrising() {
			return infreqNonHabitable ? minRising_NH : auStandard ?  minRising_AS :  minRising;
		}
		public static double getMaxrising() {
			return infreqNonHabitable ? maxRising_NH : auStandard ? maxRising_AS : maxRising;
		}
		public static boolean isOpenrising() {
			return accessibleStair ? openRising_ACC : openRising;
		}
		public static double getMingoing() {
			return infreqNonHabitable ? minGoing_NH : requiredStair ? minGoing_Req : auStandard ? minGoing_AS : minGoing;
		}
		public static double getMaxgoing() {
			return maxGoing;
		}
		public static double getMinwidth() {
			return accessibleStair ? minWidth_Acc :  minWidth;
		}
		public static double getMintreaddepth() {
			return minTreadDepth;
		}
		public static double getMaxtreadgap() {
			return maxTreadGap;
		}
		public static double getMaxgap() {
			return infreqNonHabitable ? maxGap_NH : maxGap;
		}
		public static double getMaxgaprails() {
			return infreqNonHabitable ? maxGapRails_NH : maxGapRails;
		}
		public static double getMinbannisterheight() {
			return minBannisterHeight;
		}
		public static double getMinwidthbetweenbannisters() {
			return accessibleStair ? minWidthBetweenBannisters_Acc : minWidthBetweenBannisters;
		}
		public static double getMaxwidthforsinglebannister() {
			return accessibleStair ? maxWidthForSingleBannister_Acc : maxWidthForSingleBannister;
		}
		public static double getMinheightrequiringbarrier() {
			return accessibleStair ? minHeightRequiringBarrier_Acc :  minHeightRequiringBarrier;
		}
		public static double getMinbarrierheight() {
			return minBarrierHeight;
		}
		public static double getMinlandingbarrierheight() {
			return minLandingBarrierHeight;
		}
		public static double getMinlanding() {
			return infreqNonHabitable ? minLanding_NH :  minLanding;
		}
		public static double getMinriseforthresholdlanding() {
			return minRiseForThresholdLanding;
		}
		public static int getMinrisersforthresholdlanding() {
			return minRisersForThresholdLanding;
		}
		public static int getMaxwindersforhalflanding() {
			return maxWindersForHalfLanding;
		}
	}
	public static class BuildingCode {
		private static final int     minRisersPerFlight = 2;
		private static final int     maxRisersPerFlight = 18;
		private static final int     maxRisersInLine = 36;
		private static final double  minDirectionChange = 30;
		private static final double  minAngle = 20;
		private static final double  maxAngle = 45;
		private static final double  minAngleRec = 30;  // recommended minimum angle
		private static final double  maxAngleRec = 38;  // recommended maximum angle
		private static final double  min2RplusG = 550;
		private static final double  max2RplusG = 700;
		private static final double  minHeadRoom = 200;
		private static final double  minRising = 11.5;
		private static final double  maxRising = 19;
		private static final boolean openRising = true;
		private static final double  minGoing = 24;
		private static final double  maxGoing = 35.5;
		private static final double  minWidth = 60;
		private static final double  minTreadDepth = 18.5;
		private static final double  maxTreadGap = 3;
		private static final double  maxGap = 12.5;
		private static final double  maxGapRails = maxGap;
		private static final double  minBannisterHeight = 90;
		private static final double  minWidthBetweenBannisters = 55;
		private static final double  maxWidthForSingleBannister = 100;
		private static final double  minHeightRequiringBarrier = 100;
		private static final double  minBarrierHeight = 86.5;
		private static final double  minLandingBarrierHeight = 100;
		private static final double  minLanding = 75;
		private static final double  minRiseForThresholdLanding = 570;
		private static final int     minRisersForThresholdLanding = 3;
		private static final int     maxWindersForHalfLanding = 3;

		public static int getMinrisersperflight() {
			return minRisersPerFlight;
		}
		public static int getMaxrisersperflight() {
			return maxRisersPerFlight;
		}
		public static int getMaxrisersinline() {
			return maxRisersInLine;
		}
		public static double getMindirectionchange() {
			return minDirectionChange;
		}
		public static double getMinangle() {
			return minAngle;
		}
		public static double getMaxangle() {
			return maxAngle;
		}
		public static double getMinanglerec() {
			return minAngleRec;
		}
		public static double getMaxanglerec() {
			return maxAngleRec;
		}
		public static double getMin2rplusg() {
			return min2RplusG;
		}
		public static double getMax2rplusg() {
			return max2RplusG;
		}
		public static double getMinheadroom() {
			return minHeadRoom;
		}
		public static double getMinrising() {
			return minRising;
		}
		public static double getMaxrising() {
			return maxRising;
		}
		public static boolean isOpenrising() {
			return openRising;
		}
		public static double getMingoing() {
			return minGoing;
		}
		public static double getMaxgoing() {
			return maxGoing;
		}
		public static double getMinwidth() {
			return minWidth;
		}
		public static double getMintreaddepth() {
			return minTreadDepth;
		}
		public static double getMaxtreadgap() {
			return maxTreadGap;
		}
		public static double getMaxgap() {
			return maxGap;
		}
		public static double getMaxgaprails() {
			return maxGapRails;
		}
		public static double getMinbannisterheight() {
			return minBannisterHeight;
		}
		public static double getMinwidthbetweenbannisters() {
			return minWidthBetweenBannisters;
		}
		public static double getMaxwidthforsinglebannister() {
			return maxWidthForSingleBannister;
		}
		public static double getMinheightrequiringbarrier() {
			return minHeightRequiringBarrier;
		}
		public static double getMinbarrierheight() {
			return minBarrierHeight;
		}
		public static double getMinlandingbarrierheight() {
			return minLandingBarrierHeight;
		}
		public static double getMinlanding() {
			return minLanding;
		}
		public static double getMinriseforthresholdlanding() {
			return minRiseForThresholdLanding;
		}
		public static int getMinrisersforthresholdlanding() {
			return minRisersForThresholdLanding;
		}
		public static int getMaxwindersforhalflanding() {
			return maxWindersForHalfLanding;
		}

	}
	public class Staircase {
		// Defines the staircase being constructed
		public double balusters = 0;
		public double banister = 0;
		public double baserail = 0;
		public double curtail = 0;
		public double finial = 0;
		public double newelPost = 0;
		public double volute = 0;
		public double fascia = 0;
		public double going = 0;
		public double rising = 0;
		public double nosing = 0;
		public double landing = 0;
		public double windings = 0;
		public double rise = 0;
		public double run = 0;
		public double stringInner = 0;
		public double stringOuter = 0;
		public double stepLength = 0;
		public double stepWidth = 0;
		public double stepHeight = 0;
	}
	@Override
	public PluginAction[] getActions() {
		return new PluginAction [] {new dynamicStairsAction()}; 
	}

}
/*
https://www.practicaldiy.com/carpentry/staircase/staircase.php
Inner string (closed).
Outer string (open).
Tread.
Riser.
Newel post.
Balusters.
Banister (or handrail).
Return nosing.
Fascia.
Landing.
Curtail.

Definition of staircase parts
Balusters: The vertical posts in the space under the banister to the treads or floor (on the side of a landing).
Banister: The handrails up the side (or sides) of a stairway and, as an extension, along the edge of a landing.
Curtail step: The bottom step of a staircase which curves around sideways beyond the side of the staircase.
Fascia: The vertical covering under the edge of an exposed landing which covers the gap between ceiling and floor.
Finial: A decorative ornament used to decorate the top (and possibly the bottom) of a newel post - often in the shape of an ball, spike, urn, bun, or figure.
Half Landing: The flat area of flooring where a stairway makes a turn between main floors.
Inner (closed) string: The side of a staircase set against a wall which locates the treads and risers.
Landing: The flat area of flooring at the top and bottom of a staircase leading to rooms. 
Newel post: The vertical post at the end or turn of a banister.
Outer (open) string: The side of a staircase open to view which locates the treads and risers.
Return nosing: The moulding, (normally half round) fixed to the ends of the treads exposed in a hallway and which covers where the balusters fit into the treads.
Riser: The vertical part of a step.
Riser wedges: The, usually wooden, wedges used vertically underneath a staircase in slots cut into the strings to secure the risers.
Tread: The horizontal part of a step.
Tread wedges: The, usually wooden, wedges used horizontal underneath a staircase in slots cut into the strings to secure the treads.
Tread/riser blocks: The, usually wooden, blocks used by gluing to secure the front of the treads to the top of the risers at the front edge of each step.

https://theconstructor.org/tips/components-of-staircase/7534/
Rise: Height of staircase
Run: Length of staircase for rise
Winder: step used in turn
Volute: A handrail end element for the bullnose(curtail) step that curves inward like a spiral.
Turnout: Instead of a complete spiral volute, a turnout is a quarter-turn rounded end to the handrail.

https://www.stepform.com.au/as1675-2018/stairs-detail.html
STAIRWAYS ANGLES
The angle of the stairs slope to the horizontal is 20° to 45°,  but it is recommended to have the range between 30° and 38°.

STAIRWAYS CLEARANCES
Stairways shall be ≥ 600mm wide inside the stiles and it is to have a minimum clearance of 550mm between rails.
For stair landing; the width of the landing shall not be less than the stairway width and a minimum of 600 mm clear of cross-traffic, door swing or any other structure.
Minimum headroom is typically 2000 mm, this may need to be increased if helmets are worn. In applications where the minimum headroom cannot be achieved, other measures should be taken, Such as signage, padding and highlighting. 

FLIGHTS AND LANDINGS
The maximum of 18 risers in a flight. Adjacent flights shall be connected using a landing.
Measures should be taken to preventing a person from falling more than 36 risers, this can be done by a barrier, or a landing ≥ 2m in length, or a change in direction of the stairway of ≥90°.
The tread shall extend across the full width of the stairway and the tread surface shall be slip-resistant. The nosing shall be such that the edge of the tread is clearly visible against the background.

RISERS, GOINGS AND TREADS DIMENSIONS
 	The Riser (R) 	The going (G) 	
The slope relationship (2R + G)

Range (mm)	Min	Max	Min	Max	Min	Max
AS1657	130	225	215	355	540	700
BCA	115	190	240	355	550	700

The tread depth (TD) is to be ≥ 185mm and it should not be more than 30mm shorter than the going (G).
All risers and all goings in the same flight of stairs shall be of uniform dimensions within a tolerance of ±5 mm.

STAIRWAYS GUARDRAIL AND HANDRAILS
Except where there is a fixed structure within 100 mm of the stairway stile, stairways and stairway landings shall be provided with guardrailing on any exposed side.
Every stairway shall have at least one handrail and a handrail on each side for stairway wider than 1000mm.(refer: to handrails and guardrails for details).
*/