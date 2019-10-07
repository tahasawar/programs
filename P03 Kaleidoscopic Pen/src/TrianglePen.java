//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Triangle Pen
// Files: TrianglePen.java
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

import java.util.ArrayList;
import processing.core.PApplet;

/*
 * contains fields and methods for creating a TrianglePen object: a combination of a triangle object
 * and 3 point objects that can be implemented and manipulated in the GUI
 * 
 * @author Taha Sawar, Matthew Robert Kottwitz
 */

public class TrianglePen {
  private int pointCounter; // counts the number of point objects created
  private int triangleCounter; // counts the number of triangle objects created
  private ArrayList<Point> points; // ArrayList containing point objects
  private ArrayList<Triangle> triangles; // ArrayList containing triangle objects
  private boolean mouseWasPressed; // mousePressed from previous update() call
  private char keyWasPressed; // keyPressed from previous update() call
  private Point isDragging; // stores the point being dragged
  private Triangle newTriangle; // variable for a new triangle object
  private Point newPoint; // variable for a new point object

  PApplet processing = null; // stores the processing argument passed to constructor
  boolean showPoints = false; // stores the showPoints argument passed to constructor

  /**
   * Constructor method creates a new trianglePen object capable of being implemented into the
   * PApplet GUI
   * 
   * @param processing class variable within the processing library that helps set up the GUI
   * @param showPoints boolean variable deciding whether or not the points on a triangle object are
   *                   to be shown on the GUI
   */
  public TrianglePen(PApplet processing, boolean showPoints) {
    points = new ArrayList<Point>(); // create a new ArrayList that contains every point object
    triangles = new ArrayList<Triangle>(); // create a new ArrayList that contains every triangle
    this.showPoints = showPoints; // object
    this.processing = processing;
    pointCounter = 0; // the number of point objects is initially 0
    triangleCounter = 0; // the number of triangle objects is initially 0
    isDragging = null;
  }

  /**
   * processes mouse-based data for when the mouse is clicked
   * 
   * @param mouseX the current x-position of the mouse
   * @param mouseY the current y-position of the mouse
   */
  private void handleMousePress(int mouseX, int mouseY) {

    for (int i = 0; i < points.size(); ++i) { // iterate through all of the point objects in the
                                              // points ArrayList
      if (points.get(i).isOver(mouseX, mouseY)) { // check if an existing point is being clicked on
        isDragging = points.get(i);
        return;
      }
    }
    newPoint = new Point(mouseX, mouseY); // create a new point object at the location of the
                                          // mouse when the mouse is clicked
    points.add(newPoint); // add the new point to the points ArrayList
    ++pointCounter;
    if (pointCounter % 3 == 0) { // check if there are three new point objects available to create a
                                 // triangle object
      newTriangle = new Triangle(points.get(pointCounter - 3), points.get(pointCounter - 2),
          points.get(pointCounter - 1), -1); // create a new triangle object using the previous
                                             // three points and default to color grey
      ++triangleCounter;
      if (triangleCounter <= (pointCounter / 3)) { // Ensure the number of triangles in the
                                                   // triangles ArrayList is never more than the
                                                   // number of points divided by three
        triangles.add(newTriangle);
      }

    }
  }

  /**
   * processes mouse-based input data for when the mouse button is released
   * 
   * @param mouseX the current x-position of the mouse
   * @param mouseY the current y-position of the mouse
   */
  private void handleMouseRelease(int mouseX, int mouseY) {
    isDragging = null;
  }

  /**
   * processed mouse-based input data for when the vertex of a triangle object is being dragged and
   * repositioned
   * 
   * @param mouseX the current x-position of the mouse
   * @param mouseY the current y-position of the mouse
   */
  private void handleMouseDrag(int mouseX, int mouseY) {

    if (isDragging != null) {
      isDragging.setPosition(mouseX, mouseY);
    }
  }

  /**
   * 
   * @param mouseX     the current x-position of the mouse
   * @param mouseY     the current y-position of the mouse
   * @param keyPressed the key that was pressed
   */
  private void handleKeyPress(int mouseX, int mouseY, char keyPressed) {
    for (int i = 0; i < triangles.size(); ++i) { // iterate through all of the triangle objects

      if (triangles.get(i).isOver(mouseX, mouseY)) { // check if the mouse cursor is currently over
                                                     // a triangle on the GUI
        if (keyWasPressed >= '0' && keyWasPressed <= '7') { // if a valid key (0-7) was pressed...
          triangles.get(i).setColor(keyWasPressed - '0'); // ...update the color of that triangle
                                                          // object corresponding to the key pressed
        }
      }
    }
  }

  /**
   * draws the triangle and corresponding point objects to the GUI
   */
  private void draw() {
    if (showPoints == true) {
      for (int i = 0; i < points.size(); ++i) { // iterate through points and draw every point to
                                                // the screen
        points.get(i).draw(processing);
      }
    }
    for (int j = 0; j < triangles.size(); ++j) {
      triangles.get(j).draw(processing); // draw the most recent element in the triangles array (1
                                         // is
      // subtracted from triangleCounter because triangles starts at
      // index 0)
    }
  }

  /**
   * updates the GUI
   * 
   * @param mouseX       the current x-position of the mouse cursor
   * @param mouseY       the current y-position of the mouse cursor
   * @param mousePressed boolean variable for whether or not the mouse has been clicked
   * @param keyPressed   boolean variable for whether or not the a key 0-7 has been pressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    // process mouse-based user input

    if (mousePressed != mouseWasPressed) {
      if (mousePressed)
        handleMousePress(mouseX, mouseY);
      else
        handleMouseRelease(mouseX, mouseY);
    }
    if (mousePressed)
      handleMouseDrag(mouseX, mouseY);
    mouseWasPressed = mousePressed;
    // process keyboard-based user input
    if (keyPressed != keyWasPressed)
      handleKeyPress(mouseX, mouseY, keyPressed);
    keyWasPressed = keyPressed;
    // draw everything in its current state
    draw();
  }


}
