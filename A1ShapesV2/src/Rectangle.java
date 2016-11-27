
/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 29, 2016                                                       *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Rectangle is a class extending the Shape class, defining the properties of a         * 
 *              rectangle.                                                                           *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
import java.awt.Color;
import java.awt.Graphics;

public final class Rectangle extends Shape{

	// Fields
	private double base, height;
	
	// Constructor
	public Rectangle(int x, int y, double base, double height, Color color){
		this.x = x;
		this.y = y;
		this.base = base;
		this.height = height;
		this.color = color;
	}
	
	// Define abstract methods from Shape
	public double getArea() {
		double area = 0;
		area = base * height;
		return area;
	}

	public double getPerimeter() {
		double perimeter = 0;
		perimeter = (2 * base) + (2 * height);
		return perimeter;
	}

	public void printInfo() {
		
		System.out.println(
				"Rectangle: " +
				"\n Coordinates: ("+ getX() +", "+ getY() +")" +
				"\n Color:   " + getColor() +
				"\n Base: " + base +
				"\n Height: " + height +
				"\n Area:  " + getArea() +
				"\n Perimeter:  " + getPerimeter() +
				"\n ");	
	}
	
	// Define methods for Rectangle
	public double getBase(){
		return base;
	}
	public double getHeight(){
		return height;
	}
	public void paint(Graphics canvas) {
		canvas.setColor(color);
		canvas.fillRect(x, y, (int) (base), (int) (height));
	}

}
