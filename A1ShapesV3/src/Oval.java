/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby September 7, 2016                                                     *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Circle is a class extending the Shape class, defining the properties of a Circle.    * 
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
import java.awt.Color;
import java.awt.Graphics;

public final class Oval extends Shape{

	// Fields
	private double radX, radY;

	
	// Constructor
	public Oval(int x, int y, int radX, int radY, Color color){
		this.x = x;
		this.y = y;
		this.radX = radX;
		this.radY = radY;
		this.color = color;
	}
	
		
	// Define abstract methods from Shape
	public double getArea() {
		double area = 0;
		area = Math.PI * radX * radY;
		return area;
	}
	public double getPerimeter() {
		double circumference = 0;
		circumference = Math.PI * (3 * (radX + radY) - Math.sqrt(((3*radX) + radY) * (radX + (3*radY))));
		return circumference;
	}
	public void printInfo() {
		
		System.out.println(
				"Oval (Ellipse): " +
				"\n Coordinates: ("+ getX() +", "+ getY() +")" +
				"\n Color:   " + getColor() +
				"\n RadiusX: " + radX +
				"\n RadiusY: " + radY +
 				"\n Area:  " + getArea() +
				"\n Perimeter:  " + getPerimeter() +
				"\n ");	
	}

	
	// Define methods for Circle
	public double getRadX(){
		return radX;
	}
	public double getRadY(){
		return radY;
	}
	public void paint(Graphics canvas) {
		canvas.setColor(color);
		canvas.fillOval(x, y, (int)radX, (int)radY);
	}
}