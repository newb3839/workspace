/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 24, 2016                                                       *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Heptagon is a class extending the shape class, defining the properties of a heptagon * 
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
public final class Heptagon extends Shape {

	// Fields
	double sideLength;
	
	// Constructor
	public Heptagon(double s, String c){
		sideLength = s;
		setColor(c);
	}
	
	// Define abstract methods from shape
	public double getArea(){
		double area = 0;
		area = (7/4) * (Math.pow(sideLength, 2)/Math.tan(Math.PI/7));
		return area;
	}
	public double getPerimeter(){
		double perimeter = 0;
		perimeter = 7 * sideLength;
		return perimeter;
	}
	public void printInfo(){
		System.out.println(
				"Heptagon: " +
				"\n Color:   " + getColor() +
				"\n SideLength: " + sideLength +
				"\n Area:  " + getArea() +
				"\n Perimeter:  " + getPerimeter() +
				"\n ");	
	}
	
	// Define methods for Heptagon
	public double getSideLength(){
		return sideLength;
	}
}
