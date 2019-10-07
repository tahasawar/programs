//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Kaleidoscope Pen
// Files: KaleidoscopePen.java
// Course: 300, Fall, 2019
//
// Author: Taha Sawar
// Email: tsawar@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Matthew Robert Kottwitz
// Partner Email: mrkottwitz@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import processing.core.PApplet;

/**
 * collection of fields and methods for creating a kaleidoscope on a GUI using a collection
 * TrianglePen objects
 * 
 * @author Taha Sawar, Matthew Robert Kottwitz
 */

public class KaleidoscopePen {

  private TrianglePen[] trianglePens;   // holds the triangle Pen objects that are drawn to the GUI
  private double kaledioscopeAngle; //angle between each trianglePen object drawn to the GUI
/**
 * Constructor method creates a new trianglePen objects array capable of being implemented into the
 * PApplet GUI
 * 
 * @param drawTo the PApplet object passed onto TrianglePen class containing information for the GUI 
 * @param numberOfTrianglePens holds the total number of Triangle Pens in the Triangle Pens array
 */
  public KaleidoscopePen(PApplet drawTo, int numberOfTrianglePens) {
    trianglePens = new TrianglePen[numberOfTrianglePens];   // initialises the Triangle Pens array

    // makes each element of the array equal to a new Triangle Pen object
    for (int i = 0; i < trianglePens.length; ++i) { 
      if (i == 0) { // the first element shows the points it is drawn off of
        trianglePens[i] = new TrianglePen(drawTo, true); 
      } else {
        trianglePens[i] = new TrianglePen(drawTo, false);
      }
    }
  }

  /**
   * Updates the positions of each element in the Triangle Pens array with a similar rotation offset
   * 
   * @param mouseX the current x-position of the mouse cursor
   * @param mouseY the current y-position of the mouse cursor
   * @param mousePressed boolean variable for whether or not the mouse has been clicked
   * @param keyPressed   boolean variable for whether or not the a key 0-7 has been pressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {

    int rotateX;    // stores the updated X position
    int rotateY;    // stores the updated Y position

    for (int i = 0; i < trianglePens.length; ++i) {
      // System.out.println("mouseX: " + mouseX + " mouseY: " + mouseY + " mousePressed: " +
      // mousePressed + " keyPressed: " + keyPressed);
      kaledioscopeAngle = ((i * (2 * Math.PI))) / trianglePens.length;

      rotateX = rotate(mouseX, mouseY, kaledioscopeAngle)[0];
      rotateY = rotate(mouseX, mouseY, kaledioscopeAngle)[1];
      trianglePens[i].update(rotateX, rotateY, mousePressed, keyPressed);
    }
  }

  /**
   * Rotates a position around the centre of an 800x600 screen by the specified amount, and then
   * returns an array containing the resulting position.
   * 
   * @param x     position of the point to be rotated (0 to 800 pixels)
   * @param y     position of the point to be rotated (0 to 600 pixels)
   * @param angle amount of rotation to apply (angle in radians units: 0 to 2*PI)
   * @return the rotated position array: x @ index 0, y @ index 1
   */
  private static int[] rotate(int x, int y, double angle) {
    x = x - 400; // translate centre of screen to origin (0,0)
    y = y - 300;

    int[] rotatedPosition = new int[] { // rotate around origin
        (int) (x * Math.cos(angle) - y * Math.sin(angle)),
        (int) (x * Math.sin(angle) + y * Math.cos(angle))};
    rotatedPosition[0] += 400; // return to centre of screen
    rotatedPosition[1] += 300;
    return rotatedPosition;
  }

}
