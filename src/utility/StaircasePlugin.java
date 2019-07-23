package utility;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.Level;
import com.eteks.sweethome3d.plugin.Plugin;
import com.eteks.sweethome3d.plugin.PluginAction;

import building_codes.BuildParameters;
import building_codes.BuildingCode;
import building_codes.BuildingCodeList;
import building_codes.BuildingCode_AU;
import building_codes.BuildingCode_Default;

public class StaircasePlugin extends Plugin {
	
	public class StaircaseAction extends PluginAction {
		//------------------------------------------------------------------------------
		// Put plug-in in tools menu
		public StaircaseAction() {
			putPropertyValue(Property.NAME, "Build Staircase");
			putPropertyValue(Property.MENU, "Tools");
			setEnabled(true);
		}
		//------------------------------------------------------------------------------
		//
		Home home = getHome();		
		public ArrayList<Level> levels = new ArrayList<>();
    	public BuildingCode bCode; // Building code requirements, varies by location, set in setBuildingCode
		public BuildParameters bParam = new BuildParameters(); // Build parameters, resulting from limitations set by building code and user selections
    	public Staircase staircase; // Defines the actual staircase
          
		//------------------------------------------------------------------------------
		// main procedure
		@Override
		public void execute() {
			 //bCode = new BuildingCode();
			// prompt for building code to use
			selectBuildingCode();
			// initialise build parameters
			bParam = new BuildParameters(bCode);
						
			// select levels to contain staircase
			selectLevels();
			
			// runUI("stepSetup");
			
		}
		
		//------------------------------------------------------------------------------
		// UI switchboard
		public void runUI(String whichUI) {
			switch (whichUI) {
			case "stepSetup":
				StepSetUpUI.main(null);
			default:
			}
		}
		//------------------------------------------------------------------------------		
		private void setLevels() {
			try {
				levels = new ArrayList<>(getHome().getLevels());
			} catch (Exception e) {
				try {
				levels.add(getHome().getSelectedLevel());
				} catch (Exception ex){
				Level level = new Level("Level 0", 0, getUserPreferences().getNewFloorThickness() ,getUserPreferences().getNewWallHeight());
				levels.add(level);
				}
			}
			// remove levels with same elevation and height
			if(levels.size()>1) {
				for(int i=levels.size()-1; i>0; i--) {
					if(levels.get(i).getElevation()==levels.get(i-1).getElevation() &&
							levels.get(i).getHeight()==levels.get(i-1).getHeight()) {
						levels.remove(i);
						}
				}
			}
		}
		private void selectLevels() {
			// set the levels available in the home
			setLevels();
			// select which levels will contain staircase
			int levelStart = 0;
			int levelStop = levels.size()-1;
			
			if (levels.size() > 2) {
				JPanel layoutPanel = new JPanel(new GridLayout(2, 1));
				JLabel label = new JLabel("Please select which levels will contain the staircase");
				label.setToolTipText(
						"<html>"
						+ "These are the levels through which the staircase will travel.<br>"
						+ "A two storey dwelling typically has a staircase that spans the first storey.<br>"
						+ "Do not include the level on which the staircase ends unless it will access the level above.</html>");
				layoutPanel.add(label);
				
				JPanel sliderPanel = new JPanel(new GridBagLayout());
					sliderPanel.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
					JLabel rangeSliderLabel1 = new JLabel("Lowest level:  ");
				    JLabel rangeSliderValue1 = new JLabel(String.valueOf(levelStart));
				    JLabel rangeSliderLabel2 = new JLabel("Highest level: ");
				    JLabel rangeSliderValue2 = new JLabel(String.valueOf(levelStop));
				    RangeSlider rangeSlider = new RangeSlider(levelStart, levelStop);
			        rangeSliderValue1.setHorizontalAlignment(JLabel.LEFT);
			        rangeSliderValue2.setHorizontalAlignment(JLabel.LEFT);
			        
			        rangeSlider.setPreferredSize(new Dimension(240, rangeSlider.getPreferredSize().height));
			        rangeSlider.setMinimum(levelStart);
			        rangeSlider.setMaximum(levelStop);
			        rangeSlider.setUpperValue(levelStop-1);
			        rangeSlider.setValue(levelStart);
			        
			        // Add listener to update display.
			        rangeSlider.addChangeListener(new ChangeListener() {
			        	@Override
			        	public void stateChanged(ChangeEvent e) {
			            	RangeSlider slider = (RangeSlider) e.getSource();
			                rangeSliderValue1.setText(String.valueOf(slider.getValue()));
			                rangeSliderValue2.setText(String.valueOf(slider.getUpperValue()));
			            }
			        });

			        sliderPanel.add(rangeSliderLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 3, 3), 0, 0));
			        sliderPanel.add(rangeSliderValue1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
			            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 3, 0), 0, 0));
			        sliderPanel.add(rangeSliderLabel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
			            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 3, 3), 0, 0));
			        sliderPanel.add(rangeSliderValue2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
			            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 6, 0), 0, 0));
			        sliderPanel.add(rangeSlider      , new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
			            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				layoutPanel.add(sliderPanel);
				

				JOptionPane.showConfirmDialog(null, layoutPanel, "Level Selector", JOptionPane.OK_OPTION);
				
				levelStart=rangeSlider.getValue();
                levelStop=rangeSlider.getUpperValue();
			}
			
			bParam.setHeight(levels.get(levelStop).getHeight()
					+ levels.get(levelStop).getElevation()
					- levels.get(levelStart).getElevation());
		}
		//------------------------------------------------------------------------------
		private void setBuildingCode() {
			// sets the building code by country based on user data
			String country = System.getProperty("user.country");
			setBuildingCode(country);
		}
		private void setBuildingCode(String country) {
			// Call direct to manually override the country building code selection if desired
			switch (country) {
				case "AU": {
					bCode = new BuildingCode_AU();
					break;
				}
				default: {
					bCode = new BuildingCode_Default();
					String message = "No construction code found for your region.\nUsing default building code";
					JOptionPane.showMessageDialog(new JFrame(), message, "No Building Code Found", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(bCode.getHasConditionalFields()) {
				try {
					bCode.promptForConditionalFlagValues();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			bCode = (BuildingCode) bCode;
		}
		private void selectBuildingCode() {
			// option to switch away from the automatically set building code
			int answer = JOptionPane.showConfirmDialog(null, "Use local construction code?", "Building Code Option",
					JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.OK_OPTION) {
				// stick with the automatic one
				setBuildingCode();
			} else {
				// present a list of available codes to choose from
				JRadioButton[] checkboxes = new JRadioButton[BuildingCodeList.count()];
				ButtonGroup group = new ButtonGroup();
				for (int i = 0; i < BuildingCodeList.count(); i++) {
					BuildingCodeList li = BuildingCodeList.index(i);
					checkboxes[i] = new JRadioButton(li.getDescriptor());
					if (li.getCodeAbbreviation() == "Default") {
						checkboxes[i].setSelected(true);
					}
					group.add(checkboxes[i]);
				}
				JPanel layoutPanel = new JPanel(new GridLayout(checkboxes.length + 1, 1));
				layoutPanel.add(new JLabel("Please select the Building Code to use"));

				for (JRadioButton c : checkboxes) {
					layoutPanel.add(c);
				}

				answer = JOptionPane.showConfirmDialog(null, layoutPanel, "Building Code Selector",
						JOptionPane.OK_CANCEL_OPTION);

				if (answer == JOptionPane.OK_OPTION) {
					// Process radio buttons, look up code abbreviation and send off to be set
					String countryCode = "Default";
					int i = 0;
					for (JRadioButton c : checkboxes) {
						if (c.isSelected()) {
							countryCode = BuildingCodeList.index(i).getCodeAbbreviation();
							break;
						}
						;
					}
					setBuildingCode(countryCode);
				} else {
					// On cancel just go back to the auto option
					setBuildingCode();
				}
			}
		}
	}
	//------------------------------------------------------------------------------
	@Override
	public PluginAction[] getActions() {
		return new PluginAction[] { new StaircaseAction() };
	}
	//------------------------------------------------------------------------------
	

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
