package building_codes;

import java.io.Serializable;
import staircase.Step;

public abstract class TestParameters extends BuildParameters implements Serializable {
	private static final long serialVersionUID = -5979624949036558581L;
	
	public boolean[] stepFlags = {true, true, true, true, true, true, true};
	public static final String[] stepFlagNames = {"going", "rising", "tread thickness", "tread width", "tread gap", "nosing", "step slope"};
	
	public boolean testStep(Step step) {
		setStepFlags(step);
		for (Boolean bool : stepFlags) {
			if(bool==false) {return false;}
		}
		return true;
	}
	private void setStepFlags(Step step) {
		double going = step.getGoing();
		double rising = step.getRising();
		double thickness = step.getTreadThickness();
		double width = step.getTreadWidth();
		double nosing = step.getTreadNosing();
		double gap = step.getTreadGap();
		
		stepFlags[0] = going >= getMinGoing() && going <= getMaxGoing();
		stepFlags[1] = rising >= getMinRising() && rising <= getMaxRising();
		stepFlags[2] = isOpenRising() ? rising-thickness <= getMaxGap() : true;
		stepFlags[3] = width >= getMinWidth();
		stepFlags[4] = gap <= getMaxTreadGap() && gap < nosing;
		stepFlags[5] = gap < nosing;
		stepFlags[6] = 2*rising + going <= getMax2RplusG() && 2*rising + going >= getMin2RplusG();
	}

}
