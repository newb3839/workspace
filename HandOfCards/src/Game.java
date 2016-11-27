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
	static Deck gameDeck = new Deck();
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		/**************************************************************************************************
		 *                                INSTANTIATE VARIABLES                                           *
		 *                                                                                                *
		 *************************************************************************************************/
		
		int numPlayers = 0, bettingPot = 0, currentBet = 0, currentChips = 0;
		String userInput1 = null;
		boolean proceed = false;
		final int STARTING_CHIPS = 1000; // Number of chips at beginning of game will not change
		
		
		//==============GAME PLAY STORAGE ===========================================
		int[] round1bets = new int[numPlayers];
		int[] round2bets = new int[numPlayers];
		
		//==============ARRAYLISTS===================================================
		
		
		
		/**************************************************************************************************
		 *                          INTRO MESSAGES AND USER INPUT DATA                                    *
		 *                                                                                                *
		 *************************************************************************************************/
		
		System.out.println("Welcome to Newby's Poker Game! .");
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
		
		//gameDeck.printDeck();
				
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
	
		//test print out players hands
		for(int i = 0; i < players.size(); i++){
			Hand h = players.get(i).getHand();
			System.out.println(players.get(i).getName());
			h.printHand();
		}
		
		proceed = false; // resets proceed to false for the next loop
		//TODO: DO CARD EXCHANGE BY PLAYER INDEX
		for(int i = 0; i < players.size(); i++){
			
			System.out.println(players.get(i).getName() + ", do you want to exchange any cards? (y/n) ");
			if(kb.next().trim().equalsIgnoreCase("y")){
				try{
					do{
						proceed = true;
						System.out.print(players.get(i).getName() + " enter the index of the cards you want to exchange seperated by a comma ");
						String[] s_cardsToExchange = kb.next().split(",");
						for(int j=0;j<s_cardsToExchange.length;j++){
							try{
								int cardIndex = Integer.parseInt(s_cardsToExchange[j].trim());
								Hand thisHand = players.get(i).getHand();
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
					proceed = false;
					break;
				}
			}
		}
	
		//ENTER YOUR BETS
		int minBet = 1;
		
		do{
			for(int i = 0; i < players.size(); i++){
				try{
					System.out.print(players.get(i).getName() + ", make your bet: ");
					String bet = kb.next();
					int intBet = Integer.parseInt(bet);
					if(i==0){
						minBet = intBet;
					}
					proceed = true;
					
					if(intBet > players.get(i).getChips() || intBet < 0){
						System.out.println("Your bet must be in the range of 0 to the max number of chips you have, above the minimum bet set by first player of " +minBet+" chips");
						proceed = false;
						break;
					}else{
						players.get(i).decreaseChips(intBet);
						bettingPot += intBet;
					}
					
				}catch(Exception ignore){
					System.out.println("Some of your input wasn't correct, try again.");
					proceed = false;
					break;
				}
			}
		}while(!proceed);
		
		for(int i = 0; i < players.size(); i++){
		System.out.println(players.get(i).getChips());
		}
		
		System.out.println("");
		System.out.println("The current pot is up to: " + bettingPot + " chips.");
		
		
		//TODO: DO CARD EXCHANGE BY PLAYER INDEX (is this needed)?	
		
		// TODO: MAKE FINAL BETS (is this needed)?				
		
		// EVALUATE HANDS
		// DECLARE WINNER 
		// AWARD WINNINGS 
		
		
		kb.close();
	}
		
	
}
