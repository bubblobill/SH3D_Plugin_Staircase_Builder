package staircase;

import java.io.Serializable;

public class Dimension3D implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static double height = 1;
	private static double width  = 1;
	private static double depth  = 1;
	public double[] dimension = {height, width, depth};
	
	public double[] getDimension() { return dimension; }
	public void setDimension(double[] dimension) {
		this.dimension = dimension; 
		Dimension3D.height = dimension[0];
		Dimension3D.width  = dimension[1];
		Dimension3D.depth  = dimension[2];
	}
	
	public Dimension3D() { }
}
