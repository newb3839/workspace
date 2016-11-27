/*************************************************************************************
 * 	CS 200 Assignment 7 Hand of Cards		                                         *
 *  *  October 3, 2016                         										 *
 *	Instructor: Dean Zeller															 * 
 *  Chris Newby																		 *
 *  Suit is a class handling the suit of the cards (4 total)             			 *
 * 																					 * 
 ************************************************************************************/

import java.util.Random; // Needed for picking random suit for cards later

public class Suit {

	/**************************************************************************************************
	 *                                FUNCTIONS USING INT ARGUEMENTS                                  *
	 *                                                                                                *
	 *************************************************************************************************/
	
	public static String num2suit(int num){
		String suit = null;
		switch(num){
		case 0:
			suit = "CLUB";
			break;
		case 1:
			suit = "DIAMOND";
			break;
		case 2:
			suit = "HEART";
			break;
		case 3:
			suit = "SPADE";
			break;
		default:
			System.out.println("You have entered an invalid selection in num2suit.");
			break;
		}
		return suit;
	}
	
	
	public static String verboseSuit(int num){
		String suit = null;
		switch(num){
		case 0:
			suit = "Clubs";
			break;
		case 1:
			suit = "Diamonds";
			break;
		case 2:
			suit = "Hearts";
			break;
		case 3:
			suit = "Spades";
			break;
		default:
			System.out.println("You have entered an invalid selection in verboseSuit.");
			break;
		}
		return suit;
	}
	
	
	// Basically the same method as the one above, but only returns the abbreviated value for the 
	public static String getSuitAbbreviation(int num){
		String suit = null;
		char first = 0;
		suit = num2suit(num);
		
		first = suit.charAt(0);
		//System.out.println("WITHIN METHOD2: " + first); // TEST 
		suit = String.valueOf(first);
		//System.out.println("WITHIN METHOD3: " + suit); // TEST 
		return suit;
	}
	
	
	/**************************************************************************************************
	 *                               FUNCTIONS USING STRING ARGUEMENTS                                *
	 *                                                                                                *
	 *************************************************************************************************/
	
	public static int suit2num(String suit){
		int suitNum = 0;
		switch(suit){
		case "C":
			suitNum = 0;
			break;
		case "D":
			suitNum = 1;
			break;
		case "H":
			suitNum = 2;
			break;
		case "S":
			suitNum = 3;
			break;
		default:
			System.out.println("You have entered an invalid selection in suit2num.");
			break;
		}
		return suitNum;
		
	}
	
	
	public static String abbrev2suit(String abbrev){
		String suit = null;
		switch(abbrev){
		case "C":
			suit = "CLUB";
			break;
		case "D":
			suit = "DIAMOND";
			break;
		case "H":
			suit = "HEART";
			break;
		case "S":
			suit = "SPADE";
			break;
		default:
			suit = "NONE";
			System.out.println("You have entered an invalid selection in abbrev2suit.");
			break;
		}
		return suit;
	}
	
	
	public static String getSuitAbbreviation(String rank){
		String returnRank = rank;
		char firstChar = 0;
		if(rank.contentEquals("10")){
			returnRank = "00";
		}else{
			firstChar = returnRank.charAt(0);
		}

		returnRank = String.valueOf(firstChar);
		return returnRank;
	}
	
	
	/**************************************************************************************************
	 *                          FUNCTIONS USING EMPTY - () ARGUEMENTS                                 *
	 *                                                                                                *
	 *************************************************************************************************/

	
	public static int getRandomSuit(){
		int randSuit = 0;
		Random random = new Random();
		randSuit = random.nextInt(4);
		return randSuit;
	}
	

}


/**************************************************************************************************
 *                                         GET RANDOM SUIT                                        *
 *                                                                                                *
 *************************************************************************************************/




/**************************************************************************************************
 *                             GET SUIT ABBREVIATION FROM STRING                                  *
 *                                                                                                *
 *************************************************************************************************/



/**************************************************************************************************
 *                                                                                                *
 *                                                                                                *
 *************************************************************************************************/

/**************************************************************************************************
 *                                                                                                *
 *                                                                                                *
 *************************************************************************************************/

/*		String suit = null, abbrev = null;
suit = num2suit(num);
char first = suit.charAt(0);
abbrev = first +"";
return abbrev;
*/



/*	char abbreviation = 0;
switch(num){
case 0: 
abbreviation = 'C';
break;
case 1:
abbreviation = 'D';
break;
case 2: 
abbreviation = 'H';
break;
case 3:
abbreviation = 'S';
break;
default:
System.out.println("You have entered an invalid selection.");
break;
}
return abbreviation;*/
