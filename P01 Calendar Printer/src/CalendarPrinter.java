import java.util.Scanner;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: CalendarPrinter
// Files: CalendarPrinter.java
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
 * Prompts a user for a month and year, then Prints out a Calendar for that month in the given year
 * 
 * @author Matthew Kottwitz
 * @author Taha Sawar
 */

public class CalendarPrinter {

  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

  public static void main(String args[]) {

    Scanner scnr = new Scanner(System.in);
    String month = null;
    String year = null;
    String[][] monthToPrint = null;

    System.out.println("Welcome to the Calendar Printer."); // welcome message
    System.out.println("================================");
    System.out.print("Enter month to print: "); // prompt user for month
    month = scnr.next();
    System.out.print("Enter year to print: "); // prompt user for year
    year = scnr.next();

    monthToPrint = generateCalendar(month, year); // generates the month to print with the 
                                                  // users month and year

    for (int i = 0; i < monthToPrint.length; ++i) { // loop through monthToPrint and print out
                                                    // contents
      for (int j = 0; j < DAYS_OF_WEEK.length; ++j) {   
                                                // loop through each row, printing out each element
        System.out.print(monthToPrint[i][j] + " "); // adds a space for better formatting
      }
      System.out.println("");  // Start a new line after each row for better formatting

    }
    System.out.println("================================");
    System.out.println("Thanks, and have a nice day.");

    scnr.close();
  }

  /**
   * Calculates the number of centuries (rounded down) that is represented by the specified year
   * (ie. the integer part of year/100).
   * 
   * @param year to compute the century of (based on the Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of centuries in the specified year
   */
  public static int getCentury(String year) {

    int century = 0;    // stores the century
    int numYears = Integer.parseInt(year); // converts from a String and stores the year as a number

    century = numYears / 100;   // gets the century
    return century;
  }

  /**
   * Calculates the number of years between the specified year, and the first year in the specified
   * year's century. This number is always between 0 - 99.
   * 
   * @param year to compute the year within century of (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of years since first year in the current century
   */
  public static int getYearWithinCentury(String year) {

    String numYears = null;     // stores the number of years since the first year in the century
    int intNumYears = 0;        // stores the number of years since the first year in the century
                                // as a number 

    numYears = year.substring(year.length() - 2, year.length());// finds the year within the century

    if (numYears.charAt(0) == '0') {    // checks if the year is between 01 and 09

      numYears = numYears.substring(1, numYears.length());  // if true, then it returns a number 
                                                            // between 1 and 9

    }

    intNumYears = Integer.parseInt(numYears);   // Otherwise, if > 9, it returns the number
    return intNumYears;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param yearString is the year that is being checked for leap-year-ness String must contain the
   *                   digits of a single non-negative int for year.
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean getIsLeapYear(String yearString) {

    int year = 0; // stores the year as a number

    year = Integer.parseInt(yearString); // converts the yearString to a number

    if ((year % 4) != 0) { // if the year is not divisible by 4
      return false; // Hence, it is a common year
    }

    else if ((year % 100) != 0) { // if the year is not divisible by 100
      return true; // Hence, it is a leap year
    }

    else if ((year % 400) != 0) { // if the year is not divisible by 400
      return false; // Hence, it is a common year
    }

    else { // Otherwise, it is a leap year
      return true;
    }

  }


  // Note implementation tips in Appendix I below.
  /**
   * Converts the name or abbreviation for any month into the index of that month's abbreviation
   * within MONTHS_OF_YEAR. Matches the specified month based only on the first three characters,
   * and is case in-sensitive.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @return the index within MONTHS_OF_YEAR that a match is found at and returns -1, when no match
   *         is found
   */
  public static int getMonthIndex(String month) {

    String monthName = null;    // stores the name of the month

    if (month.length() < 3) {   // checks if the months name is < 3
      return -1;                // if true, then no match is found and it returns -1
    }

    monthName = month.toUpperCase();    // converts the month name to upper case
    monthName = monthName.substring(0, 3);  // abbreviates the months name to 3 characters
    
    for (int i = 0; i < MONTHS_OF_YEAR.length; ++i) {  // finds the name in the MONTHS_OF_YEAR array
      if (monthName.equals(MONTHS_OF_YEAR[i])) {
        return i;                       // if found, it returns the index of that month
      }
    }

    return -1;  // Otherwise, as no match is found, it returns -1
  }


  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified year is a leap year.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month that days are being counted for (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return the number of days in the specified month (between 28-31)
   */
  public static int getNumberOfDaysInMonth(String month, String year) {

    int monthIndex = 0;     // stores the index of the month
    boolean isLeapYear = false; // used as a check for if the year is a leap year

    isLeapYear = getIsLeapYear(year);   // checks whether the year is a leap year
    monthIndex = getMonthIndex(month);  // gets the index of the month

    if (monthIndex == 1) {  // checks if February
      if (isLeapYear == true) { // checks if February in a leap year
        return 29;  // if true, returns the number of days of February in a leap year
      } else {
        return 28;  // otherwise, returns the number of days of February in a common year
      }
    } else if (monthIndex == 3 || monthIndex == 5 || monthIndex == 8 || monthIndex == 10) {
                        // checks if its a 30 day long month
      return 30;        // if true, returns 30 
    } else {           
      return 31;        // otherwise, as the month is 31 days long, it returns 31 
    }
  }


  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   * 
   *         use month to call getMonthIndex
   */
  public static int getFirstDayOfWeekInMonth(String month, String year) {

    int dayOfMonth = 1;     // stores the starting date of the month, i.e: 1
    int monthIndex = 0;     // stores the index of the month in the MONTHS_OF_YEAR Array
    int firstDayOfWeekIndex = 0;      // stores the index of the first day of the week in the month
    int zeroBasedCentury = 0;   // stores the century as a two digit number. Ex: 19 for 1975
    int yearOfCentury = 0; // stores the number of years since the first year in the current century

    yearOfCentury = getYearWithinCentury(year); 
                              // gets the number of years since first year in the current century

    zeroBasedCentury = Integer.parseInt(year.substring(0, 2));  
                              // gets the century as a two digit number

    monthIndex = getMonthIndex(month);  // gets the month's index from MONTHS_OF_YEAR array
    
    //Re-indexes monthIndex to fit requirements for Zeller's equation
    if (monthIndex == 0) {  // if month is January then set to "month" 13 of the previous year
      monthIndex = 13;     
      yearOfCentury -= 1;   
    } else if (monthIndex == 1) {   // if month is February then set to "month" 14 of previous year
      monthIndex = 14;    
      yearOfCentury -= 1;   
    } else {                // Otherwise, increment the month index
      ++monthIndex;
    }

    // using Zeller's equation to calculate the first day of the month
    firstDayOfWeekIndex = (dayOfMonth + (13 * (monthIndex + 1)) / 5 + yearOfCentury + 
        (yearOfCentury / 4) + (zeroBasedCentury / 4) + (5 * zeroBasedCentury)) % 7;

    if ((firstDayOfWeekIndex == 0) || (firstDayOfWeekIndex == 1)) { 
                                  // if the day is Saturday of Sunday, then increment by 5
      firstDayOfWeekIndex = firstDayOfWeekIndex + 5;
    } else {                        // Otherwise, if any other day, decrement by 2
      firstDayOfWeekIndex = firstDayOfWeekIndex - 2;
    }

    return firstDayOfWeekIndex;
  }


  // Note implementation tips in Appendix I below.
  /**
   * Creates and initializes a 2D String array to reflect the specified month. The first row of this
   * array [0] should contain labels representing the days of the week, starting with Monday, as
   * abbreviated in DAYS_OF_WEEK. Every later row should contain dates under the corresponding days
   * of week. Entries with no corresponding date in the current month should be filled with a single
   * period. There should not be any extra rows that are either blank, unused, or completely filled
   * with periods. For example, the contents for September of 2019 should look as follows, where
   * each horizontal row is stored in different array within the 2d result:
   *
   * MON TUE WED THU FRI SAT SUN . . . . . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
   * 22 23 24 25 26 27 28 29 30 . . . . . .
   *
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month generate calendar for (Gregorian Calendar AD) String must contain the
   *              digits of a single non-negative int for year.
   * @return 2d array of strings depicting the contents of a calendar
   */
  public static String[][] generateCalendar(String month, String year) {

    String[][] calendarMonth = null; // the Array which holds the calendar to be printed
    int dayCounter = 1; // counts the number of days in the month calendar
    int indexOfFirstDayOfWeekInMonth = 0; // stores index of the first day of the week in the month
    int numDaysInMonth = 0; // stores the maximum number of days in the month
    final int NUM_DAYS_IN_WEEK = 7; // stores the number of days in a week
    int numWeeksNeeded = 0;
    // calculates the number of weeks needed by dividing by the number of days in a week (7)
    int numDaysInFirstRow = 0; // calculates the number of days in the first row of the calendar

    indexOfFirstDayOfWeekInMonth = getFirstDayOfWeekInMonth(month, year);

    numDaysInMonth = getNumberOfDaysInMonth(month, year);

    numDaysInFirstRow = Math.abs(indexOfFirstDayOfWeekInMonth - NUM_DAYS_IN_WEEK);
    // Taking the absolute value so that there is no negative number

    numWeeksNeeded = ((numDaysInMonth - numDaysInFirstRow) / 7) + 1;
    // Note: +1 week is added for the first week that was subtracted

    if ((numDaysInMonth - numDaysInFirstRow) % 7 != 0) {
      // checks if a final partial week is needed on the calendar. If so, another week is added to
      // numWeeksNeeded
      ++numWeeksNeeded;
    }

    calendarMonth = new String[numWeeksNeeded + 1][7];
    // Initialises a 2D array (7 Days wide by (numWeeksNeeded + 1) long)
    // adds 1 to numWeeksNeeded to account for the labels representing the days of the week in the
    // first row of the calendar

    calendarMonth[0] = DAYS_OF_WEEK;

    // Loop a number of times equal to numWeeksNeeded to populate the remaining rows in
    // calendarMonth
    for (int i = 1; i <= numWeeksNeeded; ++i) {
      if (i == 1) {  // Enter this loop if populating the first week in the calendar
        for (int j = 0; j < NUM_DAYS_IN_WEEK; ++j) {
          // Check if a dot should be placed
          if (j < indexOfFirstDayOfWeekInMonth) {
            calendarMonth[i][j] = ".  ";
          } else {
            // Begin filling in the calendar with number dates (1,2,3, etc)
            calendarMonth[i][j] = Integer.toString(dayCounter) + "  ";
            ++dayCounter;
          }
        }
        
        // Enter this loop if populating a week in the middle of the calendar
      } else if (i < numWeeksNeeded) { 
        for (int k = 0; k < NUM_DAYS_IN_WEEK; ++k) {
          // Check if the number to be inserted is a single digit (then insert the day and add two
          // spaces)
          if (dayCounter <= 9) {
            calendarMonth[i][k] = Integer.toString(dayCounter) + "  ";
          } else {  // Else the number to be added is two digits, so just add one space
            calendarMonth[i][k] = Integer.toString(dayCounter) + " ";
          }
          ++dayCounter;
        }
      } else {  // Enter this loop if populating the final week in the calendar
        for (int y = 0; y < NUM_DAYS_IN_WEEK; ++y) {
          // Check if more numbers are to be inserted
          if (dayCounter <= numDaysInMonth) {
            calendarMonth[i][y] = Integer.toString(dayCounter) + " ";
            ++dayCounter;
          } else {  // otherwise populate the remaining positions in the row with dots
            calendarMonth[i][y] = ".  ";
          }
        }
      }
    }
    return calendarMonth;
  }
}
