/*************************************************************************************
 * 	CS 200 Assignment 7 Hand of Cards		                                         *
 *  *  October 3, 2016                         										 *
 *	Instructor: Dean Zeller															 * 
 *  Chris Newby																		 *
 *  Rank handles the ranking order of the cards in each suit (low to high)			 *
 * 																					 * 
 ************************************************************************************/
import java.util.Random;

public class Rank {

	/**************************************************************************************************
	 *                                FUNCTIONS USING INT ARGUEMENTS                                  *
	 *                                                                                                *
	 *************************************************************************************************/
	
	// This method returns the rank from an input integer 0-13
	public static String num2rank(int num){
		String rank = null;
		
		switch(num){
		
/*		case 0:
			rank = "EMPTY";
			break;*/
		case 0:
			rank = "ACE";
			break;
		case 1:
			rank = "2";
			break;
		case 2:
			rank = "3";
			break;
		case 3:
			rank = "4";
			break;
		case 4:
			rank = "5";
			break;
		case 5:
			rank = "6";
			break;
		case 6:
			rank = "7";
			break;
		case 7:
			rank = "8";
			break;
		case 8:
			rank = "9";
			break;
		case 9:
			rank = "10";
			break;
		case 10: 
			rank = "JACK";
			break;
		case 11:
			rank = "QUEEN";
			break;
		case 12:
			rank = "KING";
			break;
/*		case 14:
			rank = "ACE";
			break;*/
		default:
			System.out.println("You have entered invalid information in num2rank.");
			break;
		}
		
		return rank;
	}
	
	
	// This method returns the verbose name of the card from an input integer (0-14)
	public static String verboseRank(int num){
		String rank = null;
		
		switch(num){
		
/*		case 0:
			rank = "EMPTY";
			break;*/
		case 0:
			rank = "Ace";
			break;
		case 1:
			rank = "2";
			break;
		case 2:
			rank = "3";
			break;
		case 3:
			rank = "4";
			break;
		case 4:
			rank = "5";
			break;
		case 5:
			rank = "6";
			break;
		case 6:
			rank = "7";
			break;
		case 7:
			rank = "8";
			break;
		case 8:
			rank = "9";
			break;
		case 9:
			rank = "10";
			break;
		case 10: 
			rank = "Jack";
			break;
		case 11:
			rank = "Queen";
			break;
		case 12:
			rank = "King";
			break;
/*		case 14:
			rank = "Ace";
			break;*/
		default:
			rank = "-1";
			System.out.println("You have entered invalid information in verboseRank.");
			break;
		}
		
		return rank;
	}
	
	
	/**************************************************************************************************
	 *                               FUNCTIONS USING STRING ARGUEMENTS                                *
	 *                                                                                                *
	 *************************************************************************************************/


	// Takes a string input for the rank of the card, returns the integer value of the card
	public static int rank2num(String rank1){
		int rank = 0;
		
		switch(rank1){
		
/*		case "EMPTY":
			rank = 0;
			break;*/
		case "ACE":
			rank = 0;
			break;
		case "A":
			rank = 0;
			break;
		case "2":
			rank = 1;
			break;
		case "3":
			rank = 2;
			break;
		case "4":
			rank = 3;
			break;
		case "5":
			rank = 4;
			break;
		case "6":
			rank = 5;
			break;
		case "7":
			rank = 6;
			break;
		case "8":
			rank = 7;
			break;
		case "9":
			rank = 8;
			break;
		case "10":
			rank = 9;
			break;
		case "JACK": 
			rank = 10;
			break;
		case "J":
			rank = 10;
			break;
		case "QUEEN":
			rank = 11;
			break;
		case "Q":
			rank = 11;
			break;
		case "KING":
			rank = 12;
			break;
		case "K":
			rank = 12;
			break;
/*		case "ACE":
			rank = 14;
			break;*/
		default:
			rank = -1;
			System.out.println("You have entered invalid information in rank2num.");
			break;
		}
		
		return rank;
	}
	
	public static int oneLetterRank2num(String rank1){
		int rank = 0;
		
		switch(rank1){
		
/*		case "EMPTY":
			rank = 0;
			break;*/
		case "A":
			rank = 0;
			break;
		case "2":
			rank = 1;
			break;
		case "3":
			rank = 2;
			break;
		case "4":
			rank = 3;
			break;
		case "5":
			rank = 4;
			break;
		case "6":
			rank = 5;
			break;
		case "7":
			rank = 6;
			break;
		case "8":
			rank = 7;
			break;
		case "9":
			rank = 8;
			break;
		case "0":
			rank = 9;
			break;
		case "J": 
			rank = 10;
			break;
		case "Q":
			rank = 11;
			break;
		case "K":
			rank = 12;
			break;
/*		case "ACE":
			rank = 14;
			break;*/
		default:
			rank = -1;
			System.out.println("You have entered invalid information in oneLetterRank2num.");
			break;
		}
		
		return rank;
	}
	
	
	public static String abbrev2name(String rank1){
		String rank = null;
		
		switch(rank1){
		
/*		case "EMPTY":
			rank = 0;
			break;*/
		case "A":
			rank = "ACE";
			break;
		case "2":
			rank = "2";
			break;
		case "3":
			rank = "3";
			break;
		case "4":
			rank = "4";
			break;
		case "5":
			rank = "5";
			break;
		case "6":
			rank = "6";
			break;
		case "7":
			rank = "7";
			break;
		case "8":
			rank = "8";
			break;
		case "9":
			rank = "9";
			break;
		case "0":
			rank = "10";
			break;
		case "J": 
			rank = "JACK";
			break;
		case "Q":
			rank = "QUEEN";
			break;
		case "K":
			rank = "KING";
			break;
/*		case "ACE":
			rank = 14;
			break;*/
		default:
			System.out.println("You have entered invalid information in abbrev2name.");
			break;
		}
		
		return rank;
	}

	
	public static String getRankAbbreviation(String rankOfCard){

		char rank = 0;
		
		switch(rankOfCard){
		
/*		case "EMPTY":
			rank = 'E';
			break;*/
		case "ACE":
			rank = 'A';
			break;
		case "0":
			rank = 'A';
			break;
			
		case "1": 
			rank = 'A';
			break;
		case "2":
			rank = '2';
			break;
		case "3":
			rank = '3';
			break;
		case "4":
			rank = '4';
			break;
		case "5":
			rank = '5';
			break;
		case "6":
			rank = '6';
			break;
		case "7":
			rank = '7';
			break;
		case "8":
			rank = '8';
			break;
		case "9":
			rank = '9';
			break;
		case "10":
			rank = '0';
			break;
		case "JACK": 
			rank = 'J';
			break;
		case "QUEEN":
			rank = 'Q';
			break;
		case "KING":
			rank = 'K';
			break;
		/*case "ACE":
			rank = 14;
			break;*/
		default:
			System.out.println("You have entered invalid information in getRankAbbreviation.");
			break;
		}
		
		String output = String.valueOf(rank);
		
		return output;
		
	}
	
	
	/**************************************************************************************************
	 *                          FUNCTIONS USING EMPTY - () ARGUEMENTS                                 *
	 *                                                                                                *
	 *************************************************************************************************/
	
	public static int getRandomRank(){
		int randRank = 0;
		Random random = new Random();
		randRank = random.nextInt(13);
		return randRank;
	}
	
	
}

/**************************************************************************************************
 *                                                                                                *
 *                                                                                                *
 *************************************************************************************************/

/**************************************************************************************************
 *                                                                                                *
 *                                                                                                *
 *************************************************************************************************/

//char charRank = rank.charAt(0);
