//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: BankAccount
// Files: BankAccount.java
// Course: 300, Fall, 2019
//
// Author: Taha Sawar
// Email: tsawar@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
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

/**
 * Contains the methods of a basic Bank Acccount program. Has methods for withdrawing, depositing
 * money, checking if two accounts are equal, getting the most recent transactions and the details
 * of a bank account
 * 
 * @author taha
 */

public class BankAccount {

  private String accountID; // the unique identifier of a Bank Account
  private int balance; // the total balance of a Bank Account
  private ArrayList<String> transactions = new ArrayList<>(); // a list of the transactions of the
                                                              // of a Bank Account

  /**
   * Constructor method creates a new bank account with a given account identifier and an initial
   * balance. A deposit transaction /"1 " + initialBalance/ must be added to this account's list of
   * transactions
   * 
   * @param accountID      - this account's unique identifier
   * @param initialBalance - this account's initial balance
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if initBalance is
   *                                            less than 10
   */

  public BankAccount(java.lang.String accountID, int initialBalance) {

    this.accountID = accountID.trim();
    if (initialBalance < 10) { // checks if the initial balance is less than 10, if true,
                               // throws an exception
      throw new java.lang.IllegalArgumentException("ERROR: Initial balance is less than 10$");

    } else { // Otherwise, adds a transaction and initialises the balance field
      balance = initialBalance;
      transactions.add("1 " + initialBalance);
    }
  }

  /**
   * Gets the unique identifier of this account
   * 
   * @return the unique identifier of this account
   */
  public java.lang.String getID() {

    return accountID;
  }

  /**
   * Gets the current balance of this bank account
   * 
   * @return the current balance of this bank account
   */
  public int getBalance() {

    return balance;
  }

  /**
   * Checks if an other bank account is equal to this one
   * 
   * @param other - another BankAccount object
   * @return true if this bankAccount's identifier equals the other bankAccount's identifier. The
   *         comparison is case sensitive
   */
  public boolean equals(BankAccount other) {

    if (accountID.equals(other.accountID)) {
      return true;
    }

    return false;
  }

  /**
   * This method deposits an amount to this bank account. It also adds the transaction /"1 " +
   * depositAmount/ to this account list of transactions and updates this bank account's balance.
   * 
   * @param depositAmount - the amount of money to deposit to this bank account
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if depositAmount
   *                                            is negative
   */
  public void deposit(int depositAmount) {

    if (depositAmount < 0) { // checks if the Deposit Amount is a negative number, if true then
                             // throws an exception
      throw new java.lang.IllegalArgumentException(
          "ERROR: The amount to be deposited is less than 0");

    } else { // Otherwise, adds the deposit and updates the list of transactions
      balance = balance + depositAmount;
      transactions.add("1 " + depositAmount);
    }
  }

  /**
   * This method withdraws a specific amount of money. It also adds the transaction /"0 " +
   * withdrawalAmount/ to this accunt's list of transactions and updates this bank account's
   * balance.
   * 
   * @param withdrawAmount - the amount of money to withdraw from this bank account
   * @throws java.util.zip.DataFormatException - with a descriptive error message if
   *                                           withdrawalAmount is negative or is not a multiple of
   *                                           10
   * @throws java.lang.IllegalStateException   - if the withdrawalAmount is larger than this bank
   *                                           account's balance
   */
  public void withdraw(int withdrawAmount) throws java.util.zip.DataFormatException {

    if (withdrawAmount < 0) { // checks if the Withdraw Amount is a negative number, if true then
      // throws an exception
      throw new java.util.zip.DataFormatException(
          "ERROR: The amount to be withdrawed is less than 0");
    }
    if (!((withdrawAmount % 10) == 0)) { // checks if the Withdraw Amount is a not a multiple of 10,
      // if true then throws an exception
      throw new java.util.zip.DataFormatException(
          "ERROR: The amount to be withdrawed has to be a multiple of 10.\nE.g: $10, $20");
    }
    if (withdrawAmount > balance) { // checks if the Withdraw Amount is less than the total Account
                                    // Balance, if true then throws an exception
      throw new java.lang.IllegalStateException(
          "ERROR: The amount to be withdrawed is larger than your current account balance");
    }

    // Otherwise, withdraws the money and updates the list of transactions
    balance = balance - withdrawAmount; 
    transactions.add("0 " + withdrawAmount);

  }

  /**
   * Gets the most recent FIVE transactions in an array of length 5. This array may contain null
   * references if the total number of transactions is less than 5. If getTransactionsCount() is
   * less than 5, these transactions should be stored at the range of indices 0 ..
   * getTransactionsCount()-1. For instance, if the total number of transactions is 0, this array
   * will contain five null references. If the total number of transactions is 1, it will contain
   * the transaction at index 0, followed by 4 null references, and so on.
   * 
   * @return the most recent transactions in an array that may contain up to 5 string references
   */
  public java.lang.String[] getMostRecentTransactions() {

    String[] transactionsList = new String[5];  // holds the list of the most recent transactions

    int transactionsNo = getTransactionsCount();    // gets the number of total transactions

    int recentTransacationIndex = transactionsNo - 1; // index of most recent transaction

    // initialises the array of most recent transactions by using the ArrayList of all transactions
    for (int i = 0; i <= transactionsNo - 1 && i < 5; ++i) { 
      transactionsList[i] = transactions.get(recentTransacationIndex);
      --recentTransacationIndex;
    }


    return transactionsList;
  }

  /**
   * Gets the total number of transactions performed on this bank account, meaning the size of the
   * ArrayList of transactions of this bank account
   * 
   * @return the total number of transactions performed on this account
   */
  public int getTransactionsCount() {

    return transactions.size();
  }
}


