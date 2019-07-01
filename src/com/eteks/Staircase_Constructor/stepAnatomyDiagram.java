package com.eteks.Staircase_Constructor;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;


public class stepAnatomyDiagram extends Frame {
  /**
   * Instantiates an Example01 object.
   **/
  public static void main(String args[]) {
    new stepAnatomyDiagram();
  }

  /**
   * Our Example01 constructor sets the frame's size, adds the
   * visual components, and then makes them visible to the user.
   * It uses an adapter class to deal with the user closing
   * the frame.
   **/
  public stepAnatomyDiagram() {
    //Title our frame.
    super("Step Anatomy");

    //Set the size for the frame.
    setSize(480,200);

    //We need to turn on the visibility of our frame
    //by setting the Visible parameter to true.
    setVisible(true);

    //Now, we want to be sure we properly dispose of resources
    //this frame is using when the window is closed.  We use
    //an anonymous inner class adapter for this.
    addWindowListener(new WindowAdapter()
      {public void windowClosing(WindowEvent e)
         {dispose(); System.exit(0);}
      }
    );
  }

  /**
   * The paint method provides the real magic.  Here we
   * cast the Graphics object to Graphics2D to illustrate
   * that we may use the same old graphics capabilities with
   * Graphics2D that we are used to using with Graphics.
   **/
  public void paint(Graphics g) {
    //Let's set the Color to blue and then use the Graphics2D
    //object to draw a rectangle, offset from the square.
    //So far, we've not done anything using Graphics2D that
    //we could not also do using Graphics.  (We are actually
    //using Graphics2D methods inherited from Graphics.)
	
	Graphics2D g2d = (Graphics2D)g;
	  
	int treadDepth = Math.round(350/2);
	int treadGap = Math.round(30/2);
	int stepThickness = Math.round(20/2);
	int nosing = Math.round(40/2);
	int rising = Math.round(195/2);
	int hoffset=10;
	int voffset=50;
	int arcSize = stepThickness>nosing ? nosing : stepThickness;
	double calcAngle = treadDepth + treadGap;
	calcAngle = rising/calcAngle;
	calcAngle = Math.toDegrees(Math.atan(calcAngle));
	int slope = (int) calcAngle;
	BasicStroke defaultStroke = new BasicStroke();
	
	final float[] dash1 = { 2.4f };
	final float[] dash2 = { 3.6f };
	final BasicStroke dashed = new BasicStroke(1.0f,
			BasicStroke.CAP_BUTT, 
			BasicStroke.JOIN_MITER, 
			10.0f, dash1, 0.0f);
	final BasicStroke dashed2 = new BasicStroke(1.0f,
			BasicStroke.CAP_BUTT, 
			BasicStroke.JOIN_MITER, 
			10.0f, dash2, 0.0f);

    g2d.setColor(Color.black);
    g2d.setStroke(dashed);
    // butt joint of rising
    g2d.drawRect(
    		hoffset,
    		voffset, 
    		treadGap, 
    		stepThickness);
    // treadGap
    //first going
    g2d.setStroke(defaultStroke);
    g2d.drawRect(
    		hoffset + treadGap,
    		voffset, 
    		treadDepth, 
    		stepThickness);
    //nosing
    if (arcSize<nosing) {
    	g2d.drawLine(hoffset + treadGap + treadDepth, voffset, hoffset + treadGap + treadDepth + nosing - arcSize/2, voffset);
    	g2d.drawLine(hoffset + treadGap + treadDepth, voffset + stepThickness, hoffset + treadGap + treadDepth + nosing - arcSize/2, voffset + stepThickness);
    }
    g2d.drawArc(
    		hoffset + treadGap + treadDepth + nosing - arcSize, 
    		voffset, 
    		arcSize, 
    		arcSize, 
    		90, 
    		-180);
    // rising
    g2d.setColor(Color.blue);
    g2d.drawRect(
    		hoffset + treadGap + treadDepth - 10, 
    		voffset + stepThickness, 
    		10, 
    		rising);
    // butt join space
    g2d.drawRect(
    		hoffset + treadGap + treadDepth - 10, 
    		voffset + stepThickness + rising, 
    		10, 
    		stepThickness);
    // second treadGap
    g2d.setStroke(dashed);
    g2d.drawRect(
    		hoffset + treadGap + treadDepth, 
    		voffset + stepThickness + rising, 
    		treadGap    		, 
    		stepThickness);
    // second going
    g2d.setStroke(defaultStroke);
    g2d.setColor(Color.black);
    g2d.drawRect(
    		hoffset + treadGap + treadGap + treadDepth, 
    		voffset + stepThickness + rising, 
    		treadDepth, 
    		stepThickness);
    // second nosing    
    if (arcSize<nosing) {
    	g2d.drawLine(hoffset + treadGap + treadGap + treadDepth + treadDepth, voffset + stepThickness + rising, hoffset + treadGap + treadGap + treadDepth + treadDepth + nosing - arcSize/2, voffset + stepThickness + rising);
    	g2d.drawLine(hoffset + treadGap + treadGap + treadDepth + treadDepth, voffset + stepThickness + rising + stepThickness, hoffset + treadGap + treadGap + treadDepth + treadDepth + nosing - arcSize/2, voffset + stepThickness + rising + stepThickness);
    }
    g2d.drawArc(
    		hoffset + treadGap + treadGap + treadDepth + treadDepth + nosing - arcSize, 
    		voffset + stepThickness + rising, 
    		arcSize, 
    		arcSize, 
    		90, 
    		-180);
    g2d.setColor(Color.red);
    // angle line
    g2d.drawArc(
    		hoffset + treadGap + treadDepth + nosing -40, 
    		voffset - 7 -40,
    		80, 
    		80, 
    		0, 
    		-slope);
    g2d.drawLine(
    		hoffset + treadGap + treadDepth + nosing, 
    		voffset - 7,
    		hoffset + treadGap + treadDepth + nosing + 50, 
    		voffset - 7);
    g2d.setStroke(dashed2);
    g2d.drawLine(
    		hoffset + treadGap + treadDepth + nosing, 
    		voffset - 7, 
    		hoffset + treadGap + treadGap + treadDepth + treadDepth + nosing, 
    		voffset + stepThickness + rising - 7);
    
    g2d.setStroke(defaultStroke);
    
    //g2d.drawString("Tread Depth", 80,45);
    //g2d.drawString("Nosing", 220,80);
    //g2d.drawString("Going", 300,140);    
  }
}