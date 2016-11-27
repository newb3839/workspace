/*************************************************************************************
 * 	CS 200 Assignment 9 Hand of Cards		                                         *
 *  *  October 28 2016                         										 *
 *	Instructor: Dean Zeller															 * 
 *  Chris Newby																		 *
 *  Tester is the main program class used to test other classes/functions			 *
 * 																					 * 
 ************************************************************************************/
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
public class Hand {

	/**************************************************************************************************
	 *                                          FIELDS                                                *
	 *                                                                                                *
	 *************************************************************************************************/
	
	
	
	
	// Fields
	
	private ArrayList<Card> myHand = new ArrayList<Card>();
	
	/**************************************************************************************************
	 *                              CONSTRUCTOR FOR HAND OF CARDS                                     *
	 *                                                                                                *
	 *************************************************************************************************/
	
	public Hand(ArrayList<Card> array){
		
		this.myHand = array;
	}
	
	public ArrayList<Card> getHand(){
		return this.myHand;
	}
	
	public Card swapCard(Card c, int index){
		Card current = myHand.get(index);
		myHand.set(index, c);
		return current;
	}
	
	
/*	public Card removeCard(int cardIndex){
		Card current = myHand.get(cardIndex);
		myHand.remove(cardIndex);
		return current;
	}
	*/

	
/*	public void removeCard(String card){
		for(int i = 0; i < myHand.size(); i++){
			String indexedCardRank = myHand.get(i).getRank();
			String indexedCardSuit = myHand.get(i).getSuit();
			String indexedCard = indexedCardRank + indexedCardSuit;
			if(indexedCard.equals(card)){
				myHand.remove(card);
			}
		}*/
	
	
	
	/**************************************************************************************************
	 *                          FUNCTIONS USING EMPTY - () ARGUEMENTS                                 *
	 *                                                                                                *
	 *************************************************************************************************/
	
	
	//============================== POKER STATS FUNCTIONS ==========================================//
	
	// MAIN CALL FOR GATHERING HAND STATS

	
	
	
	// SUB-CALLS FOR INDIVIDUAL STATS
	public static void highCard(ArrayList<Card> h1){
		
		String currentRank = null, tempRank = null, finalRank = null;
		String finalSuit = null;
		int currentIntRank = 0, tempIntRank = 0, finalIntRank = 0;
		
		for(int i = 0; i < h1.size(); i++){
			currentRank = h1.get(i).getRank();
			//System.out.println("CurrentRank = " + currentRank);
			currentIntRank = Rank.oneLetterRank2num(currentRank);
			//System.out.println("CurrentIntRank = " + currentIntRank);
			if(currentIntRank == 0){
				currentRank = h1.get(i).getRank();
				finalRank = currentRank;
				//System.out.println("currentRank (in IF)= " + currentRank);
				finalSuit = h1.get(i).getSuit();
				//System.out.println("finalSuit (in IF) = " + finalSuit);
				break;
			}else{
				if(currentIntRank > finalIntRank){
					//System.out.println("CurrentIntRank (in Else): " + currentIntRank + " And finalIntRank: " + finalIntRank);
					finalIntRank = currentIntRank;
					finalRank = h1.get(i).getRank();
					finalSuit = h1.get(i).getSuit();
				}
			}
		}
		System.out.println("The High Card is: " + Card.getAbbrev(finalRank, finalSuit));
		System.out.println("");
	}
	
	
	
	//============================ BLACKJACK STATS FUNCTIONS ========================================//
	
	
	//============================= GENERAL STATS FUNCTIONS ==========================================//
	
//	public void gameStats(){
//		
//	}
//	
//
//	public void allStats(){
//		// MAY NOT BE NEEDED SINCE I'M DOING A POKER GAME, AND POKER STATS COVERS ITS OWN GAME
//		// MAYBE DO OTHER STATS???
//	}
	
	
	/**************************************************************************************************
	 *                         FUNCTIONS USING OBJECTS AS ARGUEMENTS                                  *
	 *                                                                                                *
	 *************************************************************************************************/
	
	public void printHand(){
		String cards = null;
		for (int i = 0; i < myHand.size(); i++){
			String rank = myHand.get(i).getRank();
			String suit = myHand.get(i).getSuit();
			String card = rank + suit;
			cards = (card + " ");
			System.out.print(cards);
			
		}
		System.out.println("\n");
//		for (int i = 0; i < myHand.size(); i++){
//			String rank = myHand.get(i).getRank();
//			String suit = myHand.get(i).getSuit();
//			String rankName = Rank.abbrev2name(rank);
//			int rankNum = Rank.rank2num(rankName);
//			int suitNum = Suit.suit2num(suit);
//			String verboseName = Card.getName(rankNum, suitNum);
//			System.out.println(verboseName);
//		}
		//System.out.println("");
	}
	
	
	public void addCard(Card card){		
		myHand.add(card);
	}
}

