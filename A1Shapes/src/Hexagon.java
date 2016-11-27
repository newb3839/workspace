/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 24, 2016                                                       *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Hexagon is a class extending the shape class, defining the propertiers of a hexagon  * 
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
public final class Hexagon extends Shape {

	
	// Fields
	double sideLength;
	
	// Constructor
	public Hexagon(double l, String c){
		sideLength = l;
		setColor(c);
	}
	
	// Define abstract methods from shape
	public double getArea(){
		double area = 0;
		area = 3 * (Math.sqrt(3)/2) * Math.pow(sideLength, 2);
		return area;
	}
	public double getPerimeter(){
		double perimeter = 0;
		perimeter = 6 * sideLength;
		return perimeter;
	}
	public void printInfo(){
		System.out.println(
				"Hexagon:   " +
				"\n Color:   " + getColor() +
				"\n sideLength:  " + sideLength +
				"\n Area:  " + getArea() +
				"\n Perimeter:  " + getPerimeter() +
				"\n ");	
	}
	
	// Define methods for a Hexagon
	public double getSideLength(){
		return sideLength;
	}
	
}
