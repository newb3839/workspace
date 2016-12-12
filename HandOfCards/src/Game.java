/*************************************************************************************
 * 	CS 200 Assignment 7 Hand of Cards		                                         *
 *  *  October 3, 2016                         										 *
 *	Instructor: Dean Zeller															 * 
 *  Chris Newby																		 *
 *  Game is a class handling the rules of the chosen game, methods for play, etc.	 *
 * 																					 * 
 ************************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	//Make empty list of players
	static ArrayList<Player> players = new ArrayList<Player>();
	//Generate deck 
	//static Deck gameDeck = new Deck();
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		/**************************************************************************************************
		 *                                INSTANTIATE VARIABLES                                           *
		 *                                                                                                *
		 *************************************************************************************************/
		
		int numPlayers = 0, currentBet = 0, currentChips = 0, tempPot = 0;
		String userInput1 = null;
		boolean proceed = false;
		final int STARTING_CHIPS = 1000; // Number of chips at beginning of game will not change
		int round = 1;
		int num = 1;
		boolean someoneBorrowed = false;
		
		/**************************************************************************************************
		 *                          INTRO MESSAGES AND USER INPUT DATA                                    *
		 *                                                                                                *
		**************************************************************************************************/
		Resource.ambientCasinoSound();
		System.out.println("Welcome to Newby's Poker Game!");
		System.out.println("");
		System.out.println("Please enter the number of players (2 to 5 players)");

		do{
			System.out.print("==> ");
			userInput1 = kb.next();
			try{
				numPlayers = Integer.parseInt(userInput1);
				proceed = true;	
			}catch(Exception ignore){
				System.out.println("You have an error in your input, please try again.");
				proceed = false;
			}
			if(numPlayers < 2 || numPlayers > 5){
				System.out.println("You must enter the number of players in the range 2-5.");
				proceed = false;
			}
		}while(!proceed);
		
		
		// tracks the player names and their number of hands won (different from player objects)
		String[] playerNames = new String[numPlayers];
		int[] wonHands = new int[numPlayers];
		
		System.out.println("");
		int handsToBePlayed = Game.minHands(numPlayers);
		System.out.println("Having " + numPlayers + " players means you must play at least " + handsToBePlayed + " hands." );
		System.out.println("");
		
		// main round loop set by # of hands to play
		for(int t = 0; t < handsToBePlayed; t++){
			int i, j, x, f, q;
			int bettingPot = 0;
			//System.out.println("T: " + t);
			Deck gameDeck = new Deck();
			Resource.shuffleCardSound();	
			
			if(t == 0){		
				Resource.dealCardsSound();
				//Fill the players arraylist
				for(x = 0; x < numPlayers; x++){
					String name = null;
					int index = x + 1; 
					System.out.print("Name of Player " + index + ": ");					
					name = kb.next();
					playerNames[x] = name;
					Hand h = gameDeck.dealCards();
					Player p = new Player(name, h, STARTING_CHIPS, 0);
					players.add(p);			
				}
				for(f= 0; f < players.size(); f++){
					Hand h = players.get(f).getHand();
					System.out.println(players.get(f).getName());
					h.printHand();
				}
			}else{
				Resource.dealCardsSound();
				for(q = 0; q < numPlayers; q++){
					Hand h = gameDeck.dealCards();
					players.get(q).setHand(h);
					players.get(q).getHand();
					System.out.println(players.get(q).getName());
					h.printHand();
				}
			}
			
			// individual rounds of bets
			for(i = 0; i < 2; i++){
				//System.out.println("I: " + i);
				for(j = 0; j < players.size(); j++){
					//System.out.println("J: " + j);
					System.out.println(players.get(j).getName() + ", do you want to exchange any cards? (y/n) ");
					if(kb.next().trim().equalsIgnoreCase("y")){
						try{
							do{
								proceed = true;
								System.out.print(players.get(j).getName() + " enter the index of the cards you want to exchange seperated by a comma ");
								String[] s_cardsToExchange = kb.next().split(",");
								for(int v=0; v<s_cardsToExchange.length;v++){
									try{
										int cardIndex = Integer.parseInt(s_cardsToExchange[v].trim());
										Hand thisHand = players.get(j).getHand();
										Card removed = thisHand.swapCard(gameDeck.getTopCard(), cardIndex);
										
										gameDeck.addToDeck(removed);									
									}
									catch(Exception ignore){
										System.out.println("You must enter a valid index.");
										break;
									}
								}
								System.out.println(players.get(i).getName());
								players.get(i).getHand().printHand();
							}while(!proceed);
						}catch(Exception ignore){
							System.out.println("Some of your input wasn't correct, try again.");
							break;
						}
					}
					int minBet = 1;
					try{
						System.out.print(players.get(j).getName() + ", make your bet: ");
						String bet = kb.next();
						int intBet = Integer.parseInt(bet);
						if(j == 0){
							minBet = intBet;
						}
						proceed = true;
						if(intBet > players.get(j).getChips() || intBet < 0 || intBet < minBet){
							System.out.println("");
							System.out.println("You'll have to go to Uncle Paulie for more money");
							System.out.println("Would you like to borrow chips from Uncle Paulie? (y/n)");
							if(kb.next().equalsIgnoreCase("y")){
								Resource.unclePaulie();
								players.get(i).add1000();
								bettingPot += intBet;
								someoneBorrowed = true;
								break;
							}
							System.out.println("");
							System.out.println("Your bet must be in the range of 0 to the max number of chips you have, above the minimum bet set by first player of " +minBet+" chips");
							
							break;
						}else{
							players.get(j).decreaseChips(intBet);
							bettingPot += intBet;
						}
					}catch(Exception ignore){
						System.out.println("Some of your input wasn't correct, try again.");
						break;
					}
					System.out.println(players.get(j).getName() + ", has " + players.get(j).getChips() + " chips.");
				}
				System.out.println("The current pot is up to: " + bettingPot + " chips.");	
			}
			System.out.println("The time has come folks...");
			System.out.println("");
			Resource.declareWinnerSound();
			String winner = "";
			int tempHighestScore = 0;
			
			for(int o = 0; o < players.size(); o++){
				Hand currHand = players.get(o).getHand();
				Scoring sc = new Scoring(currHand);
				int myscore = sc.getScore();
				players.get(o).increaseScore(myscore);
				System.out.println(players.get(o).getName() + ", your score is " + myscore);
							
				if(tempHighestScore == 0){
					winner = players.get(o).getName();
					tempHighestScore = myscore;
				}
				else{
					if(myscore > tempHighestScore){
						winner = players.get(o).getName();
						tempHighestScore = myscore;
						tempPot = players.get(o).getChips();
						tempPot += bettingPot;
						players.get(o).increaseChips(tempPot);
					}
				}	
			}
			System.out.println("The winner of this hand is " + winner + ", and you have been awarded " + bettingPot + " chips.");
			for(int u = 0; u < players.size(); u++){
				if(winner.equals(playerNames[u])){
					wonHands[u]++;
				}
			}
			if(t != (handsToBePlayed - 1)){
				System.out.println("");
				System.out.println("On to the next hand!");
				System.out.println("");
			}
		}
		
		System.out.println("The required number of hands has been played...");
		Resource.declareWinnerSound();
		int current = 0, temp = 0, most = 0;
		String overallWinner = null;
		for(int g = 0; g < playerNames.length; g++){
			current = wonHands[g];
			if(current > temp){
				most = current;
			}
			temp = current;	
		}
		
		for(int y = 0; y < playerNames.length; y++){
			if(most == wonHands[y]){
				overallWinner = playerNames[y];
			}
		}
		
		System.out.println("The overall winner is: " + overallWinner);
		System.out.println("Thank you again for visiting Newby's Poker table, may luck be on your side!" );
		if(someoneBorrowed){
			Resource.unclePaulieTheme();
			System.out.println("P.S. IF you borrowed money from Uncle Paulie, you may want to pay him soon, he gets edgy!");
		}
		
		kb.close();
	}
	
	
	// METHOD TO RETURN THE NUMBER OF HANDS TO BE PLAYED BASED ON NUMBER OF PLAYERS (TO ENSURE WINNER)
	public static int minHands(int numPlayers){
		int minNum = 0;
		if(numPlayers == 2){
			minNum = 3;
		}else if(numPlayers == 3){
			minNum = 4;
		}else if(numPlayers == 4){
			minNum = 5;
		}else{
			minNum = 6;
		}
		return minNum;
	}
}


//gameDeck.printDeck();
/*		Resource.shuffleCardSound();		
//Fill the players arraylist
for(int i = 0; i < numPlayers; i++){
	String name = null;
	int index = i + 1; 
	System.out.print("Name of Player " + index + ": ");					
	name = kb.next();
	Hand h = gameDeck.dealCards();
	Player p = new Player(name, h, STARTING_CHIPS, 0);
	players.add(p);			
}
Resource.dealCardsSound();
//test print out players hands
for(int i = 0; i < players.size(); i++){
	Hand h = players.get(i).getHand();
	System.out.println(players.get(i).getName());
	h.printHand();
}*/





