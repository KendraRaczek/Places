//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:            Places
// Files:            MyPlacesApp, Place, PlaceList
// Semester:         Fall 2016
//
// Author:           Kendra Raczek
// Email:            raczek@wisc.edu
// CS Login:         raczek
// Lecturer's Name:  Gary Dahl
// Lab Section:      335
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:     Maximilian Homstad
// Partner Email:    mhomstad@wisc.edu
// Partner CS Login: homstad
// Lecturer's Name:  Gary Dahl
// Lab Section:      332
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//    _X_ Write-up states that Pair Programming is allowed for this assignment.
//    _X_ We have both read the CS302 Pair Programming policy.
//    _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.
//
// Persons:          N/A
// Online Sources:   N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class stores a list of place objects. It can add, remove, and compare
 * a place in the list to another place in the list by calling the equals() 
 * method in the Place class. This class is also responsible for showing, 
 * reading from, and creating files that contain a list of places.
 *
 * &lt;p&gt;Bugs: N/A
 *
 * @author Maximilian Homstad
 * @author Kendra Raczek
 */
public class PlaceList {
	
	//this ArrayList stores place objects that will be added either by the 
	//user or from a file
	private ArrayList<Place> places;
	//this File object accesses the current directory folder from which files
	//can be accessed or written to
	private static File folder = new File(".");
	
	/**
	 * This is the constructor for the PlaceList class. It initializes the 
	 * places array to create space for an array of Places.
	 *
	 * @param None
	 * @return N/A
	 */
	public PlaceList() {
		places = new ArrayList<Place>();
	}
	
	/**
	 * This is an adding method, it adds a new parameter place to the array.
	 *
	 * @param Place newPlace is the place object that will be added the the
	 * places array.
	 * @return void
	 */
	public void addPlace(Place newPlace) {
		places.add(newPlace);
	}
	
	/**
	 * This deletes places in the array by getting rid of the provided Place
	 * object.
	 *
	 * @param Place badPlace is the provided place that will be removed from
	 * the array.
	 * @return void
	 */
	public void removePlace(Place badPlace) {
		places.remove(badPlace);
	}
	
	/**
	 * This method returns the number of places in the array by accessing the
	 * array's size.
	 *
	 * @param None
	 * @return Returns an int number of places in the array.
	 */
	public int numPlaces() {
		return places.size();
	}
	
	/**
	 * This method checks whether the array is populated.
	 *
	 * @param None
	 * @return Returns false if the array is empty, true if it is populated.
	 */
	public boolean hasPlaces() {
		return !places.isEmpty();
	}
	
	/**
	 * This method checks whether the places array has a specific place by 
	 * iterating through the array and checking whether any of the objects are
	 * equal to the provided place using the Place equals method.
	 *
	 * @param Place specificPlace is a provided place object that will be 
	 * compared to the objects in the array.
	 * @return Returns true if any of the objects are equal to specificPlace, 
	 * else returns false.
	 */
	public boolean hasSpecificPlace(Place specificPlace) {
		for(int i = 0; i < places.size(); i++) {
			if (places.get(i).equals(specificPlace))
				return true;
		}
		
		return false;
	}
	
	/**
	 * This method is an accessor method for the places array.
	 *
	 * @param None
	 * @return Returns the places array.
	 */
	public ArrayList<Place> getPlaceList() {
		return places;
	}

	/**
	 * This method displays the filenames of all the accessible place files.
	 * It will list all the files with the .mp ending. We chose to put this 
	 * method here because most methods in the main app are static, while this
	 * is an instance method, so it would not be able to be called otherwise.
	 *
	 * @param None
	 * @return void
	 */
	public void showFiles() {
		System.out.println("My Places Files: ");
		for ( File file : folder.listFiles()) {
			  if ( file.getName().endsWith(".mp")) {
			     //print out or prepare a string with the name
			     //of each file
				  System.out.println("\t" + file.getName());
			  } 
		}
		System.out.println();
	}
	
	/**
	 * The method reads from a file. It uses a scanner to read the lines and
	 * then separates the name and the address into separate variables to 
	 * create a new place. This place is then added to the arraylist, unless 
	 * it already exists. It will catch the exception if the file does not
	 * exist. We chose to put this method here because most methods in the 
	 * main app are static, while this is an instance method, so it would not 
	 * be able to be called otherwise.
	 *
	 * @param String filename is the string provided by the user in the app
	 * @return void
	 */
	public void readFile(String fileName) {
		//this string will store the name of the place
		String name = null;
		//this string will store the address of the place
		String address = null;
		//this scanner will read the file
		Scanner inStream = null;
		try {
			//the scanner is initialized to scan through the file with the
			//given name
			inStream = new Scanner(new FileInputStream(fileName));
			while (inStream.hasNext()) {
				String string = inStream.nextLine();
				//this splits the line between name and address and assigns
				//them to their respective variables
				String[] parts = string.split(";");
				name = parts[0];
				address = parts[1];
				Place place = new Place(name, address);
				if(hasSpecificPlace(place)) {
					System.out.println(name + " already in list.");
				}
				else {
					places.add(place);
				}
			}
			inStream.close();
		}catch (FileNotFoundException e) {
			System.out.println("Unable to read from file: " + fileName);
		}
	}
	
	/**
	 * This method is called when the user wants to write a file containing 
	 * the places they have added and so forth. It creates a new file with
	 * the provided filename, then iterates through the places array, 
	 * outputting the name and address of each place in the correctly
	 * formatted manner. It will catch a fileNotFound exception. We chose 
	 * to put this method here because most methods in the main app are static,
	 * while this is an instance method, so it would not be able to be called 
	 * otherwise.
	 *
	 * @param String fileName is the title of the file that is provided by 
	 * the user.
	 * @return void
	 */
	public void writeFile(String fileName) {
		PrintWriter outStream = null;
		
		
		try {
			outStream = new PrintWriter(fileName);
			
			for (Place place : places) {
				outStream.println(place.getName() + ";" + place.getAddress());
			}
			
			outStream.flush();
			outStream.close();
		}catch (FileNotFoundException e) {
			System.out.println("Unable to write to file: " + fileName);
		}
	}
}
