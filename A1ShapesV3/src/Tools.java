/***************************************************************************************************** 
 *                                                                                                   *
 * Programmed by:  Chris Newby September 7, 2016                                                     *
 * Class: CS 200                                                                                     *
 * Instructor:  Dean Zeller                                                                          *
 *                                                                                                   * 
 * Description: Tools is a class not extending or inheriting from any other class.  It is a class    * 
 *              that contains methods and tools used for making decisions, attaining numbers, and    *
 *              setting values.                                                                      *
 *                                                                                                   *
 *                                                                                                   *
 *                                                                                                   *
 ****************************************************************************************************/
import java.awt.Color;
import java.util.Random;

public class Tools {

	
	public static int getShape(){ // Sets pick for shape based on random number
		Random random = new Random();
		int shapeNum = random.nextInt(4);
		return shapeNum;
	}
	
	public static Color getRandomColor(){ // Method I devised for picking a random RGB color
		int r, g, b, o;
		r = Tools.GetRandom256();
		g = Tools.GetRandom256();
		b = Tools.GetRandom256();
		o = Tools.GetRandom256();
		Color myRandomColor = new Color(r, g, b, o);
		return myRandomColor;
	}
	
	public static Color getColor(){ // When called will return a random color based on the following decision
			
		Random random = new Random();
		int pick = random.nextInt(100);
		//int pick = 99;
		Color color = null;
		
		if(pick < 10){
			Color newC = new Color(255, 0, 0, GetRandom256());
			color = newC;
		}else if(pick < 20){
			Color newC = new Color(0, 0, 0, GetRandom256());
			color = newC;
		}else if(pick < 30){
			Color newC = new Color(0, 0, 255, GetRandom256());
			color = newC;
		}else if(pick < 40){
			Color newC = new Color(255, 255, 0, GetRandom256());
			color = newC;
		}else if(pick < 50){
			Color newC = new Color(0, 255, 0, GetRandom256());
			color = newC;
		}else if(pick < 60){
			Color newC = new Color(128, 128, 128, GetRandom256());
			color = newC;
		}else if(pick < 70){
			Color newC = new Color(255, 128, 0, GetRandom256());
			color = newC;
		}else if(pick < 80){
			Color newC = new Color(255, 153, 153, GetRandom256());
			color = newC;
		}else if(pick < 90){
			Color newC = new Color(255, 0, 255, GetRandom256());
			color = newC;
		}else if(pick < 100){
			color = getRandomColor();
		}
		return color;
	}
	
	public static int GetRandom300(){  // Returns number between 0 and 100
		Random random = new Random();
		int num = random.nextInt(300);
		return num;
	}
	
	public static int GetRandom1000(){ // Returns number between 0 and 1000
		Random random = new Random();
		int num = random.nextInt(1000);
		return num;
	}
	public static int GetRandom256(){  // Method for getting a random value from 0 to 255 (for picking a random color value)
		Random random = new Random();
		int num = random.nextInt(256);
		return num;
	}

}
