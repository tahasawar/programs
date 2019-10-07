//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Triangle
// Files: Triangle.java
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
 * Contains fields and methods for creating and drawing triangle objects into a GUI
 * 
 * @author Taha Sawar, Matthew Robert Kottwitz
 */

public class Triangle {

  private static final int[] COLORS = new int[] { // int packed w/8 bits of ARGB
      // WHITE, RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
      -1, -766643, -752563, -723891, -11668348, -11696908, -8106508, -766476};

  private Point vertex1; // the first vertex of a triangle object
  private Point vertex2; // the second vertex of a triangle object
  private Point vertex3; // the third vertex of a triangle object
  private int triangleColor; // the color of the triangle object

  /**
   * Constructor method creates a new triangle object with the given vertices and color
   * 
   * @param vertex1       the first vertex of the triangle object
   * @param vertex2       the second vertex of the triangle object
   * @param vertex3       the third vertex of the triangle object
   * @param triangleColor the color of the triangle
   */
  public Triangle(Point vertex1, Point vertex2, Point vertex3, int triangleColor) {
    this.vertex1 = vertex1;
    this.vertex2 = vertex2;
    this.vertex3 = vertex3;
    this.triangleColor = triangleColor;
  }

  /**
   * updates the color of an existing triangle object to user defined color triangleColor
   * 
   * @param triangleColor the new color of the triangle
   */
  public void setColor(int triangleColor) {
    this.triangleColor = COLORS[triangleColor];
  }

  /**
   * tells whether the mouse cursor is currently floating over an existing triangle object
   * 
   * @param mouseX the current x-position of the mouse
   * @param mouseY the current y-position of the mouse
   * @return true it the cursor is over a triangle, otherwise return false
   */
  public boolean isOver(int mouseX, int mouseY) {
    if (isPointInTriangle(mouseX, mouseY, vertex1.getX(), vertex1.getY(), vertex2.getX(),
        vertex2.getY(), vertex3.getX(), vertex3.getY()) == true)
      return true;
    else
      return false;
  }

  /**
   * draws a triangle object to the GUI
   * 
   * @param processing class variable within the processing library that helps set up the GUI
   */
  public void draw(PApplet processing) {
    // color the triangle object
    processing.fill(triangleColor);
    // draw the triangle object to the GUI
    processing.triangle(vertex1.getX(), vertex1.getY(), vertex2.getX(), vertex2.getY(),
        vertex3.getX(), vertex3.getY());

  }

  /**
   * tells whether a specified point is within the boundaries of a specified triangle object (define
   * by three coordinate pairs)
   * 
   * @param px  x-coordinate of the point being tested
   * @param py  y-coordinate of the point being tested
   * @param t1x x-coordinate of the first vertex
   * @param t1y y-coordinate of the first vertex
   * @param t2x x-coordinate of the second vertex
   * @param t2y y-coordinate of the second vertex
   * @param t3x x-coordinate of the third vertex
   * @param t3y y-coordinate of the third vertex
   * @return true if the point is within the triangle boundary, otherwise return false
   */
  private static boolean isPointInTriangle(int px, int py, int t1x, int t1y, int t2x, int t2y,
      int t3x, int t3y) {
    px -= t1x; // don't worry about this arithmetic
    py -= t1y;
    t2x -= t1x;
    t2y -= t1y;
    t3x -= t1x;
    t3y -= t1y;
    double dotp2 = px * t2x + py * t2y;
    double dotp3 = px * t3x + py * t3y;
    double dot22 = t2x * t2x + t2y * t2y;
    double dot23 = t2x * t3x + t2y * t3y;
    double dot33 = t3x * t3x + t3y * t3y;
    double invDen = 1 / (dot33 * dot22 - dot23 * dot23);
    double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;
    double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;
    return (a >= 0) && (b >= 0) && (a + b < 1);
  }


}
