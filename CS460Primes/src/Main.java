/************************************************************************
 *   CS 460 Prime Numbers 3-100 (to be translated to C or C++)          *
 *   I did input some extra lines of code for debugging purposes        *
 ***********************************************************************/
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 int count = 0;
		
		 System.out.println("This program will count the prime numbers between 3 and 100.\n");
		 for(int i = 3; i<=100; i++){
			 
			int counter = 0;
			//System.out.println("First loop I = " + i);
			 
			for(int num = i; num >= 1; num--){
				
				//System.out.println("Num = " + num);
				
				if(i % num == 0){
					//System.out.println("Yes");
					counter++;
				}
			}
			
			if(counter == 2) // only adds to overall count if there is only 2 divisible numbers (itself and 1)
				count++;
			
			//System.out.println("The current overall count is: " + count);
		 }
		 
		 System.out.println("The total count of prime numbers between 3 and 100 is: " + count);
	}

}
