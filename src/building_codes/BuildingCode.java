package building_codes;
import java.io.Serializable;
/*
Holds the requirements and limitations for building staircases
Default values are from the Australian building code.
*/


public class BuildingCode extends BuildingCodeTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public BuildingCode(boolean hasConditionalFields, boolean[] conditionalFlagFields, 
			String[] conditionalFieldPrompts,
			int minRisersPerFlight, int maxRisersPerFlight, int maxRisersInLine, double minDirectionChange,
			double minAngle, double maxAngle, double minAngleRec, double maxAngleRec, double min2RplusG,
			double max2RplusG, double minHeadRoom, double minRising, double maxRising, boolean openRising,
			double minGoing, double maxGoing, double minWidth, double minTreadDepth, double maxTreadGap, double maxGap,
			double maxGapRails, double minBannisterHeight, double minWidthBetweenBannisters,
			double maxWidthForSingleBannister, double minHeightRequiringBarrier, double minBarrierHeight,
			double minLandingLength, double minLandingBarrierHeight, double minRiseForThresholdLanding,
			int minRisersForThresholdLanding, int maxWindersForQuarterLanding, int maxQuarterLandingsWithWinders) {

		super(hasConditionalFields, conditionalFlagFields, conditionalFieldPrompts,  
				minRisersPerFlight, maxRisersPerFlight, maxRisersInLine, minDirectionChange, minAngle, maxAngle,
				minAngleRec, maxAngleRec, min2RplusG, max2RplusG, minHeadRoom, minRising, maxRising, openRising,
				minGoing, maxGoing, minWidth, minTreadDepth, maxTreadGap, maxGap, maxGapRails, minBannisterHeight,
				minWidthBetweenBannisters, maxWidthForSingleBannister, minHeightRequiringBarrier, minBarrierHeight,
				minLandingLength, minLandingBarrierHeight, minRiseForThresholdLanding, minRisersForThresholdLanding, 
				maxWindersForQuarterLanding, maxQuarterLandingsWithWinders);
	}
	
	public BuildingCode() {
		super();
	}
	public boolean getHasConditionalFields()		{return hasConditionalFields;}
	public boolean[] getConditionalFlagFields()		{return conditionalFlagFields;}
	public String[] getConditionalFieldPrompts()	{return conditionalFieldPrompts;}
	
	public int     getMinRisersPerFlight()          {return minRisersPerFlight;}
	public int     getMaxRisersPerFlight()          {return maxRisersPerFlight;}
	public int     getMaxRisersInLine()             {return maxRisersInLine;}
	public double  getMinDirectionChange()          {return minDirectionChange;}
	public double  getMinAngle()                    {return minAngle;}
	public double  getMaxAngle()                    {return maxAngle;}
	public double  getMinAngleRec()                 {return minAngleRec;}
	public double  getMaxAngleRec()                 {return maxAngleRec;}
	public double  getMin2RplusG()                  {return min2RplusG;}
	public double  getMax2RplusG()                  {return max2RplusG;}
	public double  getMinHeadRoom()                 {return minHeadRoom;}
	public double  getMinRising()                   {return minRising;}
	public double  getMaxRising()                   {return maxRising;}
	public boolean isOpenRising()                   {return openRising;}
	public double  getMinGoing()                    {return minGoing;}
	public double  getMaxGoing()                    {return maxGoing;}
	public double  getMinWidth()                    {return minWidth;}
	public double  getMinTreadDepth()               {return minTreadDepth;}
	public double  getMaxTreadGap()                 {return maxTreadGap;}
	public double  getMaxGap()                      {return maxGap;}
	public double  getMaxGapRails()                 {return maxGapRails;}
	public double  getMinBannisterHeight()          {return minBannisterHeight;}
	public double  getMinWidthBetweenBannisters()   {return minWidthBetweenBannisters;}
	public double  getMaxWidthForSingleBannister()  {return maxWidthForSingleBannister;}
	public double  getMinHeightRequiringBarrier()   {return minHeightRequiringBarrier;}
	public double  getMinBarrierHeight()            {return minBarrierHeight;}
	public double  getMinLandingLength()            {return minLandingLength;}
	public double  getMinLandingBarrierHeight()     {return minLandingBarrierHeight;}
	public double  getMinRiseForThresholdLanding()  {return minRiseForThresholdLanding;}
	public int     getMinRisersForThresholdLanding(){return minRisersForThresholdLanding;}
	public int     maxWindersForQuarterLanding()    {return maxWindersForQuarterLanding;}
	public int     maxQuarterLandingsWithWinders()  {return maxQuarterLandingsWithWinders;}
	
	public void setHasConditionalFields(boolean hasConditionalFields) {
		this.hasConditionalFields = hasConditionalFields;}
	public void setconditionalFlagFields(boolean[] conditionalFlagFields) {
		this.conditionalFlagFields = conditionalFlagFields;}
	public void setConditionalFieldPrompts(String[] conditionalFieldPrompts) {
		this.conditionalFieldPrompts = conditionalFieldPrompts;}

	public void setMinRisersPerFlight(int minRisersPerFlight) {
		this.minRisersPerFlight = minRisersPerFlight;}
	public void setMaxRisersPerFlight(int maxRisersPerFlight) {
		this.maxRisersPerFlight = maxRisersPerFlight;}
	public void setMaxRisersInLine(int maxRisersInLine) {
		this.maxRisersInLine = maxRisersInLine;}
	public void setMinDirectionChange(double minDirectionChange) {
		this.minDirectionChange = minDirectionChange;}
	public void setMinAngle(double minAngle) {
		this.minAngle = minAngle;}
	public void setMaxAngle(double maxAngle) {
		this.maxAngle = maxAngle;}
	public void setMinAngleRec(double minAngleRec) {
		this.minAngleRec = minAngleRec;}
	public void setMaxAngleRec(double maxAngleRec) {
		this.maxAngleRec = maxAngleRec;}
	public void setMin2RplusG(double min2RplusG) {
		this.min2RplusG = min2RplusG;}
	public void setMax2RplusG(double max2RplusG) {
		this.max2RplusG = max2RplusG;}
	public void setMinHeadRoom(double minHeadRoom) {
		this.minHeadRoom = minHeadRoom;}
	public void setMinRising(double minRising) {
		this.minRising = minRising;}
	public void setMaxRising(double maxRising) {
		this.maxRising = maxRising;}
	public void setOpenRising(boolean openRising) {
		this.openRising = openRising;}
	public void setMinGoing(double minGoing) {
		this.minGoing = minGoing;}
	public void setMaxGoing(double maxGoing) {
		this.maxGoing = maxGoing;}
	public void setMinWidth(double minWidth) {
		this.minWidth = minWidth;}
	public void setMinTreadDepth(double minTreadDepth) {
		this.minTreadDepth = minTreadDepth;}
	public void setMaxTreadGap(double maxTreadGap) {
		this.maxTreadGap = maxTreadGap;}
	public void setMaxGap(double maxGap) {
		this.maxGap = maxGap;}
	public void setMaxGapRails(double maxGapRails) {
		this.maxGapRails = maxGapRails;}
	public void setMinBannisterHeight(double minBannisterHeight) {
		this.minBannisterHeight = minBannisterHeight;}
	public void setMinWidthBetweenBannisters(double minWidthBetweenBannisters) {
		this.minWidthBetweenBannisters = minWidthBetweenBannisters;}
	public void setMaxWidthForSingleBannister(double maxWidthForSingleBannister) {
		this.maxWidthForSingleBannister = maxWidthForSingleBannister;}
	public void setMinHeightRequiringBarrier(double minHeightRequiringBarrier) {
		this.minHeightRequiringBarrier = minHeightRequiringBarrier;}
	public void setMinBarrierHeight(double minBarrierHeight) {
		this.minBarrierHeight = minBarrierHeight;}
	public void setMinLandingLength(double minLandingLength) {
		this.minLandingLength = minLandingLength;}
	public void setMinLandingBarrierHeight(double minLandingBarrierHeight) {
		this.minLandingBarrierHeight = minLandingBarrierHeight;}
	public void setMinRiseForThresholdLanding(double minRiseForThresholdLanding) {
		this.minRiseForThresholdLanding = minRiseForThresholdLanding;}
	public void setMinRisersForThresholdLanding(int minRisersForThresholdLanding) {
		this.minRisersForThresholdLanding = minRisersForThresholdLanding;}
	public void setmaxWindersForQuarterLanding(int maxWindersForQuarterLanding) {
		this.maxWindersForQuarterLanding = maxWindersForQuarterLanding;}
	public void setmaxQuarterLandingsWithWinders(int maxQuarterLandingsWithWinders) {
		this.maxQuarterLandingsWithWinders = maxQuarterLandingsWithWinders;}
}