/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby September 7, 2016                                                     *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Triangle is a class extending the Shape class, defining the properties of a Triangle * 
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
import java.awt.Color;
import java.awt.Graphics;

public final class Triangle extends Shape {

	// Fields
	private double base, height;
	
	
	// Constructor
	public Triangle(int x, int y, double base, double height, Color color){
		this.x = x;
		this.y = y;
		this.base = base;
		this.height = height;
		this.color = color;
	}
	
	
	// Define abstract methods from Shape
	public double getArea() {
		double area = (base * height) / 2;
		return area;
	}

	
	public double getPerimeter() {
	  
		return 0;
	}


	public void printInfo() {
		
		
	}


	public void paint(Graphics g) {
	
		
	}
	
	// Define methods for Triangle

}
