package com.eteks.test;

import java.awt.geom.Path2D;
import java.util.HashMap;
import java.util.Map;

// use PShape for SVG?
import com.eteks.test.Staircase.Step;

public class Profile {
	String name;
	Path2D path;
}

// https://stackoverflow.com/questions/40502972/is-it-possible-to-convert-svgpath-to-mesh-in-javafx
// https://stackoverflow.com/questions/48936748/how-can-i-extrude-a-complex-svg-in-processing