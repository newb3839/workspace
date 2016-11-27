/***********************************************************************************************
 * 	CS 200 Assignment 4 - Bank and Account Setup                                               *
 *  September 12, 2016                                			                               *
 * 	Instructor:  Dean Zeller							          							   *
 * 	Student:  Chris Newby																	   *
 * 	AccountTester is a class that used to test the Account Class and its functions.			   *
 * 																							   *
 **********************************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class AccountTester {

/*	public static void main(String[] args) {
		*//********************************************************************************************************************
		*            WORKING WITH BASIC METHODS BEYOND THIS POINT, NO ARRAY LIST METHODS BELOW THIS LINE
		********************************************************************************************************************//*
		
		System.out.println("Welcome to the Account Tester");
		System.out.println("Enter commands at the prompt.  Enter ? for a list of commands.  \n");
		System.out.print("==> " );
		Scanner kb = new Scanner(System.in);
		new Account(1, 100.00, "cnewby");
		String answer = null;
		
		do{
			
			System.out.println("Press ? for help.  \n");
			System.out.print("==> " );
			String userInput = kb.next();
			char userChar = userInput.charAt(0);
			switch(userChar){
			
				case 'A':
					Account.displayInfo();
					break;
					
				case 'B':
					int ID = Account.getID();
					System.out.println("The ID of the account is: " + ID + "\n");
					break;
					
				case 'C':
					double balance = Account.getBalance();
					System.out.println("The balance in the account is: $" + balance + "\n");
					break;
					
				case 'D':
					System.out.println("Please enter a new deposit amount:  \n");
					String userInput1 = kb.next();
					double depositAmt = 0;
					boolean isValid = Account.isValidDeposit(userInput1);
					
					//System.out.println("Boolean isValid =  " + isValid);
					if(!isValid){
						System.out.println("Error - Invalid Input.");
						break;
					}else{
						depositAmt = Double.parseDouble(userInput1);
						balance = Account.deposit(depositAmt);
						System.out.println("Your new balance in the account is:  " + balance);
						break;
					}
					
					
				case 'E':
					System.out.println("Please enter a withdrawl amount:  \n");
					String userInput2 = kb.next();
					double withdrawlAmt = 0;
					boolean isValid1 = Account.isValidWithdrawl(userInput2);
					if(!isValid1){
						System.out.println("Error - Invalid Input.");
						break;
					}else{
						withdrawlAmt = Double.parseDouble(userInput2);
						balance = Account.withdraw(withdrawlAmt);
						System.out.println("Your new balance in the account is:  " + balance);
						break;
					}
				
				case 'F':
					String holder = Account.getHolder();
					System.out.println("The holder of this account is: " + holder + "\n");
					break;
					
				case 'Q':
					System.out.println("End of Program.  Have a nice day!");
					System.exit(0);
					break;
					
				case '?':
					System.out.print("A - Account Info \n" +
									 "B - See the ID  \n" +
									 "C - See the Balance \n" + 
									 "D - Make a Deposit \n" +
									 "E - Make a Withdrawl \n" + 
									 "F - See the Account Holder \n" +
									 "Q - Quit the Program \n" +
									 "? - Help menu \n");
					break;
					
				default:
					System.out.println(userChar + " is not a valid menu item. \n");
					break;
		}
			
			
			
			System.out.println("Would you like to perform another function? (y/n)");
			answer = kb.next();
				
			
			
		}while(answer.equalsIgnoreCase("y"));
		System.out.println("End of Program.  Have a nice day!");
		
		kb.close();
		
	}	*/
}

/*ArrayList<Account> bankAccounts = new ArrayList<Account>();
bankAccounts.add(new Account(1, 10.0, "TEST ACCOUNT 1"));
bankAccounts.add(new Account(2, 100.0, "TEST ACCOUNT 2"));
bankAccounts.add(new Account(3, 1000.0, "TEST ACCOUNT 3"));
bankAccounts.add(new Account(4, 10000.0, "TEST ACCOUNT 4"));*/


//****TEST FOR:****//
//	- NEW ACCOUNT
//	- GET ID
// 	- GET BALANCE
//	- GET HOLDER
//	- DEPOSIT MONEY
//	- WITHDRAW MONEY
//  - DISPLAY INFORMATION ABOUT ACCOUNT

//System.out.println("Size of the array is: " + bankAccounts.size() + "\n");

