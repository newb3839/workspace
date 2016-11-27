/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby August 24, 2016                                                       *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Shape is an abstract class that serves as the inherited base for other shape         * 
 * classes, such as square, circle or pentagon.                                                      *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/

public abstract class Shape {

	// Fields
	protected String color;
	
	// Abstract Methods
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract void printInfo();
	
	//  Get and Set Methods
	public String getColor(){
		return color;
	}
	public void setColor(String c){
		color = c;
	}
}
