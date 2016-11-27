/***********************************************************************************************
 * 	CS 200 Assignment 4 - Bank and Account Setup                                               *
 *  September 12, 2016                                			                               *
 * 	Instructor:  Dean Zeller							          							   *
 * 	Student:  Chris Newby																	   *
 * 	Account class holds the information and methods for all functions of Account			   *
 * 																							   *
 **********************************************************************************************/
//import java.util.ArrayList;
import java.util.Scanner;

public class Account {

	// Private variables
	
	
	// Fields
	private int ID;
	private double balance;
	private String holder;
	
	
	// Constructor
	public Account(int ID, double balance, String holder){
		this.ID = ID;
		this.balance = balance;
		this.holder = holder;
	}
	
	
	// Define methods for Account class
	public int getID(){
		return ID;
	}
	
	
	public double getBalance(){
		
		return balance;
	}
	
	
	public String getHolder(){
		return holder;
	}
	
	
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

/*if(withdrawAmt > balance){
double newWithdrawl = 0;
withdrawAmt = 0;  // Sets the original entry for withdraw back to zero
System.out.println("ERROR - You may not withdraw more than is currently in your accountt!");
System.out.println("Please enter a new withdrawl amount: \n");
newWithdrawl = getUserDouble();
balance = balance - newWithdrawl;
}*/
