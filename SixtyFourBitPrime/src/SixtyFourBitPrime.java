import java.util.Scanner;

import mpi.MPI;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;

public class SixtyFourBitPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sixtyFourBit = Long.parseUnsignedLong("18446744073709551615");

		Scanner kb = new Scanner(System.in);
		System.out.println("TestLine");
		
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger ten = new BigInteger("10");
		
		
		String myBigAssNumber = "100000000000000000000000000000000000000";
		
		BigInteger myban = new BigInteger(myBigAssNumber);
		System.out.println(myban);
		
		System.out.println(Long.toUnsignedString(sixtyFourBit));
		System.out.println(Long.toUnsignedString(Long.MAX_VALUE));
		System.out.println("Enter a new bigInt");
		BigInteger bI1 = new BigInteger(kb.next());
		
		System.out.println(bI1);
		System.out.println("Enter a new bigInt to subtract");
		BigInteger val = new BigInteger(kb.next());
		BigInteger biggy = bI1.subtract(val);
		System.out.println(biggy);
		
		
		System.out.println("Enter a new bigInt to multiply");
		BigInteger newVal = new BigInteger(kb.next());
		System.out.println("Enter the next num: ");
		BigInteger newVal2 = new BigInteger(kb.next());
		BigInteger finalVal = newVal.multiply(newVal2);
		System.out.println(finalVal);
		kb.close();
		
		
	
		BigInteger BItwo = new BigInteger("2");
		BigDecimal BDone = new BigDecimal("0.00033434543456");
		BigDecimal BDtwo = new BigDecimal("1000000000000000000000000000000000004");
		BigDecimal BDnum = BDone.multiply(BDtwo);
		BigDecimal ZERO = new BigDecimal("0");
		BigInteger ZERO1 = new BigInteger("0");
		System.out.println(ZERO);
		
		System.out.println(BItwo);
		System.out.println(BDnum);
		
		BigDecimal modZero = new BigDecimal("10");
		BigDecimal modZero2 = new BigDecimal("10");
		
		BigDecimal newBD = BDtwo.remainder(BDone);
		System.out.println(newBD);
		
	
		if(BDtwo.remainder(BDone) != ZERO){
			System.out.println("TRUE");
		}else{
			System.out.println("FALSE");
		}
		
		
		//BigDecimal output = modZero.remainder(modZero2);
		System.out.println(modZero.remainder(modZero2));
		if(modZero.remainder(modZero2).equals(ZERO)){
			System.out.println("TRUE");
		}else{
			System.out.println("FALSE");
		}
		
		if(myban.mod(two) != ZERO1 ){
			System.out.println("mod works you rotton bastard");
		}
		
		
		int my_rank = 1;
		
		BigInteger myRank = BigInteger.valueOf(my_rank);
		BigInteger nonZeroDist = new BigInteger("0"); // INITIALIZES THE DISTRIBUTION INTEGER TO ZERO TO START WITH, VALUE WILL CHANGE
		BigInteger count = new BigInteger("0");
		
		
		System.out.println("TEST FOR RANK = 1, BLOCK SIZE = 10");
		int i = 0;
		
    	while(i < 10){
    		i++;
    		count = count.add(one);
    		nonZeroDist = ((count.subtract(one)).multiply(ten)).add(myRank.subtract(one)); // BASED ON (ITER -1)*(BLOCK) + (RANK -1)
    		System.out.println(nonZeroDist);
    	}
 
	}
}

//========================CURRENT BIG INT PROGRAM ON MPI HELLO WORLD ================================

/*long iter = 0, ZeroDist = 0, userNumber = 0;
long longLimit = Long.MAX_VALUE;
BigInteger sixtyFourBitLimit = new BigInteger("18446744073709551615");
BigInteger one = new BigInteger("1");
BigInteger two = new BigInteger("2");
BigInteger ten = new BigInteger("10");
BigInteger tenMillion = new BigInteger("10000000");
BigInteger count = new BigInteger("0");
BigInteger nonZeroDist = new BigInteger("0"); // INITIALIZES THE DISTRIBUTION INTEGER TO ZERO TO START WITH, VALUE WILL CHANGE


int my_rank = MPI.COMM_WORLD.Rank();
int my_size = MPI.COMM_WORLD.Size();

  // THIS IS PROPER DISTRIBUTION FOR NON ZERO PROCESSES (TO SPACE CHUNKS BY 10)


if(my_rank == 0){
	Scanner kb = new Scanner(System.in);
	
	// get number from user (use a LONG to accommodate a reasonably large number to start at)
	System.out.println("Welcome to Chris Newby's Prime Number Calculator!");
	System.out.print("Please enter a number to start at (must be under 9223372036854775807): ");
	userNumber = kb.nextLong();
	System.out.print("\n");
	
	
	// Checks for even number entry, if it is even it adds one to make it the next odd number
	if(userNumber % 2 == 0){
	userNumber += 1;
	}

	// broadcast this number to the other processes
	MPI.COMM_WORLD.Bcast(userNumber, 0, 1, MPI.LONG, 0);
	
	//zeroDist = ((iter -1) * 10);	// THIS IS THE PROPER WAY TO DISTRIBUTE FOR THE ZERO PROCESS (TO SPACE CHUNKS BY 10)
	System.out.println("In process...  ");
	
	kb.close();
	
}else{
	// NON ZERO RANK NUMBER
	MPI.COMM_WORLD.Bcast(userNumber, 0, 1, MPI.LONG, 0);
	
	BigInteger myRank = BigInteger.valueOf(my_rank);
	
	int i = 0; // just for the loop
	while(i < 5){
		count.add(one);  // USES BIG INTEGER FOR COUNT, ADDS ONE EVERY TIME THE LOOP RUNS
		
		nonZeroDist = ((count.subtract(one)).multiply(ten)).add(myRank.subtract(one)); // BASED ON (ITER - 1)*(BLOCK) + (RANK - 1)
		nonZeroDist = nonZeroDist.multiply(tenMillion);
	}	
}*/

//===================================================================================================
/*
 * final int INT_MAX = 2147483647; //final int INT_MAX = 1000;
 * 
 * ArrayList<Integer> primeList = new ArrayList<Integer>(); int userNumber = 0,
 * counter = 0; double sqRoot = 0;
 * 
 * System.out.print("Enter a number: "); userNumber = kb.nextInt();
 * System.out.println("The prime numbers greater than " + userNumber +
 * " up to the MAX of a standard integer are: ");
 * 
 * if(userNumber %2 == 0){ userNumber++; }
 * 
 * for(int a = userNumber; a < INT_MAX; a +=2){ boolean isPrime = true; sqRoot =
 * Math.sqrt(a); for(int b = 2; b < sqRoot; b++){ if(a % b == 0){ isPrime =
 * false; break; } } if(isPrime){ primeList.add(a); } }
 * 
 * 
 * for(int i = 0; i < primeList.size(); i++){
 * 
 * System.out.print(primeList.get(i) + " "); if(i %25 == 0){
 * System.out.print("\n"); } } //System.out.print(primeList);
 * System.out.println(""); System.out.println("End of Program.");
 */
