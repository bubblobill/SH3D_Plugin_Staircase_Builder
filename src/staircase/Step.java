package staircase;

import java.io.Serializable;

import building_codes.BuildParameters;

public class Step implements Serializable{
	private static final long serialVersionUID = 4878929699775887538L;
	
	private double treadDepth = 0; // Tread: The horizontal part of a step.
	private double treadGap = 0;
	private double treadThickness = 0;
	private double treadWidth = 0;
	private double treadNosing = 0; // Return nosing: The moulding, (normally half round) fixed to the ends of the treads exposed in a hallway and which covers where the balusters fit into the treads.
	private double going = 0;
	private double rising = 0;
	
	// Constructors
	public Step() {};
	public Step(BuildParameters buildParameters) {
		this.treadDepth = buildParameters.getTreadDepth();
		this.treadGap = buildParameters.getTreadGap();
		this.treadThickness = buildParameters.getTreadThickness();
		this.treadWidth = buildParameters.getTreadWidth();
		this.treadNosing = buildParameters.getNosing();
		this.going = buildParameters.getGoing();
		this.rising = buildParameters.getRising();
	}	
	public Step(double treadDepth, double treadGap, double treadThickness, 
			double treadWidth, double treadNosing, double going, double rising) {
		this.treadDepth = treadDepth;
		this.treadGap = treadGap;
		this.treadThickness = treadThickness;
		this.treadWidth = treadWidth;
		this.treadNosing = treadNosing;
		this.going = going;
		this.rising = rising;
	}
	// Getters and Setters
	public double getTreadDepth() {return treadDepth;}
	public double getTreadGap() {return treadGap;}
	public double getTreadThickness() {return treadThickness;}
	public double getTreadWidth() {return treadWidth;}
	public double getTreadNosing() {return treadNosing;}
	public double getGoing() {return going;}
	public double getRising() {return rising;}
	
	public void setTreadDepth(double treadDepth) {this.treadDepth = treadDepth;}
	public void setTreadGap(double treadGap) {this.treadGap = treadGap;}
	public void setTreadThickness(double treadThickness) {this.treadThickness = treadThickness;}
	public void setTreadWidth(double treadWidth) {this.treadWidth = treadWidth;}
	public void setTreadNosing(double treadNosing) {this.treadNosing = treadNosing;}
	public void setGoing(double going) {this.going = going;}
	public void setRising(double rising) {this.rising = rising;}
	
}
