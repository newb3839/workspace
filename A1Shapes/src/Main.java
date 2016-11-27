/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 24, 2016                                                       *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Main serves as the tester for the Shape, Square, and other shape classes.            * 
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		String answer = null;
		Scanner kb = new Scanner(System.in);
		
		// Introduction message
		System.out.println("Welcome to the A1Shapes inheritance project! \n");
		System.out.println("We will be demonstrating inheritance through the use of several shapes, 2 of each. \n" );
		
		
		
		do{
			// INSTANTIATE DIFFERENT SHAPES **********************************************************
			
			// Instantiate two squares
			Square s1 = new Square(2.5, "blue");
			Square s2 = new Square(-100, "green");
			
			// Instantiate two circles
			Circle c1 = new Circle(50, "red");
			Circle c2 = new Circle(150, "yellow");
			
			// Instantiate two Triangles
			Triangle t1 = new Triangle(10, 10, "turquoise");
			Triangle t2 = new Triangle(35, 70, "clear");
			
			// Instantiate two Spheres
			Sphere sp1 = new Sphere(25, "lavendar");
			Sphere sp2 = new Sphere(125, "teal");
			
			// Instantiate two Hexagons
			Hexagon h1 = new Hexagon(14, "neon pink");
			Hexagon h2 = new Hexagon(150, "flat black");
			
			// Instantiate two Heptagons
			Heptagon hp1 = new Heptagon(34, "rainbow");
			Heptagon hp2 = new Heptagon(136, "harlequin");
			
			
		// OUTPUT THE SHAPES **********************************************************************
			
			// Output square
			s1.printInfo();
			s2.printInfo();
			
			// Output circle
			c1.printInfo();
			c2.printInfo();
		
			// Output triangle
			t1.printInfo();
			t2.printInfo();
			
			// Output Sphere
			sp1.printInfo();
			sp2.printInfo();
			
			// Output Hexagon
			h1.printInfo();
			h2.printInfo();
			
			// Output Heptagon
			hp1.printInfo();
			hp2.printInfo();
			
			System.out.println("Would you like to run the program again? (y/n) ");
			
			answer = kb.nextLine();
			
		}while(answer.equalsIgnoreCase("y"));
		
		System.out.println("Thank you for using this program.  Have a nice day :) ");
		kb.close();
	}

}
