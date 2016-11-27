/***********************************************************************************************
 * 	CS 200 Assignment 6 - Black Hole Bank (Features)                                           *
 *  September 30, 2016                                			                               *
 * 	Instructor:  Dean Zeller							          							   *
 * 	Student:  Chris Newby																	   *
 * 	File is a class that holds all information and functions for file I/O.       			   *
 * 																							   *
 **********************************************************************************************/
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileIO {
	
	// File Path for BankData.txt
	private static String PATH = "C:\\Users\\chris\\Desktop\\BankData.txt";
	
	
	// Writes data to file
	public void writeToFile(ArrayList<Account> al){
		FileWriter fw;
		try {
			fw = new FileWriter(PATH, false);
			PrintWriter p2 = new PrintWriter(fw);
			for(int i = 0; i < al.size(); i++){
				int pos1 = al.get(i).getID();
				double pos2 = al.get(i).getBalance();
				String pos3 = al.get(i).getHolder();
				int pos4 = al.get(i).getPIN();
			p2.println(pos1 + "," + pos2 + "," + pos3 + "," + pos4);
			}
			p2.close();
		}catch(IOException ignore){
			System.out.println("Something went wrong!");
		}
	}
	
	
	// Gets data from file and parses it, returns objects 
	public ArrayList<Account> readFromFile(){
		ArrayList<Account> al = new ArrayList<Account>();
		try {
			 File file = new File(PATH);
			 Scanner scanner = new Scanner(file);
			 while (scanner.hasNextLine()) {
				 String[] account_arr = scanner.nextLine().split(",");
				 Account newOne = new Account(Integer.parseInt(account_arr[0]), Double.parseDouble(account_arr[1]), account_arr[2], Integer.parseInt(account_arr[3]));
				 al.add(newOne);
			 }
			 scanner.close();
		   } catch (FileNotFoundException e) {
			 e.printStackTrace();
		   }
		return al;
	}
	
	
}
