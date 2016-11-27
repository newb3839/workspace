/***********************************************************************************************
 * 	CS 200 Assignment 6 - Black Hole Bank (Features)                                           *
 *  September 30, 2016                                			                               *
 * 	Instructor:  Dean Zeller							          							   *
 * 	Student:  Chris Newby																	   *
 * 	Account class holds the information and methods for all functions of Account			   *
 * 																							   *
 **********************************************************************************************/

import java.util.Scanner;

public class Account {
	
	
	/********************************************************************************************************************
	*               FIELDS/CONSTRUCTOR/GET METHODS FOR ACCOUNT OBJECTS (MODIFIED FOR USABILITY)                         *
	********************************************************************************************************************/
	// Fields
	private int ID;
	private double balance;
	private String holder;
	private int PIN;
	
	// Constructor
	public Account(int ID, double balance, String holder, int PIN){
		this.ID = ID;
		this.balance = balance;
		this.holder = holder;
		this.PIN = PIN;
	}
	
	
	// Define methods for Account class
	public int getID(){
		return ID;
	}
	
	// Changes pin to another random PIN
	public void updatePIN(){
		this.PIN = Security.generatePIN();
	}
	
/*	// Allows user to pick their own 4 digit PIN
	public void updatePIN(int newPIN){
		this.PIN = newPIN;
	}*/
	public double getBalance(){
		
		return balance;
	}
	
	
	public String getHolder(){
		return holder;
	}
	
	
	public int getPIN(){
		return PIN;
	}
	
	
	
	/********************************************************************************************************************
	*                                       FUNCTIONS FOR THE USE OF ACCOUNTS                                           *
	********************************************************************************************************************/
	
	public double deposit(double depositAmt){
		double newDeposit = depositAmt;
		balance = balance + newDeposit;
		return balance;
	}
	
	
	public double withdraw(double withdrawAmt){
		double withdraw = withdrawAmt;
		balance = balance - withdraw;
		return balance;
	}
	
	
	public void displayInfo(){
		System.out.print("Account ID: " + ID + "\n"
						+ "Balance: $" + balance + "\n"
						+ "Holder: " + holder + "\n"
						+ "\n");
	}
	

	public double getUserDouble(){
		Scanner kb = new Scanner(System.in);
		double newInput = 0;
		newInput = kb.nextDouble();
		return newInput;
	}
	
	
}
