/***********************************************************************************************
 * 	CS 200 Assignment 6 - Black Hole Bank (Features)                                           *
 *  September 12, 2016                                			                               *
 * 	Instructor:  Dean Zeller							          							   *
 * 	Student:  Chris Newby																	   *
 * 	Security class contains security based functions for use in the Black Hole Bank        	   *
 * 																							   *
 **********************************************************************************************/

import java.util.Random;
public class Security {
	
	private static int masterPassCode = 1111;

	/********************************************************************************************************************
	*                          SECURITY METHODS FOR HANDLING PIN NUMBERS FOR ACCOUNTS                                   *
	********************************************************************************************************************/
	// Verifies the PIN number entered is the correct PIN for that account
	public static boolean verifityPIN(int pinNum){
		boolean isValidPIN = false;
		int actualPIN = 0;
		actualPIN = extractPIN(pinNum);
		if(pinNum == actualPIN){
			isValidPIN = true;
		}else{
			isValidPIN = false;
		}
		return isValidPIN;
	}
	
	// Extracts the PIN for the account in question
	public static int extractPIN(int acctNum){
		int pinNum = 0;
				
				
				
		return pinNum;
	}
	
	// Changes the PIN number for the account in question
	public static int changePIN(int acctNum, int currentPIN){
		int newPIN = 0;
		int account = acctNum;
		int currPIN = currentPIN;
		
		
		
		return newPIN;
	}
	
	public static int generatePIN(){
		int genPIN = 0;
		Random pin = new Random();
		genPIN = pin.nextInt(9999);
		//System.out.println("Your new PIN is:  " + genPIN);
		return genPIN;
	}
	
	// Master permission needed for deleting account
	public static boolean masterPermission(String tellerInput){
		boolean permission = false;
		try{
			int num = Integer.parseInt(tellerInput);
			if(num == masterPassCode){
				permission = true;
			}
		}catch(NumberFormatException ignore){
			permission = false;
		}
		return permission;
	}
	
	public static boolean isPINValid(String customerPIN){
		boolean check = false;
		try{
			int number = Integer.parseInt(customerPIN);
			check = true;
			if(number > 9999){
				System.out.println("PIN number exceeds maximum digits.");
				check = false;
			}
		}catch(NumberFormatException ignore){
			check = false;
		}
		return check;		
	}
	// Checks the PIN number for customer withdraw
	public static boolean customerPermission(String customerPIN, int accountPIN){
		//System.out.println("Customer PIN = " + customerPIN + "entered account pin = " + accountPIN);
		boolean permission = false;
		try{
			int num = Integer.parseInt(customerPIN);
			if(num == accountPIN){
				permission = true;
			}else{
				permission = false;
			}
		}catch(NumberFormatException ignore){
			permission = false;
		}
		return permission;
	}
	
	
	/********************************************************************************************************************
	*                               SECURITY METHODS FOR HANDLING TELLER INFORMATION                                    *
	********************************************************************************************************************/
	// EIN = Employee Identification Number (akin to a PIN number for an account) 
	
	// Verifies the EIN number entered is the correct PIN for that account
	public static boolean verifityEIN(int einNum){
		boolean isValidEIN = false;
		int actualEIN = 0;
		actualEIN = extractEIN(einNum);
		if(einNum == actualEIN){
			isValidEIN = true;
		}else{
			isValidEIN = false;
		}
		return isValidEIN;
	}
	
	
	// Extracts the EIN for the account in question
	public static int extractEIN(int acctNum){
		int einNum = 0;
				
				
				
		return einNum;
	}
	
	
	// Changes the PIN number for the account in question
	public static int changeEIN(int currentEIN){
		int newEIN = 0;
		
		
		
		return newEIN;
	}	
}
