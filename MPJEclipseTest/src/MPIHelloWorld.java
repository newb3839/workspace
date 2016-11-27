
import mpi.*;
import java.util.Random;
import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;

class MPIHelloWorld
{
	static public void main(String[] args) throws Exception {
		final long long2to64th = Long.parseUnsignedLong("18446744073709551615");
		
		int my_rank = MPI.COMM_WORLD.Rank();
        int my_size = MPI.COMM_WORLD.Size();
        
        long userNumber = 5501;
        
        if(userNumber % 2 == 0){
        	userNumber +=1;
        }
        
        if(my_rank == 0){
        	
        	// get number from user
        	
        	// broadcast this number to the other processes
        	int distribution = ((my_rank -1) * 4 + (my_size));
        	
        	for(int i = 0; i < long2to64th; i += 2){
        		
        	}
        	
        	
        	
        	
        }else if(my_rank == 1){
        	
        	
        	
        	
        }else if(my_rank == 2){
        	
        	
        	
        }else if(my_rank == 3){
        	
        	
        	
        }else if(my_rank == 4){
        	
        	
        	
        }
	}
}	

///////////////////////////////////////////////COMPLETE PI PROJECT//////////////////////////////////////////
/*public static final double PI = 3.141592653589793238462643;
public static final int NUM_THROWS = 1000000000;
int[] intervals = new int[1];
double[] mypi = new double[1];
double[] pi = new double[1];
long numOfDarts;
double h, x;
double sum = 0.0;
double startTime = 0, stopTime = 0, totalTime = 0;

try{
	
	MPI.Init(args);
    int my_rank = MPI.COMM_WORLD.Rank();
    int my_size = MPI.COMM_WORLD.Size();
    intervals[0] = NUM_THROWS;
    
    if(my_rank == 0){
    	startTime = MPI.Wtime();
    	 System.out.println("Pi calculation with Monte Carlo method");
    	 
         System.out.println("Number of darts: " + NUM_THROWS);
         System.out.println("Number of processes: " + my_size);
         
    	 MPI.COMM_WORLD.Bcast(intervals, 0, 1, MPI.INT, 0);
    	 MPI.COMM_WORLD.Reduce(mypi, 0, pi, 0, 1, MPI.DOUBLE, MPI.SUM, 0);
    	 
    	 stopTime = MPI.Wtime();
    	 totalTime = stopTime - startTime;
    	 
    	 System.out.format("Pi is approximately %.16f\n",pi[0]);
    	 System.out.println("The total time to complete this process is: " + totalTime + " seconds.");
          //System.out.format("Error is %.16f\n",pi[0]-MonteCarloPi.PI);
    }else{
    	
    	MPI.COMM_WORLD.Bcast(intervals, 0, 1, MPI.INT, 0);

    	 numOfDarts = intervals[0];
         h   = 1.0 / (double) intervals[0];
         sum = 0.0;
         for (int i = my_rank + 1; i <= numOfDarts; i += my_size){
           x = h * ((double)i - 0.5);
           sum += (4.0 / (1.0 + x*x));
         }
         mypi[0] = (h * sum);

    	
    	MPI.COMM_WORLD.Reduce(mypi, 0, pi, 0, 1, MPI.DOUBLE, MPI.SUM, 0);
    }      
	MPI.Finalize();
}catch(MPIException e){
	System.out.println("Something went wrong, the error message says: " + e);
	System.exit(0);;
}  */

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
	// ===============================THIS IS MY WORKING VERSION BELOW THIS LINE ===============================
/*	public static final double PI = 3.141592653589793238462643;
	public static final int NUM_THROWS = 1000000;

static public void main(String[] args) throws Exception {
	int[] intervals = new int[1];
    double[] mypi = new double[1];
    double[] pi = new double[1];
    long numOfDarts;
    double h,x;
    double sum=0.0;

    try
    {
      MPI.Init(args);
      int my_rank = MPI.COMM_WORLD.Rank();
      int my_size = MPI.COMM_WORLD.Size();
      intervals[0]=NUM_THROWS;

      if(my_rank == 0)
      {
        System.out.println("Pi calculation with Monte Carlo method");
        System.out.println("Number of darts: " + NUM_THROWS);
        System.out.println("Number of processes: " + my_size);
      }

      MPI.COMM_WORLD.Bcast(intervals, 0, 1, MPI.INT, 0);

      numOfDarts = intervals[0];
      h   = 1.0 / (double) intervals[0];
      sum = 0.0;

      double startTime = MPI.Wtime();

      for (int i = my_rank + 1; i <= numOfDarts; i += my_size){
    
        x = h * ((double)i - 0.5);
        sum += (4.0 / (1.0 + x*x));
      }
      mypi[0] = (h * sum);
   

      MPI.COMM_WORLD.Reduce(mypi, 0, pi, 0, 1, MPI.DOUBLE, MPI.SUM, 0);

            if(my_rank == 0){
            
             
              System.out.format("Pi is approximately %.16f\n",pi[0]);
              //System.out.format("Error is %.16f\n",pi[0]-MonteCarloPi.PI);
            }
    }
    catch (MPIException e)
    {
      e.printStackTrace();
    }
    MPI.Finalize();
}*/
	
	//================================WORKING VERSION ABOVE THIS LINE ==========================================
	
	
//================================
/*	    int numOfThrows = 100;
int numOfHits = 0, numThrown = 0;
int totalThrows = 0, totalHits = 0, offset = 0;
double distance_squared = 0,  x = 0, y = 0, piApprox = 0;
double pi_estimate = 0;*/
//================================	
	
	
/*	public static int generatRandomPositiveNegitiveValue(int max , int min) {
int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
    return ii;
}*/
	
/*numOfDarts = intervals[0];
int count = 0;
for (int i = 0; i < numOfDarts; i++){
	
	 x = random(-1,1);
	 y = random(-1,1);
	 //System.out.println("x = " +x);
	 //System.out.println("y = " +y);
	 distance_squared = (Math.pow(x, 2) + Math.pow(y, 2));
	 //System.out.println("DistanceSquared: " + distance_squared);
	 if(distance_squared <=1){
		 numOfHits++;
	 }
	 count++;
	 //System.out.println("Count: " + count);
	// System.out.println("NumOfHits: " + numOfHits);
}
pi_estimate = ((4 * numOfHits)/(numOfThrows));

mypi[0] = (pi_estimate);*/

	
	
	
	
	
	
	
	
//		 MPI.Init(args);
//		 
//		 int me = MPI.COMM_WORLD.Rank();
//		 int meSize = MPI.COMM_WORLD.Size();
//		 
//		 int rank = 0;
//		 int numOfThrows = 1000000;
//		 int numOfHits = 0, numThrown = 0;
//		 int totalThrows = 0, totalHits = 0, offset = 0;
//		 double distance_squared = 0,  x = 0, y = 0, piApprox = 0;
//		 
//		 try{
//			 
//			 rank = MPI.COMM_WORLD.Rank();
//			 
//			 if(me == 0){
//				MPI.COMM_WORLD.Bcast(numOfThrows, totalHits, 1, MPI.INT, 0);
//				MPI.COMM_WORLD.Reduce(numOfHits, totalHits, in, 0, j, MPI.INT, MPI.SUM, 0);
//			 }else{
//				 Random ran = new Random();
//				 for(int i = 0; i < numOfThrows; i++){
//					 x = generatRandomPositiveNegitiveValue(-1,1);
//					 y = generatRandomPositiveNegitiveValue(-1,1);
//					 distance_squared = (Math.pow(x, 2) + Math.pow(y, 2));
//					 if(distance_squared <=1){
//						 numOfHits++;
//					 }
//					 
//				 }
//				 MPI.COMM_WORLD.Reduce(mypi, 0, pi, 0, 1, MPI.DOUBLE, MPI.SUM, 0);
//				 
//			 }
//		 }catch(Exception e){
//			 System.out.println("Something went wrong: " + e.getMessage());
//		 }
//		 MPI.Finalize();
//	}
//	
//	
//	
//	public static int generatRandomPositiveNegitiveValue(int max , int min) {
//	    int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
//	    return ii;
//	}


/*static public void main(String[] args) throws Exception {
	    try {
	    	MPIHelloWorld c = new MPIHelloWorld(args);
	    }
	    catch (Exception e) {
	    }
	  }

	  public MPIHelloWorld() {
	  }

	  public MPIHelloWorld(String[] args) throws Exception {
	    int tasks, rank, i;
	    char buf[] = new char[10];
	    double time;
	    double stopTime = 0.0;
	    double startTime = 0.0;
	    long startNano = 0, stopNano = 0, totalNano = 0;
	    Status status;

	    MPI.Init(args);
	    rank = MPI.COMM_WORLD.Rank();
	    MPI.COMM_WORLD.Barrier();
	    startTime = MPI.Wtime();
	    for( i=0;i<100000;i++)
	    {
	    	startNano = System.nanoTime();
		    if (rank == 0) {
		      // for(i=0;i<1000000;i++) ;
		      // Thread.currentThread().sleep(5000);
		      MPI.COMM_WORLD.Rsend(buf, 0, 10, MPI.CHAR, 1, 1);
		      MPI.COMM_WORLD.Recv(buf, 0, 10, MPI.CHAR, 1, 1);
		    } else if (rank == 1) {
		      MPI.COMM_WORLD.Recv(buf, 0, 10, MPI.CHAR, 0, 1);
		      MPI.COMM_WORLD.Rsend(buf, 0, 10, MPI.CHAR, 0, 1);
		    }
		    stopNano = System.nanoTime();
		    totalNano += stopNano - startNano;
	    }
		    stopTime = MPI.Wtime();
		    MPI.COMM_WORLD.Barrier();
	   // if (me == 1)
	      System.out.println("Your average time for 100000 messages (Wtime) is: " + (stopTime - startTime) / 100000);
	      System.out.println("The nanoSeconds average of that same number of messages is using nanoTime is: " + (totalNano / 100000) + " nano seconds.");
	    
	    MPI.Finalize();
	  }
 * 
 * */
