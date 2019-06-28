# SH3D_Plugin_Staircase_Builder
A plugin for Sweethome3d to construct custom staircase objects

Work in progress - not funtional

The plan is to create a plugin for Sweet Home 3D www.sweethome3d.com to build bespoke staircase furniture objects.

The plugin will use the detected/selected locale to load the appropriate building code restrictions for the area. 
The restrictions on staircases change depending on building type, staircase use, and accessibility requirements.
So far only Australian building code is included. It contains flags for the use type.

Staircases have their own jargon. Here are a couple of links to help with understanding the staircase terminology and components.

https://theconstructor.org/tips/components-of-staircase/7534/
https://www.practicaldiy.com/carpentry/staircase/staircase.php

An interface will present the user with options to build a staircase. Spiral staircases are not presently in scope.
Users will be able to determine:
- the size and nature of the steps, 
- the number of steps in each flight, 
- the number of flights, 
- the size of landings, 
- whether or not landings include winders, 
- how many winders,
- the angle of directional change at landings,
- the inclusion of stringers (inside, outside, and whatever the ones underneath are calles),
- the use of balusters or rails,
- the number of banisters,
- the cross-sectional profile of balusters, rails, banisters, newel posts, and nosings,
- etc.

Being a complete newb to Java I have no doubt made many bad decisions. So far I think I have nailed down most of the staircase and building code class details.

Main things to achieve before basic functionality is achieved are;
- user interface panel
- wavefront object construction
- conversion to/and import of furniture object
