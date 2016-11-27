/*************************************************************************************
 * 	CS 200 Assignment 7 Hand of Cards		                                         *
 *  *  October 3, 2016                         										 *
 *	Instructor: Dean Zeller															 * 
 *  Chris Newby																		 *
 *  Player is a class handling all functions and fields for the player  			 *
 * 																					 * 
 ************************************************************************************/
import java.util.ArrayList;

public class Player {
	
	/**************************************************************************************************
	 *                                 FIELDS AND CONSTRUCTOR                                         *
	 *                                                                                                *
	 *************************************************************************************************/
	
	// Fields
	
	//public ArrayList<Player> players = new ArrayList<Player>();
	
	
	private String name;
	private int chips;  // <--- field added for the players beginning chips 
	private int score;
	private Hand hand;
	
	
	// Constructor
	public Player(String n, Hand h, int c, int s){
		this.name = n;
		this.chips = c;
		this.score = s;
		this.hand = h;
	}
	
	
	/**************************************************************************************************
	 *                            METHODS FOR WORKING WITH PLAYERS                                    *
	 *                                                                                                *
	 *************************************************************************************************/
	
	public String getName(){
		return this.name;
	}
	
	public int getChips(){
		return this.chips;
		
	}
	
	public int getScore(){
		return this.score;
	}
	
	public Hand getHand(){
		return this.hand;		
	}
	
	
	public void increaseScore(int s){
		score += s;		
	}
	
	
	public void decreaseScore(int s){
		score -= s;		
	}
	
	public void increaseChips(int c){
		chips += c;		
	}
	
	
	public void decreaseChips(int c){
		chips -= c;		
	}
	

	public void killPlayer(){
		
	}
	
	/**************************************************************************************************
	 *                                                                                                *
	 *                                                                                                *
	 *************************************************************************************************/
	

}
