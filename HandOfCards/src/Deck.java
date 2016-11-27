/*************************************************************************************
 * 	CS 200 Assignment 9 Hand of Cards		                                         *
 *  *  October 28 2016                         										 *
 *	Instructor: Dean Zeller															 * 
 *  Chris Newby																		 *
 *  Deck contains deck related objects, constructor and functionality   			 *
 * 																					 * 
 ************************************************************************************/
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck {
	
	/**************************************************************************************************
	 *                                  FIELDS AND CONSTRUCTOR                                        *
	 *                                                                                                *
	 *************************************************************************************************/
	
	// Fields
	
	private ArrayList<Card> myDeck = new ArrayList<Card>();
	public Deck(){
		for(int s = 0; s < 4; s++){
        	String suitName = Suit.getSuitAbbreviation(s);
        	for (int r = 0; r < 13; r++){
        		String temp = Rank.num2rank(r);
        		String rankValue = Rank.getRankAbbreviation(temp);
        		myDeck.add(new Card(rankValue, suitName));
        	}
        }
		Collections.shuffle(myDeck);
	}
	

	
	
	
	/**************************************************************************************************
	 *                                     GENERAL DECK FUNCTIONS                                     *
	 *                                                                                                *
	 *************************************************************************************************/

	
	//Deal cards from the deck to a player
	public Hand dealCards(){
		//===========DEAL THE CARDS - 5 PER HAND ===============================
		ArrayList<Card> playerHand = new ArrayList<Card>();
		for(int i = 0; i < 5; i++){			
			Card c = myDeck.get(0);
			playerHand.add(c);
			myDeck.remove(c);
		}
		Hand newHand = new Hand(playerHand);
		return newHand;
	}
	
	
	
//	public void removeCard(Card c){
//		//find this card in teh deck & remove it
//		
//	}
	
	
	
	public void addToDeck(Card c){
		myDeck.add(c);
		// Needed to have cards incoming from another function
		
	}
	
	public Card getTopCard(){
		Card c = myDeck.get(0);
		myDeck.remove(0);
		return c;
		
	}
	
	public void printDeck(){
		for(int i=0;i<myDeck.size(); i++){
			String r = myDeck.get(i).getRank();
			String s = myDeck.get(i).getSuit();
			System.out.print(r+s + " ");
		}
	}
	
	public int getDeckSize(){
		return myDeck.size();
	}
	

	/**************************************************************************************************
	 *                                                                                                *
	 *                                                                                                *
	 *************************************************************************************************/
}
