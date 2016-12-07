import java.util.ArrayList;
import java.util.Collections;

public class Scoring {
	
	 boolean pair = false, twoPair = false, threeOfAKind = false, straight = false, flush = false, 
			fullHouse = false, fourOfAKind = false, straightFlush = false, royalFlush = false;
	
	// int[] pointValues = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
	public  int handValue = 0;
	
	
	//======================SCORING METHODS=============================================
	
	public Scoring(Hand myHand){
		ArrayList<Card> handArray = myHand.getHand();
		pokerStats(handArray);
		
	}
	
	public int getScore(){
		return handValue;
	}
	
	public void pokerStats(ArrayList<Card> h1){
		pair(h1);
		twoPair(h1);
		threeOfAKind(h1);
		straight(h1);
		flush(h1);
		fullHouse(h1);
		fourOfAKind(h1);
		straightFlush();
		royalFlush(h1);
	}
	
	public void pair(ArrayList<Card> h1){
		
		String currentRank = null;
		int currentIntRank = 0;
		int[] cardCount = new int[13];
		
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
		int numPairs = 0, valueAtIndex = 0;
		for(int i = 0; i < cardCount.length; i++){
			valueAtIndex = cardCount[i];
			if(valueAtIndex == 2){
				numPairs++;
			}
		}
		if(numPairs == 1){
			pair = true;
			handValue = 1;
			
		}
		
	}
	
	public void twoPair(ArrayList<Card> h1){
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
			twoPair = true;
			
		}/*else{
			 System.out.println("Two Pairs: -1");
		}*/
		
		// IF BOOLEAN = TRUE THEN GET THE CARDS
		if(twoPairs){
			pair = false;
			handValue = 2;
/*			int highPairIndex = 0, numAtIndex1 = 0, rankNum = 0;
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
			}*/
		}
	}
	
	
	public void threeOfAKind(ArrayList<Card> h1){
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
			threeOfAKind = true;
			handValue = 3;
			/*String indexCardRank = null, indexCardSuit = null, indexCardRankValue = null;
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
			}*/
		}/*else{
			System.out.println("Three Of a Kind: -1");
		}*/
	}
	
	
	
	public void straight(ArrayList<Card> h1){
		String result = " straight ";
		straight = true;		
		ArrayList<Integer> cardsInHand = new ArrayList<Integer>();
		
		for(int i = 0; i < h1.size(); i++){
			cardsInHand.add(Rank.oneLetterRank2num(h1.get(i).getRank()));
			//System.out.print(h1.get(i).getRank() + h1.get(i).getSuit() + " ");
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
			//System.out.print(cardsInHand.get(i) + " " );
		}
		System.out.print("\n");
		for(int i=0;i<cardsInHand.size()-1;i++){			
			  if (cardsInHand.get(i) + 1 != cardsInHand.get(i + 1)) {
				 result = " Not straight ";				
				 straight = false;
			  }	
		}
		if(straight){
			handValue = 4;
		}
		//System.out.print(result);
	}
	
	protected String AceSpecialCase(ArrayList<Card> h1){
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
	
	public void flush(ArrayList<Card> h1){
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
			flush = true;
			handValue = 5;
			/*for(int i = 0; i < h1.size(); i++){
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
			System.out.println("Flush: Highest Card - " + Rank.num2rank(tempSuitRank) + " of " + currentVerboseSuit);*/
		}/*else{
			System.out.println("Flush: -1");
		}*/
		
	}
	
	
	
	public void fullHouse(ArrayList<Card> h1){
		if(pair == true && threeOfAKind == true){
			fullHouse = true;
			handValue = 6;
			// SET PAIR AND 3 OF A KIND BACK TO FALSE, THEY DON'T MATTER NOW
			pair = false;
			threeOfAKind = false;
			
			
		}
	}
	
	
	public void fourOfAKind(ArrayList<Card> h1){
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
			fourOfAKind = true;
			handValue = 7;
			/*String indexCardRank = null, indexCardSuit = null, indexCardRankValue = null;
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
				}*/
			}
			
		}/*else{
			System.out.println("Four Of a Kind: -1");
		}*/
	
	
	
	public void straightFlush(){
		if(straight == true && flush == true){
			straightFlush = true;
			handValue = 8;
			// NO LONGER NEED STRAIGHT OR FLUSH 
			straight = false;
			flush = false;
		}
	}
	
	
	public void royalFlush(ArrayList<Card> h1){
		boolean  highStraight = false;
		ArrayList<Integer> cardsInHand = new ArrayList<Integer>();
		
		for(int i = 0; i < h1.size(); i++){
			cardsInHand.add(Rank.oneLetterRank2num(h1.get(i).getRank()));
			
		}
		if(cardsInHand.contains(9) && cardsInHand.contains(10) && cardsInHand.contains(11) && cardsInHand.contains(12) && cardsInHand.contains(0)){
			highStraight = true;
		}
		if(highStraight && flush){
			royalFlush = true;
			handValue = 9;
			flush = false;
			straight = false;
		}
	}
	

		
}
