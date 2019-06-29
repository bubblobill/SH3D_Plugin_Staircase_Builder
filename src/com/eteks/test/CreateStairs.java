package com.eteks.test;

import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEditSupport;

import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.Level;
import com.eteks.sweethome3d.model.PieceOfFurniture;
import com.eteks.sweethome3d.plugin.Plugin;
import com.eteks.sweethome3d.plugin.PluginAction;
import com.eteks.test.Staircase.Flight;
import com.eteks.test.Staircase.Step;
import com.eteks.test.StaircaseDesignUI;

// NOTE: All dimension are in centimeters

public class CreateStairs extends Plugin {
	public class dynamicStairsAction extends PluginAction {

		public dynamicStairsAction() {
			putPropertyValue(Property.NAME, "Create Stairs");
			putPropertyValue(Property.MENU, "Tools");
			// Enables the action by default
			setEnabled(true);
		}

		public BuildingCode bCode; // Building code parameters, varies by location, set in setBuildingCode
		public Staircase staircase; // Defines the actual staircase
		@Override
		public void execute() {
			
			// set building code requirements for country
			setBuildingCode();
			
			// initialise staircase with building code values and selected home level height
			Home home = getHome();
			Level level = home.getSelectedLevel();
			staircase = new Staircase(bCode, level.getFloorThickness() + level.getHeight());

			// present user with staircase construction panel
			staircaseDesign();

			// build staircase as wavefront object
			buildStaircaseObj();

			// turn it into furniture
			createStaircaseFurniture();
		}

		private void staircaseDesign() {
			// TODO: Interface for user to construct staircase

			//update staircase
			staircase=staircase;

			// sample test staircase slope is in bounds
			Flight flight = staircase.flights.get(0);			
			checkSlope(flight);
		}

		private boolean checkSlope(Flight flight) {
			// test rise, going, 2R+G are within bounds
			Step step = flight.steps.get(0);
			return step.rising >= bCode.minRising && step.rising <= bCode.maxRising && step.going >= bCode.minGoing
					&& step.going <= bCode.maxGoing && 2 * step.rising + step.going >= bCode.min2RplusG
					&& 2 * step.rising + step.going <= bCode.max2RplusG;
		}

		private void buildStaircaseObj() {
			// TODO: construct wavefront object using staircase parameters
		}

		private void createStaircaseFurniture() {
			// TODO: Turn Obj file into furniture and add cutouts etc.
			//setStaircaseCutOutShape();
		}

		private void setBuildingCode() {
			// TODO: check locale somehow and set bCode according to code
			// BuildingCode_AU requires flags be set
			// bCode = (BuildingCode) new BuildingCode_AU();
			// TODO: input values for accessibleStair, requiredStair, infreqNonHabitable, &
			// auStandard
			String country = "au";
			switch (country) {
				case "au": {
					bCode = new BuildingCode_AU();
					((BuildingCode_AU) bCode).setAccessibleStair(false);
					((BuildingCode_AU) bCode).setRequiredStair(true);
					((BuildingCode_AU) bCode).setAuStandard(false);
					((BuildingCode_AU) bCode).setInfreqNonHabitable(false);
				}
				default: {
					bCode = new BuildingCode_AU();
				}	
			}
		}
	}

	@Override
	public PluginAction[] getActions() {
		return new PluginAction [] {new dynamicStairsAction()}; 
	}
	
}

/*
https://www.practicaldiy.com/carpentry/staircase/staircase.php
Inner string (closed).
Outer string (open).
Tread.
Riser.
Newel post.
Balusters.
Banister (or handrail).
Return nosing.
Fascia.
Landing.
Curtail.

Definition of staircase parts
Balusters: The vertical posts in the space under the banister to the treads or floor (on the side of a landing).
Banister: The handrails up the side (or sides) of a stairway and, as an extension, along the edge of a landing.
Curtail step: The bottom step of a staircase which curves around sideways beyond the side of the staircase.
Fascia: The vertical covering under the edge of an exposed landing which covers the gap between ceiling and floor.
Finial: A decorative ornament used to decorate the top (and possibly the bottom) of a newel post - often in the shape of an ball, spike, urn, bun, or figure.
Half Landing: The flat area of flooring where a stairway makes a turn between main floors.
Inner (closed) string: The side of a staircase set against a wall which locates the treads and risers.
Landing: The flat area of flooring at the top and bottom of a staircase leading to rooms. 
Newel post: The vertical post at the end or turn of a banister.
Outer (open) string: The side of a staircase open to view which locates the treads and risers.
Return nosing: The moulding, (normally half round) fixed to the ends of the treads exposed in a hallway and which covers where the balusters fit into the treads.
Riser: The vertical part of a step.
Riser wedges: The, usually wooden, wedges used vertically underneath a staircase in slots cut into the strings to secure the risers.
Tread: The horizontal part of a step.
Tread wedges: The, usually wooden, wedges used horizontal underneath a staircase in slots cut into the strings to secure the treads.
Tread/riser blocks: The, usually wooden, blocks used by gluing to secure the front of the treads to the top of the risers at the front edge of each step.

https://theconstructor.org/tips/components-of-staircase/7534/
Rise: Height of staircase
Run: Length of staircase for rise
Winder: step used in turn
Volute: A handrail end element for the bullnose(curtail) step that curves inward like a spiral.
Turnout: Instead of a complete spiral volute, a turnout is a quarter-turn rounded end to the handrail.

https://www.stepform.com.au/as1675-2018/stairs-detail.html
STAIRWAYS ANGLES
The angle of the stairs slope to the horizontal is 20° to 45°,  but it is recommended to have the range between 30° and 38°.

STAIRWAYS CLEARANCES
Stairways shall be ≥ 600mm wide inside the stiles and it is to have a minimum clearance of 550mm between rails.
For stair landing; the width of the landing shall not be less than the stairway width and a minimum of 600 mm clear of cross-traffic, door swing or any other structure.
Minimum headroom is typically 2000 mm, this may need to be increased if helmets are worn. In applications where the minimum headroom cannot be achieved, other measures should be taken, Such as signage, padding and highlighting. 

FLIGHTS AND LANDINGS
The maximum of 18 risers in a flight. Adjacent flights shall be connected using a landing.
Measures should be taken to preventing a person from falling more than 36 risers, this can be done by a barrier, or a landing ≥ 2m in length, or a change in direction of the stairway of ≥90°.
The tread shall extend across the full width of the stairway and the tread surface shall be slip-resistant. The nosing shall be such that the edge of the tread is clearly visible against the background.

RISERS, GOINGS AND TREADS DIMENSIONS
 	The Riser (R) 	The going (G) 	
The slope relationship (2R + G)

Range (mm)	Min	Max	Min	Max	Min	Max
AS1657	130	225	215	355	540	700
BCA	115	190	240	355	550	700

The tread depth (TD) is to be ≥ 185mm and it should not be more than 30mm shorter than the going (G).
All risers and all goings in the same flight of stairs shall be of uniform dimensions within a tolerance of ±5 mm.

STAIRWAYS GUARDRAIL AND HANDRAILS
Except where there is a fixed structure within 100 mm of the stairway stile, stairways and stairway landings shall be provided with guardrailing on any exposed side.
Every stairway shall have at least one handrail and a handrail on each side for stairway wider than 1000mm.(refer: to handrails and guardrails for details).
*/
