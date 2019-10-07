//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Point
// Files:           Point.java
// Course:          300, Fall, 2019
//
// Author:          Taha Sawar
// Email:           tsawar@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Matthew Robert Kottwitz
// Partner Email:   mrkottwitz@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:          NONE
// Online Sources:   NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import processing.core.PApplet;

/**
 * 
 * Contains fields and methods for creating and drawing circular point objects into a GUI
 * 
 * @author Taha Sawar, Matthew Robert Kottwitz
 *
 */

public class Point {

  /**
   * @param xPosition the Cartesian x-position of the point object on the output screen
   * @param yPosition the Cartesian y-position of the point object on the output screen
   */

  final static int POINT_DIAMETER = 8; // the standard, uniform diameter of every point object

  int xPosition; // stores the Cartesian x-position of the point object
  int yPosition; // stores the Cartesian x-position of the point object

  /**
   * Constructor method sets the xPosition and yPosition of the object based off of user specified
   * values
   * 
   * @param xPosition the x-position of the point object on the output screen
   * @param yPosition the y-position of the point object on the output screen
   */
  public Point(int xPosition, int yPosition) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
  }

  /**
   * 
   * @return returns the x-position of the specified point object
   */
  public int getX() {
    return xPosition;
  }

  /**
   * 
   * @return returns the y-position of the specified point object
   */
  public int getY() {
    return yPosition;
  }

  /**
   * sets the x-position and y-position of the specified point object to the user specified values
   * 
   * @param xPosition the x-position of the point object on the output screen
   * @param yPosition the y-position of the point object on the output screen
   */
  public void setPosition(int xPosition, int yPosition) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
  }

  /**
   * draws the point object to the output screen
   * 
   * @param processing class variable within the processing library that helps set up the GUI
   */
  public void draw(PApplet processing) { // draw a white circle at this point’s position
    processing.fill(-1); // colors the circle white (default)
    processing.circle(xPosition, yPosition, POINT_DIAMETER); // draw a circle to the screen with
                                                             // centre
    // (xPositon,yPosition) and diameter
    // POINT_DIAMETER

  }

  /**
   * 
   * @param mouseX the current Cartesian x-position of the mouse
   * @param mouseY the current Cartesian y-position of the mouse
   * @return returns true when the position x, y // is within the circle drawn, otherwise returns
   *         false
   */
  public boolean isOver(int mouseX, int mouseY) {
    // distance formula for the distance between the center of a circle and an arbitrary coordinate
    // point (x,y
    double distanceBetweenPointAndCircle =
        Math.sqrt(Math.pow((mouseX - xPosition), 2) + Math.pow((mouseY - yPosition), 2));
    // check if the point is within the bounds of the circle point (distance from center to mouse
    // position is less than the radius of the point)
    if (distanceBetweenPointAndCircle < (POINT_DIAMETER / 2)) {
      return true;
    }
    return false;
  }

}
