/************************************************************************************
 *      Java Babylonian Algorithm (to convert to C or C++ )                         *
 * @author chris newby                                                              *
 *                                                                                  *
 ***********************************************************************************/
import java.util.Scanner;

public class JavaBabylonian {

	public static void main(String[] args) {
		
		
		double initialValue = 0, value = 0, guess = 0, sqRoot = 0, diffValue = 0; 
		int count = 0; // counter variable for iterations
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter a number to find an approximated square root of:  \n");
		initialValue = kb.nextDouble();
		value = initialValue; // sets initial value to guess value for iteration while keeping original
		guess = (value/2);  // sets guess value
		
		do{
			guess= (guess + sqRoot)/2;
			sqRoot = value / guess;		
			diffValue = guess - sqRoot;
			System.out.println("initial = " + initialValue);
			System.out.println("value = " + value);
			System.out.println("guess = " + guess);
			System.out.println("count = " + count); 
			System.out.println("\n");
			count++;
		}while(diffValue >= 0.01); // Loops until difference between previous and current guess is less than 1%
		
		System.out.printf("The square root of %.1f determined from the "
				+ "Babylonian algorithm is: %.2f \n", initialValue, sqRoot);
		System.out.println("Thank you for using this program, have a nice day!");
		kb.close();
	}
}

/*
while (count < 4){
			guess= (guess + sqRoot)/2.0;
			sqRoot = value / guess;		
			/*
			 *  THIS IS A FEW LINES OF CODE I WROTE TO HELP IN DEBUGGING IT, USED TO DISPLAY OUTPUTS THROUGH EACH ITERATION
			 * System.out.println("initial = " + initialValue);
			 * System.out.println("value = " + value);
			 * System.out.println("guess = " + guess);
			 * System.out.println("sqroot = " + sqRoot);
			 * System.out.println("count = " + count);
			 * System.out.println("");
			 * System.out.println("");
			 */
			


