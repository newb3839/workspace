/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 24, 2016                                                       *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Circle is a class extending the Shape class, defining the properties of a circle.    * 
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/

public final class Circle extends Shape {

	// Fields
	public double radius;
	
	// Constructor
	public Circle (double r, String c){
		radius = r;
		setColor(c);
	}
	
	// Define abstract methods from Shape
	public double getArea(){
		double area = 0;
		area = Math.pow((Math.PI * radius), 2);
		return area;
	}
	public double getPerimeter(){
		double circumference = 0;
		circumference = 2 * Math.PI * radius;
		return circumference;
	}
	public void printInfo(){
		System.out.println(
				"Circle: " +
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
}
