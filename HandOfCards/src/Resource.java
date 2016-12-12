import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import sun.audio.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Resource {

	
	// HANDLES SOUND CLIP RESOURCE MANAGEMENT
	
	public static void ambientCasinoSound(){
		String fileName = "C:\\Users\\chris\\workspace\\HandOfCards\\src\\Assets\\casino-ambiance.wav";
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}

	
	public static void shuffleCardSound(){
		String fileName = "C:\\Users\\chris\\workspace\\HandOfCards\\src\\Assets\\card-shuffle.wav";
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public static void dealCardsSound(){
		String fileName = "C:\\Users\\chris\\workspace\\HandOfCards\\src\\Assets\\dealing-out-deck.wav";
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public static void declareWinnerSound(){
		String fileName = "C:\\Users\\chris\\workspace\\HandOfCards\\src\\Assets\\coinwin.wav";
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public static void unclePaulieTheme(){
		String fileName = "C:\\Users\\chris\\workspace\\HandOfCards\\src\\Assets\\paulietheme.wav";
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public static void unclePaulie(){
		Resource.unclePaulieTheme();
		System.out.println("So... a friend of a friend introduces you to Uncle Paulie...");
		System.out.println("Uncle Paulie did some time in the joint for loan-sharking, a total misunderstanding was all...");
		System.out.println(" < Paulie walks in >");
		System.out.println("So our friend over here tells me you need to borrow some money? ");
		System.out.println("Well youz owe me now...  Pay on time or Rocco will bust your face wit' a crowbar!");
	}
}
