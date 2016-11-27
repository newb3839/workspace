/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 29, 2016                                                       *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Main serves as the tester for the Shape, Square, and other shape classes.            * 
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;
import java.util.Scanner;

public class Main extends JApplet{
	
	// String for user input
	
	

	
	public void paint(Graphics canvas){
		Scanner kb = new Scanner(System.in);
		String answer;
		
		// Random color experiments
		Color myRandomColor = new Color(30,60,90); // 30-60-90... cause why not... works for triangles!
		Color myRandomColor1 = new Color(50,100,150);
		Color myRandomColor2 = new Color(255,150,120);
		
		Square s1 = new Square(25,25,36, Color.RED);
		Square s2 = new Square(30,30,10, Color.BLACK);
		Square s3 = new Square(0,50,100, myRandomColor);
		
		Circle c1 = new Circle(100,100, 100, Color.YELLOW);
		Circle c2 = new Circle(175, 175, 200, Color.CYAN);
		Circle c3 = new Circle(300, 300, 300, Color.GREEN);
		
		Rectangle r1 = new Rectangle(150, 150, 75, 175, Color.ORANGE);
		Rectangle r2 = new Rectangle(225, 150, 300, 50, Color.GRAY);
		Rectangle r3 = new Rectangle(300, 150, 45, 400, Color.BLUE);
		
		
		

			// Squares
			s1.paint(canvas);
			s2.paint(canvas);
			s3.paint(canvas);
			
			s1.printInfo();
			s2.printInfo();
			s3.printInfo();
			
			// Circles
			c1.paint(canvas);
			c2.paint(canvas);
			c3.paint(canvas);
			
			c1.printInfo();
			c2.printInfo();
			c3.printInfo();
			
			// Rectangles
			r1.paint(canvas);
			r2.paint(canvas);
			r3.paint(canvas);
			
			r1.printInfo();
			r2.printInfo();
			r3.printInfo();
			

		
	}
}
