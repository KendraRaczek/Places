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


import java.util.Scanner;

/**
 * This class is the main app. It allows the user to add places, read from 
 * files containing places, as well as (if there are place objects in the 
 * program's array) removing places, and writing place files. 
 *
 * &lt;p&gt;Bugs: N/A
 *
 * @author Maximilian Homstad
 * @author Kendra Raczek
 */
public class MyPlacesApp {
	
	//this creates a new scanner object that will scan user input
	private static Scanner scnr = new Scanner(System.in);
	//this creates a new PlaceList object, thus allowing the places array to
	//be accessed from this class
	private static PlaceList myPlaces= new PlaceList();
	//this will be used to store a number of different user inputs throughout
	//the program, such as menu choices, info for place objects, and so on
	private static String userInput = "";
	
	
	/**
	 * This is the main method for the app. It is responsible for displaying 
	 * the menu, and handling user input in terms of menu choices. If there
	 * are no places in memory, a condensed menu will be displayed.
	 *
	 * @param String[] args is an array of string arguments that can be 
	 * provided for the main method to use.
	 * @return void
	 */
	public static void main(String[] args) {
		
		//program will continue running until the user enters q
		while(!userInput.equalsIgnoreCase("q")) {
			//this menu runs if there are no place objects in the array
			if(myPlaces.getPlaceList().isEmpty()) {
				System.out.println();
				System.out.println("My Places 2016");
				System.out.println("--------------------------");
				System.out.println("No places in memory.");
				System.out.println("--------------------------");
				System.out.print("A)dd R)ead Q)uit: ");
				
				userInput = scnr.nextLine().trim();
				
				switch(userInput) {
				case "A":
				case "a":
					addPlace();
					break;
				case "R":
				case "r":
					readPlaceFile();
					break;
				case "Q":
				case "q":
					break;
				default:
					System.out.println("Unrecognized choice: " + userInput);
					System.out.println("Press Enter to continue.");
					scnr.nextLine();
					break;
				
				}
			}
			//this menu runs if there is at least 1 place object in the array
			else {
				System.out.println("My Places 2016");
				System.out.println("--------------------------");
				
				for(int i = 0; i<myPlaces.getPlaceList().size(); i++) {
					System.out.println((i+1) + ") " + myPlaces.getPlaceList().
							get(i).getName());
				}
				System.out.println("--------------------------");
				System.out.print("A)dd S)how D)elete R)ead W)rite Q)uit: ");
				
				userInput = scnr.nextLine().trim();
				
				switch(userInput) {
				case "A":
				case "a":
					addPlace();
					break;
				case "S":
				case "s":
					showPlace();
					break;
				case "D":
				case "d":
					deletePlace();
					break;
				case "R":
				case "r":
					readPlaceFile();
					break;
				case "W":
				case "w":
					writePlaceFile();
					break;
				case "Q":
				case "q":
					break;
				default:
					System.out.println("Unrecognized choice: " + userInput);
					System.out.println("Press Enter to continue.");
					scnr.nextLine();
					break;
				
				}
			}
			
				
		}
		
		System.out.print("Thank you for using My Places 2016!");
		System.out.println();
		
	}
	
	
	/**
	 * This method is called when the user chooses the add option. It will ask
	 * the user to input a name and address, and then will use those strings
	 * to create a Place object that will be added to the array.
	 *
	 * @param None
	 * @return Void
	 */
	public static void addPlace() {
		//this string will be used to store the user's input place name
		String name;
		//this string will be used to store the user's input place address
		String address;
		
		System.out.print("Enter the name: ");
		name = scnr.nextLine();
		System.out.print("Enter the address: ");
		address = scnr.nextLine();
		System.out.println("Adding: " + name);
		myPlaces.addPlace(new Place(name, address));
		
		System.out.println("Press Enter to continue.");
		scnr.nextLine();
		
	}
	/**
	 * This method is called when the user chooses the show option. It asks
	 * the user to choose the place number to display the name and address
	 * of. If the user enters an unrecognized choice, an error message will
	 * be displayed.
	 *
	 * @param None
	 * @return void
	 */
	public static void showPlace() {
		
		int userNum;
		
		System.out.print("Enter number of place to Show: ");
		if (!scnr.hasNextInt()) {
			System.out.println("Expected a number between 1 and " + myPlaces.
					getPlaceList().size() + ".");
			System.out.println("Press Enter to continue.");
			scnr.nextLine();
			//extra line is added to clear the scanner, otherwise it skips 
			//over the following user input
			scnr.nextLine();
		}
		else {
			userNum = scnr.nextInt();
			//checks to see if the input is a valid number
			if(userNum < 1 || userNum>myPlaces.getPlaceList().size()) {
				System.out.println("Expected a number between 1 and " + 
			myPlaces.getPlaceList().size() + ".");
				System.out.print("Press Enter to continue.");
				scnr.nextLine();
				//extra line is added to clear the scanner, otherwise it skips 
				//over the following user input
				scnr.nextLine();
			}
			else {
				System.out.println(myPlaces.getPlaceList().get(userNum-1).
						getName());
				System.out.println(myPlaces.getPlaceList().get(userNum-1).
						getAddress());
				
				System.out.println("Press Enter to continue.");
				scnr.nextLine();
				//extra line is added to clear the scanner, otherwise it skips 
				//over the following user input
				scnr.nextLine();
			}
		}
		
	}
	/**
	 * This method is called when the user chooses the delete option. It asks
	 * the user to input a number for the place index, then uses that number
	 * to access the index and call the delete method from PlaceList. If the 
	 * user inputs an unrecognized choice at any point, an error message will
	 * be displayed.
	 *
	 * @param None
	 * @return void
	 */
	public static void deletePlace() {
		
		int userNum;
		
		System.out.print("Enter number of place to Delete: ");
		if (!scnr.hasNextInt()) {
			System.out.println("Expected a number between 1 and " + 
		myPlaces.getPlaceList().size() + ".");
			System.out.println("Press Enter to continue.");
			scnr.nextLine();
			//extra line is added to clear the scanner, otherwise it skips 
			//over the following user input
			scnr.nextLine();
		}
		else {
			userNum = scnr.nextInt();
			if(userNum < 1 || userNum>myPlaces.getPlaceList().size()) {
				System.out.println("Expected a number between 1 and " + 
			myPlaces.getPlaceList().size() + ".");
				System.out.print("Press Enter to continue.");
				scnr.nextLine();
				//extra line is added to clear the scanner, otherwise it skips 
				//over the following user input
				scnr.nextLine();
			}
			else {
				System.out.println("Deleting: " + myPlaces.getPlaceList().
						get(userNum-1).getName());
				myPlaces.removePlace(myPlaces.getPlaceList().get(userNum-1));
				
				System.out.println("Press Enter to continue.");
				scnr.nextLine();
				//extra line is added to clear the scanner, otherwise it skips 
				//over the following user input
				scnr.nextLine();
			}
		}
		
	}
	
	/**
	 * This method is called when the user chooses the read option. It shows 
	 * the list of available files, and then asks the user to choose which
	 * file to read from. It will then call the readFile method from PlaceList.
	 *
	 * @param None
	 * @return void
	 */
	public static void readPlaceFile() {
		
		myPlaces.showFiles();
		
		System.out.print("Enter filename: ");
		String fileName = scnr.next();
	//	myPlaces.readFile
		System.out.println("Reading file: " + fileName);
		myPlaces.readFile(fileName);
		
		System.out.println("Press Enter to continue.");
		scnr.nextLine();
		//extra line is added to clear the scanner, otherwise it skips 
		//over the following user input
		scnr.nextLine();
		
	}
	/**
	 * This method is called when the user chooses the write option. It will
	 * ask the user to provide a filename and then will write the file
	 * calling the PlaceList writeFile method.
	 *
	 * @param None
	 * @return void
	 */
	public static void writePlaceFile() {
		
		myPlaces.showFiles();
		
		System.out.print("Enter filename: ");
		String fileName = scnr.next();

		System.out.println("Writing file: " + fileName);
		myPlaces.writeFile(fileName);
		
		
		System.out.println("Press Enter to continue.");
		scnr.nextLine();
		//extra line is added to clear the scanner, otherwise it skips 
		//over the following user input
		scnr.nextLine();
	}
	

}
