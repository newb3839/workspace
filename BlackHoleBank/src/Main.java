/***********************************************************************************************
 * 	CS 200 Assignment 6 - Bank and Account Setup                                               *
 *  September 12, 2016                                			                               *
 * 	Instructor:  Dean Zeller							          							   *
 * 	Student:  Chris Newby																	   *
 * 	Main is a class that runs and utilizes the other classes to perform tasks           	   *
 * 																							   *
 **********************************************************************************************/
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		/********************************************************************************************************************
		*                                         STATIC VOID MAIN ENTRY POINT                                              *
		********************************************************************************************************************/
		// ArrayList for Banks
		 ArrayList <Bank> bk = new ArrayList<Bank>();
		 
		// Welcome message and intro information
		System.out.println("Welcome to Black Hole Bank!  We are not YOUR bank, you are OUR customer. \n");
		System.out.println("Since 2016 we have been taking your money from you and not giving any back.");
		System.out.println("No corruption here, we promise! We're more responsible with your money than you are.");
		System.out.println("This is why WE are a bank, and YOU are a customer! Don't get snippy - we have all your money! \n");
		
		// Create new bank object and run it
		Bank myBank = new Bank("Black Hole Bank", 0, "Dollar Bill", "Colorado");
		bk.add(myBank);
		myBank.displayMenu();
	}
	
	
	
	
	
	
	
}
