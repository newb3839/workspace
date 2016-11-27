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
	public void pokerStats(ArrayList<Card> h1){
		highCard(h1);
		twoPair(h1);
		threeOfAKind(h1);
		straight(h1);
		flush(h1);
		fullHouse(h1);
		fourOfAKind(h1);
		straightFlush(h1);
		royalFlush(h1);
	}
	
	
	
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
	
	
	
	public static void twoPair(ArrayList<Card> h1){
		String currentRank = null;
		int currentIntRank = 0;
		int[] cardCount = new int[13]; // EACH INDEX IS A CARD, THIS COUNTS THE CARDS OF EACH KIND AND PUTS THEM INTO AN INT ARRAY
		
		// LOOP THROUGH THE CARDS, GET THE RANK OF EACH, ADD IT TO ITS APPROPRIATE COUNTER
		for(int i = 0; i < h1.size(); i++){
			currentRank = h1.get(i).getRank();
			//System.out.println("CurrentRank(in CountCardSwitch)  = " + currentRank);
			currentIntRank = Rank.oneLetterRank2num(currentRank);
			//System.out.println("CurrentIntRank (in CountCardSwitch) = " + currentIntRank);
			switch(currentIntRank){
			case 0:
				cardCount[0]++;
				break;
				
			case 1:
				cardCount[1]++;
				break;
				
			case 2:
				cardCount[2]++;
				break;
				
			case 3:
				cardCount[3]++;
				break;
				
			case 4:
				cardCount[4]++;
				break;
				
			case 5:
				cardCount[5]++;
				break;
				
			case 6:
				cardCount[6]++;
				break;
				
			case 7:
				cardCount[7]++;
				break;
				
			case 8:
				cardCount[8]++;
				break;
				
			case 9:
				cardCount[9]++;
				break;
				
			case 10:
				cardCount[10]++;
				break;
				
			case 11:
				cardCount[11]++;
				break;
				
			case 12:
				cardCount[12]++;
				break;
			default:
				System.out.println("Something went wrong when counting the card ranks in your hand." );
				break;
			}
		}
		
		//CHECK TO SEE IF THE VALUE OF 2 IS REACHED MORE THAN ONCE
		int numPairs = 0, valueAtIndex = 0;
		boolean twoPairs = false;
	
/*		for(int i = 0; i < cardCount.length; i++){
				System.out.print(cardCount[i] + " ");
			}
		System.out.println("");*/
	
		for(int i = 0; i < cardCount.length; i++){
			valueAtIndex = cardCount[i];
			if(valueAtIndex == 2){
				numPairs++;
			}
		}
		
		// SET BOOLEAN TO TRUE IF TWO PAIRS EXIST, OTHERWISE PRINT -1
		if(numPairs == 2){
			twoPairs = true;
		}else{
			 System.out.println("Two Pairs: -1");
		}
		
		// IF BOOLEAN = TRUE THEN GET THE CARDS
		if(twoPairs){
			
			int highPairIndex = 0, numAtIndex1 = 0, rankNum = 0;
			String indexCardRank = null, indexCardSuit = null;
		
			for(int i = 0; i < cardCount.length; i++){
				numAtIndex1 = cardCount[i];
				if(numAtIndex1 == 2){
					highPairIndex = i;
				}
			}
			System.out.print("The High Pair is: " + Rank.num2rank(highPairIndex) + " of ");
			for(int k = 0; k < h1.size(); k++){
				indexCardRank = h1.get(k).getRank();
				rankNum = Rank.rank2num(indexCardRank);
				//System.out.println("Ranknum =  " + rankNum);
				//System.out.println("indexCardRank = " + indexCardRank);
				if(rankNum == highPairIndex){
					indexCardSuit = h1.get(k).getSuit();
					
					System.out.print(indexCardSuit + " ");
				}
			}
		}
	}
	
	
	public static void threeOfAKind(ArrayList<Card> h1){
		String currentRank = null;
		int currentIntRank = 0;
		int[] cardCount = new int[13];
		
		for(int i = 0; i < h1.size(); i++){
			currentRank = h1.get(i).getRank();
			currentIntRank = Rank.oneLetterRank2num(currentRank);
			switch(currentIntRank){
			case 0:
				cardCount[0]++;
				break;
				
			case 1:
				cardCount[1]++;
				break;
				
			case 2:
				cardCount[2]++;
				break;
				
			case 3:
				cardCount[3]++;
				break;
				
			case 4:
				cardCount[4]++;
				break;
				
			case 5:
				cardCount[5]++;
				break;
				
			case 6:
				cardCount[6]++;
				break;
				
			case 7:
				cardCount[7]++;
				break;
				
			case 8:
				cardCount[8]++;
				break;
				
			case 9:
				cardCount[9]++;
				break;
				
			case 10:
				cardCount[10]++;
				break;
				
			case 11:
				cardCount[11]++;
				break;

			case 12:
				cardCount[12]++;
				break;
			default:
				System.out.println("Something went wrong when counting the card ranks in your hand." );
				break;
			}
		}
		
/*		for(int i = 0; i < cardCount.length; i++){
			System.out.print(cardCount[i] + " ");
		}*/
		
		int valueAtIndex = 0;
		boolean threeExists = false;
		
		for(int i = 0; i < cardCount.length; i++){
			valueAtIndex = cardCount[i];
			if(valueAtIndex == 3){
				threeExists = true;
			}
		}
		
		if(threeExists){
			String indexCardRank = null, indexCardSuit = null, indexCardRankValue = null;
			int threeAtIndex = 0, valueAtIndex1 = 0, rankNum = 0;
			
			System.out.print("Three Of A Kind: " );
			for(int i = 0; i < cardCount.length; i++){
				valueAtIndex1 = cardCount[i];
				if(valueAtIndex1 == 3){
					threeAtIndex = i;
					indexCardRankValue = Rank.num2rank(i);
					
					System.out.print(indexCardRankValue + " of ");
					for(int k = 0; k < h1.size(); k++){
						
						indexCardRank = h1.get(k).getRank();
						rankNum = Rank.rank2num(indexCardRank);
						//System.out.println("Ranknum =  " + rankNum);
				
						//System.out.println("indexCardRank = " + indexCardRank);
						if(rankNum == threeAtIndex){
							indexCardSuit = h1.get(k).getSuit();
							
							System.out.print(indexCardSuit + " ");
						}
					}
					System.out.println("");
				}
			}
		}else{
			System.out.println("Three Of a Kind: -1");
		}
	}
	
	
	
	public static void straight(ArrayList<Card> h1){
		String result = " straight ";
		ArrayList<Integer> cardsInHand = new ArrayList<Integer>();
		
		for(int i = 0; i < h1.size(); i++){
			cardsInHand.add(Rank.oneLetterRank2num(h1.get(i).getRank()));
			System.out.print(h1.get(i).getRank() + h1.get(i).getSuit() + " ");
		}
		
		String specialCase = AceSpecialCase(h1);
		if(specialCase.equals("")){
			//dont replace anything
		}
		if(specialCase.equals("HighAce")){
			//replace 0 with 13			
			int aindex = cardsInHand.indexOf(0);
			if(aindex != -1){
				cardsInHand.set(aindex,13);
			}
			
		}
		if(specialCase.equals("Round")){
			//replace 12 with -1, 11 with -2, 10 with -3
			int kindex = cardsInHand.indexOf(12);
			if(kindex != -1){
				cardsInHand.set(kindex,-1);
			}
			int qindex = cardsInHand.indexOf(11);
			if(qindex != -1){
				cardsInHand.set(qindex,-2);
			}
			int jindex = cardsInHand.indexOf(10);
			if(jindex != -1){
				cardsInHand.set(jindex,-3);
			}
		}
		System.out.print("\n");
		Collections.sort(cardsInHand);
		for(int i=0;i<cardsInHand.size();i++){
			System.out.print(cardsInHand.get(i) + " " );
			int i = 0;
		}
		System.out.print("\n");
		for(int i=0;i<cardsInHand.size()-1;i++){			
			  if (cardsInHand.get(i) + 1 != cardsInHand.get(i + 1)) {
				 result = " Not straight ";
			  }	
		}
		System.out.print(result);
	}
	
	protected static String AceSpecialCase(ArrayList<Card> h1){
		boolean hasAce = false;
		boolean hasKing = false;
		boolean has2 = false;
		for(int i=0;i<h1.size();i++){
			String r = h1.get(i).getRank();
			if(r.equalsIgnoreCase("a")){
				hasAce = true;
			}
			if(r.equalsIgnoreCase("k")){
				hasKing = true;
			}
			if(r.equalsIgnoreCase("2")){
				has2 = true;
			}
		}
		
		if(hasAce && hasKing && has2){
			return "Round";
		}
		if(hasAce && hasKing && !has2){
			return "HighAce";
		}
		return "";
	}
	
	public static void flush(ArrayList<Card> h1){
		int[] suitCount = new int[4];
		boolean isFlush = false;
		int currentNum = 0, currentCardIntRank = 0, tempSuitRank = 0, currentSuitInt = 0;
		String currentSuit = null, currentCardRank = null, currentCardSuit = null, currentVerboseSuit = null;
		
		for(int i = 0; i < h1.size(); i++){
			currentSuit = h1.get(i).getSuit();
			switch(currentSuit){
			case "C":
				suitCount[0]++;
				break;
			case "D":
				suitCount[1]++;
				break;
			case "H":
				suitCount[2]++;
				break;
			case "S":
				suitCount[3]++;
				break;
			default:
				System.out.println("Something went wrong while counting the suits.");
				break;
			}		
		}
		
/*		for(int i = 0; i < suitCount.length; i++){
		System.out.print(suitCount[i] + " ");
	    }*/
	
		for(int i = 0; i < suitCount.length; i++){
			currentNum = suitCount[i];
			if(currentNum == 5){
				isFlush = true;
			}
		}
		
		if(isFlush){
			
			for(int i = 0; i < h1.size(); i++){
				currentCardSuit = h1.get(i).getSuit();
				currentSuitInt = Suit.suit2num(currentCardSuit);
				currentVerboseSuit = Suit.verboseSuit(currentSuitInt);
				currentCardRank = h1.get(i).getRank();
				currentCardIntRank = Rank.rank2num(currentCardRank);
				//System.out.println("currentCardIntRank = " + currentCardIntRank);
				//System.out.println("tempSuitRank = " + tempSuitRank);
				if(currentCardIntRank == 0){
					System.out.println("Flush: Highest Card - " + Rank.num2rank(currentCardIntRank) + " of " + currentVerboseSuit);
				}else{
					if(currentCardIntRank > tempSuitRank){
						tempSuitRank = currentCardIntRank;
					}
				}
			}
			System.out.println("Flush: Highest Card - " + Rank.num2rank(tempSuitRank) + " of " + currentVerboseSuit);
		}else{
			System.out.println("Flush: -1");
		}
		
	}
	
	
	
	public void fullHouse(ArrayList<Card> h1){
		for(int i = 0; i < h1.size(); i++){
					
		}
	}
	
	
	public static void fourOfAKind(ArrayList<Card> h1){
		String currentRank = null;
		int currentIntRank = 0;
		int[] cardCount = new int[13];
		
		for(int i = 0; i < h1.size(); i++){
			currentRank = h1.get(i).getRank();
			currentIntRank = Rank.oneLetterRank2num(currentRank);
			switch(currentIntRank){
			case 0:
				cardCount[0]++;
				break;
				
			case 1:
				cardCount[1]++;
				break;
				
			case 2:
				cardCount[2]++;
				break;
				
			case 3:
				cardCount[3]++;
				break;
				
			case 4:
				cardCount[4]++;
				break;
				
			case 5:
				cardCount[5]++;
				break;
				
			case 6:
				cardCount[6]++;
				break;
				
			case 7:
				cardCount[7]++;
				break;
				
			case 8:
				cardCount[8]++;
				break;
				
			case 9:
				cardCount[9]++;
				break;
				
			case 10:
				cardCount[10]++;
				break;
				
			case 11:
				cardCount[11]++;
				break;

			case 12:
				cardCount[12]++;
				break;
			default:
				System.out.println("Something went wrong when counting the card ranks in your hand." );
				break;
			}
		}
		
/*		for(int i = 0; i < cardCount.length; i++){
			System.out.print(cardCount[i] + " ");
		}*/
		
		int valueAtIndex = 0;
		boolean fourExists = false;
		
		for(int i = 0; i < cardCount.length; i++){
			valueAtIndex = cardCount[i];
			if(valueAtIndex == 4){
				fourExists = true;
			}
		}
		
		if(fourExists){
			String indexCardRank = null, indexCardSuit = null, indexCardRankValue = null;
			int threeAtIndex = 0, valueAtIndex1 = 0, rankNum = 0;
			
			System.out.print("Four Of A Kind: " );
			for(int i = 0; i < cardCount.length; i++){
				valueAtIndex1 = cardCount[i];
				if(valueAtIndex1 == 4){
					threeAtIndex = i;
					indexCardRankValue = Rank.num2rank(i);
					
					System.out.print(indexCardRankValue + " of ");
					for(int k = 0; k < h1.size(); k++){
						
						indexCardRank = h1.get(k).getRank();
						rankNum = Rank.rank2num(indexCardRank);
						//System.out.println("Ranknum =  " + rankNum);
				
						//System.out.println("indexCardRank = " + indexCardRank);
						if(rankNum == threeAtIndex){
							indexCardSuit = h1.get(k).getSuit();
							
							System.out.print(indexCardSuit + " ");
						}
					}
					System.out.println("");
				}
			}
			
		}else{
			System.out.println("Four Of a Kind: -1");
		}
	}
	
	
	public void straightFlush(ArrayList<Card> h1){
		for(int i = 0; i < myHand.size(); i++){
					
		}
	}
	
	
	public void royalFlush(ArrayList<Card> h1){
		for(int i = 0; i < myHand.size(); i++){
					
		}
	}
	
	//============================ BLACKJACK STATS FUNCTIONS ========================================//
	
	
	//============================= GENERAL STATS FUNCTIONS ==========================================//
	
	public void gameStats(){
		
	}
	

	public void allStats(){
		// MAY NOT BE NEEDED SINCE I'M DOING A POKER GAME, AND POKER STATS COVERS ITS OWN GAME
		// MAYBE DO OTHER STATS???
	}
	
	
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

