/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 29, 2016                                                       *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Shape is an abstract class that serves as the inherited base for other shape         * 
 * classes, such as square, circle or pentagon.                                                      *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	
	//Fields
	protected Color color; // color of the shape
	protected int x, y;  // coordinates of shape
	
	// Abstract methods
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract void printInfo();
	public abstract void paint(Graphics g);
	
	// Get and Set Methods
	public Color getColor(){
		return color;
	}
	public void setColor(Color c){
		color = c;
	}
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
