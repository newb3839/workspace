/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 24, 2016                                                       *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Sphere is a class extending the Shape class, defining the properties of a sphere.    * 
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
public final class Sphere extends Shape {

	
	// Fields
	public double radius;
	
	// Constructor
	public Sphere(double r, String c){
		radius = r;
		setColor(c);
	}
	
	// Define abstract methods from Shape
	public double getArea(){
		double volume = 0;
		volume = ((4/3) * Math.PI * (Math.pow(radius, 2)));
		return volume;
	}
	public double getPerimeter(){
		double circumference = 0;
		circumference = 2 * Math.PI * radius;
		return circumference;
	}
	public void printInfo(){
		System.out.println(
				"Sphere: " +
				"\n Color:   " + getColor() +
				"\n Radius: " + radius +
				"\n Volume:  " + getArea() +
				"\n Perimeter:  " + getPerimeter() +
				"\n ");	
	}
	
	// Define methods for Sphere
	public double getRadius(){
		return radius;
	}
	
}
