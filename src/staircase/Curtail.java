package staircase;

import java.io.Serializable;
// Curtail step: The bottom step of a staircase which curves around sideways beyond the side of the staircase.
public class Curtail extends Step implements Serializable{
	private static final long serialVersionUID = 8806529977625827442L;
	
	public int shape = 0;
	public double stepWidth = 0;
}