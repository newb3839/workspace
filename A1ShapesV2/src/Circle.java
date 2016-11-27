/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 29, 2016                                                       *
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

public final class Circle extends Shape{

	// Fields
	private double radius;

	
	// Constructor
	public Circle(int x, int y, double radius, Color color){
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}
	
		
	// Define abstract methods from Shape
	public double getArea() {
		double area = 0;
		area = Math.PI * Math.pow(radius, 2);
		return area;
	}
	public double getPerimeter() {
		double circumference = 0;
		circumference = 2 * Math.PI * radius;
		return circumference;
	}
	public void printInfo() {
		
		System.out.println(
				"Circle: " +
				"\n Coordinates: ("+ getX() +", "+ getY() +")" +
				"\n Color:   " + getColor() +
				"\n Radius: " + radius +
				"\n Area:  " + getArea() +
				"\n Perimeter:  " + getPerimeter() +
				"\n ");	
	}

	
	// Define methods for Circle
	public double getRadius(){
		return radius;
	}
	public void paint(Graphics canvas) {
		canvas.setColor(color);
		canvas.fillOval(x, y, (int) radius, (int) radius);
		
	}
}
