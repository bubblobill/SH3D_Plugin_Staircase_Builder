package staircase;

import java.io.Serializable;
import com.sun.javafx.geom.Vec3d;
import staircase.NewelPost;
// Finial: A decorative ornament used to decorate the top (and possibly the bottom) of a newel post - often in the shape of an ball, spike, urn, bun, or figure.
public class Finial extends NewelPost implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Profile profile;
	public Object object;
	public Vec3d dimension3D;
	public Finial() {
		// TODO Auto-generated constructor stub
	}

}
