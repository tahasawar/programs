//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           BankTellerTester
// Files:           BankTellerTester.java
// Course:          300, Fall, 2019
//
// Author:          Taha Sawar
// Email:           tsawar@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
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

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Contains test methods for BankTeller
 * 
 * @author taha
 */

public class BankTellerTester {

  /**
   * Calls the test methods defined in this BankTellerTester class
   * 
   * @param args - input arguments
   */
  public static void main(String[] args) {

    System.out.println("testBankTellerConstructor is " + testBankTellerConstructor());
    System.out.println("testBankTellerAddBankAccountUsedIdentifier is "
        + testBankTellerAddBankAccountUsedIdentifier());
    System.out.println("testBankTellerLoadTransactionsFileNotFound is "
        + testBankTellerLoadTransactionsFileNotFound());
    System.out.println("testBankTellerAddBankAccountNewIdentifier is "
        + testBankTellerAddBankAccountNewIdentifier());
  }

  /**
   * Checks whether the constructor of BankTeller class creates a new BankTeller object with an
   * empty ArrayList of bank accounts.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerConstructor() {

    BankTeller beta = new BankTeller();

    if (beta.getAccountsCount() == 0) {
      return true;
    }
    return false;
  }

  /**
   * Checks whether the BankTeller.addBankAccount() method throws an IllegalStateException when it
   * is passed a bank account with an identifier already used.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerAddBankAccountUsedIdentifier() {

    try {
      BankAccount sav = new BankAccount("1069", 9090);
      BankAccount chk = new BankAccount("1069", 90000);
      BankTeller beta = new BankTeller();

      beta.addBankAccount(sav);
      beta.addBankAccount(chk);

    } catch (IllegalStateException e) {
      return true;
    }
    return false;
  }

  /**
   * Checks whether the BankTeller.addBankAccount() method does not throw an IllegalStateException
   * when it is passed a bank account with a new identifier.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerAddBankAccountNewIdentifier() {

    try {
      BankAccount sav = new BankAccount("1069", 9090);
      BankAccount chk = new BankAccount("1068", 90000);
      BankTeller beta = new BankTeller();

      beta.addBankAccount(sav);
      beta.addBankAccount(chk);

    } catch (IllegalStateException e) {
      return false;
    }
    return true;
  }

  /**
   * This method checks whether the BankTeller.loadTransactions() method that takes a File parameter
   * throws a FileNotFoundException, when it is passed a File object that does not correspond to an
   * actual file within the file system, and a non null reference of type BankAccount.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerLoadTransactionsFileNotFound() {

    try {
      File f = new File("lol.t");

      BankTeller beta = new BankTeller();
      BankAccount sav = new BankAccount("1069", 9090);

      beta.loadTransactions(f, sav);

    } catch (FileNotFoundException e) {
      return true;
    }

    return false;
  }


}
