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

/**
 * This is a class that creates an object for a place. It stores info such as 
 * the name and address, and also can compare two places to see if their names
 * are the same.
 *
 * &lt;p&gt;Bugs: N/A
 *
 * @author Maximilian Homstad
 * @author Kendra Raczek
 */
public class Place {

	//this stores the name of the place
	private String name = "";
	//this stores the street address of the place
	private String address = "";
	
	/**
	 * This is the constructor of the Place class. It initializes the name 
	 * variable to the parameter name and initializes the address variable
	 * to the parameter address.
	 *
	 * @param String name is the name of the place, this can contain spaces.
	 * @param String address is the address of the place. This is provided by
	 * the user in MyPlacesApp.
	 * @return N/A
	 */
	public Place(String name, String address) {
		this.name = name;
		this.address= address;
	}
	
	/**
	 * This is the accessor method for the name variable.
	 *
	 * @return Returns the name of the object.
	 */
	public String getName() {
		return name;	
	}
	/**
	 * This is the accessor method for the address variable.
	 *
	 * @return Returns the address of the object.
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * This method sets the name for the object.
	 *
	 * @param String name is the new name that will be assigned to the object's
	 * name variable.
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method sets the address for the object.
	 *
	 * @param String address is the new name that will be assigned to the 
	 * object's address variable.
	 * @return void
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * This method compares two place objects. It checks if the object is an
	 * instance of the same class, then checks to see if the name is the 
	 * same.
	 *
	 * @param Place comparedPlace is the second Place object that the current
	 * instance will be compared to.
	 * @return If the names are the same, this method will return true, else
	 * it will return false.
	 */
	public boolean equals(Place comparedPlace) {
		
		if( comparedPlace instanceof Place) {
			
			if (this.name.equalsIgnoreCase(comparedPlace.name)) {
				return true;
			}
			
			return false;
			
		}
		
		return false;
	}
}
