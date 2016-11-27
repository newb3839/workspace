/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby September 7, 2016                                                     *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Main serves as the tester for the Shape class and the other drawing classes          * 
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

	public void paint(Graphics canvas) {
		Scanner kb = new Scanner(System.in);
		int numOfShapes = 0, shapeNum = 0;
		
		
		System.out.println("Please enter the number of shapes you would like to place on the canvas: ");
		numOfShapes = kb.nextInt();
		
		
		
		for(int i = 0; i <= numOfShapes - 1; i++){
			shapeNum = Tools.getShape();
			int count = i;
			if(shapeNum == 0){
				int x = Tools.GetRandom1000();
				int y = Tools.GetRandom1000();
				int radius = Tools.GetRandom300();
				Color color = Tools.getColor();
				Circle circle = new Circle(x, y, radius, color);
				circle.paint(canvas);
				//circle.printInfo();	
			}else if(shapeNum == 1){
				int x = Tools.GetRandom1000();
				int y = Tools.GetRandom1000();
				int sideLength = Tools.GetRandom300();
				Color color = Tools.getColor();
				Square square = new Square(x, y, sideLength, color);
				square.paint(canvas);
				//square.printInfo();
			}else if(shapeNum == 2){
				int x = Tools.GetRandom1000();
				int y = Tools.GetRandom1000();
				int base = Tools.GetRandom300();
				int height = Tools.GetRandom300();
				Color color = Tools.getColor();
				Rectangle rect = new Rectangle(x, y, base, height, color);
				rect.paint(canvas);
				//rect.printInfo();
			}else if(shapeNum == 3){
				int x = Tools.GetRandom1000();
				int y = Tools.GetRandom1000();
				int radX = Tools.GetRandom300();
				int radY = Tools.GetRandom300();
				Color color = Tools.getColor();
				Oval oval = new Oval(x, y, radX, radY, color);
				oval.paint(canvas);
				//oval.printInfo();
			}//else if(shape == 4){
				
			//}
			
			
		}
		
		
		kb.close();
	}
	
	

}
/* GENERAL FLOW OF THE PROGRAM
 * start
 * set limit of 1000 shapes per running of program
 * get random number
 * filter through random  number decision statement (create a series of ranges to fall into)
 * create a shape based on the decision
 * create a randomized number picker that sets the values for the position, size, num of points (polygon)
 * create a picker that sets the color of the shape, possibly a gradient color picker working off count
 * draw the shapes on the screen
 * ask if they want to run the program again, if so do a loop
 * base the next random number on the counter (add 1 to each count - add this to the random number too)
 * exit
 * run the program a few times on the screen cast to show that it shouldn't draw the same thing twice!
 */