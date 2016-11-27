/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 24, 2016                                                       *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Square is a class extending the Shape class, defining the properties of a square.    * 
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/

public final class Square extends Shape {

	// Fields
	private double sideLength;
	
	// Constructor
	public Square(double s, String c){
		sideLength = s;
		setColor(c);
	}
	
	// Define abstract methods from Shape
	public double getArea(){
		//return sideLength*sideLength;
		return Math.pow(sideLength, 2);
	}
	public double getPerimeter(){
		return 4 * sideLength;
	}
	public void printInfo(){
		System.out.println(
				"Square: " +
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
	
}
