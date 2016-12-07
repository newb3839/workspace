import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.math.BigDecimal;
import java.io.PrintWriter;


public class LoopTest {

	public static void main(String[] args) {
		
		int count = 0, my_rank = 5, my_size = 6;
		long userInput = 3;
		long a = 0, BLOCK_SIZE = 1000000, TEST_MAX = 10000;
		
		long nonZeroDist = 0;
		//long nonZeroDist = (count) * BLOCK_SIZE + (my_rank - 1);
		long incriment = ((my_size - 1) * BLOCK_SIZE);
		long LONG_MAX = Long.MAX_VALUE;
		
		System.out.println("UserInput: " + userInput);
		System.out.println("my_rank: " + my_rank);
		System.out.println("my_size: " + my_size);
		System.out.println("Nonzerodist: " + nonZeroDist);
		System.out.println("incriment: " + incriment);
		System.out.println("long_max: " + LONG_MAX);
		System.out.println("Double max: " + Double.MAX_VALUE);
		
		if(userInput == 0 || userInput % 2 == 0){
			userInput++;
		}
		
		//THIS SETS THE NON ZERO DISTRIBUTION FORMULA BASED ON RANK (1 HAS TO START COUNT AT ZERO, THE REST HAVE TO START
		//THE COUNTING FOR THEIR LOOPS AT 1 FOR THE MATH TO WORK OUT RIGHT
		if(my_rank == 0){
			System.out.println("I am process 0 - I don't do ANY WORK aside from getting the input.");
			System.exit(0);
		}else if(my_rank == 1){
			//count = 0;
			//nonZeroDist = ((my_rank) * BLOCK_SIZE) + 1;
			nonZeroDist = (count + (my_rank - 1)) * BLOCK_SIZE;
			//nonZeroDist = (count) * BLOCK_SIZE + (my_rank - 1);
			
		}else{
			//count = 0;
			nonZeroDist = ((my_rank - 1)) * BLOCK_SIZE;
			//nonZeroDist = (count - 1) * BLOCK_SIZE + (my_rank - 1);
		}
		
		System.out.println("Count: " + count + " NonZeroDist: " + nonZeroDist);
		nonZeroDist += count;
		
		// ADD THE DISTRIBUTION AMOUNT TO THE INPUT NUMBER FROM THE USER
		long startPrimes = userInput + nonZeroDist;
		
		System.out.println("StartPrimes: " + startPrimes + " UserInput: " + userInput + " NonZeroDist: " + nonZeroDist);
		
		//BEGIN LOOPS
		for(a = startPrimes; a < LONG_MAX; a += incriment){
			//System.out.println("(LOOP 1): " + a);
			
			boolean fileAttempt = true;
			String primesInBlock;
			StringBuilder sb = new StringBuilder();
	
			for(long b = a; b < (a + BLOCK_SIZE); b += 2){
				//System.out.println("    (LOOP 2): " + b);
				boolean isPrime = true;
				double sqRoot = 0;
				try{
					sqRoot = Math.sqrt(b);
				}catch(Exception ignore){
					System.out.println("Your square root exceeds the capacity of the double data type!.");
					System.exit(0);
				}
				//System.out.println("SQUARE ROOT: "  + sqRoot);
				for(long c = 2; c <= sqRoot; c++){
					//System.out.println("        (LOOP 3): " + c);
					if(b % c == 0){
						isPrime = false;
						break;
					}
				}
				if(isPrime){
					sb.append(b + " ");
				}
			}
			primesInBlock = sb.toString();
			System.out.println(primesInBlock);
			
			// Writes the string containing the primes in the block to file ONE TIME per block to save access time
			try{
				// create the file for this block and write primes in block to this file
	        	String fileName = ("Primes " + a + " - " + (a + BLOCK_SIZE) + ".txt");
				File primeFile = new File("C:\\Users\\chris\\Desktop\\PRIMES\\" + fileName);
				fileAttempt = primeFile.createNewFile();
				FileWriter fw = new FileWriter(primeFile, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw);
			    out.write(primesInBlock);
			    out.close();
			}catch(Exception ignore){
				System.out.println("There was a problem creating the file." );
				System.exit(0);
			}
		}
	}
}