//import java.util.ArrayList;

/*************************************************************************************
 * 	CS 200 Assignment 7 Hand of Cards		                                         *
 *  *  October 3, 2016                         										 *
 *	Instructor: Dean Zeller															 * 
 *  Chris Newby																		 *
 *  Card is a class that contains the fields and constructor for creating a card	 *
 * 																					 * 
 ************************************************************************************/
public class Card {

	/**************************************************************************************************
	 *                                        FIELDS                                                  *
	 *                                                                                                *
	 *************************************************************************************************/
	
	// Fields
	private String rank;
	private String suit;
		
	/**************************************************************************************************
	 *                      CONSTRUCTOR AND CONSTRUCTOR BASED CARD FUNCTIONS                          *
	 *                                                                                                *
	 *************************************************************************************************/
	
	// Constructor for a card object
	public Card(String rank, String suit){
		this.rank = rank;
		this.suit = suit;
		
	}
	
	// Return methods for Card
	
	public Card(Card card) {
		Card currentCard = card;
		
	}

	// Get Rank of card object
	public String getRank(){
		return rank;
	}
	
	// Get Suit of card object
	public String getSuit(){
		return suit;
	}
	
	/**************************************************************************************************
	 *                                FUNCTIONS USING INT ARGUEMENTS                                  *
	 *                                                                                                *
	 *************************************************************************************************/
	// Get the rank of the card
	public static String getRank(int num){
		String numOfRank = null;
		numOfRank = Rank.num2rank(num);
		return numOfRank;
	}
	
	
	// Get the suit of the card
	public static String getSuit(int num1){
		String suit = null;
		suit = Suit.num2suit(num1);
		return suit;
	}
	
	// Returns the verbose name of the card
	public static String getName(int rank1, int suit1){
		String card = "";
		String verbRank = null, verbSuit = null;
		verbRank = Rank.verboseRank(rank1);
		verbSuit = Suit.verboseSuit(suit1);
		card = verbRank + " of " + verbSuit;
		return card;
	}
	
	// Gets the abbreviation of the card from the integer values
	public static String getAbbrev(int rank, int suit){
		String stringRank = Rank.num2rank(rank);
		String stringSuit = Suit.num2suit(suit);
		String rankAbb = Rank.getRankAbbreviation(stringRank);
		String suitAbb = Suit.getSuitAbbreviation(stringSuit);
		String output = rankAbb + suitAbb;
		return output;
	}
	
	/**************************************************************************************************
	 *                               FUNCTIONS USING STRING ARGUEMENTS                                *
	 *                                                                                                *
	 *************************************************************************************************/
	
	// Gets the abbreviation of the card from the string names
	public static String getAbbrev(String rank, String abbrev){
		String cardAbbrev = rank + abbrev;
		return cardAbbrev;
	}
	
	// 
	public static String printCard(String suit3, String rank3){
		String cardPrintOut = "";
		
		// Get the information about the card, then concatenate it into a printable card
		return cardPrintOut;
	}
	
	
	/**************************************************************************************************
	 *                          FUNCTIONS USING EMPTY - () ARGUEMENTS                                 *
	 *                                                                                                *
	 *************************************************************************************************/

	
	
}
