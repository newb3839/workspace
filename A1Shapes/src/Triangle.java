/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 24, 2016                                                       *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Triangle is a class extending the Shape class, defining the properties of a triangle.* 
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
public final class Triangle extends Shape{
	
	// Fields
	public double base;
	public double height;
	
	// Constructor
	public Triangle(double b, double h, String c){
		base = b;
		height = h;
		setColor(c);
	}
	
	// Define abstract methods from Shape
	public double getArea(){ 
		double area = 0;
		area = (base * height)/2;
		return area;
	}
	public double getPerimeter(){
		double hypotenuse = 0, perimeter = 0;
		hypotenuse = Math.sqrt((Math.pow(base, 2) + Math.pow(height, 2)));
		perimeter = hypotenuse + base + height;
		return perimeter;
	}
	public void printInfo(){
		System.out.println(
				"Triangle: (Right Triangle Only)  " +
				"\n Color:   " + getColor() +
				"\n Base: " + base +
				"\n Height: " + height +
				"\n Area:  " + getArea() +
				"\n Perimeter:  " + getPerimeter() +
				"\n ");	
	}
	
	// Define methods for Triangle
	public double getBase() {
		return base;
	}
	public double getHeight(){
		return height;
	}
}
