package staircase;
// Riser: The vertical part of a step.
public class RiserStyle {
	public enum RiserStyles {
		solid, open, transparent, horizontalBottomRail, horizontalTopRail, 
		horizontalMidRail, horizontalRails, verticalRails, mesh, drawers
	}
	RiserStyles riserStyle;
	
	public RiserStyle() {
		this.riserStyle = RiserStyles.solid;
	}
	public RiserStyle(RiserStyles riserStyle) {
		this.riserStyle = riserStyle;
	}
	

}
