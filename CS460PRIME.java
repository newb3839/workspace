import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.Scanner;
import mpi.*;

public class CS460PRIME {
	
	public static void main(String[] args) throws MPIException {
		int my_rank = 0, my_size =0;
		
		MPI.Init(args);
		
		try{
			
			my_rank = MPI.COMM_WORLD.getRank();
			my_size = MPI.COMM_WORLD.getSize();
			
		}catch(MPIException i){
			
			System.out.println("There is a problem with the rank/size.");
			i.printStackTrace();
			System.exit(0);
		}
		
		
		long a = 0, BLOCK_SIZE = 1000000,  count = 0;
		long nonZeroDist = 0;
		long incriment = ((my_size - 1) * BLOCK_SIZE);
		long LONG_MAX = Long.MAX_VALUE;
		long userInput = 0;
		//Object obj = null;
		long[] buffer = new long[0];
		
		// BEGIN DIVIDING UP WORK
		try{
			
			if(my_rank == 0){
				Scanner kb = new Scanner(System.in);
				
				System.out.println("Welcome to Newby's prime calculator! ");
				System.out.print("Please enter a number to start at: ");
				userInput = kb.nextLong();
				
				// if user enters an even number it increments it by one before being broadcast as the starting point
				if(userInput == 0 || userInput % 2 == 0){
					userInput++;
				}
				
				buffer[0] = userInput;
				//obj = userInput;
				// Broadcast the user input to the worker processes
				MPI.COMM_WORLD.bcast(buffer, 1, MPI.LONG, 0);
				
				System.out.println("Your prime numbers are being calculated.  Thank you!");
				
				kb.close();
				
			}else if(my_rank == 1){
				
				MPI.COMM_WORLD.bcast(buffer, 1, MPI.LONG, 0);
				//cast back to a long from object
				//userInput =  ((Long) obj).longValue();
				userInput = buffer[0];
				
				nonZeroDist = (count + (my_rank - 1)) * BLOCK_SIZE;
				
				nonZeroDist += count;
				
				// ADD THE DISTRIBUTION AMOUNT TO THE INPUT NUMBER FROM THE USER
				long startPrimes = userInput + nonZeroDist;
				
				//BEGIN LOOPS
				for(a = startPrimes; a < LONG_MAX; a += incriment){
					//System.out.println("(LOOP 1): " + a);
					
					boolean fileAttempt = true;
					String primesInBlock;
					StringBuilder sb = new StringBuilder();
			
					for(long b = a; b < (a + BLOCK_SIZE); b += 2){
						//System.out.println("    (LOOP 2): " + b);
						boolean isPrime = true, exceedsDouble = false;
						double sqRoot = 0;
						
						try{
							sqRoot = Math.sqrt(b);
							
						}catch(Exception ignore){
							System.out.println("Your square root exceeds the capacity of the double data type!");
							exceedsDouble = true;
						}
						
						for(long c = 2; c <= sqRoot; c++){
							
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
					
					// Writes the string containing the primes in the block to file ONE TIME per block to save access time
					try{
						String fileName = ("Primes " + a + " to " + (a + BLOCK_SIZE) + ".txt");
						//File primeFile = new File("C:\\Users\\chris\\Desktop\\PRIMES\\" + fileName);
						File primeFile = new File("/home/cnewby/PRIMES/" + fileName);
						fileAttempt = primeFile.createNewFile();
						Writer out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(primeFile), "UTF-16"));
					    out.write(primesInBlock);
					    out.close();
					}catch(IOException ignore){
						System.out.println("There was a problem creating the file." );
						System.exit(0);
					}
				}
				
				
			}else{
				nonZeroDist += count;
				
				MPI.COMM_WORLD.bcast(buffer, 1, MPI.LONG, 0);
				//cast back to a long from object
				//userInput =  ((Long) obj).longValue();
				userInput = buffer[0];
				
				nonZeroDist = ((my_rank - 1)) * BLOCK_SIZE;
				
				nonZeroDist += count;
				
				// add the input amount from the user to the non zero distribution
				long startPrimes = userInput + nonZeroDist;
				
				for(a = startPrimes; a < LONG_MAX; a += incriment){
					//System.out.println("(LOOP 1): " + a);
					
					boolean fileAttempt = true;
					String primesInBlock;
					StringBuilder sb = new StringBuilder(); // string builder is used to store the found primes until the end of the block
			
					for(long b = a; b < (a + BLOCK_SIZE); b += 2){
						
						boolean isPrime = true;
						double sqRoot = 0;

						try{
							sqRoot = Math.sqrt(b);
						}catch(Exception ignore){
							System.out.println("Your square root exceeds the capacity of the double data type!");
							System.exit(0);
						}
						
						for(long c = 2; c <= sqRoot; c++){
							if(b % c == 0){
								isPrime = false;
								break;
							}
						}
						
						if(isPrime){
							sb.append(b + " ");
						}
					}
					
					// string that contains all the primes found in this block
					primesInBlock = sb.toString();
					
					// Writes the string containing the primes in the block to file ONE TIME per block to save access time
					try{
						String fileName = ("Primes " + a + " to " + (a + BLOCK_SIZE) + ".txt");
						//File primeFile = new File("C:\\Users\\chris\\Desktop\\PRIMES\\" + fileName);
						File primeFile = new File("/home/cnewby/PRIMES/" + fileName);
						fileAttempt = primeFile.createNewFile();
						Writer out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(primeFile), "UTF-16"));
					    out.write(primesInBlock);
					    out.close();
					}catch(IOException ignore){
						System.out.println("There was a problem creating the file." );
						System.exit(0);
					}
				}
			}
		}catch(MPIException e){
			System.out.println("There was a problem with MPI. ");
			System.exit(0);
		}
		MPI.Finalize();
	}
}
//handles the change from double to a big int cast to a long (loses precision but should work)
//if(exceedsDouble){
//	BigDecimal bdRoot = new BigDecimal(Math.sqrt(b));
//	//sqRoot = bdRoot.longValue();
//}

