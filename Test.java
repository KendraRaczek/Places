
public class Test {
	
	public static void main(String[] args) {
		
		testEquals();
		
		System.out.println("FINISHED");
	}
	
	public static void testEquals() {
		Place place1 = new Place("Name", "Street");
		Place place2 = new Place("Name", "skjdh");
		
		boolean match = place1.equals(place2);
		
		if(!match){
			System.out.println("FAILED");
		}
		else System.out.println("PASSED");
	}

}
