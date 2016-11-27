/***********************************************************************************************
 * 	CS 200 Assignment 6 - Black Hole Bank (Features)                                           *
 *  September 30, 2016                                			                               *
 * 	Instructor:  Dean Zeller							          							   *
 * 	Student:  Chris Newby																	   *
 * 	Bank is a class that holds all information and functions for the use of Bank.			   *
 * 																							   *
 **********************************************************************************************/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bank {
	/********************************************************************************************************************
	*                          FIELDS AND CONSTRUCTOR FOR BANK OBJECTS (MODIFIED FOR USABILITY)                         *
	********************************************************************************************************************/
	 
			// Static 
			private static int nextID = 999; // NEXT ID WILL BE 1000, IT INCRIMENTS AUTOMATICALLY WHEN CALLING NEW ACCOUNT
			//private static int bankID = 0; // BANK ID FOR MULTIPLE BANKS -- NOT USED YET
			
			// ArrayList for Accounts
			 ArrayList <Account> al = new ArrayList<Account>();
			
			// Vars needed to pass information
			 String inputBal;
			
			
			// Fields for Bank
			 String name;
			 String owners;
			 int ID;
			 String division;
			 
			 // Extra fields for bank (not included in its constructor)
			 int numAccounts;
			 double totalBalance;
			
			
			// Constructor for bank objects
			public Bank(String name, int ID, String owners, String division){
				this.name = name;
				this.owners = owners;
				this.ID = ID;
				this.division = division;
				//this.numAccounts = numAccounts;
				//this.totalBalance = totalBalance;
			}
			
			
			
	/********************************************************************************************************************
	*                          DISPLAY MENU FOR THE BANK - AND ASSOCIATED FUNCTIONALITY                                 *
	********************************************************************************************************************/
			
			public void displayMenu(){
				
				// Initiate vars and scanner
				Scanner kb = new Scanner(System.in);
				char userChar = 0;
				String userInput = null, answer = null;
				
				// Display the bank information
				System.out.print("B - Bank Information \n" +
						 "N - New Account \n" +
						 "L - List all Accounts \n" + 
						 "S - Search Accounts by ID \n" +
						 "A - Display Account Menu \n" +
						 "T - Display Total Balance \n" + 
						 "R - Display Number of Accounts \n" +
						 "G - Get Data From File \n" +
						 "F - Save Data To File \n" +
						 "Q - Quit Program \n" + 
						 "? - Help menu \n" + 
						 "\n");
				System.out.println("");
				System.out.println("Enter commands at the prompt.  Enter ? for a list of commands. \n");
				
				do{
					System.out.print("==> ");
					userInput = kb.next();
					userInput = userInput.toUpperCase();
					userChar = userInput.charAt(0);
					switch(userChar){
					case '?':
						System.out.print("B - Bank Information \n" +
										 "N - New Account \n" +
										 "L - List all Accounts \n" + 
										 "S - Search Accounts by ID \n" +
										 "A - Display Account Menu \n" +
										 "T - Display Total Balance \n" + 
										 "R - Display Number of Accounts \n" +
										 "G - Get Data From File \n" +
										 "F - Save Data To File \n" +
										 "Q - Quit Program \n" + 
										 "? - Help menu \n" + 
										 "\n");
						break;
					case 'B':
						System.out.println("");
						displayBankInfo();
						break;
					case 'N':						
						//Security sec = new Security();
						double balance;
						String holder;
						System.out.println("New Account: ");
						System.out.print("Enter a Holder Name:  ");
						holder = kb.next();
						System.out.print("Enter a balance: ");
						inputBal = kb.next();
						boolean isValid = isValidDeposit(inputBal);
						if(!isValid){
							System.out.println("Error - Invalid Input.\n");
							break;
						}else{
							balance = Double.parseDouble(inputBal);
							int PIN = Security.generatePIN();
							newAccount(balance, holder, PIN);
							break;
						}
						
					case 'L':
						System.out.println("List Accounts: ");
						listAccounts();
						break;
						
					case 'S':
						System.out.println("Search Accounts: ");
						System.out.print("Enter the account ID to search for: \n");
						String searchText = null;
						searchText = kb.next();
						searchAccounts(searchText);
						break;
						
					case 'A':
						displayAccountMenu();
						break;
					
					case 'T':
						System.out.println("Total Balance:  ");
						double total = totalBalance();
						System.out.printf("The total amount in all the accounts of this bank is: $%.2f \n", total);
						break;
						
					case 'R':
						int numAcct = totalAccounts();
						System.out.println("Total Accounts: ");
						System.out.println("The total number of accounts at this bank is: " + numAcct + "\n");
						break;
						
					case 'G':
						
						System.out.println("Get Data From File: ");
						FileIO data = new FileIO();
						al = data.readFromFile();
						break;
						
					case 'F':
						System.out.println("Save Data To File: ");
						FileIO file = new FileIO();
						file.writeToFile(al);
						break;
						
					case 'Q':
						System.out.println("End of Program.  Have a nice day! \n");
						System.exit(0);
						break;
						
					default:
						System.out.println(userChar + " is not a valid menu item.\n");
						break;
					}
					
					System.out.println("Would you like to perform another function(y/n)?\n");
					answer = kb.next();
					if(!answer.equalsIgnoreCase("y")){
						System.out.println("End of Program.  Have a nice day!");
						System.exit(0);
					}
				}while(answer.equalsIgnoreCase("y"));
				
				
				kb.close();
			}
			

	/********************************************************************************************************************
	*                          DISPLAY MENU FOR THE ACCOUNT - AND ASSOCIATED FUNCTIONALITY                                 *
	********************************************************************************************************************/
			
			// DISPLAYS ACCOUNT MAIN MENU
			public  void displayAccountMenu(){
				System.out.print("A - Account Info \n" +
						 "B - See the ID  \n" +
						 "C - See the Balance \n" + 
						 "D - Make a Deposit \n" +
						 "E - Make a Withdrawl \n" + 
						 "F - See the Account Holder \n" +
						 "G - Go Back to Bank Menu \n" +
						 "H - Delete an Account \n" +
						 "I - Update PIN Number \n" +
						 "Q - Quit the Program \n" +
						 "? - Help menu \n");
				System.out.println("");
				System.out.println("Enter commands at the prompt.  Enter ? for a list of commands.  \n");
				String answer = null;
				Scanner kb1 = new Scanner(System.in);
				do{
					
					System.out.println("Press ? for help.  \n");
					System.out.print("==> " );
					String userInput1 = kb1.next();
					userInput1 = userInput1.toUpperCase();
					char userChar = userInput1.charAt(0);
					switch(userChar){
					
						case 'A':
							int acctNum = 0;
							boolean isValid = false;
							String input = null;
							
							System.out.println("Display Account Info: ");
							System.out.print("Enter the Account Number: ");
							input = kb1.next();
							isValid = isValidAcctNum(input);
							if(isValid){
								acctNum = Integer.parseInt(input);
								int currentAcct = 0;
								for(int i = 0; i < al.size(); i++){
									currentAcct = al.get(i).getID();
									if(currentAcct == acctNum){
										al.get(i).displayInfo();
									}
								}
								break;
							}else{
								System.out.println("You have entered an invalid account ID.\n");
								break;
							}
							
						case 'B':
							System.out.println("See the Account ID: ");
							System.out.print("Enter the name of the account holder: ");
							String searchName = kb1.next();
							boolean nameExists = false;
							
							// Verify that the name exists in the known accounts list
							for(int i = 0; i < al.size(); i++){
								String currentName = al.get(i).getHolder();
								if(currentName.equals(searchName)){
									nameExists = true;
								}
							}
							
							// If the name exists, search through and get the ID for said name
							if(nameExists){
								for(int i = 0; i < al.size(); i++){
									String currentName = al.get(i).getHolder();
									if(currentName.equals(searchName)){
										int acctID = al.get(i).getID();
										System.out.println("The account ID for " + searchName + " is " + acctID + ".\n");
									}
								}
								break;
							}else{
								System.out.println("The name is either incorrect or does not exist.\n");
								break;
							}
						
						case 'C':
							int acctNum2 = 0;
							boolean isValid2 = false;
							
							System.out.println("Get the Account Balance: ");
							System.out.print("Enter the account number: ");
							String input4 = kb1.next();
							isValid2 = isValidAcctNum(input4);
							
							if(isValid2){
								acctNum2 = Integer.parseInt(input4);
								int currentAcct1 = 0;
								for(int i = 0; i < al.size(); i++){
									currentAcct1 = al.get(i).getID();
									if(currentAcct1 == acctNum2){
										System.out.print("Balance: $" + al.get(i).getBalance() + "\n");
									}
								}
								break;
							}else{
								System.out.println("You have entered an invalid account number. \n");
								break;
							}

						case 'D':
							double deposit, balance;
							int index = 0, currentAcct = 0, acctNum3 = 0;
							System.out.println("Make a Deposit:  ");
							System.out.print("Enter an Account ID for the deposit: ");
							String userInput2 = kb1.next();
							boolean isValid1 = isValidAcctNum(userInput2);
							
							System.out.print("Please enter a new deposit amount:  ");
							String userInput3 = kb1.next();
							boolean isValid3 = isValidDeposit(userInput3);
							
							if(isValid1 && isValid3){
								acctNum3 = Integer.parseInt(userInput2);
								deposit = Double.parseDouble(userInput3);
								for(int i = 0; i < al.size(); i++){
									currentAcct = al.get(i).getID();
									if(acctNum3 == currentAcct){
										index = i;
										al.get(i).deposit(deposit);
									}
								}
								balance = al.get(index).getBalance();
								System.out.printf("Your new account balance is: $%.2f \n", balance);
								break;
							}else{
								System.out.println("You have entered invalid information. \n");
								break;
							}
							
						case 'E':
							double withdrawlAmt = 0, balance1 = 0;
							int acctNum5 = 0, index1 = 0, customerAcct = 0, customerPIN = 0;
							int currentAcctPIN = 0, actualPIN = 0;
							System.out.println("Make a withdrawl: \n");
							
							System.out.print("Please enter an account number: ");
							String userInput5 = kb1.next();
							boolean isValid4 = isValidAcctNum(userInput5);
							if(isValid4){
								customerAcct = Integer.parseInt(userInput5);
								
							}
							//System.out.println("Account Number valid = " + isValid4);
							
							System.out.print("Please enter a withdrawl amount: ");
							String userInput6 = kb1.next();
							boolean isValid5 = isValidWithdrawl(userInput6);
							//System.out.println("Account withdraw valid = " + isValid5);
							
							System.out.print("Please enter the PIN number:  ");
							String userInput7 = kb1.next();
							boolean checkEntry = Security.isPINValid(userInput7);
							if(checkEntry){
								
								customerPIN = Integer.parseInt(userInput7);
								for(int i = 0; i < al.size(); i++){
									currentAcctPIN = al.get(i).getPIN();
									if(currentAcctPIN == customerPIN){
										actualPIN = al.get(i).getPIN();
									}
								}
								
							}
							boolean isValid6 = Security.customerPermission(userInput7, actualPIN);
							//System.out.println("pin number valid = " + isValid6);
							
							if(isValid4 && isValid5 && isValid6){
								acctNum5 = Integer.parseInt(userInput5);
								withdrawlAmt = Double.parseDouble(userInput6);
								for(int i = 0; i < al.size(); i++){
									currentAcct = al.get(i).getID();
									if(acctNum5 == currentAcct){
										index1 = i;
										al.get(i).withdraw(withdrawlAmt);
										balance1 = al.get(index1).getBalance();
										System.out.printf("Your new account balance is: $%.2f \n", balance1);	
									}
								}
								break;
							}else{
								System.out.println("You have entered invalid information. \n");
								break;
							}
							
						case 'F':
							
							int acctNum6 = 0, currentAcct6 = 0;
							String userInput8 = null, acctHolder = null;
							boolean isValid8 = false;
							
							System.out.println("See Account Holder: \n");
							System.out.print("Enter an Account ID: ");
							userInput8 = kb1.next();
							isValid8 = isValidAcctNum(userInput8);
							
							if(isValid8){
								acctNum6 = Integer.parseInt(userInput8);
								for(int i = 0; i < al.size(); i++){
									currentAcct6 = al.get(i).getID();
									if(currentAcct6 == acctNum6){
										acctHolder = al.get(i).getHolder();
										System.out.println("The holder of this account is: " + acctHolder + "\n");
									}
								}
								break;
							}else{
								System.out.println("You have entered invalid information.\n");
								break;
							}
							
						case 'G':
							displayMenu();
						
						case 'H':
							String userInputNum = null, managerPasscode = null;;
							boolean isValid10 = false, hasPermission = false;
							System.out.println("Delete an Account:  ");
							System.out.print("Enter the Account Number: ");
							userInputNum = kb1.next();
							System.out.println("To delete an account a manager must approve.");
							System.out.println("Please enter the manager passcode: ");
							managerPasscode = kb1.next();
							hasPermission = Security.masterPermission(managerPasscode);
							
							isValid10 = isValidAcctNum(userInputNum);
							if(isValid10 && hasPermission){
								deleteAccount(userInputNum);
								System.out.println("You have successfully deleted account number " + userInputNum + ".\n");
								break;
							}else{
								System.out.println("Delete of Account " + userInputNum + " was not successful.");
								//System.out.println("Account Number valid = " + isValid10);
								break;
							}
						case 'I':
							int newPIN, userAcct;
							String acctNumber1;
							System.out.println("Update PIN Number: ");
							System.out.print("Enter the Account Number: ");
							acctNumber1 = kb1.next();
							boolean isAcctValid = isValidAcctNum(acctNumber1);
							if(isAcctValid){
								userAcct = Integer.parseInt(acctNumber1);
								newPIN = 0;
								for(int i = 0; i < al.size(); i++){
									int acctID = al.get(i).getID();
									if(acctID == userAcct){
										Account myAcct = al.get(i);
										myAcct.updatePIN();
										System.out.println("Your new PIN is:  " + al.get(i).getPIN());
									}
								}
								break;
							}else{
								System.out.println("You Have Entered Invalid Information.");
								break;	
							}
							
						case 'Q':
							System.out.println("End of Program.  Have a nice day!\n");
							System.exit(0);
							break;
							
						case '?':
							System.out.print("A - Account Info \n" +
									 "B - See the ID  \n" +
									 "C - See the Balance \n" + 
									 "D - Make a Deposit \n" +
									 "E - Make a Withdrawl \n" + 
									 "F - See the Account Holder \n" +
									 "G - Go Back to Bank Menu \n" +
									 "H - Delete an Account \n" +
									 "I - Update PIN Number \n" +
									 "Q - Quit the Program \n" +
									 "? - Help menu \n");
							break;
							
						default:
							System.out.println(userChar + " is not a valid menu item. \n");
							break;
				}
					
					System.out.println("Would you like to perform another function(y/n)?\n");
					answer = kb1.next();
					if(!answer.equalsIgnoreCase("y")){
						displayMenu();
					}
					
				}while(answer.equalsIgnoreCase("y"));
				kb1.close();
			}
			
			
	/********************************************************************************************************************
	*                                METHODS FOR THE BANK AND ACCOUNT HANDLING                                          *
	********************************************************************************************************************/
			
					
			// Function for listing accounts held in array list
			public void listAccounts(){
				System.out.println("   ID      Holder     Balance     PIN");
				System.out.println("+-------+-----------+-----------+-------+");
				for(int i = 0; i < al.size(); i++){
					int ID = al.get(i).getID();
					String holder = al.get(i).getHolder();
					double bal = al.get(i).getBalance();
					int PIN = al.get(i).getPIN();
					System.out.printf("%6d %9s %12.2f %8d \n", ID, holder, bal, PIN);
				}
				System.out.println("+-------+-----------+-----------+-------+");
			}
			
			
			// Create new account (in accounts arraylist)
			public void newAccount(double balance, String holder, int PIN){
				nextID += 1;
				//System.out.println(nextID);
				Account newAcct = new Account(nextID, balance, holder, PIN);
				al.add(newAcct);
			}
			
			
			// Delete an account from the arraylist
			public void deleteAccount(String userSelection){
				int currentAcct10 = 0, searchAcct = 0;
				searchAcct = Integer.parseInt(userSelection);
				for(int i = 0; i < al.size(); i++){
					currentAcct10 = al.get(i).getID();
					if(currentAcct10 == searchAcct){
						al.remove(i);
					}
				}
			}
			
			// Display bank information held in bank fields
			public void displayBankInfo(){
				int totalAccts = totalAccounts();
				double totalBal = totalBalance();
				
				System.out.print("Bank Name: " + name + "\n" +
								 "Owners: " + owners + "\n" +
								 "ID: " + ID + "\n" +
								 "Division: " + division + "\n" +
								 "Accounts:  " + totalAccts + "\n");
				System.out.printf("Total Balance: $%.2f \n", totalBal);
			}
			
			
			// Search account objects by account ID
			public void searchAccounts(String searchID){
				int searchFor = 0, currentID = 0;
				String holder = null;
				double balance = 0;
				searchFor = Integer.parseInt(searchID);
				for(int i = 0; i < al.size(); i++){
					currentID = al.get(i).getID();
					if(currentID == searchFor){
						holder = al.get(i).getHolder();
						balance = al.get(i).getBalance();
						System.out.printf("Account Num: %d \n" +
										  "Holder: %s \n" + 
								          "Balance: $%.2f \n", currentID, holder, balance);
					}
				}
			}
			
			// Gets the number of accounts in the arraylist
			public int totalAccounts(){
				return  al.size();
			}
			
			// Gets the total balance of the accounts in the array
			public double totalBalance(){
				double currentBalance = 0, totalingBalance = 0;
				for(int i = 0; i < al.size(); i++){
					currentBalance = al.get(i).getBalance();
					totalingBalance += currentBalance;
				}
				
				return totalingBalance;
			}
			
			// Checks for whether the account exists
			public boolean acctExists(int acctNum){
				int currentAcct = 0;
				boolean itExists = false;
				for(int i = 0; i < al.size(); i++){
					currentAcct = al.get(i).getID();
					if(currentAcct == acctNum){
						itExists = true;
					}
				}
				return itExists;
			}
			
	/*******************************************************************************************************************
	*                                         METHODS NEEDED FOR ERROR CHECKING                                        *
	********************************************************************************************************************/
			
			
			// Boolean method for checking for invalid inputs for deposits
			public boolean isValidDeposit(String userInput){
				double d = 0;
				boolean isValid = false;
				try{
					d = Double.parseDouble(userInput);
					isValid = true;
					if(d > 10000){
						System.out.println("Deposit exceeds $10K.\n");
						isValid = false;
					}else if(d < 0){
						System.out.println("Cannot make negative deposit. \n");
						isValid = false;
					}
				}catch(Exception ignore){
					isValid = false;
				}
				return isValid;
			}
			
			
			// Boolean method for checking validity of inputs for withdraw 
			public boolean isValidWithdrawl(String userInput){
				double w = 0;
				boolean isValid = false;
				try{
					w = Double.parseDouble(userInput);
					isValid = true;
					double balance = w;
					if(w > balance){
						isValid = false;
						System.out.println("Withdrawl exceeds funds. \n");
					}	
				}catch(Exception ignore){
					//e.printStackTrace();
					isValid = false;
				}
				return isValid;
			}
			
			// Boolean for checking if ID is a valid one to use in a search
			public boolean isSearchIDValid(String userInput){
				int ID = 1000;
				boolean isValid = false;
				try{
					ID = Integer.parseInt(userInput);
					isValid = true;
					if(ID < 1000){
						System.out.println("ID out of known range. \n");
						isValid = false;
					}
				}catch(Exception ignore){
					System.out.println("Invalid ID search.\n");
					isValid = false;
				}
				return isValid;
			}
			
			// Tests for whether the account number is valid (and it varies based on how many accounts are created)
			public boolean isValidAcctNum(String input){
				boolean isValid = false;
				int acctNum = 0;
				try{
					acctNum = Integer.parseInt(input); // Tests if the input string can be parsed into an Integer
					isValid = true;
					if(acctNum < 1000){ // If the integer is les than 1000 it's not a valid account number
						isValid = false;
						System.out.println("Account Number Too Small\n");
					}else if(acctNum - 999 > al.size()){ // subtracts the 999 from the account value, if valid it will be less than size
						isValid = false;
						System.out.println("Account Number Too Large\n");
						isValid = false;
					}
				}catch(Exception ignore){
					isValid = false;
				}
				return isValid;
			}
}
