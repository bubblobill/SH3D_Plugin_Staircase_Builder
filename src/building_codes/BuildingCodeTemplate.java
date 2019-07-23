package building_codes;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*
Holds the requirements and limitations for building staircases
Default values are from the Australian building code.
*/
public abstract class BuildingCodeTemplate {
	public boolean 	hasConditionalFields = false	; // allows implementing flags to set conditional values
	public boolean[] conditionalFlagFields = null	; // names of additional fields that require user interaction
	public String[] conditionalFieldPrompts = null	; // text prompts for conditional fields
	
	public int     minRisersPerFlight =  2          ; // must contain at least this many steps
	public int     maxRisersPerFlight = 18          ; // must not contain more than these many steps in a flight
	public int     maxRisersInLine = 36             ; // must turn after this many steps in a line
	public double  minDirectionChange = 30          ; // must turn at least this many degrees after maxRisersInLine
	public double  minAngle = 20                    ; // minimum angle of stair slope
	public double  maxAngle = 40                    ; // maximum angle of stair slope
	public double  minAngleRec = 30                 ; // recommended minimum angle
	public double  maxAngleRec = 38                 ; // recommended maximum angle
	public double  min2RplusG = 550                 ; // minimum calculated alternative to angle 2 x Rising + Going
	public double  max2RplusG = 700                 ; // maximum calculated alternative to angle 2 x Rising + Going
	public double  minHeadRoom = 200                ; // mimimum headroom required
	public double  minRising = 11.5                 ; // minimum rising for steps
	public double  maxRising = 19                   ; // maximum rising for steps
	public boolean openRising = false               ; // is a riser open or transparent
	public double  minGoing = 24                    ; // minimum step length not including nosing overhang
	public double  maxGoing = 35.5                  ; // maximum step length not including nosing overhang
	public double  minWidth = 60                    ; // minimum width of step
	public double  minTreadDepth = 18.5             ; // minimum total step length
	public double  maxTreadGap = 3                  ; // maximum gap between step and riser
	public double  maxGap = 12.5                    ; // maximum size of object that can fit through any gap in the staircase
	public double  maxGapRails = maxGap             ; // maximum gap between rails (where rails are used instead of balusters)
	public double  minBannisterHeight = 90          ; // minimum height of bannister
	public double  minWidthBetweenBannisters = 55   ; // minimum distance between bannisters
	public double  maxWidthForSingleBannister = 100 ; // maximum width before second bannister is required
	public double  minHeightRequiringBarrier = 100  ; // must have a barrier if the staircase exceeds this height
	public double  minBarrierHeight = 86.5          ; // minimum height of barrier on staircase
	public double  minLandingLength = 75            ; // minimum length of landing
	public double  minLandingBarrierHeight = 100    ; // minimum height of barrier on landing
	public double  minRiseForThresholdLanding = 57  ; // Threshold landing relates to staircases ending at a door
	public int     minRisersForThresholdLanding = 3 ; // Threshold landing required after this many steps
	public int     maxWindersForQuarterLanding = 3  ; // Limit to number of winders allowed per quarter landing
	public int     maxQuarterLandingsWithWinders =2 ; // Limit to number of quarter landings in a row using winders 
	
	// Constructors
	public BuildingCodeTemplate(boolean hasConditionalFields, boolean[] conditionalFlagFields, 
			String[] conditionalFieldPrompts, 
			int minRisersPerFlight, int maxRisersPerFlight, int maxRisersInLine,
			double minDirectionChange, double minAngle, double maxAngle, double minAngleRec, double maxAngleRec,
			double min2RplusG, double max2RplusG, double minHeadRoom, double minRising, double maxRising,
			boolean openRising, double minGoing, double maxGoing, double minWidth, double minTreadDepth,
			double maxTreadGap, double maxGap, double maxGapRails, double minBannisterHeight,
			double minWidthBetweenBannisters, double maxWidthForSingleBannister, double minHeightRequiringBarrier,
			double minBarrierHeight, double minLandingLength, double minLandingBarrierHeight,
			double minRiseForThresholdLanding, int minRisersForThresholdLanding, int maxWindersForQuarterLanding,
			int maxQuarterLandingsWithWinders) {
		this.hasConditionalFields = hasConditionalFields;
		this.conditionalFlagFields = conditionalFlagFields;
		this.conditionalFieldPrompts = conditionalFieldPrompts;
		this.minRisersPerFlight = minRisersPerFlight;
		this.maxRisersPerFlight = maxRisersPerFlight;
		this.maxRisersInLine = maxRisersInLine;
		this.minDirectionChange = minDirectionChange;
		this.minAngle = minAngle;
		this.maxAngle = maxAngle;
		this.minAngleRec = minAngleRec;
		this.maxAngleRec = maxAngleRec;
		this.min2RplusG = min2RplusG;
		this.max2RplusG = max2RplusG;
		this.minHeadRoom = minHeadRoom;
		this.minRising = minRising;
		this.maxRising = maxRising;
		this.openRising = openRising;
		this.minGoing = minGoing;
		this.maxGoing = maxGoing;
		this.minWidth = minWidth;
		this.minTreadDepth = minTreadDepth;
		this.maxTreadGap = maxTreadGap;
		this.maxGap = maxGap;
		this.maxGapRails = maxGapRails;
		this.minBannisterHeight = minBannisterHeight;
		this.minWidthBetweenBannisters = minWidthBetweenBannisters;
		this.maxWidthForSingleBannister = maxWidthForSingleBannister;
		this.minHeightRequiringBarrier = minHeightRequiringBarrier;
		this.minBarrierHeight = minBarrierHeight;
		this.minLandingLength = minLandingLength;
		this.minLandingBarrierHeight = minLandingBarrierHeight;
		this.minRiseForThresholdLanding = minRiseForThresholdLanding;
		this.minRisersForThresholdLanding = minRisersForThresholdLanding;
		this.maxWindersForQuarterLanding = maxWindersForQuarterLanding;
		this.maxQuarterLandingsWithWinders = maxQuarterLandingsWithWinders;
	}
	public BuildingCodeTemplate() {}
	
	// Methods
	public void promptForConditionalFlagValues() {
		if(hasConditionalFields) {
			// Create dialog with checkboxes for each flag
			JCheckBox[] checkboxes = new JCheckBox[conditionalFlagFields.length];
			for(int i=0; i<conditionalFlagFields.length; i++) {
				JCheckBox cb = new JCheckBox(conditionalFieldPrompts[i]);
				checkboxes[i]=cb;
			}
			JPanel layoutPanel = new JPanel(new GridLayout(checkboxes.length+1, 1));
			layoutPanel.add(new JLabel("Please select the appropriate options"));
			for (JCheckBox c : checkboxes) {
			  layoutPanel.add(c);
			}

			int answer = JOptionPane.showConfirmDialog(null, layoutPanel, "Title", JOptionPane.OK_CANCEL_OPTION);
			// Store responses in conditional fields array
			if(answer == JOptionPane.OK_OPTION){
				for(int i=0; i<conditionalFlagFields.length; i++) {
						conditionalFlagFields[i]=checkboxes[i].isSelected();
				}
				// update conditional flags
				setConditionalFlags();
			}
		}
	}
	
	public void setConditionalFlags() {
		// placeholder to be overridden in building codes with conditional flags
	}
	
	//Getters and Setters
	public boolean 	 getHasConditionalFields()     		{return hasConditionalFields;}
	public boolean[] getConditionalFlagFields()  		{return conditionalFlagFields;}
	public String[]  getConditionalFieldPrompts() 		{return conditionalFieldPrompts;}
	
	public int 		 getMinRisersPerFlight()			{return minRisersPerFlight;}
	public int 		 getMaxRisersPerFlight()			{return maxRisersPerFlight;}
	public int 		 getMaxRisersInLine()   			{return maxRisersInLine;}
	public double 	 getMinDirectionChange()        	{return minDirectionChange;}
	public double 	 getMinAngle()                  	{return minAngle;}
	public double 	 getMaxAngle()                  	{return maxAngle;}
	public double 	 getMinAngleRec()               	{return minAngleRec;}
	public double 	 getMaxAngleRec()               	{return maxAngleRec;}
	public double 	 getMin2RplusG()                	{return min2RplusG;}
	public double 	 getMax2RplusG()                	{return max2RplusG;}
	public double 	 getMinHeadRoom()               	{return minHeadRoom;}
	public double 	 getMinRising()                 	{return minRising;}
	public double 	 getMaxRising()                 	{return maxRising;}
	public boolean 	 isOpenRising()                		{return openRising;}
	public double 	 getMinGoing()                  	{return minGoing;}
	public double 	 getMaxGoing()                  	{return maxGoing;}
	public double 	 getMinWidth()                  	{return minWidth;}
	public double 	 getMinTreadDepth()             	{return minTreadDepth;}
	public double 	 getMaxTreadGap()               	{return maxTreadGap;}
	public double 	 getMaxGap()                    	{return maxGap;}
	public double 	 getMaxGapRails()               	{return maxGapRails;}
	public double 	 getMinBannisterHeight()        	{return minBannisterHeight;}
	public double 	 getMinWidthBetweenBannisters() 	{return minWidthBetweenBannisters;}
	public double 	 getMaxWidthForSingleBannister()	{return maxWidthForSingleBannister;}
	public double 	 getMinHeightRequiringBarrier() 	{return minHeightRequiringBarrier;}
	public double 	 getMinBarrierHeight()          	{return minBarrierHeight;}
	public double 	 getMinLandingLength()          	{return minLandingLength;}
	public double 	 getMinLandingBarrierHeight()   	{return minLandingBarrierHeight;}
	public double 	 getMinRiseForThresholdLanding()	{return minRiseForThresholdLanding;}
	public int 		 getMinRisersForThresholdLanding() 	{return minRisersForThresholdLanding;}
	public int 		 getMaxWindersForQuarterLanding()  	{return maxWindersForQuarterLanding;}
	public int 		 getMaxQuarterLandingsWithWinders()	{return maxQuarterLandingsWithWinders;}
	
	
	public void setHasConditionalFields(boolean hasConditionalFields) {this.hasConditionalFields = hasConditionalFields;}
	public void setConditionalFlagFields(boolean[] conditionalFlagFields) {this.conditionalFlagFields = conditionalFlagFields;}
	public void setConditionalFieldPrompts(String[] conditionalFieldPrompts) {this.conditionalFieldPrompts = conditionalFieldPrompts;}
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