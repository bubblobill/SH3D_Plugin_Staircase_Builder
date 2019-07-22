package staircase;

import java.awt.geom.Path2D;

public class Profile {
	public enum NosingProfileTypes {
		halfRound, quarterRound, square, squareTopBevel, squareDoubleBevel, squareBottomBevel		
	}
	Path2D path;
}

// https://stackoverflow.com/questions/40502972/is-it-possible-to-convert-svgpath-to-mesh-in-javafx
// https://stackoverflow.com/questions/48936748/how-can-i-extrude-a-complex-svg-in-processing