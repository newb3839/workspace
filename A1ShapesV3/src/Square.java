/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby September 7, 2016                                                     *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Square is a class extending the Shape class, defining the properties of a square.    * 
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
import java.awt.Color;
import java.awt.Graphics;

public final class Square extends Shape{
	
	// Fields
	private double sideLength;
	
	// Constructor
	public Square(int x, int y, double sideLength, Color color){
		this.x = x;
		this.y = y;
		this.sideLength = sideLength;
		this.color = color;
		
	}
	
	// Define abstract methods from Shape
	public double getArea() {
		
		return Math.pow(sideLength, 2);
	}

	public double getPerimeter() {
		
		return 4 * sideLength;
	}

	public void printInfo() {
		
		System.out.println(
				"Square: " +
				"\n Coordinates: ("+ getX() +", "+ getY() +")" +
				"\n Color:   " + getColor() +
				"\n SideLength: " + sideLength +
				"\n Area:  " + getArea() +
				"\n Perimeter:  " + getPerimeter() +
				"\n ");	
	}

	
	// Define methods for Square
	public double getSideLength(){
		return sideLength;
	}
	public void paint(Graphics canvas) {
		canvas.setColor(color);
		canvas.fillRect(x, y, (int) (sideLength), (int) (sideLength));
		
	}

}
