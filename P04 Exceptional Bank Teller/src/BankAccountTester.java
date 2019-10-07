//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           BankAccountTester
// Files:           BankAccountTester.java
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

import java.util.zip.DataFormatException;

/**
 * Contains the tester methods for BankAccount
 * 
 * @author taha
 */

public class BankAccountTester {

  /**
   * Calls the different test methods
   * 
   * @param args - input arguments
   */
  public static void main(String[] args) {

    System.out.println("testBankAccountConstructorValidInitialBalance is "
        + testBankAccountConstructorValidInitialBalance());
    System.out.println("testBankAccountConstructorBorderInitialBalance is "
        + testBankAccountConstructorBorderInitialBalance());
    System.out.println("testBankAccountConstructorNotValidInitialBalance is "
        + testBankAccountConstructorNotValidInitialBalance());
    System.out.println("testBankAccountConstructorInitialBalanceIntMin is "
        + testBankAccountConstructorInitialBalanceIntMin());
    System.out.println("testBankAccountConstructorInitialBalanceIntMax is "
        + testBankAccountConstructorInitialBalanceIntMax());
    System.out.println("testBankAccountEquals is " + testBankAccountEquals());
    System.out.println("testBankAccountNotEquals is " + testBankAccountNotEquals());
    System.out.println(
        "testBankAccountWithdrawInvalidAmount is " + testBankAccountWithdrawInvalidAmount());
    System.out.println("testBankAccountWithdrawInvalidAmountMultiple is "
        + testBankAccountWithdrawInvalidAmountMultiple());
    System.out.println("testBankAccountWithdrawLargerOfBalanceAmount is "
        + testBankAccountWithdrawLargerOfBalanceAmount());
    System.out
        .println("testBankAccountWithdrawValidAmount is " + testBankAccountWithdrawValidAmount());
    System.out.println(
        "testBankAccountDepositNegativeAmount is " + testBankAccountDepositNegativeAmount());
  }

  /**
   * Calls the constructor of BankAccount class to create a new BankAccount object with a given id
   * and a valid initial balance (greater or equal to 10). Checks whether the new account is created
   * with the provided account id and balance. It checks also that the list of transactions of the
   * created account contains only one transaction /"1 " + the initial balance/
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountConstructorValidInitialBalance() {

    try {
      BankAccount sav = new BankAccount("6092", 11);

      if (sav.getID().equals("6092") && (sav.getBalance() == 11)
          && sav.getMostRecentTransactions()[0].equals("1 " + 11)
          && (sav.getTransactionsCount() == 1)) {
        return true;
      }
    } catch (IllegalArgumentException e) {

      return false;
    }

    return false;
  }

  /**
   * Calls the constructor of BankAccount class to create a new BankAccount object with a given id
   * and a valid initial balance (equal to 10). Checks whether the new account is created with the
   * provided account id and balance. It checks also that the list of transactions of the created
   * account contains only one transaction /"1 " + the initial balance/
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountConstructorBorderInitialBalance() {

    try {
      BankAccount sav = new BankAccount("6092", 10);

      if (sav.getID().equals("6092") && (sav.getBalance() == 10)
          && sav.getMostRecentTransactions()[0].equals("1 " + 10)
          && (sav.getTransactionsCount() == 1)) {
        return true;
      }
    } catch (IllegalArgumentException e) {

      return false;
    }

    return false;
  }

  /**
   * Calls the constructor of BankAccount class to create a new BankAccount object with a given id
   * and a valid initial balance (integer maximum value). Checks whether the new account is created
   * with the provided account id and balance of integer maximum. It checks also that the list of
   * transactions of the created account contains only one transaction /"1 " + the initial balance/
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountConstructorInitialBalanceIntMax() {

    try {
      BankAccount sav = new BankAccount("6092", 2147483647);

      if (sav.getID().equals("6092") && (sav.getBalance() == 2147483647)
          && sav.getMostRecentTransactions()[0].equals("1 " + 2147483647)
          && (sav.getTransactionsCount() == 1)) {
        return true;
      }
    } catch (IllegalArgumentException e) {

      return false;
    }
    return false;
  }

  /**
   * This method checks whether the BankAccount constructor throws an IllegalArgumentException when
   * it is passed a balance smaller than 10.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountConstructorNotValidInitialBalance() {

    try {

      new BankAccount("6092", 9);

    } catch (IllegalArgumentException e) {

      return true;
    }

    return false;
  }

  /**
   * This method checks whether the BankAccount constructor throws an IllegalArgumentException when
   * it is passed a balance of the most negative integer
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountConstructorInitialBalanceIntMin() {

    try {

      new BankAccount("6092", -2147483648);

    } catch (IllegalArgumentException e) {
      return true;

    }

    return false;
  }

  /**
   * Checks whether BankAccount.equals() method returns true when it compares a bank account to
   * another one having the same account identifier; and it returns false otherwise.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountEquals() {

    try {
      BankAccount sav = new BankAccount("6092", 50);

      BankAccount chk = new BankAccount("6092", 21476999);

      if (sav.equals(chk) == true) {

        return true;
      }
    } catch (IllegalArgumentException e) {

      return false;
    }

    return false;
  }

  /**
   * Checks whether BankAccount.equals() method returns true when it compares a bank account to
   * another one having a different account identifier; and it returns false otherwise
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountNotEquals() {

    try {
      BankAccount sav = new BankAccount("6091", 2147483647);

      BankAccount chk = new BankAccount("6092", 21476999);

      if (sav.equals(chk) != true) {

        return true;
      }
    } catch (IllegalArgumentException e) {

      return false;
    }

    return false;
  }

  /**
   * Checks whether BankAccount.withdraw() method throws a DataFormatException when it is passed a
   * negative number or a number not multiple of 10. The account balance should not change after the
   * withdraw() method returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawInvalidAmount() {

    BankAccount sav = null;

    try {

      sav = new BankAccount("1 Taha", 10);

      sav.withdraw(-509119);
      sav.withdraw(9);

    } catch (java.util.zip.DataFormatException e) {

      if (sav.getBalance() == 10) {

        return true;
      }
    } catch (IllegalStateException e) {

      return false;

    } catch (IllegalArgumentException e) {

      return false;
    }

    return false;
  }

  /**
   * Checks whether BankAccount.withdraw() method throws a DataFormatException when it is passed a a
   * number which is a not multiple of 10. The account balance should not change after the
   * withdraw() method returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawInvalidAmountMultiple() {

    BankAccount sav = null;

    try {

      sav = new BankAccount("1 Taha", 10);

      sav.withdraw(9);

    } catch (java.util.zip.DataFormatException e) {

      if (sav.getBalance() == 10) {

        return true;
      }

    } catch (IllegalStateException e) {

      return false;

    } catch (IllegalArgumentException e) {

      return false;
    }

    return false;
  }

  /**
   * Checks whether BankAccount.withdraw() method throws an IllegalStateException when it is passed
   * a number larger than the account's balance. The account balance should not change after that
   * withdraw() method call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawLargerOfBalanceAmount() {

    BankAccount sav = null;

    try {

      sav = new BankAccount("1 Taha", 20);

      sav.withdraw(1000);
    } catch (java.lang.IllegalStateException e) {

      if (sav.getBalance() == 20) {
        return true;
      }
    } catch (DataFormatException e) {

      return false;

    } catch (IllegalArgumentException e) {

      return false;
    }
    return false;
  }

  /**
   * Checks whether BankAccount.withdraw() method returns without any exception when it is passed a
   * positive number smaller than the account's balance. The withdrawal amount should be subtracted
   * from the balance after the withdraw() method call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawValidAmount() {

    BankAccount sav = null;
    int withdrawAmount = 0;

    try {

      sav = new BankAccount("1 Taha", 100);

      withdrawAmount = 50;

      sav.withdraw(withdrawAmount);

    } catch (DataFormatException e) {

      return false;

    } catch (IllegalStateException e) {

      return false;

    } catch (IllegalArgumentException e) {

      return false;
    }

    if (sav.getBalance() == 100 - withdrawAmount) {
      return true;
    }

    return false;
  }


  /**
   * Checks whether BankAccount.deposit() method throws an IllegalArgumentException when it is
   * passed a negative number. The balance of the bank account should not change after the method
   * call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountDepositNegativeAmount() {

    BankAccount sav = null;

    try {

      sav = new BankAccount("1 Taha", 10);

      sav.deposit(-509119);

    } catch (java.lang.IllegalArgumentException e) {

      if (sav.getBalance() == 10) {
        return true;
      }
    }

    return false;
  }
}
