import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class SimplePrimeFinder {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		final int INT_MAX = 2147483647;
		//final int INT_MAX = 1000;
		
		//ArrayList<Integer> primeList = new ArrayList<Integer>();
		int userNumber = 0, counter = 0;
		double sqRoot = 0;
		
		System.out.print("Enter a number: ");
		userNumber = kb.nextInt();
		System.out.println("The prime numbers greater than " + userNumber + " up to the MAX of a standard integer are: ");
		
		if(userNumber %2 == 0){
			userNumber++;
		}
		
		for(int a = userNumber; a < INT_MAX; a +=2){
			boolean isPrime = true;
			sqRoot = Math.sqrt(a);
			for(int b = 2; b < sqRoot; b++){
				if(a % b == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				//primeList.add(a);
				System.out.print(a + " ");
				counter++;
				if(counter % 10 == 0){
					System.out.print("\n");
				}
			}
		}
	
	
		/*for(int i = 0; i < primeList.size(); i++){
			
			System.out.print(primeList.get(i) + " ");
			if(i %25 == 0){
				System.out.print("\n");
			}
		}*/
		//System.out.print(primeList);
		System.out.println("");
		System.out.println("End of Program.");
		kb.close();
	}

}

/*Scanner kb = new Scanner(System.in);
final int INT_MAX = 2147483647;
//final int INT_MAX = 1000;

ArrayList<Integer> primeList = new ArrayList<Integer>();
int userNumber = 0, counter = 0;
double sqRoot = 0;

System.out.print("Enter a number: ");
userNumber = kb.nextInt();
System.out.println("The prime numbers greater than " + userNumber + " up to the MAX of a standard integer are: ");

if(userNumber %2 == 0){
	userNumber++;
}

for(int a = userNumber; a < INT_MAX; a +=2){
	boolean isPrime = true;
	sqRoot = Math.sqrt(a);
	for(int b = 2; b < sqRoot; b++){
		if(a % b == 0){
			isPrime = false;
			break;
		}
	}
	if(isPrime){
		primeList.add(a);
	}
}


for(int i = 0; i < primeList.size(); i++){
	
	System.out.print(primeList.get(i) + " ");
	if(i %25 == 0){
		System.out.print("\n");
	}
}
//System.out.print(primeList);
System.out.println("");
System.out.println("End of Program.");
kb.close();*/


