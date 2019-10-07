//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: BankTeller
// Files: BankTeller.java
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

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * Does the functions of an actual Bank Teller machine by creating, adding and finding Bank
 * Accounts, adding transactions, withdrawing and depositing money and changing the account balance
 * 
 * @author taha
 */

public class BankTeller {

  private ArrayList<BankAccount> bankAccounts = null; // initialises an ArrayList of BankAccounts

  /**
   * Creates a new BankTeller object with an empty list of accounts
   */
  public BankTeller() {
    bankAccounts = new ArrayList<>();
  }

  /**
   * Adds a newAccount to the list of accounts of this BankTeller
   * 
   * @param newAccount - a new account to add
   * @throws java.lang.IllegalStateException    - with a descriptive error message if the accountID
   *                                            of the newAccount is used by another account already
   *                                            added to the list of accounts
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if the newAccount
   *                                            is null
   */
  public void addBankAccount(BankAccount newAccount) {

    if (newAccount == null) { // checks if Bank Account is null, if true then throws an exception
      throw new java.lang.IllegalArgumentException("ERROR: The Bank Account does not exist");
    }

    for (int i = 0; i < bankAccounts.size(); ++i) { // checks if the Bank Account already exists
      if (bankAccounts.get(i).equals(newAccount)) { // if true then throws an exception
        throw new java.lang.IllegalStateException("ERROR: AccountID already exists");
      }
    }

    bankAccounts.add(newAccount); // Otherwise, adds the Bank Account
  }

  /**
   * Returns the bank account that has exactly the provided identifier. Case sensitive comparison
   * must be considered.
   * 
   * @param id - a string that represents an identifier of a bank account
   * @return a reference to the bank account whose account identifier has an exact match with the
   *         provided string
   * @throws java.util.NoSuchElementException - with a descriptive error message if no account in
   *                                          this bankTeller's accounts list has the provided id
   */
  public BankAccount findAccount(java.lang.String id) throws java.util.NoSuchElementException {

    if (id != null) {
      // checks if the ID is not null, if true, creates a new Bank Account object with the ID
      BankAccount sav = new BankAccount(id, 1);

      for (int i = 0; i < bankAccounts.size(); ++i) { // finds a Bank Account with the same ID
        if (bankAccounts.get(i).equals(sav)) { // if true, returns it
          return bankAccounts.get(i);
        }
      }
    }
    throw new java.util.NoSuchElementException( // Otherwise, throws an exception
        "ERROR: The Bank Account does not exist for the provided id");
  }

  /**
   * Adds a new transaction to the account's list of transactions. When added, a withdrawal or
   * deposit transaction should change the account's balance
   * 
   * @param transaction - to add
   * @param account     - bank account
   * @throws java.util.zip.DataFormatException - if the format of the transaction is not correct
   * @throws java.lang.NullPointerException    - if account is null
   */
  public void addTransaction(java.lang.String transaction, BankAccount account)
      throws java.util.zip.DataFormatException {

    int transactionCode = 0;
    Integer transactionAmount = 0;
    Scanner sc = null;

    try { // used to close the scanner in the finally
      if (account == null) { // checks if the Bank Account is null, if true then throws an exception
        throw new java.lang.NullPointerException("ERROR: Bank Account does not exist");
      }

      if (transaction == null) {
        // checks if the transaction String is null, if true then throws an exception
        throw new java.util.zip.DataFormatException("ERROR: transaction does not exist");
      }

      sc = new Scanner(transaction.trim()); // creates a new Scanner object with the transaction

      if (sc.hasNextInt()) { // checks if the transaction has a transactionCode as the first int
        transactionCode = sc.nextInt();

        // checks if the transaction code is not between 0 and 1, if true then throws an exception
        if (!(transactionCode >= 0 && transactionCode <= 1)) {
          throw new java.util.zip.DataFormatException("ERROR: transaction has incorrect format");
        }

        // if the transaction does not have transactionCode as the first int, it throws an exception
      } else {
        throw new java.util.zip.DataFormatException("ERROR: transaction has incorrect format");
      }

      if (sc.hasNextInt()) { // checks if the transaction has a transactionAmount as the second int
        transactionAmount = sc.nextInt();

        // if the transaction does not have transactionAmount as the second int, it throws an
        // exception
      } else {
        throw new java.util.zip.DataFormatException("ERROR: transaction has incorrect format");
      }

      if (transactionCode == 0) { // checks if the transaction is a withdrawal
        account.withdraw(transactionAmount);
      }

      if (transactionCode == 1) { // checks if the transaction is a deposit
        account.deposit(transactionAmount);
      }
    } finally {
      sc.close();
    }
  }


  /**
   * Loads a set of transactions from a provided file object. Each transaction is in a separate
   * line. Each transaction line should contain two items: the transaction code "0" or "1" followed
   * by the transaction amount, separated by spaces. Extra spaces at the beginning and at the end of
   * a transaction line should be ignored. Not correctly formatted lines must be skipped. Valid
   * transactions must change the balance of the bank account. If java.util.Scanner object is used
   * to read from the file object, make sure to close the scanner object whenever a
   * FileNotFoundException was thrown or not.
   * 
   * @param file    - a java.io.File object referring to a file that contains a set of transactions,
   *                each in one line
   * @param account - a reference to a BankAccount object
   * @throws java.io.FileNotFoundException  - if the file object does not correspond to an actual
   *                                        file within the file system.
   * @throws java.lang.NullPointerException - if account is null
   */

  public void loadTransactions(java.io.File file, BankAccount account)
      throws java.io.FileNotFoundException {

    Scanner sc = null;
    int transactionCode = 0;
    int code = 0;   // saves the first integer in the line
    Integer transactionAmount = 0;
    String line = "";   // saves the line
    String[] transactionVariables = null;
    
    try {

      if (file == null) {
        throw new java.io.FileNotFoundException("ERROR: File does not exist");
      }
      if (account == null) {
        throw new java.lang.NullPointerException("ERROR: Bank Account does not exist");
      }

      sc = new Scanner(file);

      while (sc.hasNextLine()) { // goes through each line of the file

        line = sc.nextLine().trim(); // holds the line

        if (line.length() < 1) {
          continue;
        }

        transactionVariables = line.split(" ");

        if (transactionVariables.length != 2) { // checks if line is not equal to 2
          continue;
        }
        if (Integer.valueOf(transactionVariables[0]) >= 0
            && Integer.valueOf(transactionVariables[0]) <= 1) { // checks if valid transactionCode
          transactionCode = Integer.valueOf(transactionVariables[0]);

          transactionAmount = Integer.valueOf(transactionVariables[1]);

          try { // adds transaction
            addTransaction("" + transactionCode + transactionAmount, account);
          } catch (DataFormatException e) {
          }
        } else {
          continue;
        }

      }
    } finally { // closes scanner
      if (sc != null) {
        sc.close();
      }
    }
  }


  /**
   * Returns the total number of accounts created so far (i.e., the size of the Arraylist of
   * accounts)
   * 
   * @return the total number of accounts added to this BankTeller
   */
  public int getAccountsCount() {

    return bankAccounts.size();
  }

}
