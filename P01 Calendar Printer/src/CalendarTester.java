//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: CalendarTester
// Files: CalendarPrinter.java, CalendarTester.java
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

/**
 * @author taha
 *
 */

public class CalendarTester {

  public static void main(String args[]) {

    testGetCentury();
    testGetYearWithinCentury();
    testGetIsLeapYear();
    testGetMonthIndex();
    testGetNumberOfDaysInMonth();
    testGetFirstDayOfWeekInMonth();
    testGenerateCalendar();
  }

  public static boolean testGetCentury() {

    if (CalendarPrinter.getCentury("2") != 0) {
      return false;
    }
    if (CalendarPrinter.getCentury("2019") != 20) {
      return false;
    }
    if (CalendarPrinter.getCentury("44444") != 444) {
      return false;
    }
    System.out.println("testGetCentury Passed!");
    return true;
  }

  public static boolean testGetYearWithinCentury() {

    if (CalendarPrinter.getYearWithinCentury("2019") != 19) {
      return false;
    }
    if (CalendarPrinter.getYearWithinCentury("2005") != 5) {
      return false;
    }
    if (CalendarPrinter.getYearWithinCentury("2000") != 0) {
      return false;
    }
    if (CalendarPrinter.getYearWithinCentury("640") != 40) {
      return false;
    }
    if (CalendarPrinter.getYearWithinCentury("30000078") != 78) {
      return false;
    }
    System.out.println("testGetCenturyWithinCentury Passed!");
    return true;
  }


  public static boolean testGetIsLeapYear() {

    if (CalendarPrinter.getIsLeapYear("2012") != true) {
      return false;
    }
    if (CalendarPrinter.getIsLeapYear("2005") != false) {
      return false;
    }
    if (CalendarPrinter.getIsLeapYear("2024") != true) {
      return false;
    }
    if (CalendarPrinter.getIsLeapYear("600") != false) {
      return false;
    }
    if (CalendarPrinter.getIsLeapYear("30000") != true) {
      return false;
    }
    if (CalendarPrinter.getIsLeapYear("300003") != false) {
      return false;
    }
    System.out.println("testGetIsLeapYear Passed!");
    return true;
  }

  public static boolean testGetMonthIndex() {

    if (CalendarPrinter.getMonthIndex("January") != 0) {
      return false;
    }
    if (CalendarPrinter.getMonthIndex("JuL@*(!(!") != 6) {
      return false;
    }
    if (CalendarPrinter.getMonthIndex("jUnE91010") != 5) {
      return false;
    }
    if (CalendarPrinter.getMonthIndex("gahaagav") != -1) {
      return false;
    }
    if (CalendarPrinter.getMonthIndex("737291") != -1) {
      return false;
    }
    if (CalendarPrinter.getMonthIndex("AUGUST") != 7) {
      return false;
    }
    System.out.println("testGetMonthIndex Passed!");
    return true;
  }

  public static boolean testGetNumberOfDaysInMonth() {

    if (CalendarPrinter.getNumberOfDaysInMonth("January", "2012") != 31) {
      return false;
    }
    if (CalendarPrinter.getNumberOfDaysInMonth("JuL@*(!(!", "2005") != 31) {
      return false;
    }
    if (CalendarPrinter.getNumberOfDaysInMonth("jUnE91010", "2024") != 30) {
      return false;
    }
    if (CalendarPrinter.getNumberOfDaysInMonth("february", "2016") != 29) {
      return false;
    }
    if (CalendarPrinter.getNumberOfDaysInMonth("febraxsaqw12", "2011") != 28) {
      return false;
    }
    if (CalendarPrinter.getNumberOfDaysInMonth("AUGUST", "300003") != 31) {
      return false;
    }
    System.out.println("testGetNumberOfDaysInMonth Passed!");
    return true;
  }

  public static boolean testGetFirstDayOfWeekInMonth() {

    if (CalendarPrinter.getFirstDayOfWeekInMonth("September", "2019") != 6) {
      return false;
    }
    if (CalendarPrinter.getFirstDayOfWeekInMonth("July", "2000") != 5) {
      return false;
    }
    if (CalendarPrinter.getFirstDayOfWeekInMonth("Octobubby", "1913") != 2) {
      return false;
    }
    if (CalendarPrinter.getFirstDayOfWeekInMonth("fEB", "1975") != 5) {
      return false;
    }
    System.out.println("testGetFirstDayOfWeekInMonth Passed!");
    return true;
  }

  public static boolean testGenerateCalendar() {
    //TestCalendar array gives first 2 rows of the calendar for FEB, 2020
    String[][] testCalendar = { {"MON ", "TUE ", "WED ", "THU ", "FRI ", "SAT ", "SUN "}, {".  ",".  ",".  ",".  ",".  ","1  ","2  "}};
    String[][] calendar = CalendarPrinter.generateCalendar("FEB", "2020");
    if (!(testCalendar[1][1].equals(calendar[1][1]))) {
      return false;
    }
    if (!(testCalendar[1][4].equals(calendar[1][4]))) {
      return false;
    }
    if (!(testCalendar[1][5].equals(calendar[1][5]))) {
      return false;
    }
    System.out.println("testGenerateCalendar Passed!");
    return true;
  }
}