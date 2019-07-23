package building_codes;

import java.io.Serializable;

import staircase.Profile;
import staircase.RiserStyle;
/*
Holds the requirements and limitations for building staircases
Default values are from the Australian building code.
*/
public class BuildParameters extends BuildingCode implements Serializable {
	private static final long serialVersionUID = 1L;

	// Values
	private double  treadWidth;                   // width of step
	private double  treadDepth;                   // total step length
	private double  treadThickness;				  // thickness of step tread
	private double  treadGap;                     // gap between step and riser
	private double  nosing;                       // length of nosing
	private Profile nosingStyle;                  // nosing profile type
	private double  going=treadDepth-nosing-treadGap; // length of available step
	
	private double  rising;                       // rising for steps
	private double  riserHeight=rising-treadThickness; // height of riser
	private double  riserThickness;               // thickness of riser
	private RiserStyle riserStyle;                // style of riser
	
	private double  slopeAngle=Math.toDegrees(Math.atan(rising/going)); // angle of stair slope
	private double  slope2RplusG=(2*rising)+going; // calculated alternative to angle 2 x Rising + Going
	
	private double  gap;                          // largest gap found in staircase 
	private double  gapRails;                     // gap between rails (where rails are used instead of balusters)
	private double  bannisterHeight;              // height of bannister
	private double  widthBetweenBannisters;       // distance between bannisters
	private double  height;                       // height of staircase
	private double  barrierHeight;                // height of staircase barrier
	private double  landingLength;                // length of landing
	private double  landingBarrierHeight;         // height of barrier on landing
	private double  headroom;                     // headroom
	
	// Limits
	private int     minRisersPerFlight =  2         ; // must contain at least this many steps
	private int     maxRisersPerFlight = 18         ; // must not contain more than these many steps in a flight
	private int     maxRisersInLine = 36            ; // must turn after this many steps in a line
	private double  minDirectionChange = 30         ; // must turn at least this many degrees after maxRisersInLine
	private double  minAngle = 20                   ; // minimum angle of stair slope
	private double  maxAngle = 40                   ; // maximum angle of stair slope
	private double  minAngleRec = 30                ; // recommended minimum angle
	private double  maxAngleRec = 38                ; // recommended maximum angle
	private double  min2RplusG = 550                ; // minimum calculated alternative to angle 2 x Rising + Going
	private double  max2RplusG = 700                ; // maximum calculated alternative to angle 2 x Rising + Going
	private double  minHeadRoom = 200               ; // mimimum headroom required
	private double  minRising = 11.5                ; // minimum rising for steps
	private double  maxRising = 19                  ; // maximum rising for steps
	private boolean openRising = false              ; // is a riser open or transparent
	private double  minGoing = 24                   ; // minimum step length not including nosing overhang
	private double  maxGoing = 35.5                 ; // maximum step length not including nosing overhang
	private double  minWidth = 60                   ; // minimum width of step
	private double  minTreadDepth = 18.5            ; // minimum total step length
	private double  maxTreadGap = 3                 ; // maximum gap between step and riser
	private double  maxGap = 12.5                   ; // maximum size of object that can fit through any gap in the staircase
	private double  maxGapRails = maxGap            ; // maximum gap between rails (where rails are used instead of balusters)
	private double  minBannisterHeight = 90         ; // minimum height of bannister
	private double  minWidthBetweenBannisters = 55  ; // minimum distance between bannisters
	private double  maxWidthForSingleBannister = 100; // maximum width before second bannister is required
	private double  minHeightRequiringBarrier = 100 ; // must have a barrier if the staircase exceeds this height
	private double  minBarrierHeight = 86.5         ; // minimum height of barrier on staircase
	private double  minLandingLength = 75           ; // minimum length of landing
	private double  minLandingBarrierHeight = 100   ; // minimum height of barrier on landing
	private double  minRiseForThresholdLanding = 57 ; // Threshold landing relates to staircases ending at a door
	private int     minRisersForThresholdLanding = 3; // Threshold landing required after this many steps
	private int     maxWindersForQuarterLanding = 3 ; // Limit to number of winders allowed per quarter landing
	private int     maxQuarterLandingsWithWinders =2; // Limit to number of quarter landings in a row using winders 

	// Constructors
	public BuildParameters() {
		// You can use this one to initialise things but you really need to use the one that feeds on a Building Code
		super();
		this.headroom=minHeadRoom;               
		this.rising=minRising;             
		this.going=minGoing;                  
		this.treadWidth=minWidth;                  
		this.treadDepth=minTreadDepth; 
		this.treadThickness=5;
		this.treadGap=0;               
		this.gap=-1;                    
		this.gapRails=-1;               
		this.bannisterHeight=-1;        
		this.widthBetweenBannisters=-1; 
		this.height=0;                 
		this.barrierHeight=0;          
		this.landingLength=0;          
		this.landingBarrierHeight=-1;
		this.slopeAngle=Math.toDegrees(Math.atan(rising/going));             
		this.slope2RplusG=(2*rising)+going;
	}
	public BuildParameters(BuildingCode bCode) {
		// This one is the one to use before you start building as it sets the appropriate limitations from the building code
		super();
		this.minRisersPerFlight=bCode.minRisersPerFlight;                // must contain at least this many steps
		this.maxRisersPerFlight=bCode.maxRisersPerFlight;                // must not contain more than these many steps in a flight
		this.maxRisersInLine=bCode.maxRisersInLine;                      // must turn after this many steps in a line
		this.minDirectionChange=bCode.minDirectionChange;                // must turn at least this many degrees after maxRisersInLine
		this.minAngle=bCode.minAngle;                                    // minimum angle of stair slope
		this.maxAngle=bCode.maxAngle;                                    // maximum angle of stair slope
		this.minAngleRec=bCode.minAngleRec;                              // recommended minimum angle
		this.maxAngleRec=bCode.maxAngleRec;                              // recommended maximum angle
		this.min2RplusG=bCode.min2RplusG;                                // minimum calculated alternative to angle 2 x Rising + Going
		this.max2RplusG=bCode.max2RplusG;                                // maximum calculated alternative to angle 2 x Rising + Going
		this.minHeadRoom=bCode.minHeadRoom;                              // mimimum headroom required
		this.minRising=bCode.minRising;                                  // minimum rising for steps
		this.maxRising=bCode.maxRising;                                  // maximum rising for steps
		this.openRising=bCode.openRising;                                // is a riser open or transparent
		this.minGoing=bCode.minGoing;                                    // minimum step length not including nosing overhang
		this.maxGoing=bCode.maxGoing;                                    // maximum step length not including nosing overhang
		this.minWidth=bCode.minWidth;                                    // minimum width of step
		this.minTreadDepth=bCode.minTreadDepth;                          // minimum total step length
		this.maxTreadGap=bCode.maxTreadGap;                              // maximum gap between step and riser
		this.maxGap=bCode.maxGap;                                        // maximum size of object that can fit through any gap in the staircase
		this.maxGapRails=bCode.maxGapRails;                              // maximum gap between rails (where rails are used instead of balusters)
		this.minBannisterHeight=bCode.minBannisterHeight;                // minimum height of bannister
		this.minWidthBetweenBannisters=bCode.minWidthBetweenBannisters;  // minimum distance between bannisters
		this.maxWidthForSingleBannister=bCode.maxWidthForSingleBannister;// maximum width before second bannister is required
		this.minHeightRequiringBarrier=bCode.minHeightRequiringBarrier;  // must have a barrier if the staircase exceeds this height
		this.minBarrierHeight=bCode.minBarrierHeight;                    // minimum height of barrier on staircase
		this.minLandingLength=bCode.minLandingLength;                    // minimum length of landing
		this.minLandingBarrierHeight=bCode.minLandingBarrierHeight;      // minimum height of barrier on landing
		this.minRiseForThresholdLanding=bCode.minRiseForThresholdLanding;// Threshold landing relates to staircases ending at a door
		this.minRisersForThresholdLanding=bCode.minRisersForThresholdLanding;// Threshold landing required after this many steps
		this.headroom=minHeadRoom;               
		this.rising=minRising;             
		this.going=minGoing;                  
		this.treadWidth=minWidth;                  
		this.treadDepth=minTreadDepth;  
		this.treadThickness=5;
		this.treadGap=0;               
		this.gap=-1;                    
		this.gapRails=-1;               
		this.bannisterHeight=-1;        
		this.widthBetweenBannisters=-1; 
		this.height=0;                 
		this.barrierHeight=0;          
		this.landingLength=0;          
		this.landingBarrierHeight=-1;
		this.slopeAngle=Math.toDegrees(Math.atan(rising/going));             
		this.slope2RplusG=(2*rising)+going;
	}
	
	// Getters and Setters
	public double 	getTreadWidth() {return treadWidth;}
	public double 	getTreadDepth() {return treadDepth;}
	public double 	getTreadThickness() {return treadThickness;}
	public double 	getTreadGap() {return treadGap;}
	public double 	getNosing() {return nosing;}
	public Profile 	getNosingStyle() {return nosingStyle;}
	public double 	getGoing() {return going;}
	public double 	getRising() {return rising;}
	public double 	getRiserHeight() {return riserHeight;}
	public double 	getRiserThickness() {return riserThickness;}
	public RiserStyle getRiserStyle() {return riserStyle;}
	public double 	getSlopeAngle() {return slopeAngle;}
	public double 	getSlope2RplusG() {return slope2RplusG;}
	public double 	getGap() {return gap;}
	public double 	getGapRails() {return gapRails;}
	public double 	getBannisterHeight() {return bannisterHeight;}
	public double 	getWidthBetweenBannisters() {return widthBetweenBannisters;}
	public double 	getHeight() {return height;}
	public double 	getBarrierHeight() {return barrierHeight;}
	public double 	getLandingLength() {return landingLength;}
	public double 	getLandingBarrierHeight() {return landingBarrierHeight;}
	public double 	getHeadroom() {return headroom;}
	public int 		getMinRisersPerFlight() {return minRisersPerFlight;}
	public int 		getMaxRisersPerFlight() {return maxRisersPerFlight;}
	public int 		getMaxRisersInLine() {return maxRisersInLine;}
	public double 	getMinDirectionChange() {return minDirectionChange;}
	public double 	getMinAngle() {return minAngle;}
	public double 	getMaxAngle() {return maxAngle;}
	public double 	getMinAngleRec() {return minAngleRec;}
	public double 	getMaxAngleRec() {return maxAngleRec;}
	public double 	getMin2RplusG() {return min2RplusG;}
	public double 	getMax2RplusG() {return max2RplusG;}
	public double 	getMinHeadRoom() {return minHeadRoom;}
	public double 	getMinRising() {return minRising;}
	public double 	getMaxRising() {return maxRising;}
	public boolean 	isOpenRising() {return openRising;}
	public double 	getMinGoing() {return minGoing;}
	public double 	getMaxGoing() {return maxGoing;}
	public double 	getMinWidth() {return minWidth;}
	public double 	getMinTreadDepth() {return minTreadDepth;}
	public double 	getMaxTreadGap() {return maxTreadGap;}
	public double 	getMaxGap() {return maxGap;}
	public double 	getMaxGapRails() {return maxGapRails;}
	public double 	getMinBannisterHeight() {return minBannisterHeight;}
	public double 	getMinWidthBetweenBannisters() {return minWidthBetweenBannisters;}
	public double 	getMaxWidthForSingleBannister() {return maxWidthForSingleBannister;}
	public double 	getMinHeightRequiringBarrier() {return minHeightRequiringBarrier;}
	public double 	getMinBarrierHeight() {return minBarrierHeight;}
	public double 	getMinLandingLength() {return minLandingLength;}
	public double 	getMinLandingBarrierHeight() {return minLandingBarrierHeight;}
	public double 	getMinRiseForThresholdLanding() {return minRiseForThresholdLanding;}
	public int		getMinRisersForThresholdLanding() {return minRisersForThresholdLanding;}
	public int		getMaxWindersForQuarterLanding() {return maxWindersForQuarterLanding;}
	public int		getMaxQuarterLandingsWithWinders() {return maxQuarterLandingsWithWinders;}

	public void setTreadWidth(double treadWidth) {this.treadWidth = treadWidth;}
	public void setTreadDepth(double treadDepth) {this.treadDepth = treadDepth;}
	public void setTreadThickness(double treadThickness) {this.treadThickness = treadThickness;}
	public void setTreadGap(double treadGap) {this.treadGap = treadGap;}
	public void setNosing(double nosing) {this.nosing = nosing;}
	public void setNosingStyle(Profile nosingStyle) {this.nosingStyle = nosingStyle;}
	public void setGoing(double going) {this.going = going;}
	public void setRising(double rising) {this.rising = rising;}
	public void setRiserHeight(double riserHeight) {this.riserHeight = riserHeight;}
	public void setRiserThickness(double riserThickness) {this.riserThickness = riserThickness;}
	public void setRiserStyle(RiserStyle riserStyle) {this.riserStyle = riserStyle;}
	public void setSlopeAngle(double slopeAngle) {this.slopeAngle = slopeAngle;}
	public void setSlope2RplusG(double slope2RplusG) {this.slope2RplusG = slope2RplusG;}
	public void setGap(double gap) {this.gap = gap;}
	public void setGapRails(double gapRails) {this.gapRails = gapRails;}
	public void setBannisterHeight(double bannisterHeight) {this.bannisterHeight = bannisterHeight;}
	public void setWidthBetweenBannisters(double widthBetweenBannisters) {this.widthBetweenBannisters = widthBetweenBannisters;}
	public void setHeight(double height) {this.height = height;}
	public void setBarrierHeight(double barrierHeight) {this.barrierHeight = barrierHeight;}
	public void setLandingLength(double landingLength) {this.landingLength = landingLength;}
	public void setLandingBarrierHeight(double landingBarrierHeight) {this.landingBarrierHeight = landingBarrierHeight;}
	public void setHeadroom(double headroom) {this.headroom = headroom;}
	public void setMinRisersPerFlight(int minRisersPerFlight) {this.minRisersPerFlight = minRisersPerFlight;}
	public void setMaxRisersPerFlight(int maxRisersPerFlight) {this.maxRisersPerFlight = maxRisersPerFlight;}
	public void setMaxRisersInLine(int maxRisersInLine) {this.maxRisersInLine = maxRisersInLine;}
	public void setMinDirectionChange(double minDirectionChange) {this.minDirectionChange = minDirectionChange;}
	public void setMinAngle(double minAngle) {this.minAngle = minAngle;}
	public void setMaxAngle(double maxAngle) {this.maxAngle = maxAngle;}
	public void setMinAngleRec(double minAngleRec) {this.minAngleRec = minAngleRec;}
	public void setMaxAngleRec(double maxAngleRec) {this.maxAngleRec = maxAngleRec;}
	public void setMin2RplusG(double min2RplusG) {this.min2RplusG = min2RplusG;}
	public void setMax2RplusG(double max2RplusG) {this.max2RplusG = max2RplusG;}
	public void setMinHeadRoom(double minHeadRoom) {this.minHeadRoom = minHeadRoom;}
	public void setMinRising(double minRising) {this.minRising = minRising;}
	public void setMaxRising(double maxRising) {this.maxRising = maxRising;}
	public void setOpenRising(boolean openRising) {this.openRising = openRising;}
	public void setMinGoing(double minGoing) {this.minGoing = minGoing;}
	public void setMaxGoing(double maxGoing) {this.maxGoing = maxGoing;}
	public void setMinWidth(double minWidth) {this.minWidth = minWidth;}
	public void setMinTreadDepth(double minTreadDepth) {this.minTreadDepth = minTreadDepth;}
	public void setMaxTreadGap(double maxTreadGap) {this.maxTreadGap = maxTreadGap;}
	public void setMaxGap(double maxGap) {this.maxGap = maxGap;}
	public void setMaxGapRails(double maxGapRails) {this.maxGapRails = maxGapRails;}
	public void setMinBannisterHeight(double minBannisterHeight) {this.minBannisterHeight = minBannisterHeight;}
	public void setMinWidthBetweenBannisters(double minWidthBetweenBannisters) {this.minWidthBetweenBannisters = minWidthBetweenBannisters;}
	public void setMaxWidthForSingleBannister(double maxWidthForSingleBannister) {this.maxWidthForSingleBannister = maxWidthForSingleBannister;}
	public void setMinHeightRequiringBarrier(double minHeightRequiringBarrier) {this.minHeightRequiringBarrier = minHeightRequiringBarrier;}
	public void setMinBarrierHeight(double minBarrierHeight) {this.minBarrierHeight = minBarrierHeight;}
	public void setMinLandingLength(double minLandingLength) {this.minLandingLength = minLandingLength;}
	public void setMinLandingBarrierHeight(double minLandingBarrierHeight) {this.minLandingBarrierHeight = minLandingBarrierHeight;}
	public void setMinRiseForThresholdLanding(double minRiseForThresholdLanding) {this.minRiseForThresholdLanding = minRiseForThresholdLanding;}
	public void setMinRisersForThresholdLanding(int minRisersForThresholdLanding) {this.minRisersForThresholdLanding = minRisersForThresholdLanding;}
	public void setMaxWindersForQuarterLanding(int maxWindersForQuarterLanding) {this.maxWindersForQuarterLanding = maxWindersForQuarterLanding;}
	public void setMaxQuarterLandingsWithWinders(int maxQuarterLandingsWithWinders) {this.maxQuarterLandingsWithWinders = maxQuarterLandingsWithWinders;}
}