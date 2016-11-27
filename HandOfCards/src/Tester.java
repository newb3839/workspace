/*************************************************************************************
 * 	CS 200 Assignment 7 Hand of Cards		                                         *
 *  *  October 3, 2016                         										 *
 *	Instructor: Dean Zeller															 * 
 *  Chris Newby																		 *
 *  Tester is the main program class used to test other classes/functions			 *
 * 																					 * 
 ************************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
	/*	*//**************************************************************************************************
		 *             CREATE NEW SCANNER OBJECT AND STORAGE FOR VARIABLES (IF ANY ARE NEEDED)            *
		 *                                                                                                *
		 *************************************************************************************************//*
		
		// Scanner for getting user input for testing purposes
		Scanner kb = new Scanner(System.in);
		
		
		*//**************************************************************************************************
		 *                                 STAGE 1 TESTS FOR SUIT OUTPUT                                  *
		 *                                                                                                *
		 *************************************************************************************************//*
		
		System.out.println("Test for Card Suit: ");
		System.out.print("Enter a card suit (0-3):  ");
		int number = kb.nextInt();
		String suit = Suit.num2suit(number);
		System.out.println("The suit of the card is: " + suit);
		System.out.println("");
		
		
		*//**************************************************************************************************
		 *                                 STAGE 1 TESTS FOR RANK OUTPUT                                  *
		 *                                                                                                *
		 *************************************************************************************************//*
	
		System.out.println("Test for the card rank (int to name rank): ");
		System.out.print("Enter a card rank (0-13): ");
		int number1 = kb.nextInt();
		String rank = Rank.num2rank(number1);
		System.out.println("The rank of the card is: " + rank);
		System.out.println("");
		
		System.out.println("Test for the card rank II (name to int rank): ");
		System.out.print("Enter a card rank BY NAME: ");
		String testName = kb.next();
		testName = testName.toUpperCase();
		int nameRank = Rank.rank2num(testName);
		System.out.println("The rank of the card is: " + nameRank);
		System.out.println("");
		
		*//**************************************************************************************************
		 *                                STAGE 1 TEST FOR VERBOSE OUTPUT                                 *
		 *                                                                                                *
		 *************************************************************************************************//*
		
		String numRank, numSuit;
		int inputRank = 0, inputSuit = 0;
		
		System.out.println("Enter a Rank and the Suit (int / int): ");
		System.out.print("==>");
		inputRank = kb.nextInt();
		numRank = Rank.verboseRank(inputRank);
		
		System.out.print("==>");
		inputSuit = kb.nextInt();
		numSuit = Suit.verboseSuit(inputSuit);
		
		String verbCardName0 = Card.getName(inputRank, inputSuit);
		System.out.println(verbCardName0 + "\n");
		
		System.out.println("Or with a different method (string concatenation): ");
		String verbCardName = numRank + " of " + numSuit;
		System.out.println(verbCardName);
		System.out.println("");
		
		
		*//**************************************************************************************************
		 *                                  STAGE 1 TEST TO CREATE  A CARD                                *
		 *                                                                                                *
		 *************************************************************************************************//*
		
		System.out.println("Create a card:  ");
		System.out.println("Enter an ineteger value of a card: ");
		System.out.print("==> ");
		int userRank = kb.nextInt();
		String getRank = Rank.num2rank(userRank);
		
		System.out.println("Enter an integer value of the suit: ");
		System.out.print("==> ");
		int userSuit = kb.nextInt();
		String nameOfSuit = Suit.num2suit(userSuit);
		
		System.out.println("The rank of the suit you chose is: " + getRank);  // TEST 
		System.out.println("The name of the suit you chose is: " + nameOfSuit);  // TEST 
		System.out.println("");
		String firstChar = Suit.getSuitAbbreviation(userSuit);
		String firstRank = Rank.getRankAbbreviation(getRank);
		//System.out.println("TEST: userRank: " + firstRank + " suitAbb: " + firstChar); // TEST 
		
		
		System.out.println("");

		System.out.println("Now lets see a card with getAbbrev:  ");
		String card  = Card.getAbbrev(firstRank, firstChar);
		System.out.println("The card is: " + card);
		System.out.println("");

		
		*//**************************************************************************************************
		 *                               DEAL WITH THE CARD ARRAY OBJECTAQ                                  *
		 *                                                                                                *
		 *************************************************************************************************//*
		

        System.out.println("The size of the myCard array is: " + Deck.myDeck.size());
        System.out.println("The cards in the hand so far are: ");
        for(int i = 0; i < Deck.myDeck.size(); i++){
        	String outputRank1 = Deck.myDeck.get(i).getRank();
            String outputSuit1 = Deck.myDeck.get(i).getSuit();
            String outputCard1 = outputRank1 + outputSuit1;
            System.out.println("The card at index " + i + " is: " + outputCard1);
        }
		*//************************************************************************************************
		 *                                    GET RANDOM SUIT/RANK                                        *
		 *                                                                                                *
		 *************************************************************************************************//*
		
		System.out.println("Get Random Suit (may be needed for getting random cards later)");
		int suitNum = Suit.getRandomSuit();
		String suitName = Suit.num2suit(suitNum);
		System.out.println("The random suit chosen is: " + suitName);
		System.out.println("");
		
		System.out.println("Get Random Rank (may be needed for getting random cards later)");
		int rankNum = Rank.getRandomRank();
		String rankName = Rank.num2rank(rankNum);
		System.out.println("The random suit chosen is: " + rankName);
		System.out.println("");
		
		*/
		
		/**************************************************************************************************
		 *                                                                                                *
		 *                                                                                                *
		 *************************************************************************************************/
		
		ArrayList<Card> hand = new ArrayList<Card>();
	//	hand.add(new Card("3", "C"));
		hand.add(new Card("A", "C"));
		hand.add(new Card("6", "C"));
		hand.add(new Card("2", "C"));		
		hand.add(new Card("9", "H"));
		hand.add(new Card("3", "C"));

		//hand.add(new Card("7", "S"));
		//hand.add(new Card("7", "D"));
		//hand.add(new Card("7", "C"));
//
//		Hand newHand = new Hand(hand);
//		newHand.printHand(hand);
//		
//		
//		int numRank1 = 0, numSuit2 = 0;
//		System.out.println("Enter a new card to add:");
//		System.out.println("Enter Rank: ");
//		numRank1 = kb.nextInt();
//		System.out.println("Enter Suit: ");
//		numSuit2 = kb.nextInt();
//		String returnRank = Rank.num2rank(numRank1);
//		String returnSuit = Suit.num2suit(numSuit2);
//		String inputRank1 = Rank.getRankAbbreviation(returnRank);
//		String inputSuit1 = Suit.getSuitAbbreviation(returnSuit);
//		String cardAbbrev = inputRank1 + inputSuit1;
//		System.out.print("Adding Card: " + cardAbbrev);
//		System.out.println("");
//		hand.add(new Card(inputRank1, inputSuit1));
//		newHand.printHand(hand);
//		
//		System.out.println("Enter the index of the card to be removed (by numerical index):  ");
//		int cardIndex = kb.nextInt();
//		String indexRank = hand.get(cardIndex).getRank();
//		String indexSuit = hand.get(cardIndex).getSuit();
//		String rankName1 = Rank.abbrev2name(indexRank);
//		int indexCardRank = Rank.rank2num(rankName1);
//		int indexCardSuit = Suit.suit2num(indexSuit);
//		String cardAbbrev0 = indexRank + indexSuit;
//		String verboseCard = Card.getName(indexCardRank, indexCardSuit);
//		System.out.print("Removing Card: Index " + cardIndex + ", " + verboseCard + " (" + cardAbbrev0 + ") \n");
//		hand.remove(cardIndex);
//		newHand.printHand(hand);
//		
//		System.out.println("");
//		
//		System.out.println("Enter the index of the card to be removed (by card name):  ");
//		System.out.println("Enter a card name (Ex: 2D)");
//		String inputCard = kb.next();
//		
//		String theRank = String.valueOf(inputCard.charAt(0));
//		//System.out.println("THE RANK VALUE: " + theRank);
//		String theSuit = String.valueOf(inputCard.charAt(1));
//		//System.out.println("THE SUIT VALUE: " + theSuit);
//		String theCard = theRank + theSuit;
//		//System.out.println("the card value is: " + theCard);
//		
//		int index = 0;
//		String iCardRank1 = null, iCardSuit1 = null, iCard = null;
//		for(int i = 0; i < hand.size(); i++){
//			
//			String iCardRank = hand.get(i).getRank();
//			//System.out.println("iCardRank: " + iCardRank);
//			String iCardSuit = hand.get(i).getSuit();
//			//System.out.println("iCardSuit: " + iCardSuit);
//			iCard = iCardRank + iCardSuit;
//			//System.out.println("iCard: " + iCard);
//			iCardRank1  = iCardRank;
//			iCardSuit1  = iCardSuit;
//			if(iCard.equals(theCard)){
//				
//				//System.out.println("YES IT MATCHES");
//				int tempRankNum = Rank.oneLetterRank2num(iCardRank1);
//				int tempSuitNum = Suit.suit2num(iCardSuit1);
//				index = i;
//				String verbName = Card.getName(tempRankNum, tempSuitNum);
//				System.out.print("Removing Card: " + verbName + " (" + iCard + ", at index " + index + ") ");
//				hand.remove(i);
//				newHand.printHand(hand);
//			}
//		}
		
		Hand.highCard(hand);
		Hand.twoPair(hand);
		Hand.threeOfAKind(hand);
		Hand.fourOfAKind(hand);
		Hand.flush(hand);
		Hand.straight(hand);
		System.out.println("");
		System.out.println("END OF TEST THUS FAR");
		
		
		
		
		/**************************************************************************************************
		 *                                                                                                *
		 *                                                                                                *
		 *************************************************************************************************/
				
	}

}

