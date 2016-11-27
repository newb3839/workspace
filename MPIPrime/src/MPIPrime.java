import mpi.MPI;

//import mpi.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.ArrayList;

public class MPIPrime {

	public static void main(String[] args) {
		
		
		
		int my_rank = MPI.COMM_WORLD.Rank();
        int my_size = MPI.COMM_WORLD.Size();
        
        int N = my_size - 1;
        int N2 = N * 2;
        int myNum = 0, prime = 0, divCount = 0;
        double sqRoot = 0;
        int success = 1, unsuccesful = 0;
        boolean isDivisible = false;
        String arrayName = null;
        
        
        if(my_rank == 0){
        	Scanner kb = new Scanner(System.in);
        	
        	System.out.println("Please enter a number: ");
        	System.out.print("===> ");
        	myNum = kb.nextInt();
        	
        	
        	MPI.COMM_WORLD.Bcast(myNum, 0, 1, MPI.INT, 0);
        	
        	
        	
        	System.out.print(prime);
        	System.out.println("End of Program.");
        	kb.close();
        	
        }else if(my_rank == 1){
        	
        	 MPI.COMM_WORLD.Bcast(myNum, 0, 1, MPI.INT, 0);
        	 ArrayList myPrimeList1 = new ArrayList();
        	 sqRoot = Math.sqrt(myNum);
        	 for (int i = 3; i < sqRoot; i += N2){
        		 if(myNum % i == 0){
        			 divCount++;
        			 myPrimeList1.add(i);
        		 }
        		 
        		 
        	 }
        	 
        	
        }else if(my_rank == 2){
        	 MPI.COMM_WORLD.Bcast(myNum, 0, 1, MPI.INT, 0);
        	 ArrayList myPrimeList2 = new ArrayList();
        	 sqRoot = Math.sqrt(myNum);
        	 for (int i = 5; i < sqRoot; i += N2){
        		 if(myNum % i == 0){
        			 divCount++;
        			 myPrimeList2.add(i);
        		 }
        		 
        	 }
        	 
        	 
        	
        }else if(my_rank == 3){
        	 MPI.COMM_WORLD.Bcast(myNum, 0, 1, MPI.INT, 0);
        	 ArrayList myPrimeList3 = new ArrayList();
        	 sqRoot = Math.sqrt(myNum);
        	 for (int i = 7; i < sqRoot; i += N2){
        		 if(myNum % i == 0){
        			 divCount++;
        			 myPrimeList3.add(i);
        		 }
        		 
        	 }
        	 
        	 
        }else if(my_rank == 4){
        	 MPI.COMM_WORLD.Bcast(myNum, 0, 1, MPI.INT, 0);
        	 ArrayList myPrimeList4 = new ArrayList();
        	 sqRoot = Math.sqrt(myNum);
        	 for (int i = 9; i < sqRoot; i += N2){
        		 if(myNum % i == 0){
        			 divCount++;
        			 myPrimeList4.add(i);
        		 }
        		 
        	 }
        	 
        	 
        }else if(my_rank == 5){
        	 MPI.COMM_WORLD.Bcast(myNum, 0, 1, MPI.INT, 0);
        	 ArrayList myPrimeList5 = new ArrayList();
        	 sqRoot = Math.sqrt(myNum);
        	 for (int i = 11; i < sqRoot; i += N2){
        		 if(myNum % i == 0){
        			 divCount++;
        			 myPrimeList5.add(i);
        		 }
        	 } 
        }
	}
}
